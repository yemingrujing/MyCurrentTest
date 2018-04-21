package com.ustcInfo.socket.learn3;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) throws Exception {
		String host = "127.0.0.1";
		int port = 55533;
		Socket socket = new Socket(host, port);
		//建立连接后获得输出流
		OutputStream outputStream = socket.getOutputStream();
		String message = "hello,java" ;
		//首先需要计算得知消息的长度
		byte[] sendBytes = message.getBytes("UTF-8");
		//然后将消息的长度优先发送出去
		outputStream.write(sendBytes.length >> 8);
		outputStream.write(sendBytes.length);
		//然后将消息再次发送出去
		outputStream.write(sendBytes);
		outputStream.flush();
		//==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
		message = "第二条消息";
		sendBytes = message.getBytes("UTF-8");
		outputStream.write(sendBytes.length >> 8);
		outputStream.write(sendBytes.length);
		outputStream.flush();
		//==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
		message = "this third message";
		sendBytes = message.getBytes("UTF-8");
		outputStream.write(sendBytes.length >> 8);
		outputStream.write(sendBytes.length);
		outputStream.write(sendBytes);
		
		outputStream.close();
		socket.close();
	}
}
