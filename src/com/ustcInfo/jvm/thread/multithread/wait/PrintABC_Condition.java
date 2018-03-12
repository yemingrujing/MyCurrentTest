package com.ustcInfo.jvm.thread.multithread.wait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序打印ABC
 * @author guang.wei
 * @datetime 2018年3月12日 下午8:44:57
 */
public class PrintABC_Condition {
	private static Lock lock = new ReentrantLock();
	private static Condition A = lock.newCondition();
	private static Condition B = lock.newCondition();
	private static Condition C = lock.newCondition();
	
	private static int count = 0;
	
	static class ThreadA extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for(int i = 0; i < 10; i++) {
					while(count % 3 != 0) {
						A.await(); // A释放lock锁 
					}
					System.out.println("A");
					count++;
					B.signal(); // A执行完唤醒B线程 
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
	
	static class ThreadB extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for(int i = 0; i < 10; i++) {
					while(count % 3 != 1) {
						B.await(); // B释放lock锁 
					}
					System.out.println("B");
					count++;
					C.signal(); // AC执行完唤醒B线程 
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
	
	static class ThreadC extends Thread {
		@Override
		public void run() {
			try {
				lock.lock(); //获得锁
				for(int i = 0; i < 10; i++) {
					while(count % 3 != 2) {
						C.await(); // C释放lock锁
					}
					System.out.println("C");
					count++;
					A.signal(); // C执行完唤醒A线程  
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ThreadA().start();
		new ThreadB().start();
		ThreadC threadC = new ThreadC();
		threadC.start();
		threadC.join();
		System.out.println(count);
	}
}
