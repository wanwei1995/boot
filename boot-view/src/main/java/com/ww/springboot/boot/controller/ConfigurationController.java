package com.ww.springboot.boot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ww.springboot.boot.model.Configuration;
import com.ww.springboot.boot.service.ConfigService;


/**
 * @author wanwei
 * @TODO 系统参数
 * @date: 2018年9月12日 下午3:34:31 
 */
@Controller
@RequestMapping("config")
public class ConfigurationController {
	
	@Autowired
	private ConfigService configService;
	
	@RequestMapping()
	public String find(@ModelAttribute("configuration") Configuration configuration,
            ModelMap map){
		List<Configuration> configurationList = configService.findList(configuration);
		map.addAttribute("config", configuration);
		map.addAttribute("list", configurationList);
		return "config/list";
	}
	
	/**
	 * @author wanwei
	 * @TODO 预添加页面
	 * @date: 2018年9月12日 下午5:08:15
	 * @return
	 */
	@RequestMapping("/addpre")
	public String addPre(){
		return "config/add :: addContent";
	}
	
	/**
	 * @author wanwei
	 * @TODO 添加页面
	 * @date: 2018年9月12日 下午5:08:15
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView add(Configuration configuration){
	 configService.save(configuration);
	 ModelAndView view = new ModelAndView("redirect:/config");
     return view;
	}
	
	/** 删除 **/
	@RequestMapping("/delete")
    public ModelAndView delect(String ids, ModelMap map) {
    	configService.deleteList(ids);
    	ModelAndView view = new ModelAndView("redirect:/config");
        return view;
    }
    
    /** 清空缓存 **/
	@RequestMapping("/clear")
    public ModelAndView clear() {
    	configService.clear();
    	ModelAndView view = new ModelAndView("redirect:/config");
        return view;
    }
    //修改页面
	@RequestMapping("/queryDetial")
    public String detail(Long id, ModelMap map) {
        Configuration configuration = configService.findById(id);
        map.addAttribute("configuration", configuration);
        return "config/update:: detailContent";
    }
    
    //修改页面
	@RequestMapping("/update")
    public ModelAndView update(Configuration configuration) {
    	configService.update(configuration);
        ModelAndView view = new ModelAndView("redirect:/config");
        return view;
    }

}
