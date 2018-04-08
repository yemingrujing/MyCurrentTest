package com.ustcInfo.java8.MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 方法引用测试
 * 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 * @author guang.wei
 * @datetime 2018年4月3日 下午9:35:39
 */
public class MethodReferencesTest {
	
	public void print() {
		System.out.println("sdfs");
	}
	
	@Test
	public void test1() {
		List<String> names = new ArrayList<String>();
		names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");
        
        names.forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		String[] array = {"gjyg", "ads", "jk"};
		Arrays.sort(array, String::compareToIgnoreCase);
		Arrays.asList(array).forEach(e -> System.out.println(e));
	}
	
	class ComparisonProvider{
		public int compareByName(Person a, Person b) {
			return a.getName().compareTo(b.getName());
		}
		
		public int compareByAge(Person a, Person b) {
			return a.getAge() - b.getAge();
		}
	}
	
	@Test
	public void test3() {
		Person[] persons = initPerson();
		Arrays.asList(persons).stream().forEach(person -> System.out.println(person.getName() + ":" + person.getAge()));
		
		
		System.out.println("*******以下是lambda表达式写法*******");
		Arrays.sort(persons, (a, b) -> a.getAge() - b.getAge());
		for(Person person : persons) person.printPerson();
		
		//静态方法引用  语法是Class::static_method。这个方法接受一个Class类型的参数
		System.out.println("*******以下是引用静态方法，比lambda表达式写法简单*******");
		Arrays.sort(persons, Person::compareByAge);
		Arrays.asList(persons).stream().forEach(person -> System.out.println(person.getName() + ":" + person.getAge()));

		//特定对象的方法引用   语法是instance::method。这个方法接受一个instance对应的Class类型的参数
		System.out.println("*******以下是引用实例方法*******");
		ComparisonProvider provider = new ComparisonProvider();
		Arrays.sort(persons, provider::compareByAge);
		Arrays.asList(persons).stream().forEach(person -> System.out.println(person.getName() + ":" + person.getAge()));
		
		//构造器引用  语法是Class::new
		System.out.println("*******使用lambda表达式-引用的是构造方法*******");
		final List<Person> personList = Arrays.asList(persons);
		Set<Person> personSet = transferElements(personList, () -> new HashSet<>());
		personSet.forEach(Person::printPerson);
		
		System.out.println("*******使用方法引用-引用的是构造方法*******");
		Set<Person> personSet2 = transferElements(personList, HashSet::new);
		personSet2.forEach(Person::printPerson);
	}
	
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST 
		transferElements(SOURCE sourceCollections,Supplier<DEST> colltionFactory) {
		DEST result = colltionFactory.get();
		sourceCollections.forEach(o -> result.add(o));
		return result;
	}
	private Person[] initPerson() {
		Person[] persons = new Person[3];
		Person person = new Person();
        person.setName("张三");
        person.setAge(10);
        persons[0] = person;

        person = new Person();
        person.setName("李四");
        person.setAge(50);
        persons[1] = person;

        person = new Person();
        person.setName("王五");
        person.setAge(2);
        persons[2] = person;
        return persons;
	}
}
