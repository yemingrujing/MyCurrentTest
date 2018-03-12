package com.ustcInfo.jvm.thread.multithread.yield;

/**
 * 多线程学习,yield
 * @author guang.wei
 * @datetime 2018年3月12日 上午11:13:02
 */
public class ThreadYield extends Thread{
	public ThreadYield(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i <= 50; i++) {
			System.out.println("" + this.getName() + "---------" + i);
			if(i == 30) {
				// 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
				this.yield();
			}
		}
	}
}