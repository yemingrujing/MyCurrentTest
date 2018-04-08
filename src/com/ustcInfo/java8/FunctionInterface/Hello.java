package com.ustcInfo.java8.FunctionInterface;

/**
 * 函数式接口
 * 1.静态方法不可以被继承
 * 2.默认方法可以被继承
 * 3.函数式接口可以实现另一个函数式接口
 * 4.默认方法可以被重写
 * 5.默认方法重新声明，则变成了普通方法
 * @author guang.wei
 * @datetime 2018年4月3日 下午8:55:28
 */
public interface Hello {
	
	void sayHello();
	
	/**
	 * default方法可以有多个
	 */
	default void sayDefault() {
		System.out.println("我是default方法");
	}
	
	default void sayDefault1() {
		System.out.println("我是default11方法");
	}
	
	static void sayStatic() {
		System.out.println("我是static方法");
	}
}
