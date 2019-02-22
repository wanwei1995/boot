package com.ww.springboot.boot.baseTest.design.bridge;

import com.ww.springboot.boot.baseTest.design.bridge.impl.Blue;
import com.ww.springboot.boot.baseTest.design.bridge.shapeSon.Circle;


//将颜色与形状分离
public class Test {

	public static void main(String[] args) {
		Shape shape = new Circle();
		Color color = new Blue();
		shape.setColor(color);
		shape.draw();
	}
}
