package javaexp.a13_database;

import java.util.List;

import javaexp.a13_database.vo2.Emp01;

public class A00_MainCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Dao를 만들어 놓으면 어느 위치에서든지 해당 객체를 생성해서 사용할 수 있다
		// 로그인 처리 : 다른 프로그램 해당 항목에서 처리하고 데이터베이스 연동만 호출해서 처리한다  --Dao에서 로그인 처리 하는거 아니다
		
		A04_DaoExp dao = new A04_DaoExp();
		
		dao.getSch01(10); // 데이터건수만 출력
		// 전체 결과 출력
		List<Emp01> list = dao.getSch01(10);
		for(Emp01 e:list) {
			System.out.print(e.getDeptno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t\t");
			System.out.print(e.getSal()+"\n");
		}
		
	}

}
