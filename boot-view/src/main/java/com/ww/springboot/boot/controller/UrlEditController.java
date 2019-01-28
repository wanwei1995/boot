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
 * @TODO 页面导航管理
 * @date: 2018年11月30日 上午9:40:15
 */
@Controller
@RequestMapping("/urlEdit")
public class UrlEditController {

	@Autowired
	private UrlManageService urlManageService;

	@RequestMapping("")
	public String init() {

		return "url/listEdit";
	}

	@RequestMapping("/list")
	@ResponseBody
	public String dataList() {
		List<UrlManage> urls = urlManageService.findAll();
		return JacksonUtil.toJSon(urls);
	}

	/**
	 * @author wanwei
	 * @TODO 添加子节点
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/right")
	public String right(String id, ModelMap map) {
		map.addAttribute("pId", id);
		return "url/addSon";

	}

	/**
	 * @author wanwei
	 * @TODO 点击次数
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/click")
	@ResponseBody
	public void click(String id, ModelMap map) {
		//编辑页面不记录点击次数
		urlManageService.updateOperateTime(Long.valueOf(id));
	}

	/**
	 * @author wanwei
	 * @TODO 添加一级目录
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/addFirst")
	@ResponseBody
	public ModelAndView addFirst() {
		int count = urlManageService.selectNumByPId(0L);
		UrlManage urlManage = new UrlManage();
		urlManage.setName("一级目录");
		urlManage.setId(Long.valueOf(count + 1));
		urlManage.setpId(0L);
		urlManageService.insert(urlManage);
		ModelAndView view = new ModelAndView("redirect:/urlEdit");
		return view;
	}

	/**
	 * @author wanwei
	 * @TODO 更新
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/updatePre")
	public String updatePre(String id, ModelMap map) {
		UrlManage urlManage = urlManageService.findById(Long.valueOf(id));
		map.addAttribute("urlManage", urlManage);
		return "url/update";
	}

	/**
	 * @author wanwei
	 * @TODO 修改
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView update(UrlManage urlManage, ModelMap map) {
		urlManageService.update(urlManage);
		ModelAndView view = new ModelAndView("redirect:/urlEdit");
		return view;
	}

	/**
	 * @author wanwei
	 * @TODO 清缓存
	 * @date: 2018年11月30日 下午4:15:27
	 * @param id
	 * @return
	 */
	@RequestMapping("/clearCache")
	public ModelAndView clearCache() {
		urlManageService.clearCache();
		ModelAndView view = new ModelAndView("redirect:/urlEdit");
		return view;
	}

	@RequestMapping("/addSon")
	public ModelAndView addSon(UrlManage urlManage) {
		// 根据PId生成id
		Long pId = urlManage.getpId();
		// 查询父id下子集个数
		int count = urlManageService.selectNumByPId(pId);
		if (count == 0) {
			// 一级目录每个子节点为10个
			if (pId < 10) {
				urlManage.setId(pId * 10 + count);
			} else if (pId < 100) {
				// 二级目录每个子节点为100个
				urlManage.setId(pId * 100 + count);
			} else if (pId < 10000) {
				// 三级目录每个子节点为100个
				urlManage.setId(pId * 100 + count);
			}
		} else {
			// 取父id下子集的最大的id+1
			Long id = urlManageService.selectIdByPId(pId);
			urlManage.setId(id + 1);
		}
		urlManageService.insert(urlManage);
		ModelAndView view = new ModelAndView("redirect:/urlEdit");
		return view;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id) {

		urlManageService.delete(Long.valueOf(id));

		return "删除成功";
	}
}
