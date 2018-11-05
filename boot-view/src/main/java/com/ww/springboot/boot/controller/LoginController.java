package com.ww.springboot.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ww.springboot.boot.exception.ExceptionAspect;
import com.ww.springboot.boot.shiro.authorization.Authentication;

@Controller
public class LoginController {

    @Autowired
    private Authentication authentication;

    /**
     * 登录页面
     * 
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        if (authentication.isAuthenticated()) {
            return "index";
        }
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(Model model, HttpServletRequest request) {
        authentication.logout();
        request.getSession().removeAttribute("loginName");
        request.getSession().removeAttribute("password");
        return "login";
    }

    /**
     * 用户登录
     * 
     * @param model
     * @param request
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/doLogin")
    public String doLogin(ModelMap model, HttpServletRequest request, @RequestParam String userName,
            @RequestParam String password) {
        try {
            authentication.login(userName, password);
        } catch (Exception e) {
            model.addAttribute(ExceptionAspect.ATTRIBUTE_EXCEPTION_TYPE,
                    ExceptionAspect.ATTRIBUTE_EXCEPTION_ERROR);
            model.addAttribute(ExceptionAspect.ATTRIBUTE_EXCEPTION_RESULT, e.getMessage());
            return "login";
        }
        // SecurityUtils.getSubject().getSession().setTimeout(1800000);
        return "redirect:/index";
    }

}
