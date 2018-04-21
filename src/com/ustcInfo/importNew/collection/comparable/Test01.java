package com.ustcInfo.importNew.collection.comparable;

import java.util.Set;
import java.util.TreeSet;

/**
 * 实现Comparable接口从而根据键对元素进行排序
 * @author guang.wei
 * @datetime 2018年4月21日 下午3:54:28
 */
public class Test01 {

	public static void main(String[] args) {
		Set<Student> set = new TreeSet<>(); /// Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
		
		set.add(new Student("Hao Luo", 33));
		set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));
        
        for(Student stu : set) {
        	System.out.println(stu);
        }
	}
}
