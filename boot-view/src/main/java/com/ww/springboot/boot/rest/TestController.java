package com.ww.springboot.boot.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ww.springboot.boot.rest.dto.DianaPageInitDto;
import com.ww.springboot.boot.utils.JacksonUtil;

@RestController
@RequestMapping("/rest/test")
public class TestController {
	
	@RequestMapping(value = "/test",method = RequestMethod.POST)
	@ResponseBody
	private String test(Object object){
		List<DianaPageInitDto> dList = new ArrayList<>();
		for(int i =0 ;i<20;i++){
			DianaPageInitDto dianaPageInitDto = new DianaPageInitDto();
			dianaPageInitDto.setId("id"+i);
			dianaPageInitDto.setText("text"+i);
			dList.add(dianaPageInitDto);
		}
		
		return JacksonUtil.toJSon(dList);
	}

}
