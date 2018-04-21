package com.ustcInfo.importNew.multithread.Synchronized.test1;

/**
 * 线程同步以及线程调度-没有使用同步机制
 * 银行账户
 * @author guang.wei
 * @datetime 2018年4月23日 上午9:44:09
 */
public class Account {
	
	private double balance; //账户余额
	
	/**
	 * 存款
	 * @param money 存入金额
	 */
	public void deposit(double money) {
		double newBalance = balance + money;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		balance = newBalance;
	}
	
	/**
	 * 获得账户余额
	 */
	public double getBalance() {
		return balance;
	}
}
