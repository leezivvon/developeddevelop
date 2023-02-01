package javaexp.z01_homework;

import java.util.ArrayList;

public class A11_0914 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		2022-09-14
[1단계:개념] 1. (연습이 필요한 분)1:1관계 설정 연습 - 연필/종이, TV/리모콘, 어머니/자식, 스포츠팀/감독
[1단계:개념] 2. 데이터의 처리 단계별 내용을 예제와 함께 기술하세요. 기본유형 ~~~  1:다 객체형까지.. 
[1단계:개념] 3. 정적배열과 동적배열의 차이점을 예제를 통해서 설명하세요.
[1단계:코드] 4. 구매한 물건(물건명,가격,갯수) 3개를 클래스를 선언하고 정적배열로 선언 할당 후, 배열을 통해서 출력하세요.
[1단계:코드] 5. 팀(팀명,승,무,패) 3개의 클래스를 정적배열객체로 선언 for문을 통해 getXXX메서드로 출력하세요.
[1단계:개념] 6. 동적배열처리하는 객체 ArrayList에서 사용하는 메서드의 기능을 기본예제를 통하여 설명하세요.
[1단계:코드] 7. 읽어야할 도서명 5권을 ArrayList로 선언/추가하고 출력하세요.
[1단계:개념] 8. 1:다관계와 1:1관계 처리 구조의 차이점을 기술하세요.
[1단계:코드] 9. 아래의 1:다관계 동적처리 구조의 데이터를 처리하세요.
      1) 마트/구매물건 2) 도서관/빌린도서  3) 컴퓨터/구성하는부품
		*/
		
		
		//2 
		
		/*
		자바의 데이터 처리 단위
		1. bit  0/1
		2. byte  bite가 8개 모여 데이터의 기본유형 시작
		3. char  문자단위
		4. 정수형, 실수형, boolean(논리)형자바의 데이터 처리 단위
	       ..... 기본데이터유형.....
	    5. 배열형 데이터 
	        _같은 유형의 기본데이터가 모여서 데이터 처리
	          int[] array ={1,2,3};
	          char[] carray = {"공", "명"};  = String name = "공명";
	    6. 객체형 데이터    
	        _다른 유형의 데이터를 모아서 처리
	        class Person{
	        String name;
	        int age;
	        boolean isAdult;
	        }
	        Person p = new Person(); // 객체 생성
	    7. 배열 + 객체    
            Person[] p = {new Person(), new Person()...}
            List<Person> plist = new ArrayList<Person>();
        8. 객체 안에 배열과 객체 포함
            class Person{
                Woman wonman; // 객체
                Stirng[] favfoods; // 배열
            }
        9. 여러객체를 동적 처리( 1: 다 관계)    
            class Person{
                Food[] food;
                List<Friend> flist;
            }
		*/		
		//3  정적배열과 동적배열의 차이점
		/*
		정적 배열은 고정된 배열안에 객체를 담는 처리로 크기가 고정되어서 추가나 삭제가 불가능
		동적 배열은 크기가 동적으로 변경이 가능하여 추가나 삭제가 가능하다
		*/
		//4 	
		BuyPro[] bparray = {new BuyPro("호떡",1000,5),
				            new BuyPro("붕어빵",500,10),
				            new BuyPro("어묵",300,20)
		                    };
		int tot = 0;
		System.out.println("< 포장마차 심부름 목록 >");
		for(int idx=0;idx<bparray.length;idx++) {
			BuyPro bp = bparray[idx];
			System.out.println(bp.getName()+"\t"+bp.getCnt()+"개,\t하나당 "+bp.getPay()+"원");
			tot +=bp.getCnt()*bp.getPay();
		}
		System.out.println("총 "+tot+"원.\n"+tot+"원 꼭 챙겨가기" );
		System.out.println();
		
		
		//5 팀(팀명,승,무,패) 3개의 클래스를 정적배열객체로 선언 for문을 통해 
