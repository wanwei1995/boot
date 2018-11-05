package com.ww.springboot.boot.baseTest.design.zhuangshi.impl;

import com.ww.springboot.boot.baseTest.design.zhuangshi.InterfaceComponent;

public class DecoratorTwo extends AbstractDecorator{

	public DecoratorTwo(InterfaceComponent component) {
		super(component);
	}
	public void preSay(){   
        System.out.println("DecoratorTwo.preSay():装饰者二的preSay()方法！");   
    }   
	public void afterSay(){   
        System.out.println("DecoratorTwo.afterSay():装饰者二的afterSay()方法！");   
    }   

}
