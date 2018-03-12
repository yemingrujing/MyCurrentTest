package com.ustcInfo.jvm.thread.multithread.join;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ustcInfo.util.LogFactory;
import com.ustcInfo.util.LogUtil;

/**
 * 没有加入join
 * @author guang.wei
 * @datetime 2018年3月2日 上午11:03:14
 */
public class TestNoJoin {

	// 自定义的全局log（个人一般用这个记录） 
	private static Logger log = LogFactory.getGlobalLog();
	// Jdk1.7以后自带的全局log（后面我添加了FileHandler，用于写入文件日志）
	private static Logger sysLog = Logger.getGlobal();
	static {
		LogUtil.addFileHandler(sysLog, Level.ALL, LogFactory.LOG_FOLDER 
				+ File.separator + "sys.log");
	}
	
	public static void main(String[] args) {
		log.info(Thread.currentThread().getName() + "主线程运行开始！");
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		mTh2.start();
		log.info(Thread.currentThread().getName() + "主线程运行结束！");
	}
}
