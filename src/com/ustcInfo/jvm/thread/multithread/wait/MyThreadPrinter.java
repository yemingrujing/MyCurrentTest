package com.ustcInfo.jvm.thread.multithread.wait;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ustcInfo.util.LogFactory;
import com.ustcInfo.util.LogUtil;

/**
 * 多线程学习,wait
 * @author guang.wei
 * @datetime 2018年3月12日 上午11:37:41
 */
public class MyThreadPrinter implements Runnable{
	
	public static Logger log = LogFactory.getGlobalLog();
	public static Logger sysLog = Logger.getGlobal();
	static {
		LogUtil.addFileHandler(log, Level.ALL, LogFactory.LOG_FOLDER 
				+ File.separator + "sys.log");
	}
	
	private String name;
	private Object prev;
	private Object self;
	
	private MyThreadPrinter(String name,Object prev,Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}
	
	@Override
	public void run() {
		int count = 10;
		while(count > 0) { //多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒  
			synchronized(prev) { // 先获取 prev 锁
				synchronized(self) { // 再获取 self 锁 
					System.out.println(name);
					count--;
					self.notifyAll(); // 先释放 self，唤醒其他线程竞争self锁 
				}
				try {
					prev.wait(); // 再释放 prev，休眠等待唤醒  
					/** 
                     * 注意的是notify()调用后，并不是马上就释放对象锁，而是在相应的synchronized(){}语句块执行结束，自动释放锁， 
                     * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。 
                     */  
				} catch (InterruptedException e) {
					log.log(Level.WARNING, e.getMessage());
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		MyThreadPrinter pa = new MyThreadPrinter("A", c, a);
		MyThreadPrinter pb = new MyThreadPrinter("B", a, b);
		MyThreadPrinter pc = new MyThreadPrinter("C", b, c);
		new Thread(pa).start();
		Thread.sleep(100);  //确保按顺序A、B、C执行  
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
	}
}
