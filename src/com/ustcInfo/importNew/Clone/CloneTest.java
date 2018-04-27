package com.ustcInfo.importNew.Clone;

/**
 * 基于序列化和反序列化实现的克隆不仅仅是深度克隆，
 * 更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，
 * 这项检查是编译器完成的，不是在运行时抛出异常，
 * 这种是方案明显优于使用Object类的clone方法克隆对象。
 * 让问题在编译的时候暴露出来总是优于把问题留到运行时。
 * @author guang.wei
 * @datetime 2018年4月20日 下午5:17:16
 */
public class CloneTest {

	public static void main(String[] args) {
		try {
	        Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
	        Person p2 = MyUtil.clone(p1);   // 深度克隆
	        p2.getCar().setBrand("BYD");
	        // 修改克隆的Person对象p2关联的汽车对象的品牌属性
	        // 原来的Person对象p1关联的汽车不会受到任何影响
	        // 因为在克隆Person对象时其关联的汽车对象也被克隆了
	        System.out.println(p1);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
