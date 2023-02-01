package javaexp.a12_io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class A14_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ex) A15_FileWriter.java
		//     Z02_Test.txt 파일에 문자, 문자배열, 문자열을 선언하고 할당 처리하세요
				
		String file01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\Z02_test.txt";

		try {
			
			Writer w;
			w = new FileWriter(file01);
			
			w.write(78);
			char c = '야';
			w.append(c);
			// = w.append('야');
			
			// 문자열 배열
			char[] arrc = {'그','만','해',' ','좀','\n'};
			w.write(arrc);
			w.write("진짜 짜증나(String)\n");
			
			w.flush();
			w.close();
			
		} catch (IOException e) {
			
			System.out.println("IO에러: "+e.getMessage());
//			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.out.println("일반 에러: "+e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
