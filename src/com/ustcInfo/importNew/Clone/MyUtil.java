package com.ustcInfo.importNew.Clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 实现对象克隆
 * 1). 实现Cloneable接口并重写Object类中的clone()方法；
 * 2). 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆，
 * @author guang.wei
 * @datetime 2018年4月20日 下午5:18:40
 */
public class MyUtil {

	private MyUtil() {
		throw new AssertionError();
	}
	
	public  static <T> T clone(T obj) throws Exception {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bout);
		oos.writeObject(obj);
		
		ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bin);
		return (T) ois.readObject();
		//说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
		//这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
	}
}
