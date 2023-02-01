package z01_util;

import com.google.gson.Gson;
//import = "com.google.gson.Gson  jspexp.vo.Dept"
import jspexp.vo.Person;

public class A01_Gson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//객체를 json데이터로 만드는거래 시발
		Person p = new Person("홍길동", 25 , "서울");
		Gson gson = new Gson();
		String json = gson.toJson(p);
		System.out.println(json);
	}

}