//		getXXX메서드로 출력하세요.
		SoccerTeam[] soct= {new SoccerTeam("수원FC",2,5,8),
				            new SoccerTeam("서울FC",3,3,4),
				            new SoccerTeam("전북 현대",8,2,3)
		};
		System.out.println("< 2099 K-리그 결과 >");
		for(int idx=0;idx<soct.length;idx++) {
			SoccerTeam st = soct[idx];
			System.out.println(st.getTname()+": "+st.getWin()+"승 "+st.getTie()+"무 "+st.getLoose()+"패");
		}
		System.out.println();
		
		//6
		/*
		 객체 ArrayList에서 사용하는 메서드의 기능에는 추가등록 메서드와 정보 출력 메서드가 있다
		 <추가등록 메서드>
		  **class Book{}
           - 하나씩 추가
               public void addBook(Book b) {
		       this.blist.add(b);     
           - 다중으로 추가
               public void addBookAll(ArrayList<Book> blist) {
		       this.blist.addAll(blist);
         <정보 출력 메서드>
            - 기본 정보 출력 : 책 이름 @@@
            - ArrayList 출력
                 if(this.blist.size()>0) {
			        for(Book b:this.blist) {
				        System.out.println(b.getBname()+"\t"+b.getBkind()+"\t"+b.getDate());
			        }	
		         }else {
		            	System.out.println("**대출할 도서들을 등록해주세요**");
		         }
          <삭제> // 메서드는 아니지만..
          cart.remove(4);     
			*/
		
		//7 
		ArrayList blist = new ArrayList();
		blist.add("창백한 푸른 점");
		blist.add("코스모스");
		blist.add("공정하다는 착각");
		blist.add("침묵의 봄");
		blist.add("진보와 빈곤");
		for(int idx=0;idx<blist.size();idx++) {
			System.out.println(idx+1+") "+blist.get(idx));
		}
		System.out.println();
		//8 
		/*
		1:1 관계는  데이터 값이 변수에 바로 저장되는 반면 
		1:다 관계에서는 객체(객체의 주소)가 출력되고 그 객체에 데이터 값이 저장되어 있다.  
		*/
		
		//9 
		//9-1
		ArrayList<Mart> cart = new ArrayList<Mart>();
		int tot0 =0;
		cart.add(new Mart("요거트",20000,3));
		cart.add(new Mart("냉동새우",18000,2));
		cart.add(new Mart("샤인머스켓",20000,5));
		cart.add(new Mart("포카칩",2000,2));
		cart.add(new Mart("해창 막걸리",9000,3));
		System.out.println("\t- 계산대 화면 -");
		for(Mart counter : cart) {
			System.out.println("삑! "+counter.getProd()+"\t"+counter.getPrice()+"원\t"+counter.getCnt()+"개\t합계: "+counter.getPrice()*counter.getCnt());
			tot0+=counter.getPrice()*counter.getCnt();
		}
		cart.remove(3);
		cart.remove(4);
		System.out.println("상품을 제외합니다");
		for(Mart counter : cart) {
			System.out.println("삑! "+counter.getProd()+"\t"+counter.getPrice()+"원\t"+counter.getCnt()+"개\t합계: "+counter.getPrice()*counter.getCnt());
			tot0+=counter.getPrice()*counter.getCnt();
		}
		System.out.println("\t\t\t\t총액: "+tot0);
		System.out.println();
		//9-2
		Library l = new Library("마포구립");
		l.showAllList();
		System.out.println();
		
		l.addBook(new Book("과식의 종말", "인문학",8.29));
		l.addBook(new Book("천개의 찬란한 태양","소설",9.01));
		l.addBook(new Book("죽음의 자서전","시",9.01));
		
		ArrayList<Book> bblist = new ArrayList<Book>();

		bblist.add(new Book ("총 균 쇠","인문학",9.14));
		bblist.add(new Book ("나는 소망한다","소설",9.14));
		l.addBookAll(bblist);
		l.showAllList();
		System.out.println();
		
		//9-3
		ArrayList<Compu> com = new ArrayList<Compu>();
		com.add(new Compu("하양",8,"i-3"));
		com.add(new Compu("검정",20,"i-5"));
		for(Compu co : com) {
			System.out.println("제품 색상: "+co.getCcolor()+"\t"+"RAM사양: "+co.getRam()+"gb\t"+"CPU: "+co.getCpu());
		}	
	    // 정답
	    //9-1
	    Martt mt = new Martt("행복");
	    mt.calcu(); // 아무것도 안샀을 때
	    mt.addBuyList(new Product("사과", 2000, 2));
	    mt.addBuyList(new Product("사과", 2000, 2));
	    
	    
	    
	    //9-2
