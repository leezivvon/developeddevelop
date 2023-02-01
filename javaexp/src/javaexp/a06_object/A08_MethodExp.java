package javaexp.a06_object;

public class A08_MethodExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 기능 메서드의 혼합에제 처리
		1. 메서드의 리턴 처리, 매개변수 데이터, 프로세스처리, 실제 리턴값 처리를 기준으로
		   복합내용을 사용하는 기능이 많다 
		2. 매개변수로 시작번호, 끝번호를 입력하여 해당 데이터의 총합을 return처리
		   int totAll(int start, int end){
		       int tot=0;
		       for(int cnt=start;cnt<=end;cnt++){
		           system.out.print()
		       }
		   } 
				
		*/
		MethodCompo mc = new MethodCompo();
		int totAll = mc.totAll(1,10);
		System.out.println("총계: "+totAll);
	
		//ex1 ) 매개변수를 통해서 구구단의 단을 입력하여 해당 단의 내용을 처리하는 매서드 구현
		
		/*
		ggDan gg = new ggDan();
		int getGG = gg.getGG(5);
		System.out.println(getGG+"단");
		*/
		
		mc.gugu(5);
		
		
		/*
		ex2) 물건명, 단가(4000), 개수(4)를 입력하여
		     @@@ 1개   @@@원
		     
		  
		*/   
		int lastTot = mc.prodCalcu("복숭아", 17000, 7);
		System.out.println("마지막 계: "+lastTot);
	
		
		// ex3) 삼각형의 면적 리턴으로 면적 밑면*높이*1/2
		// 처리하는 방법1
		int triSz = mc.getriDem(8, 9);
		System.out.println(triSz);
		// 처리하는 방법2
		System.out.println("면적: "+mc.getriDem(8, 9));
				
		
	}
}
/*
class ggDan{
	int getGG (int wantNum) {
		for(int cnt=1;cnt<=9;cnt++) {
			System.out.println(wantNum+"X"+cnt+"="+wantNum*cnt);
		}
		return wantNum;
	}
}
*/
class MethodCompo{
	void gugu(int grade) {
		System.out.println("# "+grade+"단 #");
		for(int cnt=1;cnt<=9;cnt++) {
			System.out.println(grade+"X"+cnt+"="+grade*cnt);
		}
	}// ex1
	
	
	int prodCalcu(String name, int price, int end) {
		int tot = price*end;
		for(int cnt=1;cnt<=end;cnt++) {
			System.out.print(name+"\t");
			System.out.print(price+"\t");
			System.out.print(price*cnt+"\n");
		}
		return tot;
	}// ex2
	
	int getriDem(int under, int high) {
		System.out.println("# 삼각형의 면적 #");
		
		return  under * high / 2 ;
	}// ex3
	
	
	int totAll(int start, int end) {
		int tot = 0;
		for(int cnt=start;cnt<=end;cnt++) {
			System.out.print(cnt+(cnt!=end?"+":"\n"));
			tot +=cnt;
		}
		return tot;
	}
}
