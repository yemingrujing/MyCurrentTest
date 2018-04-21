package com.ustcInfo.importNew.multithread.Synchronized.test3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步以及线程调度-使用同步机制Lock
 * 银行账户
 * @author guang.wei
 * @datetime 2018年4月24日 下午9:33:50
 */
public class Account {

	private Lock accountLock = new ReentrantLock();
	private double balance; // 账户余额
	
	/**
	 * 存款
	 * @param money
	 */
	public void deposit(double money) {
		accountLock.lock();
		double newBalance = balance + money;
		try {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance = newBalance;
		} finally {
			accountLock.unlock();
		}
	}
	
	/**
	 * 获得账户余额
	 * @return
	 */
	public double getBalance() {
		return balance;
	}
}
