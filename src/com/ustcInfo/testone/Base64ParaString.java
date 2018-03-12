package com.ustcInfo.testone;

import org.junit.Test;

import com.ustcInfo.util.Base64Utils;
import com.ustcInfo.util.Base64Utils2;

public class Base64ParaString {

	@Test
	public void teseOne(){
		String str = "你好，我平时都是都是";
		//String param = Base64Utils2.encode(str);
		String param = "MTIxMXNzZHNk6YO95piv5a+555qE";
		String paraString = new String(Base64Utils.decode(param));//解密后
		System.out.println(paraString);
	}
}
