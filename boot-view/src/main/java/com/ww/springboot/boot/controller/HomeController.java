package com.ww.springboot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

	/**
     * 登录页面
     * 
     * @return
     */
    @RequestMapping(value = "")
    public String show() {
        return "home/list";
    }
}
