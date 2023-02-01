package a01_diexp.backend;

import java.util.List;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Member;

public interface A03_Dao {
	
	public List<Dept> getDeptList(Dept sch);
	public List<Member> getMemberList(Member sch);
	public Member login(Member m);
}
