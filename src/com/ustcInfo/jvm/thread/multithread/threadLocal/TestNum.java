package com.ustcInfo.jvm.thread.multithread.threadLocal;

/**
 * ThreadLocal完全不提供锁，而使用了以空间换时间的手段，为每个线程提供变量的独立副本，以保障线程安全，
 * 因此它不是一种数据共享的解决方案
 * @author guang.wei
 * @datetime 2018年3月10日 下午2:44:13
 */
public class TestNum {
	// 通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};
	//获取下一个序列值
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	public static void main(String[] args) {
		TestNum sn = new TestNum();
		//3个线程共享sn，各自产生序列号
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}
	private static class TestClient extends Thread{
		private TestNum sn;
		public TestClient(TestNum sn) {
			this.sn = sn;
		}
		public void run() {
			for(int i = 0; i < 3; i++) {
				System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
						+ sn.getNextNum() + "]");
			}
		}
	}
}
