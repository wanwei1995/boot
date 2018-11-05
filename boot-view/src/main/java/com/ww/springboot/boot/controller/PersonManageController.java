package com.ww.springboot.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.exception.MyExceptionInterceptor;
import com.ww.springboot.boot.model.ExportMessageDto;
import com.ww.springboot.boot.model.PersonManage;
import com.ww.springboot.boot.service.PersonManageService;
import com.ww.springboot.boot.utils.JacksonUtil;

@Controller
@RequestMapping("personManage")
public class PersonManageController {
	
	@Autowired
	private PersonManageService personManageService;
	
	@RequestMapping("")
	public String find (@ModelAttribute("configuration")PersonManage personManage,ModelMap map){
		List<PersonManage> personManageList = personManageService.findList(personManage);
		map.addAttribute("personManage", personManage);
		map.addAttribute("list", personManageList);
		return "personManage/list";
	}
	
	
	/**
	 * @author wanwei
	 * @TODO 预添加页面
	 * @date: 2018年9月12日 下午5:08:15
	 * @return
	 */
	@RequestMapping("/addpre")
	public String addPre(){
		return "personManage/add :: addContent";
	}
	
	/**
	 * @author wanwei
	 * @TODO 添加页面
	 * @date: 2018年9月12日 下午5:08:15
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView add(PersonManage personManage){
		personManageService.save(personManage);
	 ModelAndView view = new ModelAndView("redirect:/personManage");
     return view;
	}
	
	/** 删除 **/
	@RequestMapping("/delete")
    public ModelAndView delect(String ids, ModelMap map) {
		personManageService.deleteList(ids);
    	ModelAndView view = new ModelAndView("redirect:/personManage");
        return view;
    }
    
  
    //修改页面
	@RequestMapping("/queryDetial")
    public String detail(Long id, ModelMap map) {
		PersonManage personManage = personManageService.findById(id);
        map.addAttribute("personManage", personManage);
        return "personManage/update:: detailContent";
    }
    
    //修改页面
	@RequestMapping("/update")
    public ModelAndView update(PersonManage personManage) {
		personManageService.update(personManage);
        ModelAndView view = new ModelAndView("redirect:/personManage");
        return view;
    }
	
	
	/**
     * 请求导入文件
     * 
     * @date :2017年9月8日
     * @return:String
     */
    @RequestMapping("/upload")
    public String upload(Model model) {
        return "personManage/upload";
    }
    
    /**
     * excel导入数据库
     * 
     * @date :2017年9月8日
     * @return:String
     */
    @RequestMapping(value = "/createFromExcel", method = RequestMethod.POST)
    @MyExceptionInterceptor("redirect:/deliverRule")
    public ModelAndView createFromExcel(@RequestParam MultipartFile myFileName,
            HttpServletRequest request, RedirectAttributes redirectAttributes,
            RedirectAttributes attrs) {
        ModelAndView view = new ModelAndView("redirect:/personManage");
        try {
        	ExportMessageDto result = personManageService.saveFromExcel(myFileName.getInputStream());
            attrs.addAttribute("result", JacksonUtil.toJSon(result));
            return view;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/dataToExcel", method = RequestMethod.GET)
    @ResponseBody
    public void poiToExcel(HttpServletResponse response, HttpServletRequest request) {
    	PersonManage personManage = new PersonManage();
        String personName = request.getParameter("personName");
        String status = request.getParameter("status");
        personManage.setPersonName(personName);
        if(!StringUtils.isEmpty(status)){
        	   personManage.setStatus(Integer.valueOf(status));
        }
        personManageService.dataToExcel(response, personManage);
		// return deliverRuleService.poiToExcel(deliverRuleDto, response);
    }
}
