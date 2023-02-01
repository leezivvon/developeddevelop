package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.z01_vo.Kimbab;

@Controller //이거 안했다...ㅋ시바아아알
public class Z02_HWController {

	// 3-1
	// http://localhost:7080/springweb/hwgrade.do
	@GetMapping("/hwgrade.do")
	public String hwgrade01() {
		return "WEB-INF\\views\\z01_homework\\a02_hw1grade.jsp";
	}
	@PostMapping("/hwgrade.do")
	public String hwgrade02( @RequestParam("score") int score, Model d) {
		
		d.addAttribute("grade",score>=90?"A":(score>=80?"B":(score>=70?"C":"F")) );
		return "WEB-INF\\views\\z01_homework\\a02_hw1grade.jsp";
	}
	
	//3-2
	// http://localhost:7080/springweb/hwlogin01.do
	/*
	@GetMapping("/hwlogin.do")
	public String hwlogin01() {
		return "WEB-INF\\views\\z01_homework\\a02_hw2login.jsp";
	}
	@PostMapping("/hwlogin.do")
	public String hwlogin02( @RequestParam("id") String id, 
							 @RequestParam("pass") String pass, 
							 Model d
							) {	
		d.addAttribute("correct", id=="helloworld"&&pass=="byeworld" );
		return "WEB-INF\\views\\z01_homework\\a02_hw2login.jsp";
	}
	*/
	//정답
	@GetMapping("/hwlogin01.do")
	public String hwlogin01() {
		return "WEB-INF\\views\\z01_homework\\a02_hw2login.jsp";
	}
	@PostMapping("/hwlogin02.do")
	public String hwlogin02( @RequestParam("id") String id, 
							 @RequestParam("pass") String pass, 
							 Model d
							) {	
		String msg = id.equals("helloworld")&&pass.equals("byeworld")?"로그인 성공":"로그인 실패";
		d.addAttribute("msg",  msg);
		return "WEB-INF\\views\\z01_homework\\a02_hw2login.jsp";
	}
	
	
	//3-3
	// http://localhost:7080/springweb/hwgugu.do
	/*
	@RequestMapping("/hwgugu.do")
	public String hwgugu( @RequestParam(value="answer", defaultValue="1" ) int answer,
						  Model d
						) {
		int num01=(int)(Math.random()*9+1);
		int num02=(int)(Math.random()*9+1);
		d.addAttribute("num01", num01);
		d.addAttribute("num02", num02);
		d.addAttribute("correct", num01*num02);
				
		return "WEB-INF\\views\\z01_homework\\a02_hw3gugu.jsp";
	}
	
	
	컨트롤단 : defaultValue를 통해 숫자값 처리
	모델데이터로 임의의 2~9, 1~9전달되게 처리한다
	화면 form안에 [ 3 ] X [ 4 ] ? [ @@@ ] [ 정답확인 ]
	형식으로 임의의 모델데이터를 input의 value값으로 전달하게
		모델데이터 rGrade, rCnt (문제제출), msg(정답처리)
	요청값: grade, cnt, inReply로 선언하여 전달한다
	다시 controller에 요청데이터를 전달하여 모델 데이터로 해당 값이 맞으면 정답 그렇지 않으면 오답이 되게 처리한다
	그 결과 내용을 alert으로 로딩이 되게 하고 다음 문제가 풀어지게 한다
	
	*/
	//정답
	@RequestMapping("/hwgugu.do")
	public String hwgugu( @RequestParam(value="grade", defaultValue="0" ) int grade,
						  @RequestParam(value="cnt", defaultValue="0" ) int cnt,
						  @RequestParam(value="inRply", defaultValue="0" ) int inRply,
						  Model d
						) {
		//rGrade, rCnt
		d.addAttribute("rGrade", (int)(Math.random()*8+2));
		d.addAttribute("rCnt", (int)(Math.random()*9+1));
		
		if(grade!=0) { //초기화면과 구분
			String msg = grade*cnt==inRply?"정답":"오답";
			d.addAttribute("msg", msg);
		}
	
		return "WEB-INF\\views\\z01_homework\\a02_hw3gugu.jsp";
	}
	
	
	//3-4  컴퓨터와 하는 가위바위보라는 타이틀로 해당 내용을 선택했을 때, 컴퓨터와 나의 결과에 따라 승/무/패가 처리되게 하세요.(get/post 통합)
	// http://localhost:7080/springweb/hwrsp.do
	/*
	@RequestMapping("/hwrsp.do")
	public String hwrsp( @RequestParam(value="pChoice", defaultValue="" ) String pChoice ,
						  Model d
						) {
		int cChoice=(int)(Math.random()*3+1);
		d.addAttribute("cChoice", cChoice==1?"가위":(cChoice==2?"바위":"보"));
		//d.addAttribute("correct", cChoice==1&&pChoice=="바위"?"당신의 승":"");
				
		return "WEB-INF\\views\\z01_homework\\a02_hw4gugu.jsp";
	}
	
	mySel
		<select name="mySelect">
			<option value="0">가위</option>
			<option value="1">바위</option>
			<option value="2">보</option>
		</select>
			
	comSel 모델데이터
		String []games = ["가위", "바위"]
		int comIdx = (int)(Math.random()*3)
		
		com(가위, 바위, 보), my(가위, 바위, 보)
		if(comIdx==mySel){
			result= "무승부"
		}else( (comIdx+1)%3==mySel ) {
			result="컴퓨터 승"
		else{
			result="나의 승"
		}
		
		String com=games[comIdx]
		String my=games[mySel]
		d.addAttribute("com", com);
		d.addAttribute("my", my);
		d.addAttribute("result", result);
	 
		String msg = "컴퓨터:"+com+", 나:"+my+"\n"+result
		d.addAttribute("msg", msg);
	*/
	// http://localhost:7080/springweb/hwrsp.do
	@RequestMapping("/hwrsp.do")
	public String hwrsp( @RequestParam(value="mySel", defaultValue="-1" ) int myIdx ,
						  Model d
						) { 
		//초기화면구분
		if(myIdx != -1) {
			String []games = {"가위", "바위", "보"};
			int comIdx = (int)(Math.random()*3);
			
			//com(가위, 바위, 보), my(가위, 바위, 보)
			String result="";
			if(comIdx==myIdx){
				result= "무승부";
			}else if( (comIdx+1)%3==myIdx ) {
				result="나의 승";
			}else{
				result="컴퓨터 승";
			}
			
			String com=games[comIdx];
			String my=games[myIdx];
		 
			String msg = "컴퓨터:"+com+", 나:"+my+"\\n"+result;
			d.addAttribute("msg", msg);
		}
				
		return "WEB-INF\\views\\z01_homework\\a02_hw4rsp.jsp";
	}
	
	
	
	//4-3
	/*
	요청값 : price, cnt
	모델값 : tot
		Kimbab Vo price, cnt, tot
	매개변수 VO 생성
		Kimbab kb
	kb.getPrice()>0
		kb.setCnt(kb.getCnt()+1);
		kb.setTot(kb.getPrice()*bk.getCnt());
		
	name="price" value=${kimbab.price}	
	name="cnt" value=${kimbab.cnt}	
	
	${kimbab.tot}
	다음 ${kimbab.cnt+1}개 확인-버튼
	 */
	
	// http://localhost:7080/springweb/kimbab.do
		@RequestMapping("/kimbab.do")
		public String kimbab(Kimbab kb) { 
			if(kb.getPrice()>0) {
				kb.setCnt(kb.getCnt()+1);
				kb.setTot(kb.getPrice()*kb.getCnt());
			}
				
			return "WEB-INF\\views\\z01_homework\\a02_hw5kimbab.jsp";
		}
		

		
	
}






