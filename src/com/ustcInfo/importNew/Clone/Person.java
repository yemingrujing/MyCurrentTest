package com.ustcInfo.importNew.Clone;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 人类
 * @author guang.wei
 * @datetime 2018年4月20日 下午5:18:18
 */
@Getter
@Setter
@AllArgsConstructor //自动生成全参数构造函数。
@NoArgsConstructor //自动生成无参数构造函数。
public class Person implements Serializable {
	
	private static final long serialVersionUID = 9221958594265565027L;
	
	private String name; //姓名
	private int age; //年龄
	private Car car; //座驾
	
	@Override
	public String toString() {
		 return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
