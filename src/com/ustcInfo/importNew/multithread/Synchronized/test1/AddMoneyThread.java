package com.ustcInfo.importNew.multithread.Synchronized.test1;

import lombok.AllArgsConstructor;

/**
 * 存钱线程
 * @author guang.wei
 * @datetime 2018年4月23日 上午9:52:09
 */
@AllArgsConstructor
public class AddMoneyThread implements Runnable {

	private Account account; //存入账户
	private double money; //存入金额
	
	@Override
	public void run() {
		account.deposit(money);
	}

}
