package com.ustcInfo.java8.FunctionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * 函数式接口测试
 * @author guang.wei
 * @datetime 2018年4月3日 上午11:14:09
 */
public class FunctionInterfaceTest {

	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		//测试Predicate
		eval(list, abc -> true); //打印所有数字
		eval(list, abc -> false); //打印不是数字的
		eval(list, a -> a % 2 == 0);
		
		//测试BiFunction:表示接受两个参数，并产生一个结果的函数
		BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> {return a * b;};
		System.out.println(biFunction.apply(10, 2));
	}
	
	/**
	 * Predicate< T>接口接受一个T类型参数，返回一个boolean值
	 * @param list
	 * @param predicate
	 */
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		list.forEach(integer -> {if(predicate.test(integer)) System.out.println(integer);});
	}
}
