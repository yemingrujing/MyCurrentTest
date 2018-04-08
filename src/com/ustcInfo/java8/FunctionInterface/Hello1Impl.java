package com.ustcInfo.java8.FunctionInterface;

import org.junit.Test;

public class Hello1Impl implements Hello1 {

	@Override
	public void sayHello() {
		System.out.println("com.ustcInfo.java8.FunctionInterface.Hello1Impl.sayHello1");
	}

	@Test
	public void test() {
		Hello1Impl impl = new Hello1Impl();
		impl.sayHello();;
		impl.sayDefault();
		sayDefault();
		sayDefault1();
		Hello.sayStatic();
	}
}
