package com.ww.springboot.boot.baseTest.sync;

/**
 * @author wanwei
 * @TODO  synchronized 使用测试1   ：1.一个线程获取对象锁，另一个需要等待 ：   
 *                                  2.未锁的方法可以被任意调用
 * 
 * synchronized 可修饰方法或代码块，修饰方法和代码块功能一样：就是将其上锁，等待执行完毕后才能解锁，其他的线程才能访问；
 *              1.场景：test1 test2 都是方法上锁 ：同一个syncTest1在不同的线程中调用任意一个方法都需等待解锁
 *              2.场景：test1代码块上锁，test2方法上锁；同一个syncTest1在不同的线程中，需要等待其中一个方法解锁才能跑另外一个
 *              为什么要使用代码块上锁 ： 代码块1循环5次，代码块2循环10000次，代码块1需要上锁，如果锁住方法，则需要等全部循环结束才能解锁，
 *                                     如果锁住代码块1，则只需要等代码块1解锁，其他即可调用此方法
 * @date: 2018年9月26日 下午3:23:22 
 */
public class syncTest1 {
	
	public void test1() 
    {  
         synchronized(this) 
         {  
              int i = 5;  
              while( i-- > 0) 
              {  
                   System.out.println(Thread.currentThread().getName() + " : " + i);  
                   try 
                   {  
                        Thread.sleep(1000);  
                   } 
                   catch (InterruptedException ie) 
                   {  
                   }  
              }  
         }  
         int j = 10;  
         while( j-- > 5) 
         {  
              System.out.println(Thread.currentThread().getName() + " : " + j);  
              try 
              {  
                   Thread.sleep(1000);  
              } 
              catch (InterruptedException ie) 
              {  
              }  
         }  
    }  
	
	public synchronized void test2() 
    {  
         int i = 5;  
         while( i-- > 0) 
         {  
              System.out.println(Thread.currentThread().getName() + " : " + i);  
              try 
              {  
                   Thread.sleep(1000);  
              } 
              catch (InterruptedException ie) 
              {  
              }  
         }  
    }  
	
	public static void main(String[] args) 
    {  
         final syncTest1 myt2 = new syncTest1();  
         Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );  
         Thread test2 = new Thread(  new Runnable() {  public void run() { myt2.test2();   }  }, "test2"  );  
         test1.start();;  
         test2.start();  
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    } 

}


