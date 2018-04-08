package com.ustcInfo.java8.MethodReferences;

public class Person {

	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void printPerson() {
		System.out.println(this.getName() + ":" + this.getAge());
	}
	
	public static int compareByAge(Person a, Person b) {
		return a.getAge() - b.getAge();
	}
}
