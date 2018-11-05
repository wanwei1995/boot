package com.ww.springboot.boot.baseTest.finalS;

/**
 * @author wanwei
 * @TODO final被修饰的变量不能被修改，被修饰的类不能被继承;
 *       final被修饰的变量一旦被赋值不可被修改： 1.定义时，2.构造函数中，3.初始化代码块或static{}
 * @date: 2018年9月27日 下午4:20:04 
 */
public class FinalTest1 {
	
	private final String value;
	
	public static void main (String args[]){
		FinalTest1 finalTest1 = new FinalTest1();
		System.out.println(finalTest1.value);
		/*value = "1214";*/
	} 
	
	public FinalTest1(){
		value = "123";
	}
	
	class test {
		
	}
    /*class test1 extends FinalTest1{
    	
    }*/
}
