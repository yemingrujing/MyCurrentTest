package com.ustcInfo.util;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 新建LogFactory.Java（用于获取全局log，这里的全局log不同于jdk自带log的全局log，
 * jdk自带的全局log需要手动添加ConsoleHandler和FileHandler，这里只全部定义好了，只需要通过LogFactory.getGlobalLog()就可以获取到，使用的过程中会自动添加日志到对应的文件）
 * @author guang.wei
 * @datetime 2018年3月2日 上午10:57:35
 */
public class LogFactory {

	// 全局Log的名称
	public static final String LOG_NAME = "Global";
	// 这个文件路径必须存在，不存在会报错，并不会自动创建 
	public static final String LOG_FOLDER = "E:\\java\\log\\JDKLog";
	
	// log文件路径
	private static String log_filepath;
	
	// 静态变量globleLog
	private static Logger globalLog;
	
	static {
		 // 加载类的时候初始化log文件全路径，这里的文件名称是JDKLog_+时间戳+.log  
		log_filepath = LOG_FOLDER + File.separator + "JDKLog_" 
				+ LogUtil.getCurrentDateStr(LogUtil.DATE_PATTERN_NOMARK) 
				+ ".log";
		
		 // 加载类的时候直接初始化globleLog
		globalLog = initGlobalLog();
	}
	
	public static Logger initGlobalLog() {
		// 获取Log
		Logger log = Logger.getLogger(LOG_NAME);
		// 为log设置全局等级
		log.setLevel(Level.ALL);
		// 添加控制台handler
		LogUtil.addConsoleHandler(log, Level.INFO);
		// 添加文件输出handler 
		LogUtil.addFileHandler(log, Level.INFO, log_filepath);
		// 设置不适用父类的handlers，这样不会在控制台重复输出信息  
		log.setUseParentHandlers(false);
		
		return log;
	}
	
	public static Logger getGlobalLog() {
		return globalLog;
	}
}
