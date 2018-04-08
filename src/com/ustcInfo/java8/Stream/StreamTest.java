package com.ustcInfo.java8.Stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Stream测试
 * @author guang.wei
 * @datetime 2018年4月4日 上午10:13:52
 */
public class StreamTest {

	/**
	 * 把空指针过滤掉，返回前三个
	 */
	@Test
	public void test(){
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> list = strings.stream().filter(n -> !"".equals(n)).limit(3).collect(Collectors.toList());
		list.forEach(n -> System.out.println(n));
	}
	
	/**
	 * 计算集合每个元素的平方，并且去重，然后将值为81的去掉，输出排序后的数据
	 */
	@Test
	public void test2() {
		List<Integer> ints = Arrays.asList(1,5,9,6,5,4,2,5,9);
		ints.stream().map(n -> n*n).distinct().filter(n -> n != 81).
			sorted().collect(Collectors.toList()).
			forEach(n -> System.out.println(n));
	}
	
	/**
	 * 并行流，求和
	 */
	@Test
	public void test3() {
		List<Integer> ints = Arrays.asList(1,5,9,6,5,4,2,5,9);
		System.out.println(ints.parallelStream().filter(n -> n > 2).distinct().count());
		Integer sum = ints.parallelStream().map(n -> n * n).filter(n -> n != 81).reduce(Integer::sum).get();
		System.out.println(sum);
	}
	
	/**
	 * mapToInt将其转换为可以进行统计的数值型。类似的还有mapToLong、mapToDouble
	 */
	@Test
	public void test4() {
		List<Integer> ints = Arrays.asList(1,5,9,6,5,4,2,5,9);
		IntSummaryStatistics statistics = ints.stream().mapToInt(n -> n).summaryStatistics();
		System.out.println(statistics.getAverage());
		System.out.println(statistics.getCount());
		System.out.println(statistics.getMax());
		System.out.println(statistics.getMin());
	}
}
