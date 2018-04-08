package com.ustcInfo.java8.BackwardCompatability;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Test;

/**
 * toInstant()方法被添加到可用于将它们转换到新的日期时间的API原始日期和日历对象
 * 使用ofInstant(Insant,ZoneId)方法得到一个LocalDateTime或ZonedDateTime对象
 * @author guang.wei
 * @datetime 2018年4月4日 下午4:53:35
 */
public class BackwardCompatabilityTest {

	@Test
	public void testBackwardCompatability() {
		//Get the current date
		//java.util.Date#from方法可以将Instant转化为旧版本的Date对象。这两个方法都是jdk8以后新加的。
		Date currentDate = new Date();
		System.out.println("Current date：" + currentDate);
		
		//Get the instant of current date in terms of milliseconds
		Instant now = currentDate.toInstant();
		ZoneId currentZone = ZoneId.systemDefault();
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
		System.out.println("Local date：" + localDateTime);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
		System.out.println("Zoned date：" + zonedDateTime);
	}
}
