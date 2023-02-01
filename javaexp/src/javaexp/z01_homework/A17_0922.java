package javaexp.z01_homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class A17_0922 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		2022-09-22
[1단계:개념] 1. Stream이 무엇인지 기술하고, 자바의 대표적인 입출력 객체를 선언하세요.
[1단계:코드] 2. InputStream을 이용하여, 70점 이상인지 여부를 확인하여 출력하세요.(byte ==> char ==> String ==> int 변환 필요) 
[1단계:개념] 3. byte 기반 stream과  문자기반 stream의 내용과 차이점을 기술하세요.
[1단계:코드] 4. read(byte[])를 활용하여 웹기반 자바프로그램은 무엇인가?라은 질문에 jsp이면 정답 그렇지 않으면 오답으로 처리하세요.
[1단계:코드] 5. InputStreamReader를 이용하여 물건명, 가격, 갯수를 입력받고, 총계까지 출력하세요.
[1단계:개념] 6. File객체/물리적파일의 생성방법을 기술하세요.
[1단계:코드] 7. homework 패키지 하위에 z01_home,z02_home,z02_home 폴드를 만들고 그 하위에 각각 menual1.txt~menual10.txt 파일을 생성하세요
		
		*/
		
		//1
		/*
		Stream은 데이터 전송을 처리하는 api객체이다
		Stream을 통해서 데이터를 입력하거나 출력을 하는 등의 처리를 한다.
		 	- System.out.println()은 기본적인 자바의 OutputStream의 한 형태	
		*/
		// 자바의 대표적인 입출력 객체 선언
		InputStream is = System.in;
		
		// Stream이란 물결이라는 뜻으로 프로그래밍에서는 데이터의 흐름을 처리할 때 사용하는 객쳉이다
		// 주로 콘솔창에 입력되는 데이터, 파일을 통해서 입력된 데이터, 
		// 네트워크를 통해서 전송해오는 데이터를 읽고 쓸 때 중간에 객체로 이동하거나 전송할 때 활용된다.
		// InputStream, OutputStream객체를 상위 객체로 하여 하위에 여러가지 가능을 추가하는 객체들이 있다
		
		//2 
		byte[] srcode = new byte[3];
		System.out.print("점수를 입력하세요\n!!세 자리수로 입력하세요 ex)000,065 _ ");

		try {
	        is.read(srcode);
			String score = new String(srcode);
			System.out.println("- 합격 커트라인:\t 70점\n- 입력한 점수:\t"+score+"점");
			if (Integer.parseInt(score)>=70) {
				System.out.println("<축하합니다! 합격입니다!>");
			}else {
				System.out.println("<귀하는 불합격하셨습니다.>");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		//3
		/*
		>> byte 기반 stream의 최상위 클래스는 InputStream 클래스이다
		 	- byte 기반 stream은 1byte를 읽거나 byte배열을 리턴한다
		 	- 주요 기능 메서드
			1) int read() 
			2) int read(byte[] b):
			3) int read(byte[] b, int off, int len) 
			4) void close()                  
		ㅅ
		>> 문자 기반 stream의 최상위 클래스는 Reader 클래스이다
		    - 문자 기반 stream은 2byte이상의 문자에대한 처리가 가능하다
		    - 상위 클래스 Reader 밑에, 실제 클래스 FileReader  BufferedReader  InputStreamReader가 있다.
			- 주요 기능메서드
			1) int read()
			2) int read(char[] cbuf) 
			3) int read(char[] cbuf, int off, int len)
			4) void close() 
		*/
		//4  	
		InputStream iss = System.in;
		byte[] youranswer = new byte[3];
		System.out.println("웹기반 자바프로그램은 무엇인가?\n!!영어 소문자로 적으세요_");
		
		try {
			
			iss.read(youranswer);
			String yAnswer = new String(youranswer);
			System.out.println();
			System.out.println("입력한 답_");
			
			if(yAnswer.equals("jsp")) {
				System.out.println("정답입니다");
			}else {
				System.out.println("오답입니다, 공부하세요!");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println();
		
		// 5 5. InputStreamReader를 이용하여 물건명, 가격, 갯수를 입력받고, 총계까지 출력하세요.
		Reader rd = new InputStreamReader(System.in); 
		BufferedReader bfr = new BufferedReader(rd);
		StringBuffer sbf = new StringBuffer("물건명\t개수\t가격\n");

		int tot=0;
		
		try {	
			System.out.print("몇가지의 물건을 입력하시겠습니까?\n!!물건명을 기준으로 입력하세요_");
			String kindc = bfr.readLine();
			System.out.println(kindc+"가지 물건명 입력을 시작하겠습니다");
			
			System.out.println("주문하신 물건명과 개수와 가격을 차례로 입력하세요");
			for(int cnt=1; cnt<=Integer.parseInt(kindc);cnt++) {
				System.out.print("물건명_");
				String pname = bfr.readLine();
				System.out.print("개수_");
				String pcnt = bfr.readLine();
				System.out.print("가격_");
				String pprice = bfr.readLine();
				
				tot +=Integer.parseInt(pcnt)*Integer.parseInt(pprice);	
				sbf.append(pname+"\t"+pcnt+"개\t"+pprice+"원\n");
			}
			System.out.println(sbf.toString());
			System.out.println("\t총계: "+tot);
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		System.out.println();
		
		//6
		/*
		-상위 파일 주소 따기 : 마우스우클릭>>properties>>Location복사
		-파일 객체 생성
	 	File file = new File("c:\\aa\aa.txt");
	 	File file2 = new File("c:/aa/aa.txt");
	 	
	 	-파일 및 디렉토리 생성 메소드
	 	boolean createNewFile() 새로운 파일을 생성
		boolean mkdir() 새로운 디렉토리를 생성
		*/
		// 7 (6.예시) 7. homework 패키지 하위에 z01_home,z02_home,z02_home 폴드를 만들고 
//		그 하위에 각각 menual1.txt~menual10.txt 파일을 생성하세요
		
		// 폴드
		String path01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home";
		String path02 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home";
		
		// 객체 생성
		File p01 = new File(path01); 
		File p02 = new File(path02);
		// 파일 생성
		if(!p01.exists()) p01.mkdir();
		if(!p02.exists()) p02.mkdir();
		
		// txt 파일 생성&객체생성
		File f01 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual1.txt");
		File f02 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual2.txt");
		File f03 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual3.txt");
		File f04 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual4.txt");
		File f05 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual5.txt");
		File f06 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual6.txt");
		File f07 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual7.txt");
		File f08 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual8.txt");
		File f09 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual9.txt");
		File f10 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z01_home\\menual10.txt");
		
		File f11 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual1.txt");
		File f12 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual2.txt");
		File f13 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual3.txt");
		File f14 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual4.txt");
		File f15 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual5.txt");
		File f16 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual6.txt");
		File f17 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual7.txt");
		File f18 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual8.txt");
		File f19 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual9.txt");
		File f20 = new File("C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\z02_home\\menual10.txt");
		
		try {
			if(!f01.exists()) f01.createNewFile();
			if(!f02.exists()) f02.createNewFile();
			if(!f03.exists()) f03.createNewFile();
			if(!f04.exists()) f04.createNewFile();
			if(!f05.exists()) f05.createNewFile();
			if(!f06.exists()) f06.createNewFile();
			if(!f07.exists()) f07.createNewFile();
			if(!f08.exists()) f08.createNewFile();
			if(!f09.exists()) f09.createNewFile();
			if(!f10.exists()) f10.createNewFile();
			
			if(!f11.exists()) f11.createNewFile();
			if(!f12.exists()) f12.createNewFile();
			if(!f13.exists()) f13.createNewFile();
			if(!f14.exists()) f14.createNewFile();
			if(!f15.exists()) f15.createNewFile();
			if(!f16.exists()) f16.createNewFile();
			if(!f17.exists()) f17.createNewFile();
			if(!f18.exists()) f18.createNewFile();
			if(!f19.exists()) f19.createNewFile();
			if(!f20.exists()) f20.createNewFile();
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		== 평가대비(자바) 객관식 문제 ==
1. 
	답3.
	File클래스는 파일 시스템을 표현하는 클래스이고
	OutputStream은 출력 스트림 클래스이고
	Reader클래스는 문자 기반 입력 스트림 클래스이다
		 
2.
	답 4.
	InputStream은 1byte 혹은 byte[]기반이라 한글 입력처리는 어렵다
	OutputStream은 출력 스트림 클래스이며 대표적으로 System.out.println 객체가 있다
	Writer..는 그냥 변수 아닌가.. 
	
3. 
	답4
	FileReader, BufferedReader, InputStreamReader 는 모두 Reader클래스의 하위 객체이나
	InputStream은 byte 기반 stream의 최상위 클래스이다.

4. 
	답1
	String[] list()      디렉토리에 포함된 파일 및 서브디렉토리 목록 배열로 리턴
	File[] listFiles()   디렉토리에 포함된 파일 및 서브디렉토리 목록 "전부"를 File배열로 리턴
    boolean canRead()    읽을 수 있는지 여부
    File getParentFile() 부모 디렉토리를 File 객체로 생성 후 리턴

		*/		
	}
}
