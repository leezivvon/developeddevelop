package springweb.a05_mvc.a03_dao;
// 230127과제

import java.util.List;

import springweb.z01_vo.Member;


// springweb.a02_homwork
// public List<Member> getHWMemList(Member sch);
public interface Z13_HWMemberDao {
	
	// 230127과제 #2,3-조회 
	public List<Member> getHWMemList(Member sch);
	
	// 230127과제 #7
	public List<String> hwMemAuthComb();
	
	// 230127과제 #4-수정
	public void hwUptMem(Member upt);
	// 230127과제 #5-삭제
	public void hwDelMem(String id);

	
	
	// 230127과제-단일데이터
	public Member getMember(String id);
	
	
	// 230130과제#2
	public void insertMember(Member ins);
	
	
	
	
}
