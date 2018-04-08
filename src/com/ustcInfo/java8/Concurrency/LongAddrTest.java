package com.ustcInfo.java8.Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发
 * CAS原子类增强：LongAddr
 * LongAddr是高性能的原子计数器，比atomicLong性能还要高。
 * 关于LongAddr的实现原理，简单来说就是解决了伪共享的问题
 * @author guang.wei
 * @datetime 2018年4月4日 下午11:18:56
 * LongAddr： 比AtomicLong性能更高的原子类
 * 本例比较加锁，AtomicLong，LongAddr  三种无锁
 */
public class LongAddrTest {
	static long maxValue = 100000000;
	static CountDownLatch countDownLatch = new CountDownLatch(10);
	public volatile long count = 0;
	
	public synchronized void incr() {
		if(getValue() < maxValue) count++;
	}
	
	public long getValue() {
		return count;
	}
	
	public static void main(String[] args) throws InterruptedException {
		LongAddrTest longAddrTest = new LongAddrTest();
		 long begin = System.currentTimeMillis();
		 ExecutorService executorService = Executors.newFixedThreadPool(10);
		 
		 for(int i = 0; i < 10; i++) {
			 executorService.execute(() -> {
				 while(longAddrTest.getValue() < maxValue) {
					 longAddrTest.incr();
				 }
				 countDownLatch.countDown();
			 });
		 }
		 
		 countDownLatch.await();
		 executorService.shutdown();
		 
		 System.out.println("总共耗时:" + (System.currentTimeMillis() - begin) + 
				 "毫秒, count=" + longAddrTest.getValue());
	}
}
