package javaexp.a05_restore;

public class A05_MultiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 다차원 배열
		1. 2차원 배열 이상의 배열을 말한다
		   - 수학의 행렬과 같은 자료 구조
		2. 자바는 1차원 배열을 이용해 2차원 배열을 구현한다
		   int[][] scores = new int[2][3];
		   scores[0][0] = 1000;		
		   scores[0][1] = 2000;
		   scores[0][2] = 3000;
		   scores[1][0] = 4000;
		   scores[1][1] = 5000;
		   scores[1][2] = 6000;

				*/
		// 기차의 구조
		// 2차원 배열을 이용해
		String[][] trains = new String[6][70]; // 6호차 각호차마다70좌석
		
		// 1호차의 1번좌석
		trains[0][0] = "★";
		// 2호차의 3번좌석
		trains[1][2] = "★";
		
		for(int idx=0;idx<trains.length;idx++) {
			System.out.println(idx+1+"호차 좌석번호");
			// trains[idx].length : 각 호차에 소속된 좌석번호
			for(int jdx=0; jdx<trains[idx].length;jdx++) {
				System.out.print(jdx+1+"번"+trains[idx][jdx]+" ");
			}
			System.out.println();
		}
		// ex) 고등학교 1~3학년, 1~10반을 2차원 배열로 선언하여 각반에 학생을 기본값을 30명씩 할당하여 처리해보자
		//     정수형 2차원 배열을 선언
		/*
		int[][] highsc1st = new int[10][30]; // 1학년
		int[][] highsc2nd = new int[10][30];
		int[][] highsc3rd = new  int[10][30];
		
		System.out.println("# 고닥교 1학년 #");
		for(int idx=0;idx<highsc1st.length;idx++) {
			System.out.println(idx+1+"반");
		}
		*/
		int[][] highschool = new int [3][10]; // 세 학년 각 열 반
		for(int idx=0;idx<highschool.length;idx++) {
			System.out.println(idx+1+"학년 반: ");
			// highschool[idx].length :학년 별 반의 수
			for(int jdx=0;jdx<highschool[idx].length;jdx++) {				
				highschool[idx][jdx]=30;// 할당
				System.out.println(jdx+1+"반-"+highschool[idx][jdx]+"명, ");
			}
			System.out.println();
		}
		
		
		/*
		3. 이차원 배열의 선언/할당
		   int[][] prices = { {1000,2000,3000}, {4000,5000,6000} } //밖에는 2개 안에는 3개
		*/
		// ex) 3개 부서별로 팀원3명씩 할당된 내용을 2차원배열(String)로 나타내세요  
		String[][] teams ={ 
				{"이지원", "이지수", "이지우"}, 
				{"이정단", "이종길", "이현국"}, 
				{"이길황", "이나경", "이주하"}
		}; 
		for(int idx=0;idx<teams.length;idx++) {
			System.out.println(idx+1+"번째 부서 명단: ");
			for(int jdx=0;jdx<teams[idx].length;jdx++) {
				System.out.println(teams[idx][jdx]+",");
			}
			System.out.println();
		}
		
		
		
	}
}
