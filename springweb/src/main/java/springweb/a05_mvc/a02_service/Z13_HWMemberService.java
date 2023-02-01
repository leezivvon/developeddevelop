package springweb.a05_mvc.a02_service;

// 230127과제

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvc.a03_dao.Z13_HWMemberDao;
import springweb.z01_vo.Member;

@Service
public class Z13_HWMemberService {
	@Autowired(required=false)
	private Z13_HWMemberDao dao;
	
	// 230127과제#2,3
	public List<Member> getHWMemList(Member sch){
		if(sch.getName()==null) sch.setName("");
		if(sch.getAuth()==null) sch.setAuth("");
		
		return dao.getHWMemList(sch);
	}
	
	// 230127과제#7
	public List<String> hwMemAuthComb(){
		return dao.hwMemAuthComb();
	}
	

	//
	public Member getMember(String id) {
		return dao.getMember(id);
	}
	
	
	
	// 230127과제 #4-수정
	public void hwUptMem(Member upt) {
		dao.hwUptMem(upt);
	}	
	// 230127과제 #5-삭제
	public void hwDelMem(String id) {
		dao.hwDelMem(id);
	}
	
	
	//230130과제#2
	public void insertMember(Member ins) {
		
	}


	
}
