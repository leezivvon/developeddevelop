package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javaexp.z03_project.vo.Pcommute;
import javaexp.z03_project.vo.Pdept;
import javaexp.z03_project.vo.Pemp;
import javaexp.z03_project.vo.Phrd;
import javaexp.z03_project.vo.Pjoin;
import javaexp.z03_project.vo.Ppfapp;
import javaexp.z03_project.vo.Pretire;
import javaexp.z03_project.vo.Psalexp;
import javaexp.z03_project.vo.Pschedule;
import javaexp.z03_project.vo.Pvacation;

public class A00_MainCall {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static void main(String[] args) {

		A10_Login dao = new A10_Login();
		A02_PrDept dao2 = new A02_PrDept();
		A03_PrEmp dao3 = new A03_PrEmp();
		A04_PrEmp2 dao4 = new A04_PrEmp2();
		A05_Psch dao5 = new A05_Psch();
		A06_Prvac dao6 = new A06_Prvac();
		A07_Prcom dao7 = new A07_Prcom();
		A08_Prsalex dao8 = new A08_Prsalex();
		A09_Prhrd dao9 = new A09_Prhrd();

		Scanner sc = new Scanner(System.in);

		System.out.println("___________________________");
		System.out.println("       오뚝이 인사프로그램       ");  
		System.out.println("___________________________");
		// 로그인
		Pemp llogin = new Pemp();
		boolean isFirst = true;
		do {
			if (!isFirst) {
				System.out.println("사원번호 혹은 비밀번호가 틀렸습니다");
			}
			System.out.println("로그인");
			System.out.print("ID\t| ");
			String empno = sc.nextLine();
			System.out.print("Pass\t| ");
			String pass = sc.nextLine();
			System.out.println();
			llogin.setEmpno(empno);
			llogin.setPass(pass);

		} while ( !dao.login(llogin) );

		// 프로그램입장
		System.out.println("\n\t***로그인 완료***");
		System.out.println("___오뚝이 인사프로그램을 시작합니다___");
		System.out.print("\n사원번호를 한번 더 입력해주세요_ ");
		String empnop = sc.nextLine();
		// 출근
		System.out.println("삑-");
		dao7.insertPcommute1(empnop);

		// 페이지결정(관리자/근로자)
		List<Pemp> eglist = dao.getgrd(empnop);
		Pemp eg = eglist.get(0);
		String pos = eg.getPos();
		int grd = eg.getGrd();
		if (grd < 4) {
			System.out.println("\n\n "+pos+"님 환영합니다.");
			System.out.print("\n관리자 페이지로 들어가시겠습니까?\n들어가신다면 '네'를 입력하세요_ ");
			String answer = sc.nextLine();
			if (!answer.equals("네")) {
				grd += 3;
				System.out.println("\n-일반사원 페이지로 들어갑니다\n");
			} else {
				System.out.println("\n-관리자 페이지로 들어갑니다\n");
			}
		}

