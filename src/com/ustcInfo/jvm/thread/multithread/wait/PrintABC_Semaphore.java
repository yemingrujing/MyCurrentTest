package com.ustcInfo.jvm.thread.multithread.wait;

import java.util.concurrent.Semaphore;

/**
 * 顺序打印ABC--信号量
 * @author guang.wei
 * @datetime 2018年3月12日 下午8:56:17
 */
public class PrintABC_Semaphore {
	private static Semaphore A = new Semaphore(1);
	private static Semaphore B = new Semaphore(0);
	private static Semaphore C = new Semaphore(0);
	
	static class ThreadA extends Thread{
		@Override
		public void run() {
			try {
				for(int i = 0; i < 10; i++) {
					A.acquire(); //A获取信号执行
					System.out.println("A");
					B.release(); //B释放信号，B信号量为1，可以执行
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ThreadB extends Thread {
		@Override
		public void run() {
			try {
				for(int i = 0; i < 10; i++) {
					B.acquire();
					System.out.println("B");
					C.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ThreadC extends Thread {
		@Override
		public void run() {
			try {
				for(int i = 0; i < 10; i++) {
					C.acquire();
					System.out.println("C");
					A.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}
}
