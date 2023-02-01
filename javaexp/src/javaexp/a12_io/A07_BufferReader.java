package javaexp.a12_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class A07_BufferReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ex) BufferedReader 객체를 활용하여 좋아하는 음악과 가수명을 입력받아 출력하세요

		Reader reader = new InputStreamReader(System.in); // 유동적 , 글자수X
		BufferedReader bf = new BufferedReader(reader);
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); : 얘도 가능
		
		try {
			
			System.out.print("좋아하는 음악 입력\n_");
			String music = bf.readLine();
			System.out.print("좋아하는 가수 입력\n_");
			String singer = bf.readLine();
			
			System.out.println("좋아하는 음악: "+music);
			System.out.println("좋아하는 가수: "+singer);
						
			bf.close();
			reader.close();
				
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
