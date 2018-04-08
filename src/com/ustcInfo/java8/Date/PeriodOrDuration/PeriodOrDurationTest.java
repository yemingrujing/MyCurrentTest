package com.ustcInfo.java8.Date.PeriodOrDuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * Period/Duration测试
 * Period - 处理有关基于时间的日期数量
 * Duration - 处理有关基于时间的时间量
 * @author guang.wei
 * @datetime 2018年4月4日 下午4:22:03
 */
public class PeriodOrDurationTest {

	@Test
	public void testPeriod() {
		//Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date：" + date1);
		
		//add 1 month to the current date
		LocalDate date2 = date1.plus(1,ChronoUnit.MONTHS);
		System.out.println("date2：" + date2);
		
		Period period = Period.between(date1, date2);
		System.out.println("Period：" + period);
		System.out.println("Period.getYears：" + period.getYears());
		System.out.println("Period.getMonths：" + period.getMonths());
		System.out.println("Period.getDays：" + period.getDays());
	}
	
	@Test
	public void testDuration() {
		LocalTime time = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);
		System.out.println("towHours.getSeconds()：" + twoHours.getSeconds());
		System.out.println("towHours.toHours()：" + twoHours.toHours());
		
		LocalTime time1 = time.plus(twoHours);
		System.out.println("time1：" + time1);
		
		Duration duration = Duration.between(time, time1);
		System.out.println("Duration：" + duration);
		System.out.println("Duration.getSeconds：" + duration.getSeconds());
	}
}
