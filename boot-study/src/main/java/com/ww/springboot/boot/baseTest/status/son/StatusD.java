package com.ww.springboot.boot.baseTest.status.son;

import com.ww.springboot.boot.baseTest.status.Status;
import com.ww.springboot.boot.baseTest.status.Work;

public class StatusD extends Status{

	@Override
	public void workStatus(Work w) {
		if(w.getHour()<20 && !w.getFinish()){
			System.out.println("加班很困");
		}else{
			System.out.println("下班");
		}	
	}
}
