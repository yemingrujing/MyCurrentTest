package com.ustcInfo.java8.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

import org.junit.Test;

/**
 * Base64测试
 * Java8现在有内置编码器和解码器的Base64编码
 * 简单: 输出映射设置字符在A-ZA-Z0-9+/。编码器不添加任何换行输出和解码器拒绝在A-Za-z0-9+/以外的任何字符。
 * URL : 输出映射设置字符在A-Za-z0-9+_。输出URL和文件名安全。
 * MIME : 输出映射到MIME友好的格式。输出表示在每次不超过76个字符行和使用’\r’后跟一个换行符’\n’回车作为行分隔符。无行隔板的存在是为了使编码的结束输出。
 * @author guang.wei
 * @datetime 2018年4月4日 下午10:48:50
 */
public class Base64Test {

	@Test
	public void test() {
		try {
			byte[] bytes = "guangwei?java8".getBytes();
			//Encode using basic encoder
			String base64encodedString = Base64.getEncoder().encodeToString(bytes);
			System.out.println("Base64 Encoded String(Basic)：" + base64encodedString);
			
			//Decode
			byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
			System.out.println("Original String：" + new String(base64decodedBytes, "utf-8"));
			
			base64encodedString = Base64.getUrlEncoder().encodeToString(bytes);
			System.out.println("Base64 Encoded String(URL)：" + base64encodedString);
			
			StringBuilder stringBuilder = new StringBuilder();
			for(int i = 0; i < 10; ++i) {
				stringBuilder.append(UUID.randomUUID().toString());
			}
			
			byte[] mimeBytes = stringBuilder.toString().getBytes();
			System.out.println("stringBuilder：" + stringBuilder);
			String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println("Base64 Encoded String(MIME)：" + mimeEncodedString);
			byte[] mimeDecodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
			System.out.println("Base64 Decoded String：" + new String(mimeDecodedBytes, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error：" + e.getMessage());
		}
	}
}
