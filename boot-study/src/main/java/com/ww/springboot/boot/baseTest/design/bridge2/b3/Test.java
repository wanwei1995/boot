package com.ww.springboot.boot.baseTest.design.bridge2.b3;

public class Test {
	
	public static void main(String[] args) {
		HandsetBrand sx = new NokiaAddressBook();
		sx.run();
		sx = new SanxinAddressBook();
		sx.run();
		sx = new NokiaGame();
		sx.run();
		sx = new SanxinGame();
		sx.run();
	}

}
