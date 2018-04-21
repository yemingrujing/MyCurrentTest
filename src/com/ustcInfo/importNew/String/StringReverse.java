package com.ustcInfo.importNew.String;

public class StringReverse {

	public static void main(String[] args) {
		System.out.println(reverse("asdfghjkl"));
	}
	
	public static String reverse(String originStr) {
		if(originStr == null || originStr.length() <= 1) {
			return originStr;
		}
		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}
}
