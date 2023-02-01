package javaexp.a12_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A16_PathCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * # Path를 통한 파일 copy
		 * 
		 */
		// 1. 연습 파일 만들기
		String path = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io";
		// 2. 폴드만들기
		File fold01 = new File(path + "\\a01_fold");
		if (!fold01.exists()) fold01.mkdir();

		File fold02 = new File(path + "\\a02_fold");
		if (!fold02.exists()) fold02.mkdir();

		// 3.
		File file01 = new File(path + "\\a01_fold", "a03Show.txt");

		try {
			
			if (!file01.exists())file01.createNewFile();
			
			// 파일 copy
			String orgFile = path + "\\a01_fold\\a01Show.txt"; // 파일 경로 
			String tarFile = path + "\\a02_fold\\cpyFile01.txt"; // 파일도 복사하고 이름도 바꾸고	
			Path oriPath = Paths.get(orgFile);
			Path copPath = Paths.get(tarFile);
			
			// 복사 처리
			Files.copy(oriPath, copPath, StandardCopyOption.REPLACE_EXISTING); // 마지막껀 옵션
			System.out.println("복사완료");
			
			// A18_PathCopy.java
			// a02_fold/cpyFile01.txt
			// ==> a03_flod/showcpcpy.txt
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
