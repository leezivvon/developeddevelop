package springweb.a02_dao1;

import org.springframework.stereotype.Service;

import springweb.z01_vo.Dept;



@Service
public class Z03_HWService {

	// 230118-6
	public Dept getDeptInfo() {
		return new Dept(70, "회계", "서울");
	}
	
}