//	    Libraryy lb = new Libraryy("서울 시립도서관");
//	    lb.showLentList();
//	    lb.addLensList(new LBook("himan","기초자바","2022-10-10"));
//	    
//	    //9-3
//	    Computer01 com = new Computer01("데스크탑", "조립품");
//	    com.setPlist(new Part("CPU", "인텔", "i7 3.5GHz"));

	    
		//1-1
		Pencil p = new Pencil("스테들러");
		p.writing();
		
		p.readyWrite(new Paper(5,"흰색"));
		p.writing();		
		
		//1-2
		Tv tv = new Tv("LG");
		tv.turnOn();
		
		tv.explainRemote(new RemoteContrl("검정색","셋톱전원"));
		tv.turnOn();
		
		//1-3
		Motherr mom = new Motherr("헬레나");
		mom.introdc();
		
		mom.myChild(new Child("소피오", 27, "아들"));
		mom.introdc();
		
		//1-4
		SportsTeam st = new SportsTeam("두산", "야구");
		st.releaseDirc();
		
		st.sportsDirect(new Director("홍성흔", 0));
		st.releaseDirc();		
 }
}	
//1. 
//1-4
class Director{
	private String name;
	private int career;
	public Director(String name, int career) {
		this.name = name;
		this.career = career;
	}
	public void dirInfo() {
		System.out.print(this.career+"년 경력의 "+this.name+" 감독");
	}
}
class SportsTeam{
	private String tname;
	private String event;
	private Director dirc;
	public SportsTeam(String tname, String event) {
		this.tname = tname;
		this.event = event;
	}
	public void sportsDirect(Director dirc) {
		this.dirc=dirc;
	}
	public void releaseDirc() {
		System.out.println("깜짝 발표!! "+ tname+" "+event+"팀 감독 전격 교체!!");
		if(this.dirc==null) {
			System.out.println("/t속보라 내용 없음.");
		}else {
			System.out.println("이 "+tname+" "+event+"팀으로 선임되었다.");
		}
	}
}
//1-3
class Child{
	private String name;
	private int age;
	private String gender;
	public Child(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void info() {
		System.out.println("우리 "+this.gender+"의 이름은 "+this.name+"이고 나이는"+this.age+"살 입니다." );
	}
}
class Motherr{
	private String name;
	private Child child;
	public Motherr(String name) {
		this.name = name;
	}
	public void myChild(Child child) {
		this.child=child;
	}
	public void introdc() {
		if(this.child!=null) {
			System.out.println(this.name+"의 자식 소개가 있겠습니다!");
			System.out.println();
			child.info();
		}else {
			System.out.println("아직 준비가 되지 않았습니다. 모두 기다려주세요.");
		}
	}
}
//1-2
class RemoteContrl{
	private String color;
	private String kind;
	public RemoteContrl(String color, String kind) {
		this.color = color;
		this.kind = kind;
	}
	public void info() {
		System.out.println(this.color+" 리모컨은 "+this.kind+" 리모컨 입니다.");
	}
}
class Tv{
	private String cmp;
	private RemoteContrl remote;
	public Tv(String cmp) {
		this.cmp = cmp;
	} 
	public void explainRemote(RemoteContrl remote) {
		this.remote=remote;
	}
	public void turnOn() {
		System.out.println("_____"+this.cmp+"사 TV 리모컨 사용설명"+"_____");
		if(this.remote != null) {
			this.remote.info();
		}else {
			System.out.println("주변에 리모컨이 없습니다. 리모컨을 준비해주세요");
		}
	}
}

//1-1
class Paper{
	private int num;
	private String color;
	public Paper(int num, String color) {
		this.num = num;
		this.color = color;
	}
	public void info() {
		System.out.println(this.color+" 종이\t"+this.num+" 장을 구비했습니다");
	}
}
class Pencil{
	private String cmp;
	private Paper paper;
	public Pencil(String cmp) {
		this.cmp = cmp;
	}
	public void readyWrite(Paper paper) {
		this.paper=paper;
	}
	public void writing() {
		System.out.println(cmp+"사 연필을 구비했습니다.");
		if(this.paper==null) {
			System.out.println("\"        \"");
		}else {
		    this.paper.info();
			System.out.println("-쓱싹쓱싹");
		}
	}
}
//9-3
class Compu{
	private String ccolor;
	private int ram;
	private String cpu;
	public Compu(String ccolor, int ram, String cpu) {
		this.ccolor = ccolor;
		this.ram = ram;
		this.cpu = cpu;
	}
	public String getCcolor() {
		return ccolor;
	}
	public void setCcolor(String ccolor) {
		this.ccolor = ccolor;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
}
//9-2
class Library{
	private String lname;
	private ArrayList<Book> blist;
	public Library(String lname) {
		this.lname = lname;
		this.blist=new ArrayList<Book>();
	}
	public void addBook(Book b) {
		this.blist.add(b);
		System.out.println("["+b.getBname()+"] 이 등록되었습니다");
	}
	public void addBookAll(ArrayList<Book> blist) {
		this.blist.addAll(blist);
		System.out.println("\t"+blist.size()+"권 추가 등록");
	}
	public void showAllList() {
		System.out.println("- "+this.lname+"도서관 도서대출 목록 -");
		System.out.println("도서명\t\t도서종류\t대출일");
		if(this.blist.size()>0) {
			for(Book b:this.blist) {
				System.out.println(b.getBname()+"\t"+b.getBkind()+"\t"+b.getDate());
			}	
		}else {
			System.out.println("**대출할 도서들을 등록해주세요**");
		}
	}

}
class Book{
	private String bname;
	private String bkind;
	private double date;
	public Book(String bname, String bkind, double date) {
		this.bname = bname;
		this.bkind = bkind;
		this.date = date;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBkind() {
		return bkind;
	}
	public void setBkind(String bkind) {
		this.bkind = bkind;
	}
	public double getDate() {
		return date;
	}
	public void setDate(double date) {
		this.date = date;
	}
	
	
	
}

//9-1
class Mart{
	private String prod;
	private int price;
	private int cnt;
	public Mart(String prod, int price, int cnt) {
		this.prod = prod;
		this.price = price;
		this.cnt = cnt;
	}
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}

//5
class SoccerTeam{
	private String tname;
	private int win;
	private int tie;
	private int loose;
	public SoccerTeam(String tname, int win, int tie, int loose) {
		this.tname = tname;
		this.win = win;
		this.tie = tie;
		this.loose = loose;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getTie() {
		return tie;
	}
	public void setTie(int tie) {
		this.tie = tie;
	}
	public int getLoose() {
		return loose;
	}
	public void setLoose(int loose) {
		this.loose = loose;
	}
}

//4
class BuyPro{
	private String name;
	private int pay;
	private int cnt;
	public BuyPro(String name, int pay, int cnt) {
		this.name = name;
		this.pay = pay;
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
// 정답
/*
# 처리 순서
1. 포함될 클래스
    필드, getset메서드, 출력메서드
2. 포함할 클래스
    필드(고유속성, 포함될 클래스ArrayList)
    생성자(고유속성 초기화, ArrayList객체 생성)
    메서드(단일 추가 메서드, 다중추가 메서드, 전체 내용 출력내용처릭)// 다중추가 메서드는 안해도 됨
*/
//9-1
class Martt{
	private String mname;
	private ArrayList<Product> blist;
	public Martt(String mname) {
		this.mname = mname;
		this.blist = new ArrayList<Product>();
	}
	public void addBuyList(Product product) {
		this.blist.add(product);
		System.out.println(product.getName()+" "+product.getCnt()+"개를 구매목록에 담았습니다");
	}
	public void calcu() {
		System.out.println(mname+"마트에서 구매 및 계산서");
		if(blist.size()>0) {
			int cnt = 0;
			int tot = 0;
			System.out.println("no\t물건명\t가격\t개수\t계");
			for(Product prod:blist) {
				System.out.print(++cnt+"\t");
				tot+=prod.buyInfo(); // buyInfo에서 리턴해서 가능한거,,,
			}
			System.out.println("총계"+tot);
		}else {
			System.out.println("아직 구매한 물품이 없습니다");
		}
	}
	
}
class Product { // 포함될 클래스
	private String name;
	private int price;
	private int cnt;
	public Product(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public int buyInfo() {
		System.out.print(this.name+"\t");
		System.out.print(this.price+"\t");
		System.out.print(this.cnt+"\n");
		return this.price*this.cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

//9-2
class Libraryy{
	private String name;
	private ArrayList<LBook> lblist;
	public Libraryy(String name) {
		this.name = name;
		this.lblist = new ArrayList<LBook>();
	}
	public void addLendList(LBook book) {
		this.lblist.add(book);
		System.out.println(book.getLendId()+"님이 "+book.getTitle()+" 대출하였습니다");
	}
	public void showLentList() {
		System.out.println(name+"에서 대출된 대출 내역");
		if(lblist.size()>0) {
			System.out.println("번호\t대출자\t도서명\t반납일");
			for(int idx=0;idx<lblist.size();idx++) {
				LBook bk = lblist.get(idx);
				bk.lendIfo(idx+1); //번호 리스트	
		     }
			System.out.println("총 "+lblist.size()+"권 대출되었습니다!");
		}else{
			System.out.println("대출된 내역이 없습니다");
		}
	}
	
}
class LBook{
	// 빌린사람 도서명 반납일
	private String lendId;
	private String title;
	private String endDate;
	public LBook(String lendId, String title, String endDate) {
		this.lendId = lendId;
		this.title = title;
		this.endDate = endDate;
	}
	public void lendIfo(int no) {
		System.out.print(no+"\t");
		System.out.print(this.lendId+"\t");
		System.out.print(this.title+"\t");
		System.out.print(this.endDate+"\t");
	}
	public String getLendId() {
		return lendId;
	}
	public void setLendId(String lendId) {
		this.lendId = lendId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
}
// 9-3
class Computer01{
	private String kind;
	private String comp; //제조사
	private ArrayList<Part> plist;
	public Computer01(String kind, String comp) {
		this.kind = kind;
		this.comp = comp;
		this.plist= new ArrayList<Part>();
	}
	public void showPartList() {
		System.out.println("# 컴퓨터 사양 #");
		System.out.println("종류: "+kind);
		System.out.println("제조사: "+comp);
		if(plist.size()==0) {
			System.out.println("부품이 아직 없네요");
		}else {
			System.out.println("포함된 부품 리스트");
			for(Part p:plist) {
				System.out.println(p);
			}
		}
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public ArrayList<Part> getPlist() {
		return plist;
	}
	public void setPlist(Part p) {
		this.plist.add(p);
		System.out.println(p.getPname()+"부품 추가");
	}
	
	
}
class Part{
	// 부품종류, 제조사 사양
	private String pname;
	private String comp;
	private String perform;
	public Part(String pname, String comp, String perform) {
		this.pname = pname;
		this.comp = comp;
		this.perform = perform;
	}
	@Override
	public String toString() {
		return "Part [pname=" + pname + ", comp=" + comp + ", perform=" + perform + "]";
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getPerform() {
		return perform;
	}
	public void setPerform(String perform) {
		this.perform = perform;
	}
	
}


