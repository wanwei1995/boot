package com.ww.springboot.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ww.springboot.boot.model.UrlManage;
import com.ww.springboot.boot.service.UrlManageService;

/**
 * @author wanwei
 * @TODO    页面导航管理
 * @date: 2018年11月30日 上午9:40:15 
 */
@Controller
@RequestMapping("/usualUrl")
public class UsualUrlController {

	@Autowired
	private UrlManageService urlManageService;
	
	@RequestMapping("")
	public String usualUrl(ModelMap map){
		
		List<UrlManage> urlManageList = urlManageService.findUsualUrl();
		
		List<UrlManage> urlManageOperateList = urlManageService.findUsualUrlByOperateTime();
		map.addAttribute("urlManageList", urlManageList);
		map.addAttribute("urlManageOperateList", urlManageOperateList);
	    return "url/usual";
	}
}
