package com.ustcInfo.java8.FunctionInterface;

import org.junit.Test;

public class Hello3Impl implements Hello3 {

	@Override
	public void sayHello() {
		System.out.println("com.ustcInfo.java8.FunctionInterface.Hello3Impl.sayHello");
	}

	/**
	 * 这里必须重写，因为sayDefault已经不是一个默认方法
	 */
	@Override
	public void sayDefault() {
		System.out.println("com.ustcInfo.java8.FunctionInterface.Hello3Impl.sayDefault");
	}

	@Test
	public void test() {
		sayDefault();
		sayHello();
		sayDefault1();
	}
}
