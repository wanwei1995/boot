package com.ww.springboot.boot.baseTest.status.son;

import com.ww.springboot.boot.baseTest.status.Status;
import com.ww.springboot.boot.baseTest.status.Work;

public class StatusA extends Status {

	@Override
	public void workStatus(Work w) {
		if(w.getHour()<12){
			System.out.println("精力充沛");
		}else{
			w.setStatus(new StatusB());
			w.workStatus();
		}
		
	}

}
