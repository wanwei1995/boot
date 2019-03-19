package com.ww.springboot.boot.baseTest.design.bridge2.b4;

public class SanxinBrand extends HandsetBrand{

	@Override
	public void run(Features features) {
		// TODO Auto-generated method stub
		System.out.println("三星品牌");
		features.run();
	}

}
