package com.ustcInfo.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date date = new Date(-30);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = sdf.format(date);
		System.out.println(s1);
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		
	}
}
