package javaexp.a12_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A17_PathCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// A18_PathCopy.java
		// a02_fold/cpyFile01.txt
		// ==> a03_flod/showcpcpy.txt
		
		
		// 1. a03폴드 만들기
		String path = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io";
		
		File fold03 = new File(path+"\\a03_fold");
		if(!fold03.exists()) fold03.mkdir();
		
		// 2. 파일 복사
		
		String orgf= path+"\\a02_fold\\cpyFile01.txt";
		String cpf = path+"\\a03_fold\\showcpcpy.txt";
		
		Path orgPath = Paths.get(orgf); // 복사 Paths.get
		Path cpyPath = Paths.get(cpf);
		
		try {
			
			Files.copy(orgPath, cpyPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("복사 완.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
