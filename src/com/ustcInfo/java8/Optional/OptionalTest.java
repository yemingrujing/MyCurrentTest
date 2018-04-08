package com.ustcInfo.java8.Optional;

import java.util.Optional;

import org.junit.Test;

/**
 * 测试Optional，常用的几个方法
 * ofNullable：如果不为null, 则返回一个描述指定值的Optional；否则返回空的Optional
 * of：如果不为null, 则返回一个描述指定值的Optional；否则报异常
 * isPresent：如果有值存在，则返回TRUE，否则返回false
 * orElse：如果有值，则返回当前值；如果没有，则返回other
 * get：如果有值，则返回当前值；否则返回NoSuchElementException
 * @author guang.wei
 * @datetime 2018年4月4日 上午9:25:11
 */
public class OptionalTest {

	@Test
	public void test1() {
		OptionalTest java8Tester = new OptionalTest();
		
		Integer value1 = null;
		Integer value2 = new Integer(10);
		//Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);
		//Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		
		System.out.println(java8Tester.sum(a, b));
	}
	
	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		//Optional.isPresent[判断值是否存在] - checks the value is present or not
		System.out.println("First parameter is present:" + a.isPresent());
		System.out.println("Second parameter is present:" + b.isPresent());
		
		//Optional.orElse - returns the value if present otherwise returns
		//the default value passed.
		Integer value1 = a.orElse(new Integer(0));
		
		//Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		
		return value1 + value2;
	}
}
