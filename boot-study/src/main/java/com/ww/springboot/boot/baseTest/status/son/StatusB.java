package com.ww.springboot.boot.baseTest.status.son;

import com.ww.springboot.boot.baseTest.status.Status;
import com.ww.springboot.boot.baseTest.status.Work;

public class StatusB extends Status{

	@Override
	public void workStatus(Work w) {
		if(w.getHour()<16){
			System.out.println("精力还行");
		}else{
			w.setStatus(new StatusC());
			w.workStatus();
		}
		
	}

}
