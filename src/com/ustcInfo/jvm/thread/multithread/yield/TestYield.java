package com.ustcInfo.jvm.thread.multithread.yield;

/**
 * 测试yield
 * @author guang.wei
 * @datetime 2018年3月12日 上午11:12:47
 */
public class TestYield {
	public static void main(String[] args) {
		ThreadYield y1 = new ThreadYield("张三");
		ThreadYield y2 = new ThreadYield("李四");
		y1.start();
		y2.start();
	}
}
