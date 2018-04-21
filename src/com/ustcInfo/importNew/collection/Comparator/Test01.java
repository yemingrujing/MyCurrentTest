package com.ustcInfo.importNew.collection.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Comparator接口的子类型（需要重写compare方法实现元素的比较）
 * @author guang.wei
 * @datetime 2018年4月21日 下午4:03:04
 */
public class Test01 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>(); //// Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
		
		list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));
        
        Collections.sort(list, (o1, o2) -> {
        	return o1.getName().compareTo(o2.getName());
        });
        
        for(Student stu : list) {
        	System.out.println(stu);
        }
	}
}
