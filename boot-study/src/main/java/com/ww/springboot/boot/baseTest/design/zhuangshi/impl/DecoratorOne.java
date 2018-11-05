package com.ww.springboot.boot.baseTest.design.zhuangshi.impl;

import com.ww.springboot.boot.baseTest.design.zhuangshi.InterfaceComponent;

public class DecoratorOne extends AbstractDecorator {

	public DecoratorOne(InterfaceComponent component) {
		super(component);
	}

	public void preSay() {
		System.out.println("DecoratorTwo.preSay():装饰者一的preSay()方法！");
	}

	public void afterSay() {
		System.out.println("DecoratorTwo.afterSay():装饰者一的afterSay()方法！");
	}

	
}
