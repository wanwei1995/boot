package com.ww.springboot.boot.shiro.authorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.shiro.cache.RedisCacheManager;
import com.ww.springboot.boot.system.model.User;
import com.ww.springboot.boot.system.service.UserService;
import com.ww.springboot.boot.utils.MD5Util;

@Component("authentication")
public class Authentication {


    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private MyShiroRealm myShiroRealm;

    @Autowired
    private UserService userService;

    public void login(String name, String password) {
        String md5password = MD5Util.md5Hex(password).toLowerCase();
        Subject currentUser = SecurityUtils.getSubject();
        //session永不过期
        currentUser.getSession().setTimeout(-1000l);
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(name, md5password);
            token.setRememberMe(false);
            try {
                if (StringUtils.isEmpty(name)) {
                    throw new BusinessException("用户名为空");
                } else if (StringUtils.isEmpty(password)) {
                    throw new BusinessException("密码为空");
                }
                currentUser.login(token);
                // 错误次数清零
                userService.clearErrorCount(name);
            } catch (UnknownAccountException e) {
                throw new BusinessException("用户 " + name + " 不存在");
            } catch (IncorrectCredentialsException e) {
                // 当错误次数到达5次以上时，锁定用户
                User user = userService.findByName(name);
                // 数据库为4，则此次是第5次错误
                if (user.getErrorCount() >= 4) {
                    // 锁定用户且错误次数加1
                    userService.lockUserByUserName(name, 1L);
                } else {
                    // 错误次数加1
                    userService.updateErrorCount(name);
                }
                throw new BusinessException("密码错误!");
            } catch (AuthenticationException e) {
                if (e.getCause() instanceof BusinessException) {
                    throw new BusinessException(e.getCause().getMessage());
                }
                throw new BusinessException(e.getMessage());
            }
        }
    }

    /**
     * 是否认证
     */
    public boolean isAuthenticated() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.isAuthenticated();
    }

    /**
     * 验证是否登录（登录但不一定是认证了）
     */
    public boolean isLoggedin() {
        Subject currentUser = SecurityUtils.getSubject();
        PrincipalCollection principals = currentUser.getPrincipals();
        return principals != null && !principals.isEmpty();
    }

    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
    }

    public void clearPermissionCache() {
        ((RedisCacheManager) cacheManager).getCache(myShiroRealm.getAuthorizationCacheName())
            .remove(getUserId());
    }

    public void clearPermissionCache(Long userId) {
        ((RedisCacheManager) cacheManager).getCache(myShiroRealm.getAuthorizationCacheName())
            .remove(userId);
    }

    public static String getUserName() {
        String userName = "";
        Subject currentUser = SecurityUtils.getSubject();
        PrincipalCollection principals = currentUser.getPrincipals();
        if (principals != null && !principals.isEmpty()) {
            User user = (User) principals.fromRealm(principals.getRealmNames().iterator().next())
                .iterator().next();
            userName = user.getLoginName();
        }
        return userName;
    }

    public static Long getUserId() {
        Long userId = 0L;
        Subject currentUser = SecurityUtils.getSubject();
        PrincipalCollection principals = currentUser.getPrincipals();
        if (principals != null && !principals.isEmpty()) {
            User user = (User) principals.fromRealm(principals.getRealmNames().iterator().next())
                .iterator().next();
            userId = user.getId();
        }
        return userId;
    }
}
