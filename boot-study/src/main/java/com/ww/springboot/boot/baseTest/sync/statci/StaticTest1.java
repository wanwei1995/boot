package com.ww.springboot.boot.baseTest.sync.statci;

/**
 * @author wanwei
 * @TODO   static 关键字的用法 ：不创建对象的情况下依旧可以调用变量
 *         静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。
 *         而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响
 * @date: 2018年9月27日 下午1:55:13 
 */
public class StaticTest1 {
	
	public static String value = "123";
	
	public static void main(String arge []){
		System.out.println(StaticTest1.value);
	}
}
