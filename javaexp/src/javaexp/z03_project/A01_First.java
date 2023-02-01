package javaexp.z03_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A01_First {

	public static void main(String[] args) {

		// 1. 제품 검색 기능
		Scanner sc = new Scanner(System.in);

		System.out.println("__________________________________________________");
		System.out.print("MUSINSA| 찾는 물품이나 브랜드를 입력하세요_");

		String schcloth = sc.nextLine();
		System.out.println();

		System.out.println("__________________________________________________");
		System.out.print("MUSINSA| " + schcloth);
		System.out.println("\n__________________________________________________");
		System.out.println("\'" + schcloth + "\'에 대한 검색 결과");
		System.out.println();

		try {
			String storage = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z03_project\\Storage";
			Path path1 = Paths.get(storage);

			List<String> clist = Files.readAllLines(path1); // readAllLines()는 파일의 문자열을 리스트로 리턴
			for (String clothes : clist) { 
				if (clothes.indexOf(schcloth) != -1) { // Scanner로 입력한 글자 위치를 찾아서
					System.out.println(clothes.substring(clothes.indexOf(schcloth), clothes.length()));
				} // substring으로 그 시작 위치부터 배열 끝까지 추출해서 
			} // for문으로 출력
		
		} catch (IOException e) {	
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();

		
		// 2. 구매후기 작성
		// mypage파일에 적립금 출력할 거라서 주소 할당
		String myPagef = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z03_project\\MyPage_zivvonyyy16";
		
		System.out.println();
		System.out.println(" 일반 후기작성");
		System.out.println("__________________________________________________");
		System.out.println("· 후기 작성시 500원의 적립금이 지급됩니다.\n· 후기 내용은 20자 이상 작성합니다.");
		System.out.println();
		System.out.println("\t< 구매한 상품 >\n\t   hoody A");
		System.out.println();

		System.out.println("__________________________________________________");
		System.out.print("별점을 매겨주세요\t| ☆☆☆☆☆ \n(1~5 중 입력)\t| ");
		String starScr = sc.nextLine();
		StringBuffer sbf1 = new StringBuffer("☆☆☆☆☆");
		String[] starArr = new String[5]; // for문에서 하나씩 검정별로 바뀔 때마다 할당될 배열공간 만들어놓고 
		for (int idx = 0; idx < starArr.length; idx++) { // starArr[]에 할당
			sbf1.replace(idx, idx + 1, "★");
			starArr[idx] = sbf1.toString();
		}

		String[] choice = { "사이즈\t\t| □커요\t|   □보통이에요\t| □작아요  | ", "밝기\t\t| □밝아요\t|   □보통이에요\t| □어두워요 | ",
				"색감\t\t|□선명해요|   □보통이에요\t| □흐려요  | ", "두께감\t\t|□두꺼워요|   □보통이에요\t| □얇아요  | " };
		String[] put = new String[4];
		StringBuffer sbf2 = new StringBuffer();

		System.out.println("__________________________________________________");
		System.out.println("\t   해당 하는 항목을 입력하세요");
		for (int cnt = 1; cnt <= 4; cnt++) {
			System.out.println("__________________________________________________");
			String ch = choice[cnt - 1];
			sbf2 = new StringBuffer(ch);

			System.out.print(ch);
			put[cnt - 1] = sc.nextLine();
			if (ch.indexOf(put[cnt - 1]) != -1) {
				int idxLoc = ch.indexOf(put[cnt - 1]);
				sbf2.replace(idxLoc - 1, idxLoc, "■");
			}
			choice[cnt - 1] = sbf2.toString();
		}

		System.out.println("\n신체정보--------------");

		System.out.println("__________________________________________________");
		System.out.print("성별\t\t|");
		String gender = sc.nextLine();
		System.out.println("__________________________________________________");
		System.out.print("키\t\t|");
		String height = sc.nextLine();
		System.out.println("__________________________________________________");
		System.out.print("몸무게\t\t|");
		String weight = sc.nextLine();
		System.out.println("__________________________________________________");
		System.out.println("상품에 대한 평가를 20자 이상 작성해주세요");
		while (true) {
			String comment = sc.nextLine();
			if (comment.length() >= 20) {
				System.out.println("__________________________________________________");
				System.out.println("\n" + comment);
				System.out.println("__________________________________________________");
				System.out.println();
				System.out.println("_상품평 작성을 완료하셨습니다.");
				break;
			} else {
				System.out.println("20자 이상 작성해주세요");
			}
		}
		System.out.println();

		// 등록 후 포인트 지급
		System.out.print("모든 후기 작성을 마치셨으면 등록을 입력하세요_");
		String reg = sc.nextLine();
		if (reg.equals("등록")) {
			// 결과 출력
			// 별점출력
			System.out.println();
			System.out.println("__________________________________________________");
			System.out.print("별점을 매겨주세요\t| ");
			System.out.println(starArr[Integer.parseInt(starScr) - 1]); 
			// 항목입력 출력
			for (int idx = 0; idx <= 3; idx++) {
				System.out.println("__________________________________________________");
				System.out.println(choice[idx]);
			}
			// 신체정보와내용 출력
			System.out.println("__________________________________________________");
			System.out.print("성별\t\t|");
			System.out.println(gender);
			System.out.print("키\t\t|");
			System.out.println(height);
			System.out.print("몸무게\t\t|");
			System.out.println(weight);
			System.out.println("__________________________________________________");

		} else {
			System.out.println("정확히 입력하세요_");
		}
		// 포인트지급
		System.out.println("\n등록되었습니다\n");
		System.out.println("포인트를 지급합니다.마이페이지에서 확인하세요.");
		try {
			Writer w = new FileWriter(myPagef, true);
			w.append("\n+ 500\n");
			w.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();

		
		
		// 3. 래플 참여
		String memberInfo = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z03_project\\MemberInfo";
		String applicationL = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\z03_project\\ApplicationList";
		Path path2 = Paths.get(memberInfo);
		Path path3 = Paths.get(applicationL); 

		System.out.println("Raffle\n");
		System.out.println("\t--응모방법--\n응모하기를 입력하면 응모자가 추가됩니다. 응모를 멈추고 싶다면 그만을 입력하세요\n");

		try {
			String test = Files.readString(path3); // 래플신청자 수 세기 위해 '신청자파일(path3)'파일크기 읽고 
			StringTokenizer st = new StringTokenizer(test, "\n");   // "\n"를 기준으로 행 개수 센 후
			System.out.println("\t" + st.countTokens() + "명 참여중"); // 출력

			List<String> mlist = Files.readAllLines(path2); // 회원정보(path2) 배열로 선언해서
			Writer ww = new FileWriter(applicationL, true);

			while (true) {
				System.out.print("\t응모하기를 입력하세요_"); // 응모할때마다
				String regRan = sc.nextLine();
				System.out.println();
				if (regRan.indexOf("응모") != -1) {
					int memRandom = (int) (Math.random() * mlist.size()); 
					String pickMem = mlist.get(memRandom) + "\n";
					ww.append(pickMem);
				} else if (regRan.equals("그만")) {
					break;
				}
				ww.flush();			// 랜덤으로 '신청자파일(path3)'에 추가
			}

			List<String> alist = Files.readAllLines(path3);		  // 객체로 만들어 행을 한 개의 정보로 인식
			System.out.println("\t" + alist.size() + "명 참여중\n"); 

			int winRandom = (int) (Math.random() * alist.size()); // '신청자파일(path3)'에서 당첨자뽑기
			String winner = alist.get(winRandom);
			System.out.print("당첨 결과를 확인하시겠습니까?\n네/아니오 중 하나를 입력하세요_");
			String chResult = sc.nextLine();

			if (chResult.equals("네")) {
				
				System.out.println("\n________________________당첨 결과___________________________\n");
				System.out.println("당첨자 : " + winner + "님.");
				System.out.println("_________________________________________________________");
				
			} else {
				System.out.println("\n당첨결과 페이지를 벗어납니다.");
			}
			
			System.out.println("\n당첨결과는 마이페이지에서도 확인할 수 있습니다.\n래플에 참여해주셔서 감사합니다");
			Writer www = new FileWriter(myPagef, true); 		// mypage에도 결과 출력
			if (winner.equals(mlist.get(15))) {
				www.write("\n래플결과_\n축하합니다! 래플에 당첨되었습니다!!\n당첨자 : " + winner + "님.");
			} else {
				www.write("\n래플결과_\n당첨목록에 없습니다. 래플에 참여해주셔서 감사합니다.");
			}
			www.flush();
			www.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
