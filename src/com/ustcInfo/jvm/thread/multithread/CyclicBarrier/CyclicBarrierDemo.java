package com.ustcInfo.jvm.thread.multithread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier是一个同步工具类，它允许一组线程在到达某个栅栏点(common barrier point)互相等待，发生阻塞，直到最后一个线程到达栅栏点，栅栏才会打开，处于阻塞状态的线程恢复继续执行.
 * 它非常适用于一组线程之间必需经常互相等待的情况
 * CyclicBarrier字面理解是循环的栅栏，之所以称之为循环的是因为在等待线程释放后，该栅栏还可以复用。
 * CyclicBarrier有两个构造函数：
 * public CyclicBarrier(int parties) 参数parties指定线程数量，当指定的线程值都到达栅栏点时，栅栏打开，线程恢复
 * public CyclicBarrier(int parties, Runnable barrierAction) 用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景
 * @author guang.wei
 * @datetime 2018年4月8日 下午6:48:05
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) throws InterruptedException {
		final CyclicBarrier barrier = new CyclicBarrier(5, () -> {
			System.out.println("所有人都到了,开始活动。。。。。");
		});
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			service.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + "到大目的地了");
					Thread.sleep(2000);
					//await() 调用该方法会使当前线程在栅栏点发生阻塞，直到指定的线程数量都达到栅栏点时恢复执行
					//await(long timeout, TimeUnit unit) 类似于await()，增加了超时时间参数。
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			});
		}
		service.shutdown();
	}
}
