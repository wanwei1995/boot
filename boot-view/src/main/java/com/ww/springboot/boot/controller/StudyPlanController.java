package com.ww.springboot.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ww.springboot.boot.model.StudyPlan;
import com.ww.springboot.boot.model.StudyPlanDetail;
import com.ww.springboot.boot.service.StudyPlanDetailService;
import com.ww.springboot.boot.service.StudyPlanService;

/**
 * @author wanwei
 * @TODO 学习规划页面
 * @date: 2019年2月18日 下午3:42:51
 */

@RequestMapping("/studyPlan")
@Controller
public class StudyPlanController {

	@Autowired
	private StudyPlanService studyPlanService;

	@Autowired
	private StudyPlanDetailService studyPlanDetailService;

	/**
	 * @author wanwei
	 * @TODO   way 排序方式  sort 排序列
	 * @date: 2019年2月22日 上午11:20:15
	 * @param map
	 * @param way
	 * @param sort
	 * @return
	 */
	@RequestMapping("")
	public String list(ModelMap map,String way,String sort) {
		List<StudyPlan> studyPlans = new ArrayList<>();
		if(StringUtils.isEmpty(way) || StringUtils.isEmpty(sort)){
			//默认以学习时间 倒序排列
			way = "1";
			sort = "0";
			studyPlans = studyPlanService.findBySelective(way,sort);
		}else{
			studyPlans = studyPlanService.findBySelective(way,sort);
		}
		
		map.addAttribute("studyPlans", studyPlans);
		map.addAttribute("sort", sort);
		return "studyPlan/list";
	}

	@RequestMapping("/update")
	public Object update(ModelMap map, StudyPlan studyPlan, int flag) {
		studyPlanService.update(studyPlan);
		if (flag == 1) {
			map.addAttribute("studyName", studyPlan.getStudyName());
			return "studyPlan/addDetail::addContent";
		}
		ModelAndView view = new ModelAndView("redirect:/studyPlan");
		return view;
	}

	@RequestMapping("/addDetail")
	public ModelAndView addDetail(ModelMap map, StudyPlanDetail studyPlanDetail) {
		studyPlanDetailService.insert(studyPlanDetail);
		ModelAndView view = new ModelAndView("redirect:/studyPlan");
		return view;
	}

	@RequestMapping("/createPre")
	public String createPre(ModelMap map) {

		return "studyPlan/add::addContent";
	}

	@RequestMapping("/create")
	public ModelAndView create(ModelMap map, StudyPlan studyPlan) {
		studyPlanService.insert(studyPlan);
		ModelAndView view = new ModelAndView("redirect:/studyPlan");
		return view;
	}
	
	@RequestMapping("/detail")
	public String detail(ModelMap map, String studyName) {
		List<StudyPlanDetail> studyPlanDetailList  = studyPlanDetailService.selectByStudyName(studyName);
		map.addAttribute("studyPlanDetailList",studyPlanDetailList);
		return "studyPlan/detail";
	}
	
	@RequestMapping("/sort")
	public ModelAndView sort(ModelMap map, int way) {
		
		ModelAndView view = new ModelAndView("redirect:/studyPlan");
		return view;
	}
}
