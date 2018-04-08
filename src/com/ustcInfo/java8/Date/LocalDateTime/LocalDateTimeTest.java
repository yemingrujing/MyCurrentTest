package com.ustcInfo.java8.Date.LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.junit.Test;

/**
 * LocalDateTime测试类
 * LocalDateTime类包含了LocalDate和LocalTime的信息，但是不包含ISO-8601日历系统中的时区信息
 * @author guang.wei
 * @datetime 2018年4月4日 下午3:45:42
 */
public class LocalDateTimeTest {

	@Test
	public void testLocalDate() {
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime：" + currentTime);
		
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1：" + date1);
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
		System.out.println("Month：" + month + "  day：" + day
                + "  seconds：" + seconds);
		
		//指定时间
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2：" + date2);
		
		//12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3：" + date3);
		
		//22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15, 33);
		System.out.println("date4：" + date4);
		
		//parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5：" + date5);
	}
}
