package com.ustcInfo.java8.Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAddr： 比AtomicLong性能更高的原子类
 * 本例比较加锁，AtomicLong，LongAddr  三种无锁
 * @author guang.wei
 * @datetime 2018年4月8日 上午9:40:38
 * AtomicLong，LongAddr两个比加锁性能提高了很多，LongAddr又比AtomicLong性能高。
 * 所以我们以后在遇到线程安全的原子计数器的时候，首先考虑LongAddr
 */
public class LongAddrTest2 {

	public static void main(String[] args) throws InterruptedException {
		//CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行
		//CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量
		CountDownLatch countDownLatch = new CountDownLatch(10);
		LongAdder longAdder = new LongAdder();
		
		long maxValue = 100000000;
		long begin = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 10; i++) {
			executorService.execute(() -> {
				while(longAdder.sum() < maxValue) {
					longAdder.increment();
				}
				//CountDownLatch.countDown()通知CountDownLatch对象，他们已经完成了各自的任务
				//每调用一次这个方法，在构造函数中初始化的count值就减1。所以当N个线程都调 用了这个方法，count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务
				countDownLatch.countDown();
			});
		}
		
		//与CountDownLatch的第一次交互是主线程等待其他线程。
		//主线程必须在启动其他线程后立即调用CountDownLatch.await()方法,这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
		countDownLatch.await();
		executorService.shutdown();
		
		System.out.println("总共耗时:" + (System.currentTimeMillis() - begin) + 
				"毫秒, count=" + longAdder.sum());
	}
}
