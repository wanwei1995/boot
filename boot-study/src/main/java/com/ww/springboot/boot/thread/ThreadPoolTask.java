package com.ww.springboot.boot.thread;

public class ThreadPoolTask implements Runnable {
	//保存任务所需要的数据
	private Object threadPoolTaskData;

	public ThreadPoolTask(String task) {
		// TODO Auto-generated constructor stub
		this.threadPoolTaskData = task;
	}

	@Override
	public void run() {
		//处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
		System.out.println("start .."+threadPoolTaskData);
		try {
		////便于观察，等待一段时间
		Thread.sleep(Test1.consumeTaskSleepTime);
		} catch (Exception e) {
		e.printStackTrace();
		}
		threadPoolTaskData = null;
		}
}
