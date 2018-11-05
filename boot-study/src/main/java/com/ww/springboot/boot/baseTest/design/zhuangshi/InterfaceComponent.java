package com.ww.springboot.boot.baseTest.design.zhuangshi;

/**
 * @author wanwei
 * @TODO  装饰者模式：在不改变原对象的基础上，对其方法进行加工
 *        方法： 原对象接口   原对象      
 *        定义一个原对象接口实现抽象类，使用装饰类继承并实现抽象类中原对象接口的方法：
 *        方法中一定要包含对于原对象方法的引用,这样才能保证被无限制地装饰
 *        
 *        
 *        装饰者模式强调的是对于方法的装饰,即对于原有的某个方法的加工，而不是让某一个对象拥有更多的方法
 * @date: 2018年9月28日 上午9:37:38 
 */
public interface InterfaceComponent {

	public void say(); 
}
