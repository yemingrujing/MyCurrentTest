package com.ustcInfo.importNew.Integer;

public class Test02 {

	public static void main(String[] args) {
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
		
		System.out.println(f1 == f2); //如果整型字面量的值在-128到127之间，那么不会new新的Integer对象
		System.out.println(f3 == f4); //而是直接引用常量池中的Integer对象，所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
	}
}
