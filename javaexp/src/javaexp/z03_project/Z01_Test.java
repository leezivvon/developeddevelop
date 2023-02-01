package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javaexp.a13_database.DB;
import javaexp.z03_project.vo.Pcommute;
import javaexp.z03_project.vo.Pdept;
import javaexp.z03_project.vo.Pemp;
import javaexp.z03_project.vo.Pjoin;
import javaexp.z03_project.vo.Ppfapp;
import javaexp.z03_project.vo.Pretire;
import javaexp.z03_project.vo.Psalexp;
import javaexp.z03_project.vo.Pschedule;
import javaexp.z03_project.vo.Pvacation;

public class Z01_Test {


	public static void main(String[] args) {
	switch (grd) {
	case 1: // 이사
	case 2: // 부장
	case 3: // 차장
	case 4: // 과장
	case 5: // 대리
	case 6: // 사원
		for (int cnt = 1; cnt < 20; cnt++) {
			System.out.println("\n-일반사원 페이지입니다.");
			System.out.println("이용할 프로그램을 고르세요\n");
			System.out.println("1.인사\n2.급여\n3.근태/휴가");
			String wanswer = sc.nextLine();

			switch (Integer.parseInt(wanswer)) {
			case 1: // 인사
				for (int cntt = 1; cntt < 20; cntt++) {
					System.out.println("인사프로그램 중 이용할 기능을 고르세요");
					System.out.println("1.부서정보검색	| 2.부서이동신청결과조회	 ");
					System.out.println("3.인사정보검색	| 4.인사평가결과조회  	| 5.퇴사자현황검색 ");
					System.out.println("6.비밀번호변경");
					String wanswer2 = sc.nextLine();

					switch (Integer.parseInt(wanswer2)) {
					case 1: // 부서정보검색
						break;

					case 2: // 부서 이동 신청 결과
						break;

					case 3: // 인사정보검색
						break;

					case 4: // 인사평가결과조회
						break;

					case 5: // 퇴사자현황검색
						break;

					case 6: // 비밀번호변경
						break;

					default:
						System.out.println("범위 내의 숫자를 입력하세요");
					}
					System.out.println("\n인사 프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
					String stop2 = sc.nextLine();
					if (stop2.equals("그만"))
						break; // for문 break
				}
				break; // case1 break

			case 2: // 급여
				for (int cntt = 1; cntt < 5; cntt++) {
					System.out.println("급여프로그램 중 이용할 기능을 고르세요");
					System.out.println("1.급여조회	 | 2.수당 신청	 ");
					String wanswer2 = sc.nextLine();

					switch (Integer.parseInt(wanswer2)) {
					case 1: // 급여조회
						break;
					case 2: // 수당 신청
						break;
					default:
						System.out.println("하나의 숫자를 입력하세요");
					}
					System.out.println("\n");
					System.out.println("급여 프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
					String stop2 = sc.nextLine();
					if (stop2.equals("그만"))
						break;
				}
				break; // case2 break

			case 3: // 근태/휴가
				for (int cntt = 1; cntt < 5; cntt++) {
					System.out.println("근태/휴가 프로그램 중 이용할 기능을 고르세요");
					System.out.println("1.근무스케줄 검색 | 2.출근부조회  | 3.휴가조회	 ");
					String wanswer2 = sc.nextLine();

					switch (Integer.parseInt(wanswer2)) {
					case 1: // 근무스케줄 검색
						break;
					case 2: // 출근부조회
						break;
					case 3: // 휴가조회
						break;
						
					System.out.println("근태/휴가 프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
					String stop2 = sc.nextLine();
					if (stop2.equals("그만"))
						break; // for문 break
				}
			}break; // case3 break

			default:
				System.out.println("범위 내의 숫자를 입력하세요");
			}

			System.out.println("사원페이지를 나가고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
			String stop3 = sc.nextLine();
			if (stop3.equals("그만")) break;// 사원관리 for문
		}
	}

	}

}
