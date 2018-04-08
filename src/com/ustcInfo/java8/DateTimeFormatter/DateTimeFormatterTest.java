package com.ustcInfo.java8.DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.Test;

/**
 * DateTimeFormatter测试
 * DateTimeFormatter可以替代以前的dateformat，使用起来方便一些。
 * DateTimeFormatter是线程安全的，因为他是final的类
 * @author guang.wei
 * @datetime 2018年4月4日 下午10:31:42
 */
public class DateTimeFormatterTest {
	
	@Test
	public void testDateTimeFormatter() {
		LocalDateTime currentDate = LocalDateTime.now();
		System.out.println("Current date：" + currentDate);
		
		System.out.println(currentDate.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(DateTimeFormatter.ISO_LOCAL_TIME.format(currentDate));
		
		System.out.println(currentDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(currentDate));
		
		System.out.println(currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(currentDate));
	}
}
