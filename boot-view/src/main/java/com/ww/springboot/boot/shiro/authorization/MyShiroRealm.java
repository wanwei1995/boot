package com.ww.springboot.boot.shiro.authorization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.ww.springboot.boot.common.YesOrNo;
import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.system.model.Permission;
import com.ww.springboot.boot.system.model.Role;
import com.ww.springboot.boot.system.model.User;
import com.ww.springboot.boot.system.service.PermissionService;
import com.ww.springboot.boot.system.service.RoleService;
import com.ww.springboot.boot.system.service.UserService;


/**
 * 身份校验核心类;
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    // 获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 此处不做集合判断会报错。
        /*
         * User user = (User) principals.fromRealm(getName()).iterator() .next();
         */
        User user = null;
        Collection<User> thisPrincipals = principals.fromRealm(getName());
        if (!CollectionUtils.isEmpty(thisPrincipals)) {
            user = (User) thisPrincipals.iterator().next();
        } else {
            user = (User) principals.getPrimaryPrincipal();
        }
        String userName = user.getLoginName();
        if (!StringUtils.isEmpty(userName)) {
            List<Role> roles = roleService.findRoleByUserId(user.getId());
            List<Long> roleIds = new ArrayList<Long>();
            List<String> roleNames = new ArrayList<String>();
            for (Role role : roles) {
                roleIds.add(role.getId());
                roleNames.add(role.getName());
            }

            // 查询用户授权信息
            Set<Permission> pers = new HashSet<>();
            if (!CollectionUtils.isEmpty(roleIds)) {
                pers = permissionService.getPermissionsByRoleIds(roleIds);
            }

            // "admin"用户初始化拥有全部权限,不再通过关联查询（防止"admin"权限不全）
            if (roleNames.contains("admin")) {
                Set<Permission> allPermissions = permissionService.getAll();
                pers.addAll(allPermissions);
            }

            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for (Permission per : pers) {
                info.addStringPermission(per.getCode());
            }
            info.addRoles(roleNames);
            return info;
        }
        return null;
    }

    // 获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
        throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        // 通过表单接收的用户名
        String userName = token.getUsername();
        if (!StringUtils.isEmpty(userName)) {
            // 登录错误次数到达一定次数会锁定
            User user = userService.findByName(userName);
            if (user == null) {
                return null;
            }
            if (user.getIsLock() == YesOrNo.YES.getValue()) {
                throw new BusinessException("该用户已被锁定!");
            }
            if (new Date().after(user.getExpireTime())) {
                throw new BusinessException("该用户已到期!");
            }
            if (user != null) {
                return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            }
        }
        return null;
    }
}
