package com.ww.springboot.boot.baseTest.design.bridge2.b4;

import com.ww.springboot.boot.baseTest.design.bridge2.b4.impl.GameFeaturesImpl;

public class Test {
	
	public static void main(String[] args) {
		 HandsetBrand hs = new SanxinBrand(); 
		 Features fea = new GameFeaturesImpl();
		 hs.run(fea);
		 
	}

}
