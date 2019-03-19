package com.ww.springboot.boot.baseTest.design.bridge2.b4;

public class NokiaBrand extends HandsetBrand{

	@Override
	public void run(Features features) {
		System.out.println("诺基亚品牌");
		features.run();
	}

}
