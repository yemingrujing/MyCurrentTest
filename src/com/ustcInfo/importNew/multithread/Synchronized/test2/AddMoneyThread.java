package com.ustcInfo.importNew.multithread.Synchronized.test2;

import lombok.AllArgsConstructor;
/**
 * 存钱线程
 * @author guang.wei
 * @datetime 2018年4月23日 上午11:30:32
 */
@AllArgsConstructor
public class AddMoneyThread implements Runnable {
	
	private Account account; //存入账户
	private double money; //存入金额
	@Override
	
	public void run() {		
		synchronized(account) {
			account.deposit(money);
		}
	}
}
