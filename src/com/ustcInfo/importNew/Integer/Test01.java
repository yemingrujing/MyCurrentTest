package com.ustcInfo.importNew.Integer;

/**
 * Java是一个近乎纯洁的面向对象编程语言，但是为了编程的方便还是引入了基本数据类型，但是为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class）
 * int的包装类就是Integer，从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。
 * Java 为每个原始类型提供了包装类型：
 * - 原始类型: boolean，char，byte，short，int，long，float，double
 * - 包装类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double
 * @author guang.wei
 * @datetime 2018年4月20日 下午3:30:45
 */
public class Test01 {

	public static void main(String[] args) {
		Integer a = new Integer(3);
		Integer b = 3; //将3自动装箱成Integer类型
		int c = 3;
		System.out.println(a == b); //false 两个引用没有引用同一对象
		System.out.println(a == c); //true a自动拆箱成int类型再和c比较
	}
}
