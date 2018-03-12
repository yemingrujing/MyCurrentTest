package com.ustcInfo.testone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceStr {

	public static String replaceStr1(String str){
		if(str!=null && !"".equals(str)) {      
            String pattern = "\\}\\s{0,}\\{";
            String strNoBlank = str.replaceAll(pattern, "},{");
            return strNoBlank;      
        }else {      
            return str;      
        }
	}
	
	public static void main(String[] args) {
		String Str = "你好,{} {} 	  {}{}";
		System.out.println(replaceStr1(Str));
	}
}
