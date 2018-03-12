package com.ustcInfo.jvm.thread.multithread.wait;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序打印ABC
 * @author guang.wei
 * @datetime 2018年3月12日 下午8:45:12
 */
public class PrintABC_Lock {

	private static Lock lock = new ReentrantLock(); ////通过JDK5中的Lock锁来保证线程的访问的互斥
	private static int state = 0;
	
	static class ThreadA extends Thread {
		@Override
		public void run() {
			for(int i = 0; i < 10;) {
				try {
					lock.lock();
					while(state % 3 == 0) { //多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
						System.out.println("A");
						state++;
						i++;
					}
				} finally {
					lock.unlock(); //lock()和unlock()操作结合try/catch使用  
				}
			}
		}
	}
	
	static class ThreadB extends Thread {
		@Override
		public void run() {
			for(int i = 0; i < 10;) {
				try {
					lock.lock();
					while(state % 3 == 1) {
						System.out.println("B");
						state++;
						i++;
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}
	
	static class ThreadC extends Thread {
		@Override
		public void run() {
			for(int i = 0; i < 10;) {
				try {
					lock.lock();
					while(state % 3 == 2) {
						System.out.println("C");
						state++;
						i++;
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
	}
}
