package com.ustcInfo.java8.FunctionInterface;

public interface Hello3 extends Hello{
	
	/**
	 * 重新声明，成了普通抽象方法
	 */
	@Override
	void sayDefault();
}
