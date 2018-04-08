package com.ustcInfo.java8.Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * LongAddr： 比AtomicLong性能更高的原子类
 * 本例比较加锁，AtomicLong，LongAddr  三种无锁
 * @author guang.wei
 * @datetime 2018年4月8日 上午9:19:13
 */
public class LongAddrTest1 {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		AtomicLong atomicLong = new AtomicLong(0);
		
		long maxValue = 100000000;
		long begin = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 10; i++) {
			executorService.execute(() -> {
				while(atomicLong.get() < maxValue) {
					atomicLong.getAndIncrement();
				}
				countDownLatch.countDown();
			});
		}
		
		countDownLatch.await();
		executorService.shutdown();
		
		System.out.println("总共耗时:" + (System.currentTimeMillis() - begin) + 
				"毫秒, count=" + atomicLong.get());
	}
	
}
