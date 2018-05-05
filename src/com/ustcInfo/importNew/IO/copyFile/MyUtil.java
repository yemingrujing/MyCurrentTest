package com.ustcInfo.importNew.IO.copyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件拷贝
 * @author guang.wei
 * @datetime 2018年4月27日 上午9:56:57
 */
public class MyUtil {

	private MyUtil() {
		throw new AssertionError();
	}
	
	public static void fileCopy(String source, String target) throws FileNotFoundException, IOException {
		try(InputStream in = new FileInputStream(source)){
			try(OutputStream out = new FileOutputStream(target)) {
				byte[] buffer = new byte[4096];
				int bytesToRead;
				while((bytesToRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytesToRead);
				}
			}
		}
	}
	
	public static void fileCopyNIO(String source, String target) throws FileNotFoundException, IOException {
		try(FileInputStream in = new FileInputStream(source)){
			try(FileOutputStream out = new FileOutputStream(target)){
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(4096); //首先给Buffer分配空间，以字节为单位
				while(inChannel.read(buffer) != -1) {
					buffer.flip(); //flip() 将limit设置为position，然后position重置为0，返回对缓冲区的引用
					outChannel.write(buffer); //clear() 清空调用缓冲区并返回对缓冲区的引用
					buffer.clear();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
