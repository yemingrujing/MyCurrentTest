package com.ustcInfo.java8.Date.ZonedDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

/**
 * ZonedDateTime测试
 * 带时区日期时间处理
 * @author guang.wei
 * @datetime 2018年4月4日 下午4:00:06
 */
public class ZonedDateTimeTest {

	@Test
	public void testZonedDateTime() {
		// Get the current date and time
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println("now：" + now);
		ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
		System.out.println("date1：" + date1);
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZondId：" + id);
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("curremtZone：" + currentZone);
	}
}
