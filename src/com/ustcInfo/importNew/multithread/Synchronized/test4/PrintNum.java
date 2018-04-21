package com.ustcInfo.importNew.multithread.Synchronized.test4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 10个线程按照顺序打印0~10
 * @author guang.wei
 * @datetime 2018年4月26日 下午3:03:41
 */
public class PrintNum {

	static int num = 0;
	
	public static void main(String[] args) {
		Lock printLock = new ReentrantLock();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 10; i++) {
			service.execute(() -> {
				printLock.lock();
				try {
					System.out.println(num);
					num++;
				} finally {
					printLock.unlock();
				}
			});
		}
		service.shutdown();
	}
}
