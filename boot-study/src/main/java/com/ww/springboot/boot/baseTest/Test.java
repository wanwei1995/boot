package com.ww.springboot.boot.baseTest;

import com.ww.springboot.boot.baseTest.design.builder.impl.Director;
import com.ww.springboot.boot.baseTest.design.builder.impl.SmartManBuilder;
import com.ww.springboot.boot.baseTest.design.zhuangshi.InterfaceComponent;
import com.ww.springboot.boot.baseTest.design.zhuangshi.impl.Component;
import com.ww.springboot.boot.baseTest.design.zhuangshi.impl.DecoratorOne;
import com.ww.springboot.boot.baseTest.design.zhuangshi.impl.DecoratorTwo;

public class Test {
	public static void main(String args[]) {
		//装饰者模式
		InterfaceComponent interfaceComponent = new DecoratorOne(new DecoratorOne(new DecoratorTwo(new Component())));
		interfaceComponent.say();
		
		
		//建造者模式
		Director director = new Director();
		System.out.println(director.createHumanByDirecotr(new SmartManBuilder()).toString());
		
	}
}
