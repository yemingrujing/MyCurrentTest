package com.ustcInfo.jvm.thread.multithread.join;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ustcInfo.util.LogFactory;
import com.ustcInfo.util.LogUtil;

/**
 * 加入join
 * @author guang.wei
 * @datetime 2018年3月2日 上午11:13:04
 */
public class TestHasJoin {

	public static Logger log = LogFactory.getGlobalLog();
	public static Logger sysLog = Logger.getGlobal();
	static {
		LogUtil.addFileHandler(log, Level.ALL, LogFactory.LOG_FOLDER 
				+ File.separator + "sys.log");
	}
	
	public static void main(String[] args) {
		log.info(Thread.currentThread().getName() + "主线程运行开始！");
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		mTh2.start();
		try {
			mTh1.join();
		} catch (InterruptedException e) {
			log.log(Level.ALL, e.getMessage(), e);
		}
		try {
			mTh2.join();
		} catch (InterruptedException e) {
			log.log(Level.ALL, e.getMessage(), e);
		}
		log.info(Thread.currentThread().getName() + "主线程运行结束！");
	}
}
