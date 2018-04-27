package com.ustcInfo.importNew.Exception;

class Annoyance extends Exception {
};

class Sneeze extends Annoyance {
};

/**
 * 根据里氏代换原则[能使用父类型的地方一定能使用子类型
 * 
 * @author guang.wei
 * @datetime 2018年4月21日 下午3:40:43
 */
public class Human {

	public static void main(String[] args) throws Exception {
		try {
			try {
				throw new Sneeze();
			} catch (Annoyance a) {
				System.out.println("Caught Annoyance");
				throw a;
			}
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
			return;
		} finally {
			System.out.println("Hello World!");
		}
	}
}
