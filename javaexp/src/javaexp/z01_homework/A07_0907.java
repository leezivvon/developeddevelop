package javaexp.z01_homework;

public class A07_0907 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 2022-09-07
[1단계:개념] 1. 생성자의 this()를 사용하는 경우와 규칙을 예제를 통하여 기술하세요.
[1단계:코드] 2. 자바의 기본데이터 유형으로 class ExpConst에 데이터를 할당하고, 생성자에 할당된 데이터를 출력하세요.
[1단계:개념] 3. 메서드의 기능적 구성요소를 기술하고 예제를 통해서 설명하세요.
[1단계:코드] 4. AutoSeller 클래스 선언 메서드 insertCoin()를 통해서 입력된 동전을 필드 
      curMoney에 누적 저장하고, getCurMoney()를 통해
      현재 저장된 돈을 리턴 처리하는 기능을 처리하세요.
[1단계:코드] 5. GoTravel 클래스를 선언하고  오버로딩의 원칙에 따라 메서드를 선언하되 
      - 리턴유형을 void
      1) setTarget : 목적지를 1, 2, 3개로 선언하여 출력
      2) setTarget : 비용을 선언하는 내용 처리 
      3) setTarget : 목적지와 비용을 순서를 다르게 선언 출력..
[2단계:코드] 6. BuyProduct 클래스를 선언하고, 생성자를 통해서 물건명과 가격을 초기화하고
      getProdName(), getProdPrice(),  물건명, 가격(정수) 리턴
      buyProd() 매개변수로 갯수를 할당, 가격과 연산하여 계를 리턴하게 처리하게 하세요.
[1단계:코드] 7. Member클래스로 선언하여 login()에 매개변수로 id, pass를 입력하여 himan/7777일 때, 로그인
      성공문자리턴, 그외는 로그인실패문자리턴처리.
		
		*/
		/*
		1.
		 생성자 오버로딩되면 생성자간의 중복된 코드가 발생할 수 있다. 이러한 경우에 생성자에 this()를 사용한다
		 규칙: 초기화 내용을 한 생성자에 몰아 작성하고 다른 생성자는 초기화 내용을 작성한 생성자를 this(..)로 호출한다.
		
		class Music{
			String nameM;
			String nameS;
			Music(){ //초기화 한 내용을 한 생성자에 몰아 작성
				this.nameM = "비밀의 화원";
				this.nameS = "아이유";
			}
			Music(String nameM){ //오버로딩
				this();
				this.nameM = nameM;
			}
			Music(String nameM, String nameS){  //오버로딩
				this(nameM);
				this.nameS = nameS;
		*/
		//2. 
		ExpConst ex = new ExpConst("법학", 16); 
		
		/*
		3.메서드의 기능적 구성요소는 리턴타입과 메소드명, 매개변수와 프로세스처리가 있는 return문이 있다
		
		class Method{ 
			String name; // 선언
			String callName(String name) { 
			// 리턴타입:String, 메소드명:callName, 매개변수:String name
				return name; // return문
			}
		} 	
		 */
		//4. 
		 AutoSeller as = new AutoSeller();
	     as.insertCoin(500);
	     System.out.println(as.getCurMoney());
	     
	     //5
	     
	     //6
	     
	     // 7.
	     Member mb = new Member();
	     mb.login("himan", 7777);
	     System.out.println(as.login());
	     
	     
//	     <정답>
	     // 4
			/*
			class AutoSeller{
			  int curMoney; // 매개변수
			  void insertCoin(int money){
			      this.curMoney+=money; // 누적저장
		    	}
			  int getCurMoney(){
			       return curMoney;
			    }
			}
			
			AutoSeller as = new AutoSeller();
			System.out.println("초기 현재 저장된 금액: "+as.getCurMoney)
			as.insertCoin(500);
			as.insertCoin(1000);
			as.insertCoin(1500);
			as.insertCoin(2000);
			System.out.println("현재 저장된 금액: "+as.getCurMoney)
			*/
	     
	     
	     // 5
			/*
			class GoTravel{
			    void setTarget(String loc1, String loc2, String loc3){
			       System.out.println("# 목적지 3개 메서드 #");
			       System.out.println("목적지1: "+loc1);
			       System.out.println("목적지2: "+loc2);
			       System.out.println("목적지3: "+loc3);
			    }   
			    void steTarget(int loc1){
			       System.out.println("# 목적지 메서드 #");
			       System.out.println("목적지: "+loc1);
			    }
			    void steTarget(int pay){
			       System.out.println("# 비용 메서드 #");
			       System.out.println("비용: "+pay);
			    }   
			    void setTarget(String loc1, int pay){
			       System.out.println("# 매개순서(목적지, 비용) #");
			       System.out.println("목적지: "+loc1);
			       System.out.println("비용: "+pay);
			    }
			    void setTarget(int pay, String loc1){
			       System.out.println("# 매개순서(목적지, 비용) #");
			       System.out.println("목적지: "+loc1);
			       System.out.println("비용: "+pay);
			    }
			}
			
			GoTravel gt = new GoTravel();
			gt.setTarget("부산","제주도","런던");
			gt.setTarget("하와이");
			gt.setTarget(20000000);
			gt.setTarget("괌", 3000000);
			gt.setTarget(200000,"사이판");  // 왜 바로 출력이 돼?
			
			*/
	     
	     //6
	     
			/*
			class BuyProduct{
			   String name; //속성갑
			   int price;
			   BuyProduct(String name, int pice){// 초기화
			       this.name = name;
			       this.price = price;
			   }
			   String getProdName(){
			       return this.name;
			   }
			   int getProdPrice(){
			       return this.price;
			   }
			   
			   int buyProd(int cnt){ //cnt 입력은 어떻게...?
			       System.out.println("# 물건 구매 #");
			       System.out.println("물건명: "+this.name);
			       System.out.println("가격: "+this.price);
			       System.out.println("개수: "+this.cnt);
			       return this.price*cnt
			   }
			}
			
			BuyProduct bp = new BuyProduct("사과", 1200);
			System.out.println("구매 계: "+bp.buyprod(2));
			System.out.println("구매 계: "+bp.buyprod(3));
			*/
	     
	     //7
			/*
			class Member{ // 왜 필드에 선언안하냐 시바..
			    String login(String id, String pass){
			        String result = "로그인 실패" // 초기값을 로그인 실패로 설정
			        if(id.quals("himan")&&pass.equals("7777")) {
			            result = "로그인 성공";
			        }
			        return result;
			    }
			}
			
			Member m1 = new Member();
			System.out.println("login 결과: "+m1.login("himan", "7777"));
			System.out.println("login 결과: "+m1.login("himan2", "7777"));
			*/
	}
}



//7 
class Member{
	String id;
	int pass;
	String login(String id, int pass) {
		if (id=="himan"&&pass==7777) {
			return "성공";
		}else {
			return "실패";
		}
}


//4
class AutoSeller {
	int coin;
	int curMoney; 
	
	void insertCoin(int coin) {
		this.coin=coin;
	}
	int getCurMoney() {
		return this.curMoney+=this.coin;
	}
}
// 계속 누적을 시키기 위해서는 for문을 사용해야 될 것 같긴 한데 어떻게 해야 할지 모르겟다..


//2
class ExpConst {
	String major;
	int collNum;
	ExpConst(String major, int collNum){
		this.major = major;
		this.collNum = collNum;
		System.out.println("전공: "+major);
		System.out.println("학번: "+collNum+"학번");
	}
}
