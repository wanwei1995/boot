package com.ww.springboot.boot.baseTest.sync.statci;

/**
 * @author wanwei
 * @TODO  静态方法中不能调用非静态方法或变量 ；非静态方法不受限制
 *        
 * @date: 2018年9月27日 下午2:04:51 
 */
public class StaticTest2 {
	private static String value1 = "123";
	
	private String value2 = "456";
	
	
	void print1(){
		System.out.println(value1);
		System.out.println(value2);
		print2();
	}
	static void print2(){
		System.out.println(value1);
		/*System.out.println(value2);
		print1();*/
	}
	

}
