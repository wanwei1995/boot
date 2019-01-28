package com.ww.springboot.boot.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wanwei
 * @TODO  3、在这段程序中，main()方法相当于一个残忍的领导，他派发出许多任务，丢给一个叫 threadPool的任劳任怨的小组来做。
                                  这个小组里面队员至少有两个，如果他们两个忙不过来，任务就被放到任务列表里面。
                                  如果积压的任务过多，多到任务列表都装不下(超过3个)的时候，就雇佣新的队员来帮忙。但是基于成本的考虑，不能雇佣太多的队员，至多只能雇佣 4个。
                                  如果四个队员都在忙时，再有新的任务，这个小组就处理不了了，任务就会被通过一种策略来处理，我们的处理方式是不停的派发，直到接受这个任务为止(更残忍！呵呵)。
                                  因为队员工作是需要成本的，如果工作很闲，闲到 3SECONDS都没有新的任务了，那么有的队员就会被解雇了，但是，为了小组的正常运转，即使工作再闲，小组的队员也不能少于两个。
 * @date: 2019年1月3日 下午2:37:06 
 */
public class Test1 {

	private static int produceTaskSleepTime = 20;
	public static int consumeTaskSleepTime = 5000;
	private static int produceTaskMaxNumber = 20;
    // ArrayBlockingQueue 没有超的话，不会创建非核心线程
	public static void main(String[] args) throws InterruptedException {
		// 构造一个线程池
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 6, 1, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(4), new ThreadPoolExecutor.CallerRunsPolicy());
		
		//构造一个缓冲功能的线程池，配置corePoolSize=0，maximumPoolSize=Integer.MAX_VALUE，keepAliveTime=60s,以及一个无容量的阻塞队列 SynchronousQueue，因此任务提交之后，将会创建新的线程执行；线程空闲超过60s将会销毁 
		threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
		//threadPool.allowCoreThreadTimeOut(true);
		
		//构造一个只支持一个线程的线程池，配置corePoolSize=maximumPoolSize=1，无界阻塞队列LinkedBlockingQueue；保证任务由一个线程串行执行
		threadPool =new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
		
		
		for (int i = 1; i <= produceTaskMaxNumber; i++) {
			try {
				// 产生一个任务，并将其加入到线程池
				String task = "task@ " + i;
				System.out.println("put " + task);
				threadPool.execute(new ThreadPoolTask(task));
				System.out.println(threadPool.getActiveCount());

				// 便于观察，等待一段时间
				Thread.sleep(produceTaskSleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Thread.sleep(5000L);
		//
		for (int i = produceTaskMaxNumber+1; i <= produceTaskMaxNumber*2; i++) {
			try {
				// 产生一个任务，并将其加入到线程池
				String task = "task@ " + i;
				System.out.println("put " + task);
				threadPool.execute(new ThreadPoolTask(task));
				System.out.println(threadPool.getActiveCount());

				// 便于观察，等待一段时间
				Thread.sleep(produceTaskSleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
