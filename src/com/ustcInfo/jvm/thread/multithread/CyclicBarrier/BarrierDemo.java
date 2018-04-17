package com.ustcInfo.jvm.thread.multithread.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		final CyclicBarrier barrier = new CyclicBarrier(5, () -> {
			System.out.println("所有线程已到达栅栏点");
			try {
				/**
				 * TimeUnit是java.util.concurrent包下面的一个类，TimeUnit提供了可读性更好的线程暂停操作，通常用来替换Thread.sleep()，
				 * 在很长一段时间里Thread的sleep()方法作为暂停线程的标准方式,它是一个静态方法，暂停线程时它不会释放锁，该方法会抛出InterrupttedException异常（如果有线程中断了当前线程）
				 * Thread.sleep()是一个重载方法，可以接收长整型毫秒和长整型的纳秒参数，可读性差
				 * TimeUnit类解决了这个问题，通过指定DAYS、HOURS、MINUTES,SECONDS、MILLISECONDS和NANOSECONDS
				 * 除了sleep的功能外，TimeUnit还提供了便捷方法用于把时间转换成不同单位，例如，如果你想把秒转换成毫秒，你可以使用下面代码：TimeUnit.SECONDS.toMillis(44)
				 * TimeUnit在并发编程中也是一个关键API
				 */
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}) ;
		for(int i = 0; i < 5; i++) {
			service.execute(new Player("玩家" + i,barrier));
		}
	}
}
