package com.ustcInfo.jvm.thread.multithread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量(Semaphore)
 * 拿到信号量的线程可以进入代码，否则就等待。通过acquire()和release()获取和释放访问许可。
 * Semaphore有两个构造方法 Semaphore(int)、Semaphore(int,boolean)，
 * 参数中的int表示该信号量拥有的许可数量，boolean表示获取许可的时候是否是公平的，如果是公平的那么，当有多个线程要获取许可时，会按照线程来的先后顺序分配许可，否则，线程获得许可的顺序是不定的。
 * @author guang.wei
 * @datetime 2018年4月8日 下午4:55:59
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		//只能允许5个客户端线程访问服务器资源
		final Semaphore semaphore = new Semaphore(5);
		//新建30个线程，模拟客户端同时有30个请求线程
		ExecutorService service = Executors.newFixedThreadPool(30);
		//模拟提交30个请求给服务器
        for(int i = 0; i < 30; i++){ 
        	service.execute(() -> {
        		try {
        			//获取许可
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "线程持有信号量");
					//模拟请求服务器资源
					Thread.sleep(2000);
					System.out.println("当前可用的信号量为：" + semaphore.availablePermits());
					//访问完后，释放资源
					System.out.println(Thread.currentThread().getName() + "线程释放信号量");
					semaphore.release();
					System.out.println("当前可用的信号量为：" + semaphore.availablePermits());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	});
        }
        //释放线程资源
    	service.shutdown();
	}
}
