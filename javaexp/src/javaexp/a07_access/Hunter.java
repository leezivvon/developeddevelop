package javaexp.a07_access;

import javaexp.a07_access.a01_friendship.WoodCutter; // 다른 클래스라서 import문 필요

public class Hunter {
	public void callWoodCutter() {
		// public으로 크래스 선언과 생성자 선언은 가능하지만 
		WoodCutter w1 = new WoodCutter();
		// 접근제어자가 default(X)이기 때문에 외부 패키지에 있는 Hunter클래스는 접근할 수 없다
//		System.out.println(w1.hiddenDeer);
//		System.out.println(w1.hiddenCloth);
		System.out.println(w1.introMyself); // public이라서 접근 가ㄴㅇ
	
	}

}
