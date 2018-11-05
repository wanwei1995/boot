package com.ww.springboot.boot.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ww.springboot.boot.shiro.authorization.Authentication;
import com.ww.springboot.boot.system.model.Role;
import com.ww.springboot.boot.system.model.User;
import com.ww.springboot.boot.system.service.RoleService;
import com.ww.springboot.boot.system.service.UserService;
import com.ww.springboot.boot.utils.MD5Util;

/**
 * @author wanwei
 * @TODO 用户页面
 * @date: 2018年1月17日 下午4:57:59
 */
@Controller
@RequiresRoles("admin")
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private Authentication authentication;

    /**
     * 展示页面
     * 
     * @author hhl
     * @date 17/12/20
     */
    @RequiresRoles("admin")
    @RequestMapping("")
    public ModelAndView list(@ModelAttribute("user") User user,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("rows") Optional<Integer> rows) {
        ModelAndView view = new ModelAndView("user/list");
        PageInfo<User> pageInfo = PageHelper.startPage(page.orElse(1), rows.orElse(10))
                .doSelectPageInfo(() -> userService.findBySelective(user));
        // 暂时不需要显示当前用户所属角色
        /*
         * List<User> list = pageInfo.getList(); //List<User> newList = new ArrayList<User>();
         * for(User u : list) { List<String> roleNames =
         * roleService.findRoleNameByUserId(u.getId()); String roleName =
         * StringUtils.join(roleNames, ","); u.setUndef1(roleName); //newList.add(u); }
         */
        view.addObject("pageInfo", pageInfo);
        view.addObject("user", user);
        return view;
    }

    /**
     * 获取添加页面
     * 
     * @author hhl
     * @date 2017/12/22
     */
    @RequiresRoles("admin")
    @RequestMapping("/preAdd")
    public ModelAndView preAdd() {
        return new ModelAndView("user/add :: detailContent");
    }

    /**
     * 添加用户信息
     * 
     * @author hhl
     * @date 2017/12/22
     */
    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(@ModelAttribute("user") User user,
            @RequestParam("verifyPassword") String verifyPassword) {
        if (verifyPassword.equals(user.getPassword())) {
            user.setPassword(encrypt(verifyPassword));
            user.setExpireTime(new Timestamp(System.currentTimeMillis()));
            userService.insert(user);
        }
        return "redirect:/user";
    }

    /**
     * 删除用户
     * 
     * @author hhl
     * @date 2017/12/22
     */
    @RequiresRoles("admin")
    @ResponseBody
    @RequestMapping("delete")
    public String delete(String[] ids) {
        userService.forbidden(ids);
        return "删除成功";
    }

    /**
     * 获取更新页面
     * 
     * @author hhl
     * @date 2017/12/22
     */
    @RequiresRoles("admin")
    @RequestMapping("/preUpdate")
    public ModelAndView preUpdate(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("userId"));
        // "user/update :: updateContent"，写成这样<script>脚本未包含进去
        ModelAndView view = new ModelAndView("user/update");
        User user = userService.findById(userId);
        view.addObject("user", user);
        // 配置用户所属角色
        List<Role> roles = roleService.findAll();

        // 选择用户所属的角色id
        List<Long> roleIds = roleService.findRoleIdByUserId(userId);

        view.addObject("roles", roles);
        String defaultValue = "";
        for (Long roleId : roleIds) {
            defaultValue = defaultValue + roleId + ",";
        }
        if (defaultValue.length() > 0) {
            view.addObject("defaultValue", defaultValue.substring(0, defaultValue.length() - 1));
        }
        return view;
    }

    /**
     * 更新用户
     * 
     * @author hhl
     * @date 2017/12/22
     */
    @RequiresRoles("admin")
    @RequestMapping("update")
    public String update(@ModelAttribute("user") User user,
            @RequestParam("roleIds") String[] roleIds) {
        // 删除当前用户的角色，并添加角色，操作s_user_role表
        userService.updateUserRoles(roleIds, user.getId());
        // 更新用户，更新s_user表
        user.setPassword(encrypt(user.getPassword()));
        userService.update(user);
        // 修改对应用户所属角色，权限也有变化，清除redis的shiro缓存。
        authentication.clearPermissionCache(user.getId());
        return "redirect:/user";
    }

    @RequestMapping("update-password")
    public String toUpdatePassword() {
        return "user/updatePassword";
    }

    /**
     * 修改密码
     * 
     * @author hhl
     * @date 2017/12/28
     */
    // @MyExceptionInterceptor("user/updatePassword")
    @RequestMapping("updatePassword")
    public String updatePassword(@RequestParam("newPassword") String newPassword) {
        userService.updatePasswordByUserName(Authentication.getUserName(), encrypt(newPassword));
        // 销毁session,重新登录
        authentication.logout();
        return "login";
    }

    /**
     * 管理员更新用户密码
     * 
     * @author hhl
     * @date 2017/12/29
     * @param userId
     * @param password
     * @return
     */
    @RequiresRoles("admin")
    @ResponseBody
    @RequestMapping("updatePasswordByAdmin")
    public String updatePasswordByAdmin(@RequestParam("userId") Long userId,
            @RequestParam("password") String password) {
        password = encrypt(password);
        userService.updatePasswordByAdmin(userId, password);
        return "修改密码成功";
    }

    /**
     * 根据不同状态批量更新用户的锁定状态
     * 
     * @author hhl
     * @date 2017/12/29
     * @param ids
     * @param state
     * @return
     */
    @ResponseBody
    @RequestMapping("isLock")
    public String isLock(@Param("ids") String[] ids, @Param("state") Long state) {
        userService.updateLockState(ids, state);
        return "修改选定用户状态成功";
    }

    /**
     * 验证原始密码
     * 
     * @author hhl
     * @date 2017/12/29
     */
    @ResponseBody
    @RequestMapping("verifyPassword")
    public String verifyPassword(@RequestParam("oldPassword") String oldPassword) {
        User user =
                userService.findByNameAndPwd(Authentication.getUserName(), encrypt(oldPassword));
        if (user == null) {
            return "密码错误!";
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("isExist")
    public String isExist(@RequestParam("loginName") String loginName) {
        User user = userService.findByNameWithoutDeleted(loginName);
        if (user == null) {
            return "success";
        }
        return "failure";
    }

    public static String encrypt(String password) {
        return MD5Util.md5Hex(password).toLowerCase();
    }

    /*public static void main(String[] args) {
        System.out.println(encrypt(""));
        System.out.println(
                DateUtil.dateAdd(AddpartEnum.DD, new Timestamp(System.currentTimeMillis()), 180));
    }*/
}
