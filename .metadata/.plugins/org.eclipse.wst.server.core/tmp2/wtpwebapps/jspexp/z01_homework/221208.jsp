<%-- 
2022-12-08
[1단계:개념] 1. form요소객체의 하위 속성을 속성값을 동적으로 변경하는 코드를 기술하세요
[1단계:확인] 2. 회원아이디를 입력하고 옆에 유효 CHECK 버튼을 클릭시,
               글자수가 8~16이고, himan가 아닐 때만 유효여부 checkbox표기하고, readOnly 속성으로 설정하세요.
               회원아이디 [    ] [유효check]  []유효여부
[1단계:확인] 3. checkbox, radio, select의 js로 접근할 때, 차이점을 기술하세요.
[1단계:확인] 4. checkbox와 월드컵 출전팀을 리스트하고, check 후, 16강진출 버튼 클릭시, 선택된 팀만 하단에 리스트하게 하세요.
[1단계:확인] 5. radio를 이용해서 현재 해결해야 할 문제(3가지) 중에 가장 중요한 것을 클릭시, 하단에 표현되게 하세요.
[1단계:확인] 6. 물건명, 가격select(1000단위~9000), 갯수(select 1~9) 가격나 갯수를 선택시, 하단에 구매한 물건과 총비용을 출력되게 하세요
[1단계:확인] 7. 쿠키와 세션의 궁극적인 차이점으로 설정 코드와 함께 설명하세요
[1단계:확인] 8. Emp Vo로 세션을 설정하고, 세션이 없을 때, 세션설정하는 페이지로 이동하게 하되, 세션 확인하는 페이지에서
                   10/20/30/40  테이블 리스트에서 클릭시, 해당 부서만 접근가능 alert() 그 외는 접근 불가능 alert()로딩되게 처리하세요.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"  
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
*/
</script>

</head>
<body>
<%-- 
1.

--%>
<%--  --%>

<%-- 
2022-12-08
[1단계:개념] 1. form요소객체의 하위 속성을 속성값을 동적으로 변경하는 코드를 기술하세요
[1단계:확인] 2. 회원아이디를 입력하고 옆에 유효 CHECK 버튼을 클릭시,
               글자수가 8~16이고, himan가 아닐 때만 유효여부 checkbox표기하고, readOnly 속성으로 설정하세요.
               회원아이디 [    ] [유효check]  []유효여부
[1단계:확인] 3. checkbox, radio, select의 js로 접근할 때, 차이점을 기술하세요.
[1단계:확인] 4. checkbox와 월드컵 출전팀을 리스트하고, check 후, 16강진출 버튼 클릭시, 선택된 팀만 하단에 리스트하게 하세요.
[1단계:확인] 5. radio를 이용해서 현재 해결해야 할 문제(3가지) 중에 가장 중요한 것을 클릭시, 하단에 표현되게 하세요.
[1단계:확인] 6. 물건명, 가격select(1000단위~9000), 갯수(select 1~9) 가격나 갯수를 선택시, 하단에 구매한 물건과 총비용을 출력되게 하세요
[1단계:확인] 7. 쿠키와 세션의 궁극적인 차이점으로 설정 코드와 함께 설명하세요
[1단계:확인] 8. Emp Vo로 세션을 설정하고, 세션이 없을 때, 세션설정하는 페이지로 이동하게 하되, 세션 확인하는 페이지에서
                   10/20/30/40  테이블 리스트에서 클릭시, 해당 부서만 접근가능 alert() 그 외는 접근 불가능 alert()로딩되게 처리하세요.
--%>








<!-- 정답 -->
	<!-- 2정답 -->
	<h2>회원 아이디 유효성 check</h2>
	회원아이디:<input type="text" name="id"/>
	<input type="button" value="유효check" onclick="ckValid()"/>
	<input type="checkbox" id="isValid"/> 유효여부
