package com.ustcInfo.importNew.multithread.Synchronized.test4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程轮流打印数字
 * @author guang.wei
 * @datetime 2018年4月26日 下午3:15:03
 */
public class TwoThreadPrinter {

	private Lock threadLock = new ReentrantLock();
	private boolean flag = false;
	int count = 10;
	
	Thread aThread = new Thread(() -> {
		while(true) {
			// 锁定
			threadLock.lock();
			try {
				if(count < 1) {
					return;
				}
				if(flag) {
					// aThread的任务
					System.out.println(Thread.currentThread().getName() + "-->" + (count--));
					flag = !flag;
				}
			} finally {
				// 释放锁
				threadLock.unlock();
			}
		}
	});
	
	Thread bThread = new Thread(() -> {
		while(true) {
			// 锁定
			threadLock.lock();
			try {
				if(count < 1) {
					return;
				}
				if(!flag) {
					// bThread的任务
					System.out.println(Thread.currentThread().getName() + "-->" + (count--));
					flag = !flag;
				}
			} finally {
				threadLock.unlock();
			}
		}
	});
	
	public void startTwoThread() {
		aThread.start();
		bThread.start();
	}
	
	public static void main(String[] args) {
		TwoThreadPrinter twoThreadPrinter = new TwoThreadPrinter();
		twoThreadPrinter.startTwoThread();
	}
}
