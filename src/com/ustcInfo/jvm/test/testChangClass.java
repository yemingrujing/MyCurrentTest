package com.ustcInfo.jvm.test;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.Constant;
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

public class testChangClass {

	public static void main(String[] args) throws Exception {
		String filePath = "E:\\java\\jclasslib\\testChangeClass\\JVMTest.class";
		FileInputStream fis = new FileInputStream(filePath);
		
		DataInput di = new DataInputStream(fis);
		ClassFile cf = new ClassFile();
		cf.read(di);
		Constant[] infos = cf.getConstantPool();
		
		int count = infos.length;
		for(int i = 0; i < count; i++) {
			if(infos[i] != null) {
				System.out.print(i);
				System.out.print(" = ");
				System.out.print(infos[i].getVerbose());
				System.out.print(" = ");
//				System.out.println(infos[i].getVerbose() != "");
				System.out.println(infos[i].getVerbose() != "" ? infos[i].getConstantType() : "");
				if(i == 54) {
					ConstantUtf8Info uInfo = (ConstantUtf8Info) infos[i];
					uInfo.setString("哈哈！");
					infos[i] = uInfo;
				}
			}
		}
		cf.setConstantPool(infos);
		fis.close();
		File f = new File(filePath);
		ClassFileWriter.writeToFile(f, cf);
	}
}
