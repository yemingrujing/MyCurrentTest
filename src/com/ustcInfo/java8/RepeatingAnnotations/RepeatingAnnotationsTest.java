package com.ustcInfo.java8.RepeatingAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 重复注解允许同一个位置声明多次注解。
 * 重复注解机制本身必须用@Repeatable注解。
 * 事实上，这并不是语言层面上的改变，更多的是编译器的技巧，底层的原理保持不变。
 * @author guang.wei
 * @datetime 2018年4月3日 下午10:37:33
 */
public class RepeatingAnnotationsTest {

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}
	
	/**
	 * 使用@Repeatable( Filters.class )注解的注解类Filter，
	 * Filters仅仅是Filter注解的数组，
	 * 但Java编译器并不想让程序员意识到Filters的存在
	 * @author guang.wei
	 * @datetime 2018年4月4日 上午9:24:04
	 */
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value();
	}
	
	@Filter("filter1")
	@Filter("filter2")
	public interface Filterable {
		
	}
	
	public static void main(String[] args) {
		//函数getAnnotationsByType()返回重复注解的类型
		//Filterable.class.getAnnotation( Filters.class )经编译器处理后将会返回Filters的实例
		for(Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
			System.out.println(filter.value());
		}
	}
}
