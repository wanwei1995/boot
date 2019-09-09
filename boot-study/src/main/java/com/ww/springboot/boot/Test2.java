package com.ww.springboot.boot;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test2 {
	
	public static void main(String[] args) {
		Map<String,Long> map = new HashMap<>();

		map.put("a",3L);
		System.out.println(map.get("a"));
		map.put("a",4L);
		map.put("a",5L);
		System.out.println(map.get("a"));
		map.put("a",6L);
		System.out.println(map.get("a"));
		map.put("a",7L);

		System.out.println(map.get("a"));
		//测试
	}

}
