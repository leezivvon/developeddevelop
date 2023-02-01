package javaexp.z01_homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class A18_0923 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 2022-09-23 
		 * [1단계:코드] 1. File객체를 통해 현재 경로 기준으로 room1~3만들고,
		 * Person1.txt~Person10.txt를 생성하세요. 
		 * [1단계:개념] 2. OutputStream 객체란 무엇인가? 기능메서드와 함께
		 * 설명하세요. 
		 * [1단계:코드] 3. 기본 OutputStream객체를 생성해서 System.out을 할당하여, byte, byte[]로
		 * 데이터를 출력하세요. 
		 * [1단계:코드] 4. 기본 Writer객체 활용하여 char[], String을 write()로 출력하세요.
		 * [1단계:코드] 5. Reader객체를 통해서 입력된 데이터를 FileWriter를 활용하여 파일에 내용을 기록하세요. ex)
		 * 회원정보(아이디/패스워드/이름/포인트) 탭간격처리. 
		 * [2단계:코드] 6. Path 객체를 활용하여 새파일 등록/파일내용 기록/파일 삭제를  처리하세요. 
		 * [1단계:코드] 7. Files와 Path를 활용하여 경로2개를 만들고, 경로1의 파일을 5개 임의로 만들어, 경로2에 1~5번이 numbering된 파일을 만드세요. 
		 * [2단계:코드] 8. 일기장 시스템 만들기. Scanner를 이용해서 오늘 날짜를 입력하면 @@@@년@@월@@일.txt 파일이 생성되고 날짜를 포함하여 오늘의 일기를 기록하고 Q!를 입력시 입력이 종료되면 해당 파일에
		 * 기록이 되게 처리하세요.
		 */

		// 1
		String path = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework";

		try {
			for (int cnt = 1; cnt <= 3; cnt++) {
				String pname = path + "\\room" + cnt;
				File p = new File(pname);
				if (!p.exists())
					p.mkdir();
				for (int cntt = 1; cntt <= 10; cntt++) {
					String fname = "Person" + cntt + ".txt";
					File f = new File(pname, fname);
					if (!f.exists())
						f.createNewFile();
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
	
		}
		/*
		// 정답
		/ 처리 순서
		1) File 생성할 기준 경로(최상위 경로)
		2) File(경로) room1의 경로 객체 생성
		3) File(파일) Person1.txt 파일 객체 생성
		4) 위 경로 객체 for 처리
		5) 위 파일 객체 for 처리
		
		String sPath = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework";
		
		
		try{
		
			for(int rcnt=1; rcnt<=3;rcnt++){
				String roomPath = sPath+"\\room1"   // 기준경로 + 추가경로
				File = room = new File(roomPath);
				if(!room.exists()) 
					room.mkdir();
					
				for(int fcnt=1;fcnt<=10;fcnt++){
					String fName = roomPath+"\\Person"+fcnt+".txt";
					File file = new File(fName);
						
					if(!file.exists()) 
						file.createNewFile();
				}
			}	
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		*/
		

		// 2
		/*
		 * OutputStream이란 바이트기반 출력 스트림의 최상위 클래스로 추상 클래스이며 FileOutputstream, PrintStream,
		 * BufferedOutputStream, DataOutputStream을 하위 객체로 가지고 있따 - 주요기능 메서드 write(int b)
		 * : 출력 스트림으로 1바이트를 보낸다 write(byte[] b) : 출력 스트림으로 매개값이 주어진 바이트 배열 b의 모든 바이트를
		 * 보낸다 wirte(byte[] b, int off, int len) flush() : 버퍼에 잔류하는 모든 바이트를 출력한다 close();
		 * : 사용한 시스템을 반납하고 출력 스트림을 닫는다
		 */
		// 3
		OutputStream os = System.out;

		try {
			// byte데이터 출력
			os.write(64);
			// byte[] 데이터 출력
			byte[] b = { 76, 79, 86, 69, 83, 50 };
			os.write(b);

			os.flush();

			// 4
			String pathfile = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\room1\\Person1.txt";
			
			Writer w = new OutputStreamWriter(System.out);
			OutputStream oss = new FileOutputStream(pathfile);
			// char[]
			char[] c = { '할', ' ', '수', ' ', '있', '다', '!' };
			w.write(c);
			// String
			w.write("아자아자");
			
			System.out.println();
			System.out.println();
			// 5.
			// Reader객체
			Reader r = new InputStreamReader(System.in);
			BufferedReader bfr = new BufferedReader(r);
			StringBuffer sbf = new StringBuffer("이름\tID\tPassword\tPoint\n");

			// FileWriter
			String file = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\room2\\Person1.txt";
			Writer ww = new FileWriter(file);

			ww.write("<5번문제>\n이름\t ID\tPassword\tPoint\n");

			System.out.print("몇 개의 회원정보를 입력하시겠습니까? ");
			String cntMInfo = bfr.readLine();

			System.out.println("< " + cntMInfo + "개의 회원정보를 입력합니다 >\n이름, 아이디, 패스워드, 포인트를 차례로 입력하세요");
			for (int cnt = 1; cnt <= Integer.parseInt(cntMInfo); cnt++) {
				System.out.print("이름_");
				String name = bfr.readLine();
				System.out.print("ID_");
				String id = bfr.readLine();
				System.out.print("Password_");
				String pw = bfr.readLine();
				System.out.print("point_");
				String pt = bfr.readLine();
				System.out.println();

				ww.write(name + "\t");
				ww.write(id + "\t");
				ww.write(pw + "\t");
				ww.write(pt + "\n");

				sbf.append(name + "\t" + id + "\t" + pw + "\t" + pt + "점\n");
			}
			r.close();
			ww.flush();
			ww.close();
			System.out.println(sbf.toString());

			// 6 Path 객체를 활용하여 새파일 등록/파일내용 기록/파일 삭제를  처리하세요. 
			
//			String fpath = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\room2\\Person1.txt";
//			Path filePath = Paths.get(fpath);
//			File f = filePath.toFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 정답
		/*
		처리순서
		1) File 객체 만들기
		2) FileWriter를 활용하여 파일 내용 쓰기 처리..
		3) Path를 전환 후, 파일 삭제 처리하기
		
		*/
		// path
		String fname = "z01_show99.txt";
		File f = new File(path, fname);
		
			try {
				
			// 파일 생성
				if(!f.exists()) f.createNewFile();  
				
			// 파일 내용 쓰기
				// 파일명 ==> File ==> FileWriter ==> PrintWriter  생성자로 담기
				FileWriter fw = new FileWriter(f);
				// 파일 내용에 쓰기 처리
				PrintWriter out = new PrintWriter(fw);
				out.print("문자열을 파일에 입력 처리합니다!");
				
				out.close();
				fw.close();
				
			// 파일 삭제
				Path delFile = Paths.get(path+"\\"+fname);
				Files.delete(delFile);
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		
		
		// 7
		// 정답
		/*	
		Files와 Path를 활용하여 경로2개를 만들고, 경로1의 파일을 5개 임의로 만들어, 경로2에 1~5번이 numbering된 파일을 만드세요. 
		room3에 있는 파일을 newRoom4에 복사하면서 
		Person1.txt~Person5.txt ==> 1000File.txt~1005File.txt로 만들기 처리
		*/
			
		/*
		// 업로드
		client1  ==> show.txt ==>  server
			                           DB      - 1001.txt  show.txt  상세정보 (DB는 세 가지의 데이터를 가지고 있는 것)
			                           File서버 - 1001.txt(저장될 파일명)
		client2  ==> show.txt ==>  server	
			                           DB      - 1002.txt  show.txt  상세정보
			                           File서버 - 1002.txt(저장될 파일명)
		// 다운로드                           
		client3  <== show.txt ==       DB      - 1002.txt  show.txt
		                               File서버 - 1002.txt(저장될 파일명)                         
		*/
			
			
		try {
			
			for(int fcnt=1; fcnt<=5; fcnt++) {
				String path1 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\room3";	
				String org1 = path1+ "\\Person"+fcnt+".txt";
				String path2 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\newRoom4";	
				String tar1 = path2 + "\\100"+fcnt+"File.txt";
				Path orgFile = Paths.get(org1);
				Path tarFile = Paths.get(tar1);
				
				Files.copy(orgFile, tarFile, StandardCopyOption.REPLACE_EXISTING); // 파일명 바뀌면서 복사
			}
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
			
			
			
		//8 .
		
		// diary경로 생성
		File dp = new File(path+"\\diary");
		if(!dp.exists()) dp.mkdir();
		
		System.out.println("_____< 일기장 >_____");
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜를 입력하세요\n!! 2022년01월01일 형태로 입력하세요_ ");
		String dayw = sc.nextLine();

		try {
			String dfname = dayw+".txt";
			File df = new File (dp, dfname);
			if(!df.exists()) df.createNewFile();
			
			Writer dw = new FileWriter(dfname);
			
			System.out.print("내용을 입력하세요\n_");
			String contw =sc.nextLine();
			if(contw.indexOf("Q!")!= -1) {
				dw.write(contw);
				dw.append('*');
				
				dw.flush();
				dw.close();
				
			}else {
				dw.write(contw);
			}
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// 정답
		/*
		처리순서
		1) 파일생성
			파일명을 입력받아서 File 객체에 파일을 생성하기
			- 기준 경로
			- 입력된 내용으로 파일명 만들기
		2) 입력된 내용으로 파일 쓰기
			- File객체 ==> PrintWriter
			- 반복문을 통해서 계속 내용 입력 후 
			- Q!통해서 파일 쓰기 종료 처리
		*/
		Scanner s =  new Scanner(System.in);
		System.out.println("일기장 등록할 날짜 입력(YYYYMMDD): ");
		String date = s.next(); // \n을 빼고 입력  nextLine()에는 \n이 있음
		System.out.println("입력할 파일명: "+date+".txt");
		String dPath = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z01_homework\\diary";
		File dff = new File(dPath+ date);
	
		try {
			
			if(!dff.exists()) dff.createNewFile();
			
			System.out.println("내용을 입력하세요!");
			
			// 파일명 ==> File() ==> FileWriter ==> PrintWriter
			FileWriter fww = new FileWriter(dff);
			PrintWriter outt = new PrintWriter(fww);
			outt.write("날짜: "+date+"\n");
			
			StringBuffer sbf = new StringBuffer(); // 누적하게 입력되도록
			while(true) {				
				// 라인별로 문자열을 받아서
				String data = s.nextLine(); // Scanner로 입력
				// 마지막 라인에서 Q!를 입력시 
				if(data.equals("Q!")) {
					break;
				}
				sbf.append(data+"\n");
			}
			// 최종적으로 입력받은 문자열을 쓰기 처리
			outt.write(sbf.toString());	
			System.out.println("일기 쓰기 종료");
			outt.flush();
			
			// 자원해제
			outt.close();
			fww.close();
			
			
			// .print(), .append(), .write() 차이가 뭘까
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		/*
		 == 평가대비(자바) 객관식 문제 ==
		 1. 2. 
		 정답2
		 InputStream은 바이트기반 스트림의 최상위 클래스이며 추상클래스이다. 
		 OutputStream은 바이트기반 출력 스트림의 최상위 클래스로 추상클래스이다.
		 Reader는 문자 기반 입력 스트림의 최상위 클래스로 추상 클래스이다
		 Writer는 문자 기반 출력 스트림의 최상위 클래스로 추상 클래스이다
		 */

	}

}
