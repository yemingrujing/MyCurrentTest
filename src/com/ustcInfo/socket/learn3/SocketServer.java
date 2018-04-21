package com.ustcInfo.socket.learn3;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 先指定后续命令的长度，然后读取指定长度的内容做为客户端发送的消息。
 * @author guang.wei
 * @datetime 2018年4月18日 下午4:48:38
 */
public class SocketServer {

	public static void main(String[] args) throws Exception {
		int port = 55533;
		ServerSocket server = new ServerSocket(port);
		System.out.println("server将一直等待连接的到来");
		ExecutorService threadPool = Executors.newFixedThreadPool(100);
		
		while(true) {
			Socket socket = server.accept();
			threadPool.submit(() -> {
				try {
					InputStream inputStream = socket.getInputStream();
					byte[] bytes;
					//因为可以复用Socket且能判断长度，所以可以一个Socket用到底
					while(true) {
						//首先读取两个字节表示的长度
						int first = inputStream.read();
						//如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
						if(first == -1) {
							break;
						}
						int second = inputStream.read();
						int length = (first << 8) + second;
						//然后构造一个指定长的byte数组
						bytes = new byte[length];
						//然后读取指定长度的消息即可
						inputStream.read(bytes);
						System.out.println("get message from client：" + new String(bytes, "UTF-8"));
					}
					inputStream.close();
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		
	}
}
