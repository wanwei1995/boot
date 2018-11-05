package com.ww.springboot.boot.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.exception.MyExceptionInterceptor;
import com.ww.springboot.boot.system.model.Role;
import com.ww.springboot.boot.system.service.RoleService;

/**
 * @author wanwei
 * @TODO 角色页面
 * @date: 2017年12月22日 上午11:10:07
 */
@Controller
@RequiresRoles("admin")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @author wanwei
     * @TODO 用户角色页面显示
     * @date: 2017年12月22日 下午4:01:55
     * @param role
     * @param page
     * @param rows
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping("")
    public ModelAndView list(@ModelAttribute("role") Role role,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("rows") Optional<Integer> rows) {
        ModelAndView view = new ModelAndView("role/list");
        PageInfo<Role> pageInfo = PageHelper.startPage(page.orElse(1), page.orElse(10))
                .doSelectPageInfo(() -> roleService.findBySelective(role));
        view.addObject("pageInfo", pageInfo);
        view.addObject("role", role);
        return view;
    }

    /**
     * @author wanwei
     * @TODO 更新用户角色权限
     * @date: 2017年12月22日 下午4:02:34
     * @param ids
     * @param map
     * @param response
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/update")
    @ResponseBody
    public String update(String ids, ModelMap map, HttpServletResponse response) {
        roleService.update(ids);
        return "Success";
    }

    /**
     * @author wanwei
     * @TODO 添加页面
     * @date: 2017年12月22日 下午4:03:08
     * @param map
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/adddetail")
    public String adddetail(ModelMap map) {
        return "role/add :: addContent ";
    }

    /**
     * @author wanwei
     * @TODO 添加功能
     * @date: 2017年12月22日 下午4:03:39
     * @param role
     * @param redirectAttributes
     * @return
     * @throws IOException
     */
    @RequiresRoles("admin")
    @PostMapping("/add")
    @MyExceptionInterceptor("redirect:/role")
    public ModelAndView add(Role role, RedirectAttributes redirectAttributes) throws IOException {
        boolean flag = roleService.add(role);
        ModelAndView view = new ModelAndView("redirect:/role");
        if (!flag) {
            throw new BusinessException("角色名称重复，请重试！");
        } else {
            return view;
        }
    }

    /**
     * @author wanwei
     * @TODO 删除角色及权限
     * @date: 2017年12月22日 下午4:03:50
     * @param ids
     * @param redirectAttributes
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/delete")
    @MyExceptionInterceptor("redirect:/role")
    public String delect(String ids, RedirectAttributes redirectAttributes) {
        String[] idArray = ids.split(",");
        roleService.deleteList(idArray);
        return "redirect:/role";
    }
}
