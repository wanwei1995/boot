package com.ww.springboot.boot.baseTest.design.builder.impl;

import com.ww.springboot.boot.baseTest.design.builder.Human;
import com.ww.springboot.boot.baseTest.design.builder.IBuildHuman;

public class Director {
	public Human createHumanByDirecotr(IBuildHuman bh){
		bh.buildBody();
		bh.buildFoot();
		bh.buildHand();
		bh.buildHead();
		return bh.createHuman();
	}
}