<script type="text/javascript">
	var idOb = document.querySelector("[name=id]")
	var ckValOb = document.querySelector("#isValid")
	
	function ckValid(obj){
		if(obj.value=="유효check"){
			var len = idOb.value.length
			if(len>=8 && len<=16 && idOb.value!='himan'){
				//유효여부 checkbodx 표시
				ckValOb.checked = true
				idOb.readOnly = true
				obj.value="아이디재입력"
				// 실무적으로는 입력내용과 패턴만 유효성check하고 
				// 데이터에 대한 확인은 ajax(비동기적으로 서버 접근) 처리하여 유효여부를 확인한다
			}
		}else{
			ckValOb.checked = false
			idOb.readOnly = false
			idOb.value=""; idOb.focus()
			Obj.value=="유효check"
	}
</script>
	
	
		<br>
		<!-- 6정답 //jsp에서도 javascript에서도 처리할 수 있음-->
		<h2>구매</h2>
		물건명:<input type="text" name="pname"/>
		가격:<select name="price" onchange="cal()"></select> <!--  onkeyup="cal()"==>물건명바꿔도 계속 바뀜 -->
		개수:<select name="cnt" onchange="cal()"></select>
		<h3 id="shwBuy"></h3>
	<script type="text/javascript">
		var pnameOb = document.querySelector("[name=pname]")
		var priceOb = document.querySelector("[name=price]")
		var cntOb = document.querySelector("[name=cnt]")
		var shwBuyOb = document.querySelector("#shwBuy")
		
		var add1 = ""
		var add2 = ""
		for(var cnt=1;cnt<=9;cnt++){
			add1+="<option>"+cnt*1000+"</option>" 
			add2+="<option>"+cnt+"</option>"
		}
		priceOb.innerHTML = add1;
		cntOb.innerHTML = add2;
		
		
		function cal(){
			//주의!!! 반드시 선택할 당시 value를 가져오게 event를 가져오게 처리 >>handler사용
			var tot = priceOb.value*cntOb.value
			shwBuyOb.innerText = "구매물건: "+pnameOb.value+", 총비용: "+tot
		}
	</script>
	
	
	<!-- 8 -->
	<!-- 내가 맞으면 비밀번호 또 입력안하고 수정 삭제 할 수 있게끔 >> session처리 -->
	<%-- 
		1) 세션 처리 페이지 및 리스트 페이지 이동	ex)로그인 후 세션설정 후 리스트 페이지
			z43_makesession.jsp
		2) 221208.jsp
			- 세션가져오기(만약에 session이 없으면 세션페이지에서 세션 처리하기)
			- 현재페이지에서 테이블 리스트 출력
				메뉴 리스트를 클릭 시 지정된 메뉴의 권한 내용과 세션에 있는 권한과 비교하여 같으면 접근, 다르면 접근불가능 경고창 처리
	--%>
	<%
	Emp emp =(Emp)session.getAttribute("emp");
	boolean hasSess = emp!=null; //null이 아니면 true
	
	//세션이 있을 때만 메서드 호출, 없을 때는 0으로 할당
	//js코드로 넘겨서 메뉴 check시 활용
	int sesDeptno = hasSess?emp.getDeptno():0;	//따로 변수 선언
	
	List<Dept> dlist = new ArrayList<Dept>();
	dlist.add(new Dept("인사", 10, ""));
	dlist.add(new Dept("회계", 20, ""));
	dlist.add(new Dept("네트워크", 30, ""));
	dlist.add(new Dept("총무", 40, ""));
	%>
	<table>
		<tr><th>부서리스트</th></tr>
		<%for(Dept d:dlist){ %>
			<tr><td ondblclick="ckAuth('<%=d.getDeptno() %>')"><%=d.getDname() %></td></tr>
		<%} %>
	</table>
</body>
<script type="text/javascript">
	var hasSess =<%=hasSess%>
	if(!hasSess){
		alert("세션이 없습니다.\n세션 설정 페이지로 이동하겠습니다")
		location.href="z43_makesession.jsp"
	}
	var sesNo = <%=sesDeptno %> //화면이 로딩될때 이미 세팅이 된거
	function ckAuth(deptno){
		//세션에 있는 deptno와 부서리스트에서 잔달하는 deptno가 같으면 권한 있기 때문에 이동 가능
		if(sesNo==deptno){
//		if(sesNo==<.%=emp.getDeptno() %.>){==>먼저만들어
			alert("권한이 있습니다. 이동 성공")
		}else{
			alert("메뉴사용권한이 없습니다")
		}
	}
		
		/*
		jsp  >> javascript
		해당 자원이 html이면 그대로 전송, jsp이면 java/class 과정을 거쳤는지 여부에 따라서 
		처음 호출 java(서블릿) ==> class 
		==> 실행명령에 의해서 ==> java+html 혼합된 최종 html코드(css,js포함) ==> 클라이언트에 전달 
		==> html 랜더링(h1을 태그에 맞는 내용으로 변환), js도 여기에 실행처리(이벤트 처리 등 처리)
	3) 로딩된 화면이 form 형태로 입력값을 처리할 수 있는 화면이면 
		action, name, value ==> 페이지명?key=value 형태로 submit클릭 시 서버에 특정페이지에 전송
		==>jsp/php/asp(어플리케이션 프로그램)에서 요청값을 받아서 해석(로직/DB접속)해서 화면을 다시 구성 ==> client에 전달
	
		
		*/
		
	
</script>
</html>