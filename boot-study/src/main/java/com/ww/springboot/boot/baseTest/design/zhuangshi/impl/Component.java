package com.ww.springboot.boot.baseTest.design.zhuangshi.impl;

import com.ww.springboot.boot.baseTest.design.zhuangshi.InterfaceComponent;

public class Component implements InterfaceComponent{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("Component.say():原组件的方法！");   
	}

}
