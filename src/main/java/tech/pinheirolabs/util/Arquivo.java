package tech.pinheirolabs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class Arquivo {

	static void writeFile(byte[] contents, String filePath) {
		FileOutputStream out = null;
  
		try {
		   out = new FileOutputStream(filePath);
		   out.write(contents);
		   out.close();
		} catch (Exception var4) {
		   var4.printStackTrace();
		}
  
	 }
  
	 static byte[] readFile(String filePath) {
		FileInputStream fis = null;
		File f = new File(filePath);
		int i = 0;
		byte[] array = null;
  
		try {
		   fis = new FileInputStream(f);
  
		   int buf;
		   for(array = new byte[(int)f.length()]; (buf = fis.read()) != -1; array[i++] = (byte)buf) {
		   }
  
		   fis.close();
		} catch (Exception var7) {
		   var7.printStackTrace();
		}
  
		return array;
	 }
	
}//END - By FP - 2021
