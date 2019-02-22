package com.ww.springboot.boot.baseTest.design.bridge.shapeSon;

import com.ww.springboot.boot.baseTest.design.bridge.Shape;

public class Circle extends Shape{

	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		getColor().doPaint("正方形");
	}

}
