package com.ustcInfo.java8.FunctionInterface;

/**
 * 继承Hello
 * 重写默认方法
 * @author guang.wei
 * @datetime 2018年4月3日 下午9:05:16
 */
public interface Hello2 extends Hello{
	
	@Override
	default void sayDefault() {
		System.out.println("我是重写的Hello的default方法!");
	}
}
