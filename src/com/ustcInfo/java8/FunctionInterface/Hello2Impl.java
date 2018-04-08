package com.ustcInfo.java8.FunctionInterface;

import org.junit.Test;

public class Hello2Impl implements Hello2 {

	@Override
	public void sayHello() {
		System.out.println("com.ustcInfo.java8.FunctionInterface.Hello2Impl.sayHello");
	}
	
	@Test
	public void test() {
		Hello2Impl impl = new Hello2Impl();
		impl.sayHello();
		impl.sayDefault();
		
		sayDefault();
		sayDefault1();
	}

}
