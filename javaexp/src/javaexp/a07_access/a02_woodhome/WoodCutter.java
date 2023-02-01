package javaexp.a07_access.a02_woodhome;

public class WoodCutter {
	
	private String privSec="개인비밀(선녀옷)";
	String payOurHome = "우리집산림경비"; // default
	protected String inheritMoney = "상속재산";
	public String announce="막내딸이 10월의 신부가 됩니다";
	
	public void callWoodCutter() {
		System.out.println("private: "+privSec);
		System.out.println("default: "+payOurHome);
		System.out.println("protected: "+inheritMoney);
		System.out.println("public: "+announce);
	}
// 같은 패키지의 클래스에서의 접근, 외부패키지의 클래스에서의 접근, 상속 클ㄹ스에서ㅡ이 접근
}
