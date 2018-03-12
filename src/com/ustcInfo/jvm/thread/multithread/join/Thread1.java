package com.ustcInfo.jvm.thread.multithread.join;

/**
 * 多线程学习,join 
 * @author guang.wei
 * @datetime 2018年3月2日 上午10:21:46
 */
public class Thread1 extends Thread{
	private String name;
	public Thread1(String name) {
		super(name);
		this.name = name;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName() + "线程开始运行！");
		for(int i = 0; i < 5; i++) {
			System.out.println("子线程" + name + "运行" + i);
			try {
				sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}