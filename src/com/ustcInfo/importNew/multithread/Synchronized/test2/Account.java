package com.ustcInfo.importNew.multithread.Synchronized.test2;

/**
 * 线程同步以及线程调度-使用同步机制synchronized
 * 银行账户
 * @author guang.wei
 * @datetime 2018年4月23日 上午11:25:45
 */
public class Account {

	private double balance; //账户余额
	
	public synchronized void deposit(double money) {
		double newBalance = balance + money;
		try {
			Thread.sleep(10); //模拟此业务需要一段处理时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		balance = newBalance;
	}
	
	/**
	 * 获得账户余额
	 * @return
	 */
	public double getBalance() {
		return balance;
	}
}
