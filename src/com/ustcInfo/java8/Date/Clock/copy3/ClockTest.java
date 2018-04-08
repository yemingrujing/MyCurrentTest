package com.ustcInfo.java8.Date.Clock.copy3;

import java.time.Clock;

/**
 * Clock类，它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间
 * Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()
 * @author guang.wei
 * @datetime 2018年4月4日 下午3:44:49
 */
public class ClockTest {
	public static void main(String[] args) {
		Clock clock = Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());
	}
}
