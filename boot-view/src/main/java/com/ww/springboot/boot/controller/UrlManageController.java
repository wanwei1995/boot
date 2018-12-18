package com.ww.springboot.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ww.springboot.boot.model.UrlManage;
import com.ww.springboot.boot.service.UrlManageService;
import com.ww.springboot.boot.utils.JacksonUtil;

/**
 * @author wanwei
 * @TODO    页面导航管理
 * @date: 2018年11月30日 上午9:40:15 
 */
@Controller
@RequestMapping("/url")
public class UrlManageController {

	@Autowired
	private UrlManageService urlManageService;
	
	@RequestMapping("")
	public String init(){
		
		return "url/list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String dataList(){
		List<UrlManage> urls = urlManageService.findAll();
		return JacksonUtil.toJSon(urls);
	}
	/**
	 * @author wanwei
	 * @TODO   添加子节点
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/right")
	public String right(String id, ModelMap map){
		map.addAttribute("pId", id);
	    return "url/addSon";
	
	}
	
	/**
	 * @author wanwei
	 * @TODO   点击次数
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/click")
	@ResponseBody
	public void click(String id, ModelMap map){
	//
		urlManageService.updateClickTimes(Long.valueOf(id));
	}
	
	@RequestMapping("/addSon")
	public ModelAndView addSon(UrlManage urlManage){
		//根据PId生成id
		Long pId = urlManage.getpId();
		//查询父id下有多少个字节点
		int count = urlManageService.selectNumByPId(pId);
		//一级目录每个子节点为10个
		if(pId<10){
			urlManage.setId(pId*10+count);
		}
		//二级目录每个子节点为100个
		if(pId<100){
			urlManage.setId(pId*100+count);
		}
		//三级目录每个子节点为100个
		if(pId<10000){
			urlManage.setId(pId*100+count);
		}
		urlManageService.insert(urlManage);
		ModelAndView view = new ModelAndView("redirect:/url");
	    return view;
	}
}
