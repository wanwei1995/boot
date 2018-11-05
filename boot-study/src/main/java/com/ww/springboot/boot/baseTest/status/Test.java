package com.ww.springboot.boot.baseTest.status;

/**
 * @author wanwei
 * @TODO  状态模式:消除庞大分支  ---适用于有规律性的条件分支汇中 （可以方便的更改每一个分支而不影响其他分支）
 *        原理：将庞大分支拆成一个一个的分支并在分支中进行逻辑判断，判断是本分支还是下一分支
 * @date: 2018年10月9日 上午10:07:54 
 */
public class Test {
	
	public static void main(String[] args) {
		Work work = new Work();
		work.setHour(9);
		work.workStatus();
		work.setHour(12);
		work.workStatus();
		work.setHour(14);
		work.workStatus();
		work.setHour(16);
		work.workStatus();
		work.setHour(18);
		work.workStatus();
		work.setHour(19);
		work.setFinish(true);
		work.workStatus();
		Work work2 = new Work();
		work2.setHour(12);
		work2.setFinish(true);
		work2.workStatus();
		
	}

}
