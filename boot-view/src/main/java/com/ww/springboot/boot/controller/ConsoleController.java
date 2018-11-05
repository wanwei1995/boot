package com.ww.springboot.boot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ww.springboot.boot.service.Md5Service;
import com.ww.springboot.boot.service.TempSoService;

//控制台
@Controller
@RequestMapping("/console")
public class ConsoleController {
	
	@Autowired
	private TempSoService tempSoService;
	@Autowired
	private Md5Service md5Service;

	
	@RequestMapping("")
	private String find(){
		return "console/list";
	}
	@RequestMapping("/makeData")
	@ResponseBody
	private String makeData(){
		StringBuilder bulid = new StringBuilder("刷新提示：").append("\n");
		for(int i =0;i<10;i++){
			Date date1 = new Date();
			tempSoService.makeData();
			Date date2 = new Date();
			bulid.append("第").append(i).append("次数据插入时间为").append(date2.getTime() - date1.getTime()).append("\n");
			System.out.println(date2.getTime() - date1.getTime());
		}
		return bulid.toString();
	}
	@RequestMapping("/makeMd5Data")
	@ResponseBody
	private String makeMd5Data(){
	  md5Service.MakeData();
	  return "SUCCESS";
	}

}