		// 페이지
		switch (grd) {
		case 1: // 이사
		case 2: // 부장
		case 3: // 차장
			System.out.println("이용할 프로그램을 고르세요");
			System.out.println("1.인사\n2.급여\n3.근태/휴가\n4.인사관리");
			String manswer = sc.nextLine();

			switch (Integer.parseInt(manswer)) {
			case 1: // 인사
				for (int cnt = 1; cnt < 20; cnt++) {
					System.out.println("인사프로그램 중 이용할 기능을 고르세요");
					System.out.println("1.부서정보등록 | 2.부서이동	  	| 3.부서정보삭제 |");
					System.out.println("4.인사정보등록 | 5.인사정보삭제		|");
					System.out.println("6.인사평가등록 | 7.퇴사신청서등록	|");
					String manswer1 = sc.nextLine();

					switch (Integer.parseInt(manswer1)) {
					case 1: // 부서정보등록
						System.out.println("// 새로운 부서정보를 등록합니다.");
						System.out.print("등록할 부서번호_ ");
						String deptno1 = sc.nextLine();
						System.out.print("등록할 부서명_ ");
						String dname1 = sc.nextLine();
						System.out.print("등록하는 부서 위치_ ");
						String loc1 = sc.nextLine();
						dao2.insertPdept(new Pdept(Integer.parseInt(deptno1), dname1, loc1));
						System.out.println("\n부서번호 " + deptno1 +" "+dname1 + " 팀이 새롭게 등록되었습니다\n");
						break;
					case 2: // 부서 이동
						System.out.println("// 부서를 이동합니다.");
						System.out.print("부서이동이 있는 사원의 사원번호_ ");
						String empno1 = sc.nextLine();
						System.out.print("\n해당 사원이 이동할 부서번호_ ");
						String deptno2 = sc.nextLine();
						dao4.movePdept(Integer.parseInt(deptno2), empno1);
						System.out.println(empno1 + " 사원의 부서가 " + deptno2 + "로 변경되었습니다\n");
						break;
					case 3:// 부서정보삭제
						System.out.println("// 부서 정보를 삭제합니다");
						System.out.print("삭제할 부서의 부서번호_ ");
						String deptno3 = sc.nextLine();
						dao2.deletePdept(Integer.parseInt(deptno3));
						System.out.println("부서번호 " + deptno3 + " 부서가 삭제되었습니다\n");
						break;
					case 4: // 인사정보등록
						// 입사정보등록-사원번호생성
						System.out.println("// 인사정보를 등록합니다");
						System.out.print("입사일(YYYYMMDD)_ ");
						String entrydt = sc.nextLine();
						System.out.print("입사직위_ ");
						String entrypos = sc.nextLine();
						System.out.print("입사부서번호_ ");
						String entrydeptno = sc.nextLine();
						dao3.insertPjoin(new Pjoin(entrydt, entrydt, entrypos, Integer.parseInt(entrydeptno)));
						// 인사정보등록
						List<Pjoin> jlist = dao3.getPjoinList();
						Pjoin j = jlist.get( jlist.size() - 1);
						String fempno = j.getEmpno();
						String rpass = "";
						for (int cntt = 1; cntt <= 6; cntt++) {
							int rword = (int) (Math.random() * 76 + 47);
							rpass += (char) rword;
						}
						System.out.print("\n사원이름_ ");
						String ename1 = sc.nextLine();
						System.out.print("소속부서번호_ ");
						String deptno4 = sc.nextLine();
						System.out.print("직위(부장/차장/과장/대리/사원)_ ");
						String pos1 = sc.nextLine();
						System.out.print("생년월일(YYYY/MM/DD)_ ");
						String birtd1 = sc.nextLine();
						System.out.print("실거주지_ ");
						String address1 = sc.nextLine();
						dao3.insertPemp(
								new Pemp(fempno, ename1, Integer.parseInt(deptno4), pos1, birtd1, address1, rpass));
						System.out.println("사원번호 " + fempno + " " + ename1 + " " + pos1 + "의 정보가 등록되었습니다.\n");
						System.out.println("아이디는 부여된 사원번호는 "+fempno+", 임시비밀번호는 "+rpass+"입니다");
						break;
					case 5: // 인사정보삭제
						System.out.println("// 인사정보를 삭제합니다.");
						System.out.print("삭제할 사원번호_ ");
						String empno2 = sc.nextLine();
						dao3.deletePemp(empno2);
						System.out.println("사원번호" + empno2 + "의 사원정보가 삭제되었습니다\n");
						break;
					case 6: // 인사평가등록
						System.out.println("// 인사평가를 등록합니다");
						System.out.print("사원번호_ ");
						String empno3 = sc.nextLine();
						System.out.print("\n평가 점수(5점만점)_ ");
						String pfscore = sc.nextLine();
						System.out.print("\n직원의 업무성과_ ");
						String pfresult = sc.nextLine();
						System.out.print("\n업무개선 정보_ ");
						String impinfo = sc.nextLine();
						dao4.insertPpfapp(new Ppfapp(empno3, Double.parseDouble(pfscore), pfresult, impinfo));
						System.out.println("사원번호 " + empno3 + "의 인사평가가 등록되었습니다\n");
						break;
					case 7: // 퇴사신청서등록
						System.out.println("// 퇴사 신청서를 등록합니다");
						System.out.print("사원번호_ ");
						String empno4 = sc.nextLine();
						System.out.print("\n퇴사일(YYYY/MM/DD)_ ");
						String retiredt = sc.nextLine();
						System.out.print("\n퇴사 사유_ ");
						String retirerson = sc.nextLine();
						System.out.print("\n연락처_ ");
						String hp = sc.nextLine();
						dao4.insertPretire(new Pretire(empno4, retiredt, retirerson, hp));
						System.out.println("사원번호 " + empno4 + "의 퇴사가 등록되었습니다\n");
						break;
					default:
						System.out.println("하나의 숫자를 입력하세요");
					}

					System.out.println("인사 프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
					String stop = sc.nextLine();
					if (stop.equals("그만"))
						break; // for문 break
				}
				break; // case1 break

			case 2: // 급여
				for (int cnt = 1; cnt < 20; cnt++) {
					System.out.println("급여프로그램 중 이용할 기능을 고르세요");
					System.out.println("1.급여등록	 | 2.급여수정  | 3.수당조회  ");
					String manswer1 = sc.nextLine();

					switch (Integer.parseInt(manswer1)) {
					case 1: // 급여등록
						System.out.println("// 직원의 급여를 등록합니다");
						System.out.print("사원번호_ ");
						String empno1 = sc.nextLine();
						System.out.print("월급여_ ");
						String sal = sc.nextLine();
						System.out.print("퇴직금_ ");
						String svpy = sc.nextLine();
						dao8.insertPsal(empno1, Integer.parseInt(sal), Integer.parseInt(svpy));
						System.out.println("사원번호 " + empno1 + "의 급여가 등록되었습니다\n");
						break;
					case 2: // 급여 수정
						System.out.println("// 직원의 급여를 수정합니다");
						System.out.print("사원번호_ ");
						String empno2 = sc.nextLine();
						System.out.print("\n인상/삭감된 급여_ ");
						String sal2 = sc.nextLine();
						dao8.updPsal(Integer.parseInt(sal2), empno2);
						System.out.println("사원번호 " + empno2 + "의 급여가 변경되었습니다\n");
						break;
					case 3: // 수당 조회
						System.out.println("// 직원의 수당을 조회합니다");
						System.out.print("조회할 직원명_ ");
						String ename1 = sc.nextLine();
						System.out.print("조회할 달(MM)_ ");
						String month = sc.nextLine();
						List<Psalexp> exlist = dao8.getPextrapayList(ename1, month);
						System.out.println(ename1 + "의 " + month + "월 수당 검색 결과 ");
						System.out.println();
						System.out.println("수당종류\t수당액");
						System.out.println("------\t----");
						for (Psalexp ex : exlist) {
							System.out.print(ex.getExpkind() + "  ");
							System.out.println(+ex.getSumm());
						}
						System.out.println();
						break;
					default:
						System.out.println("하나의 숫자를 입력하세요");
					}
					System.out.println("급여 프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
					String stop = sc.nextLine();
					if (stop.equals("그만"))
						break; // for문 break
				}
				break; //// case2 break

			case 3: // 근태 휴가
				for (int cnt = 1; cnt < 20; cnt++) {
					System.out.println("근태/휴가프로그램 중 이용할 기능을 고르세요");
					System.out.println("1.근무스케줄등록	| 2.근무스케줄 수정	| 3.근무스케줄 삭제 ");
					System.out.println("4.휴가 신청	| 5.휴가정보 수정	| 6.휴가정보 삭제 ");
					System.out.println("7.출근부 수정	| 8.출근부 삭제  ");
					String manswer1 = sc.nextLine();
					switch (Integer.parseInt(manswer1)) {
					case 1: // 근무스케줄등록
						System.out.println("// 근무스케줄을 등록합니다");
						System.out.print("스케줄 구분번호(AA001)_ ");
						String schno = sc.nextLine();
						System.out.print("근무스케줄 날짜(YYYY/MM/DD)_ ");
						String schdt1 = sc.nextLine();
						System.out.print("근무스케줄 내용_ ");
						String con = sc.nextLine();
						System.out.print("참여인원_");
						String ctp = sc.nextLine();
						System.out.println();
						for (int cntt = 1; cntt <= Integer.parseInt(ctp); cntt++) {
							System.out.print("참여사원의 사원번호 " + cntt + "_ ");
							String empno1 = sc.nextLine();
							dao5.insertPschedule(new Pschedule(schno, empno1, schdt1, con));
						}
						System.out.println("\n"+schno + " " + schdt1 + "일자 근무스케줄이 등록되었습니다\n");
						break;
					case 2: // 스케줄 수정
						System.out.println("// 근무스케줄 날짜를 변경합니다");
						System.out.print("수정할 스케줄의 주제_ ");
						String theme1 = sc.nextLine();
						System.out.print("수정할 날짜(YYYYMMDD)_ ");
						String schdt2 = sc.nextLine();
						dao5.updatePschedule(schdt2, theme1);
						System.out.println("\n스케줄이 " + schdt2 + "로 변경되었습니다\n");
						break;
					case 3: // 스케줄 삭제
						System.out.println("// 근무스케줄을 삭제합니다");
						System.out.print("삭제할 스케줄의 주제_ ");
						String theme2 = sc.nextLine();
						System.out.print("삭제할 스케줄의 날짜(YYYYMMDD)_ ");
						String schdt3 = sc.nextLine();
						dao5.deletePschedule(theme2, schdt3);
						System.out.println("스케줄이 삭제되었습니다\n");
						break;
					case 4: // 휴가 신청
						System.out.println("// 직원의 휴가신청을 등록합니다");
						System.out.print("사원번호_ ");
						String empno1 = sc.nextLine();
						System.out.print("휴가 시작일(YYYYMMDD)_ ");
						String vacfdt1 = sc.nextLine();
						System.out.print("휴가 마지막일(YYYYMMDD)_ ");
						String vacldt1 = sc.nextLine();
						dao6.insertPvacation(new Pvacation(empno1, vacfdt1, vacldt1));
						System.out.println("\n사원번호 " + empno1 + "의 휴가 신청이 등록되었습니다\n");
						break;
					case 5: // 휴가정보 수정
						System.out.println("// 직원의 휴가를 수정합니다");
						System.out.print("사원번호_ ");
						String empno2 = sc.nextLine();
						System.out.print("수정할 휴가의 시작일(YYYYMMDD)_ ");
						String udvacfdt = sc.nextLine();
						System.out.print("휴가 시작일(YYYYMMDD)_ ");
						String vacfdt2 = sc.nextLine();
						System.out.print("휴가 마지막일(YYYYMMDD)_ ");
						String vacldt2 = sc.nextLine();
						dao6.updatePvacation(new Pvacation(vacfdt2, vacldt2, empno2, udvacfdt));
						System.out.println("사원번호 " + empno2 + "의 휴가가 수정되었습니다.\n");
						break;
					case 6: // 휴가 정보 삭제
						System.out.println("// 직원의 휴가를 삭제합니다");
						System.out.print("사원번호_ ");
						String empno3 = sc.nextLine();
						System.out.print("삭제할 휴가의 시작일(YYYYMMDD)_ ");
						String dlvacfdt = sc.nextLine();
						dao6.deletePvacation(empno3, dlvacfdt);
						System.out.println("\n휴가가 삭제되었습니다\n");
						break;
					case 7: // 출근부 수정
						System.out.println("// 직원의 출근시간을 수정합니다");
						System.out.print("사원번호_ ");
						String empno4 = sc.nextLine();
						System.out.print("수정할 날짜(YYYYMMDD)_ ");
						String dt = sc.nextLine();
						System.out.print("수정 시간(HH24MI)_ ");
						String updhm = sc.nextLine();
						dao7.updatePcommute(new Pcommute(dt + updhm, empno4, dt));
						System.out.println(dt + "일자의 출근시간이 수정되었습니다");
						break;
					case 8: // 출근부 삭제
						System.out.println("// 직원의 출근기록을 삭제합니다");
						System.out.print("사원번호_ ");
						String empno5 = sc.nextLine();
						System.out.print("삭제할 날짜(YYYYMMDD)_ ");
						String dldt = sc.nextLine();
						dao7.deletePcommute(empno5, dldt);
						System.out.println("사원번호 " + empno5 + "의 " + dldt + "일자 출근기록이 삭제되었습니다");
						break;
					default:
						System.out.println("범위 내의 숫자를 입력하세요");
					}
					System.out.println("\n근태/휴가프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
					String stop = sc.nextLine();
					
					if ( stop.equals("그만") ) break; // for문 break
				}
				break; // case3 break

			case 4: // 인사관리
				for (int cnt = 1; cnt < 20; cnt++) {
					System.out.println("인사관리 프로그램 중 이용할 기능을 고르세요");
					System.out.println("1.인사계획입력	| 2.인사 분석	| 3.평가 분석 ");
					String manswer1 = sc.nextLine();

					switch (Integer.parseInt(manswer1)) {
					case 1: // 인사계획입력
						System.out.println("// 한 해의 인사계획을 등록합니다");
						System.out.print("계획 년도(YYYY)_ ");
						String plyear = sc.nextLine();
						for (int cntt = 1; cntt <= 10; cntt++) {
							System.out.print("부서 번호_ ");
							String deptno1 = sc.next();
							System.out.print("계획 인원(부장)_ ");
							String grd1 = sc.nextLine();
							System.out.print("계획 인원(차장)_ ");
							String grd2 = sc.nextLine();
							System.out.print("계획 인원(과장)_ ");
							String grd3 = sc.nextLine();
							System.out.print("계획 인원(대리)_ ");
							String grd4 = sc.nextLine();
							System.out.print("계획 인원(사원)_ ");
							String grd5 = sc.nextLine();
							dao9.insertPperplan(new Phrd(plyear, Integer.parseInt(deptno1), Integer.parseInt(grd1),
									Integer.parseInt(grd2), Integer.parseInt(grd3), Integer.parseInt(grd4),
									Integer.parseInt(grd5)));

						}
						System.out.println(plyear + "년의 각 부서의 인사계획을 등록하였습니다");
						break;
					case 2: // 인사 분석
						System.out.println("// 한 해의 인사분석을 살펴봅니다");
						System.out.print("계획 년도(YYYY)_ ");
						String plyear2 = sc.nextLine();
						System.out.print("분석대상 부서의 부서 번호_ ");
						String deptno1 = sc.nextLine();

						List<Phrd> hrlist1 = dao9.getPhrdList1(Integer.parseInt(deptno1)); // 현재 인원
						List<Phrd> hrlist2 = dao9.getPhrdList2(plyear2, Integer.parseInt(deptno1)); // 계획인원
						Phrd h = hrlist2.get(0); // hab, dgc, per
						int hab = h.getHab();
						int dgc = h.getDgc();
						double per = h.getPer();
						System.out.println("부서번호\t" + deptno1);
						
						System.out.println("         이사/부장\t차장\t과장\t대리\t사원");
						System.out.print("계획 인원 | ");
						for (Phrd hh : hrlist2) {
							System.out.print(hh.getBu() + "\t");
							System.out.print(hh.getCha() + "\t");
							System.out.print(hh.getGwa() + "\t");
							System.out.print(hh.getDae() + "\t");
							System.out.print(hh.getSawon() + "\t");
						}
						System.out.print("총합: " + hab + "\n");
						// 인사계획 - 현재 인원 조회
						System.out.print("현재 인원 | ");
						for (Phrd hh : hrlist1) {
							System.out.print(hh.getCt() + "\t");
						}
						System.out.print("총합: " + dgc + "\n");
						System.out.print("\n계획인원 대비 현재인원 퍼센테이지: " + per + "%\n분석 결과 : ");
						if (per < 100) {
							System.out.print("인원 미달");
						} else if (per == 100) {
							System.out.print("적정 인원");
						} else {
							System.out.print("인원 초과");
						}
						break;
//					case 3: // 평가분석
//						break;
					default:
						System.out.println("숫자 하나만 입력하세요");
						continue;
					}
					System.out.println("\n");
					System.out.println("인사관리 프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
					String stop = sc.nextLine();
					if (stop.equals("그만")) break; // for문 break
				}
				break; // case4 break

			default:
				System.out.println("\n관리자 페이지를 종료합니다");
			}
			System.out.println("\n관리자 페이지를 종료합니다\n");
			System.out.println("일반 사원 페이지로 들어가시려면 \"네\"를");
			System.out.print("프로그램을 종료하려면 \"아니오\"를 입력하세요_ ");
			String answer2 = sc.nextLine();
			if (!answer2.equals("네")) {
				System.out.println("\n\n\n프로그램이 종료됩니다\n");
				System.out.println("삑-\n");
				dao7.insertPcommute2(empnop);
				break;
			}
				 // 관리자페이지 break

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
							System.out.println("// 부서정보를 검색합니다");
							System.out.println("// 전체 부서의 정보를 알고 싶다면 enter키를 누르세요");
							System.out.print("검색할 부서의 부서이름_ ");
							String deptno1 = sc.nextLine();
							for (Pdept d : dao2.getPdeptList(deptno1)) {
								System.out.print(d.getDeptno() + "\t");
								System.out.print(d.getDname() + " \t");
								System.out.print(d.getLoc() + "  \t");
								System.out.print(d.getCtp() + "\n");
							}
							break;

						case 2: // 부서 이동 신청 결과
							System.out.println("// 부서 이동 신청 결과입니다");
							System.out.print("이동 신청한 부서번호를 입력하세요_ ");
							String deptno2 = sc.nextLine();
							List<Pemp> ednolist = dao2.getPempdptno(deptno2);
							Pemp edno = ednolist.get(0);
							int mydeptno = edno.getDeptno();
							System.out.println("현재 소속 부서: " + mydeptno);
							if (mydeptno == Integer.parseInt(deptno2))
								System.out.println("부서가 이동되었습니다");
							if (mydeptno != Integer.parseInt(deptno2))
								System.out.println("부서이동신청이 받아들여지지 않았습니다");
							break;

						case 3: // 인사정보검색
							System.out.println("// 인사 정보를 검색합니다");
							System.out.println("// 전체 사원의 정보를 조회하고 싶다면 enter를 입력하세요");
							System.out.print("검색할 사원명_ ");
							String ename1 = sc.nextLine();

							for (Pemp e : dao3.getPempList(ename1)) {
								System.out.println("\"" + e.getEname() + "\"님의 사원정보");
								System.out.println("사원번호\t: " + e.getEmpno());
								System.out.println("이름   \t: " + e.getEname());
								System.out.println("부서번호\t: " + e.getDeptno());
								System.out.println("현재직급\t: " + e.getPos());
								System.out.println("생년월일\t: " + e.getBirthd());
								System.out.println("거주지\t: " + e.getAddress());
								System.out.println();
							}
							break;

						case 4: // 인사평가결과조회
							System.out.println("// 인사 평가 결과를 조회합니다");
							System.out.println("  평가날짜\t\t    부서명/사원명\t\t    개인성과\t   업무개선사항\n");
							for (Ppfapp pf : dao4.getPpfappList(empnop)) {
								System.out.print(pf.getPfapdate() + "\t");
								System.out.print(pf.getDname() + "팀 ");
								System.out.print(pf.getPos() + " ");
								System.out.print(pf.getEname() + "\t");
								System.out.print(pf.getPrresult() + "\t");
								System.out.print(pf.getImpinfo() + "\n");
							}
							break;

						case 5: // 퇴사자현황검색
							System.out.println("//퇴사자현황을 조회합니다");
							System.out.println("사원번호\t사원명\t   소속팀/직급\t   입사일\t\t퇴직일\t    주소\t\t퇴직사유\t\t연락처\n");
							for (Pretire rt : dao4.getPretireList()) {
								System.out.print(rt.getEmpno() + "\t");
								System.out.print(rt.getEname() + "\t");
								System.out.print(rt.getDname() + "팀 ");
								System.out.print(rt.getPos() + "\t");
								System.out.print(rt.getEntrydate() + "   ");
								System.out.print(rt.getRetiredate() + "\t  ");
								System.out.print(rt.getAddress() + "\t");
								System.out.print(rt.getRetirereason() + "\t    ");
								System.out.print(rt.getPh() + "\n");
							}
							break;

						case 6: // 비밀번호변경
							System.out.println("//비밀번호를 변경합니다");
							System.out.print("변경할 비밀번호를 입력하세요_ ");
							String pass1 = sc.nextLine();
							dao3.changePass(pass1, empnop);
							System.out.println("비밀번호가 변경되었습니다");
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
							System.out.println("// 급여를 조회합니다");
							List<Psalexp> slist = dao8.getPsalList(empnop);
							for (Psalexp s : slist) {
								System.out.println("_ " + s.getEf() + "의 급여조회 결과 _");
								System.out.print("     월급 : " + s.getSal() + "\t");
								System.out.println(" 연봉 : " + s.getYsal() + "\n");
							}
							break;
						case 2: // 수당 신청
							System.out.println("// 수당을 신청합니다");
							System.out.print("수당종류_ ");
							String kind = sc.nextLine();
							System.out.print("수당 액수_ ");
							String pay = sc.nextLine();
							System.out.print("수당발생한 날짜(YYYYMMDD)_");
							String dt1 = sc.nextLine();
							dao8.insertPextrapay(new Psalexp(empnop, dt1, kind, Integer.parseInt(pay)));
							System.out.println("수당번호 " + dt1 + "의 " + kind + "이 신청되었습니다 ");
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
							System.out.println("// 근무스케줄을 조회합니다");
							System.out.print("조회할 년도(YYYY)_ ");
							String schyy = sc.nextLine();
							System.out.print("조회할 달(MM)_ ");
							String schmm = sc.nextLine();
							StringTokenizer st;
							List<Pschedule> schlist = dao5.getPscheduleList(new Pschedule(schyy, schmm));
							System.out.println(schlist.size());
							for (Pschedule sch : schlist) {
								System.out.println(sch.getSchdate() + " 스케줄");
								System.out.println("안건\t| " + sch.getTopic());
								System.out.println("참여인원\t| " + sch.getCemp() + " 명");
								System.out.print("참여명단\t| ");
								st = new StringTokenizer(sch.getList(), ",");
								while (st.hasMoreTokens()) {
									System.out.print(st.nextToken() + "\n\t  ");
								}
								System.out.println();
							}
							break;
						case 2: // 출근부조회
							System.out.println("// 출근부를 조회합니다");
							System.out.print("사원명_ ");
							String ename2 = sc.nextLine();
							List<Pcommute> clist = dao7.getPcommuteList(ename2);
							System.out.println("    날짜\t\t사원번호\t사원이름\t출근시간\t퇴근시간");
							for (Pcommute c : clist) {
								System.out.print(c.getCdate() + "\t");
								System.out.print(c.getEmpno() + "\t");
								System.out.print(c.getEname() + "\t");
								System.out.print(c.getArt() + "\t");
								System.out.print(c.getLvt() + "\n");
							}
							break;
						case 3: // 휴가조회
							System.out.println("// 휴가 정보를 조회합니다");
							System.out.println("// 검색하고 싶은 사원의 이름이나 날짜를 입력하세요");
							System.out.print("휴가자 이름_ ");
							String ename1 = sc.nextLine();
							System.out.print("검색할 날짜(YYYYMMDD)_ ");
							String schdt = sc.nextLine();
							List<Pvacation> vlist = dao6.getPvacationList(ename1, schdt);
							System.out.println("직원\t\t\t휴가시작날짜\t휴가마지막날짜");
							for (Pvacation v : vlist) {
								System.out.print(v.getWorker() + "\t");
								System.out.print(v.getVacfdate() + "\t");
								System.out.print(v.getVacldate() + "\n");
							}
							break;
						}
						System.out.println("\n");
						System.out.println("근태/휴가 프로그램을 중지하고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
						String stop2 = sc.nextLine();
						if (stop2.equals("그만"))
							break;
					}
					break; // case3 break

				default:
					System.out.println("범위 내의 숫자를 입력하세요");
				}

				System.out.println("사원페이지를 나가고 싶다면 \" 그만 \"을, 계속하고 싶다면 \" ㄱ \"을 입력하세요");
				String stop3 = sc.nextLine();
				if (stop3.equals("그만")) break;// 사원관리 for문
			}
			
			default:
				System.out.println("\n\n프로그램이 종료됩니다\n");
				System.out.println("삑-\n");
				System.out.println("퇴근시간이 등록되었습니다");
				dao7.insertPcommute2(empnop);
		}

	}
}