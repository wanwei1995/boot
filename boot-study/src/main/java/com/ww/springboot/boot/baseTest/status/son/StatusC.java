package com.ww.springboot.boot.baseTest.status.son;

import com.ww.springboot.boot.baseTest.status.Status;
import com.ww.springboot.boot.baseTest.status.Work;

public class StatusC extends Status{

	@Override
	public void workStatus(Work w) {
		if(w.getHour()<18){
			System.out.println("精力不足");
		}else{
			w.setStatus(new StatusD());
			w.workStatus();
		}	
	}
}
