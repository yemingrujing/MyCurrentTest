package com.ustcInfo.java8.Lambda;

import java.util.Arrays;

/**
 * Lambda测试
 * 语法:parameter -> expression body
 * 1.可选类型声明 - 无需声明参数的类型。编译器可以从该参数的值推断。
 * 2.可选圆括号参数 - 无需在括号中声明参数。对于多个参数，括号是必需的。
 * 3.可选大括号 - 表达式主体没有必要使用大括号，如果主体中含有一个单独的语句。
 * 4.可选return关键字 - 编译器会自动返回值，如果主体有一个表达式返回的值。花括号是必需的，以表明表达式返回一个值。
 * @author guang.wei
 * @datetime 2018年4月3日 上午9:28:24
 */
public class LambdaTest {
	
	/**
	 * lambda表达式测试
	 * @param args
	 */
	public static void main(String[] args) {
		LambdaTest tester = new LambdaTest();
		//with type declaration
		MathOperation addtion = (int a, int b) -> a + b;
		//with out type declaration
		MathOperation subtraction = (a, b) -> a - b;
		//with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {return a * b;};
		//without return statement and without curly braces
		MathOperation division = (int a, int b) -> a/b;
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addtion));
		System.out.println("10 -5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 * 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));
		//with parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello!" + message);
		//without parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello!" + message);
		
		greetService1.sayMessage("Mary");
		greetService2.sayMessage("Lina");
		
		//数组遍历
		String[] arrayList = {"b","a","c","e","d"};
		Arrays.asList(arrayList).forEach(e -> System.out.print(e));
		Arrays.asList(arrayList).sort((e1, e2) -> e1.compareTo(e2));
		System.out.println();
		Arrays.asList(arrayList).forEach(e -> System.out.print(e));
	}
	
	interface MathOperation{
		int operation(int a, int b);
	}
	
	interface GreetingService{
		void sayMessage(String message);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
