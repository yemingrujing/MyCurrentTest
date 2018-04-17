package com.ustcInfo.jvm.thread.multithread.Condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition(用来实现线程间通信的)
 * Condition是个接口，基本的方法就是await()和signal()方法
 * Condition依赖于Lock接口，生成一个Condition的基本代码是lock.newCondition()
 * 调用Condition的await()和signal()方法，都必须在lock保护之内，就是说必须在lock.lock()和lock.unlock之间才可以使用
 * Conditon中的await()对应Object的wait()
 * Condition中的signal()对应Object的notify()
 * Condition中的signalAll()对应Object的notifyAll()
 * @author guang.wei
 * @datetime 2018年4月8日 下午5:34:21
 */
public class ConditionDemo {

	//可重入锁
	final Lock lock = new ReentrantLock();
	//写线程条件
	final Condition notFull = lock.newCondition();
	//读线程条件
	final Condition notEmpty = lock.newCondition();
	//缓存队列的深度
	final Object[] items = new Object[100];
	//写索引
	int putptr = 0;
	//读索引
	int takeptr = 0;
	//缓存队列中存在的数据个数
	int count = 0;
	/**
	 * 描述：模拟往队列里面放对象
	 * @param x
	 * @throws InterruptedException 
	 */
	public void put(Object x) throws InterruptedException {
		System.out.println("获取写锁！");
		//上锁
		lock.lock();
		try {
			/**
			 * 如果当前队列里面的对象个数和队列的深度相同，说明队列已经满了，准备阻塞写线程
			 * 注意，此处用while而不用if，是为了防止假唤醒 
			 */
			while(count == items.length) {
				System.out.println("队列已满，阻塞写线程！");
				//阻塞写线程
				notFull.await();
			}
			//写数据
			System.out.println("写入的数据为：" + x);
			items[putptr] = x;
			//如果当前的写索引和队列的深度相同，说明队列已经写满了，所以需要从索引0开始写数据
			if(++putptr == items.length) {
				putptr = 0;
			}
			//队列中的数据个数递增
			++count;
			//唤醒读线程
			notEmpty.signal();
		} finally {
			System.out.println("释放写锁");
			//释放锁
			lock.unlock();
		}
	}
	/**
	 * 描述：模拟从队列里面取对象
	 * @return
	 * @throws InterruptedException 
	 */
	public Object take() throws InterruptedException {
		System.out.println("获取读锁！");
		//上锁
		lock.lock();
		try {
			//如果当前队列里面没有数据，阻塞读线程，此处用while原因同上
			while(count == 0) {
				System.out.println("队列为空，阻塞读线程！");
				//阻塞读线程
				notEmpty.await();
			}
			//读数据
			Object x = items[takeptr];
			//如果读索引和队列的深度相同，说明已经读到了队列的最后一个数据，需要从0开始读
			if(++takeptr == items.length) {
				takeptr = 0;
			}
			//队列里面的个数递减
			--count;
			//唤醒写线程
			notFull.signal();
			//返回读取的对象
			return x;
		} finally {
			System.out.println("释放读锁！");
			//释放锁
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final ConditionDemo demo = new ConditionDemo();
		
		//新建N个写线程，且写比读快
		ExecutorService put = Executors.newCachedThreadPool();
		
		put.execute(() -> {
			for(int i = 0; i < 399; i++) {
				try {
					demo.put("putData" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		//新建N个读线程,读比写满
		ExecutorService take = Executors.newCachedThreadPool();
		take.execute(() -> {
			while(true) {
				try {
					Thread.sleep(200);
					String message = (String) demo.take();
					System.out.println("读取的数据为：" + message);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}); 
	}
}
