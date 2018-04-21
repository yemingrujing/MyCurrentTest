package com.ustcInfo.importNew.collection.comparable;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * lombok.AllArgsConstructor 增加全参构造器
 * lombok.NoArgsConstructor 增加无参构造
 * lombok.RequiredArgsConstructor 增加必选参数构造器
 * @author guang.wei
 * @datetime 2018年4月21日 下午3:45:49
 */
@ToString
@AllArgsConstructor
public class Student implements Comparable<Student> {

	private String name; //姓名
	private int age; //年龄
	
	@Override
	public int compareTo(Student o) {
		
		return this.age - o.age;
	}
}
