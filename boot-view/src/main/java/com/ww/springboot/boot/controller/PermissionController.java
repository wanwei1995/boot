package com.ww.springboot.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ww.springboot.boot.system.dto.PermissionDto;
import com.ww.springboot.boot.system.service.PermissionService;
import com.ww.springboot.boot.utils.JacksonUtil;

/**
 * @author wanwei
 * @TODO 权限管理页面
 * @date: 2018年1月17日 下午4:57:33
 */
@Controller
@RequiresRoles("admin")
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequiresRoles("admin")
    @RequestMapping("")
    public String list(String roleId, ModelMap map) {
        map.addAttribute("roleId", roleId);
        return "permission/list";
    }

    @RequiresRoles("admin")
    @RequestMapping("/list")
    @ResponseBody
    public String dataList(String roleId, ModelMap map, HttpServletResponse response) {
        List<PermissionDto> permissions = permissionService.findAll(roleId);
        String permission = JacksonUtil.toJSon(permissions);
        return permission;
    }
}
