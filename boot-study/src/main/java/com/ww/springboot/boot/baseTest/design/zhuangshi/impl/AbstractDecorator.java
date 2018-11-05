package com.ww.springboot.boot.baseTest.design.zhuangshi.impl;

import com.ww.springboot.boot.baseTest.design.zhuangshi.InterfaceComponent;

public class AbstractDecorator implements InterfaceComponent{

	private InterfaceComponent component;
	
	public AbstractDecorator(InterfaceComponent component){   
        this.component = component;   
    }   
	
	
	public void preSay() {
		
	}
	public void afterSay(){
	
	}
	
	public void say(){   
        preSay();   
        component.say();   
        afterSay();      
    };   
	
}