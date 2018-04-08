package com.ustcInfo.java8.parallel;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * parallel测试
 * 并行（parallel）数组
 * parallelSort()方法:可以在多核机器上极大提高数组排序的速度
 * @author guang.wei
 * @datetime 2018年4月4日 下午11:09:57
 */
public class parallelTest {

	/**
	 * 并行初始化一个20000的数组，并且填充1000000内的随机数，然后并行排序
	 * @param args
	 */
	public static void main(String[] args) {
		LocalTime begin = LocalTime.now();
		long[] arrayOfLong = new long[20000];
		
		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		Arrays.parallelSort(arrayOfLong);
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println(Duration.between(begin, LocalTime.now()));
	}
}
