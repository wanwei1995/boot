package com.ww.springboot.boot.baseTest.design.bridge.impl;

import com.ww.springboot.boot.baseTest.design.bridge.Color;

public class Blue implements Color{

	@Override
	public void doPaint(String s) {
		// TODO Auto-generated method stub
		System.out.println("蓝色的"+s);
	}

}
