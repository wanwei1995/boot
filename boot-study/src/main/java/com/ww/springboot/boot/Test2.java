package com.ww.springboot.boot;

import java.util.ArrayList;
import java.util.Iterator;

public class Test2 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();  
		list.add("one");  
		list.add("two");  
		list.add("two");  
		list.add("two");  
		list.add("two");  
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String s = iterator.next();
			if(s.equals("two")){
				iterator.remove();
			}
		}
		System.out.println(list);

		//测试
	}

}
