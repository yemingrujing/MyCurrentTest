package com.ustcInfo.java8.Date.TemporalAdjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

/**
 * TemporalAdjuster测试
 * TemporalAdjuster 是做日期数学计算
 * @author guang.wei
 * @datetime 2018年4月4日 下午4:37:44
 */
public class TemporalAdjusterTest {

	@Test
	public void testAdjusters() {
		//Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date：" + date1);
		
		//get the next tuesday(下周二)
		LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("next Tuesday on：" + nextTuesday);
		
		//获得当月的第二个周六
		LocalDate firstInMonth = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
		LocalDate secondSaturday = firstInMonth.
				with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).
				with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second saturday on：" + secondSaturday);
		
	}
}
