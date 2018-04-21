package com.ustcInfo.importNew.jvm;

/**
 * 创建对象时构造器的调用顺序是：先初始化静态成员，然后调用父类构造器，再初始化非静态成员，最后调用自身构造器。
 * @author guang.wei
 * @datetime 2018年4月20日 下午5:31:06
 */
public class Hello {

	public static void main(String[] args) {
		A ab = new B();
		ab = new B();
	}
}
