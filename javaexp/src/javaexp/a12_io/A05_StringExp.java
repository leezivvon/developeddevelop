package javaexp.a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A05_StringExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ex) 등록할 물건명(영문)으로 입력하고 "apple" 과 동일하면 검색되었습니다.
		//     그렇지 않으면 없습니다. 출력.
		
		InputStream is = System.in;
		byte[] schProd = new byte[5];
		System.out.print("검색할 물건명(영문): ");
		
		try {
			
			is.read(schProd);
			String input = new String(schProd);
			
			System.out.println("입력한 물건: "+input);
			if(input.equals("apple")) {
				System.out.println(" 검색되었습니다");
			}else {
				System.out.println(" 해당 물건은 없습니다");
			}
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
