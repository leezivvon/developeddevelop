<%-- 
2022-11-21
[1단계:확인] 1. [js] 가변매개변수 arguments를 활용하여 가변적으로 구매 정보를 매개변수로 처리하여 출력하게 하세요.
[1단계:확인] 2. [js] ... 가변매개변수에 따라 등록할 물건의 이름 1/2/3개 다른 매개변수로 설정하여 하단에 p태그로 클릭시 마다 처리되게 하세요
[1단계:확인] 3. [js] default 가변매개변수를 활용하여 사원번호, 사원명, 부서번호를 클릭시 마다, 처리하는 내용을 하단에 테이블로 추가 하여 출력하세요
               login(), login(7780) login(7880,'오길동') login(8000,'이영자','인사')
[1단계:확인] 4. [js] 화살표 함수를 활용하여 사칙연산을 처리 및 출력하세요.
[1단계:확인] 5. [js] 키오스크 메뉴판(3가지)과 동일하게 메뉴가 나오고 +/-에 따라서 개수가 선택되게 하여
               아래에 메뉴내용과 총금액이 나오게 처리하세요.
[1단계:확인] 6. [jsp] jsp에서 숫자형 데이터가 요청값이 없더라도 숫자형 데이터가 에러 나지 않게 할려고 한다.
                 아래 화면을 입력값이 없더라도 전송시 에러 발생하지 않게
                첫번째 숫자 : [   ]
                두번째 숫자 : [   ]  [합산]
               1) javascript 단 처리 부분
               2) jsp 처리 부분을 나누어서 처리하세요
[1단계:확인] 7. [jsp] script의 declare를 활용하여, 입력값이 70이상 일때, 합격 그외 불합격 처리하는 기는
            메서드를 선언하고, expression으로 호출하여 처리하세요.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">

</head>
<body>
	<%-- 
	5 정답
	
	1) 화면구성
	2) +/-에 대한 이벤트 핸들러 함수 선언과 이벤트 처리
	3) 메뉴내용과 총금액 처리
	--%>
	<script type="text/javascript">
		
		var orcnts = [0,0,0,0]	// 클릭 시 마다 함수 전역적으로 주문개수를 증가

		function cal( cIdx, ch ){
			var menus = ["짜장면", "짬뽕", "탕수육", "깐쇼새우"]
			var prices = [6000, 7000, 18000, 23000]
			if(ch=="+"){
				orcnts[cIdx]++;
			}else{
				if(orcnts[cIdx]<=0){
					alert("0이하는 감소되지 않습니다");
				}else{
					orcnts[cIdx]--;
				}
			}
			var showList =""; // 하단에 메뉴 내용 출력
			var tot = 0; // 총 비용 출력
			// orcnts = [0,0,0,0] 주문량이 있을 때
			for(var idx=0; idx<orcnts.length;idx++){
				if( orcnts[idx]>0 ){
					showList+=menus[idx]+"("+prices[idx]+"원)  "+orcnts[idx]+"<br>"// 누적해서 처리
					tot += prices[idx]*orcnts[idx]
				}
			}
			showList+="총비용: "+tot+"원 "
			document.querySelector("#show").innerHTML = showList
		}
	</script>
	<h2>주문하세요</h2>
	<style>
		span{border:1px solid blue; border-radius:5px;display:inline-block;width:20px}
	</style>
	<table>	
		<tr><td>짜장면(6000원) <span onclick="cal(0, '+')">+</span><span onclick="cal(0, '-')">-</span></td></tr>
		<tr><td>짬뽕(7000원)	 <span onclick="cal(1, '+')">+</span><span onclick="cal(1, '-')">-</span></td></tr>
		<tr><td>탕수육(18000원)<span onclick="cal(2, '+')">+</span><span onclick="cal(2, '-')">-</span></td></tr>
		<tr><td>깐쇼새우(23000원)<span onclick="cal(3, '+')">+</span><span onclick="cal(3, '-')">-</span></td></tr>
	</table>
	<p id="show" align="center"></p>


<%-- 6 --%>
<%--
int pro06(String req){
	int ret = 0;
	if(req!=null){
		try{
			ret=Integer.parseInt(req);
		}catch(Exception e){
			log("에러발생:"+e.getMessage());
			ret = 0;
		}
	}
	return ret;
}
--%>
<%--
	int num01 = pro06(request.getParameter("num01"));
	int num02 = pro06(request.getParameter("num02"));
	int plusTot = num01+num02;
--%>
<%-- 
<form>
<input type="text" name="num01" value="<%=call(num01)%>"><br>
<input type="text" name="num02" value="<%=pro06(num02)%>">
<input type="submit" value="합산"> 
</form>
--%>
<%-- 6 정답 --%>
<script type="text/javascript">
	//js유효성check = 오류를 안보내려고
	function calPlus(){
		var num01Ob = document.querySelector("[name=num01]")
		var num01 = num01Ob.value
		var num02Ob = document.querySelector("[name=num02]")
		var num02 = num02Ob.value
	
		if(num01=="" || isNaN(num01)){
			alert("공백이거나 숫자가 아닙니다")
			num01Ob.value=""; // 내용지워주는거
			num01Ob.focus()
			return;	// 특정 조건에 따라 프로세스를 중단 처리
		}
		if(num02=="" || isNaN(num02)){
			alert("공백이거나 숫자가 아닙니다")
			num02Ob.value="";num02Ob.focus()
			return;
		}
		document.querySelector("form").submit();	// submit버튼을 클릭한 것과 동일한 효과
	}
</script>

<%
	String num01S = request.getParameter("num01");
	String num02S = request.getParameter("num02");
	int num01=0; int num02=0; int sum=0;
	boolean isValid1 = false;
	boolean isValid2 = false;
	if( num01S!=null && !num01S.equals("") ){ // 초기화면이 아니고 요청값을 입력했을 때
		try{
			num01 = Integer.parseInt(num01S);//형변환처리
		}catch(Exception e){ // 수사형태 데이터가 아닐 때 0으로 처리
			isValid1=true;
		}
	}
	if( num02S!=null && !num02S.equals("") ){ // 초기화면이 아니고 요청값을 입력했을 때
		try{
			num02 = Integer.parseInt(num02S);//형변환처리
		}catch(Exception e){ // 수사형태 데이터가 아닐 때 0으로 처리
			isValid2=true;
		}
	}
%>
<form>
	첫번째 숫자: <input type="text" name="num01" ><br>
	두번째 숫자: <input type="text" name="num02" />
	<input type="button" onclick="calPlus()" value="합산"/> <br>
	<%=isValid1&&isValid2? num01+"+"+num02+"="+(num01+num02) :"" %>
</form>


<%-- 7 
<form>
 <h4 name="pro07" type="text"></h4>
</form>
--%>
<%-- 7정답 --%>
<%!
	String chPass(String pt){
		String re = "";
		if(pt!=null){ 				// && pt.trim().equals("") 공백값은 
			try{ //정상적으로 될 때
				int point = Integer.parseInt(pt);
				if(point>=70){
					re="결과: 합격";
				}else{
					re="결과: 불합격";
				}
			}catch(Exception e){	// 여기서 걸러짐
				re = "입력데이터이상(입력, 숫자형)";
			}
		}
		return re;
	}
%>
<%
	String pt = request.getParameter("pt");
%>
<form>
	점수:<input type="text" name="pt"/>
	<input type="submit"> 
</form>
<h3><%=chPass(pt) %></h3>

</body>
<script type="text/javascript">
// 7

var sh = document.h4;
sh.innerHTML +=typeof(70<=parseInt(pro07))+"합격?불합격"

</script>
</html>