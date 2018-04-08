package com.ustcInfo.java8.Date.ChronoUnit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * ChronoUnit测试
 * 可以代替Calendar的日期操作
 * @author guang.wei
 * @datetime 2018年4月4日 下午4:13:16
 */
public class ChronoUnitTest {

	@Test
	public void testChronoUnits() {
		//Get the current date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date：" + today);
		//add 1 week to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week：" + nextWeek);
		//add 1 month to the current date
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month：" + nextMonth);
		//add 1 year to the current date
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year：" + nextYear);
		//add 10 years to the current date
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Date after 10 year: " + nextDecade);
		//add 20 years to the current date
		LocalDate nextDecade20 = today.plus(2, ChronoUnit.DECADES);
		System.out.println("Date after 20 year: " + nextDecade20);
	}
}
