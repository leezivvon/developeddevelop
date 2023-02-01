<%--
2022-12-06
[1단계:개념] 1. 배열형 DOM객체의 속성 처리 방식을 기본예제로 기술하세요.
[1단계:확인] 2. 월드컵 16강 팀들을 배열로 리스트하고, 8X2 테이블에 DOM으로 출력하세요 
[1단계:확인] 3. 사원번호/사원명 5개,  부서번호와 부서명4개를 json데이터를 선언하고, 하나는 테이블에 하나는 select의 option에 레이블과 value로 출력해보세요
[1단계:개념] 4. 예외 처리하는 형식(페이지 지정, 서버단위) 내용을 기본 예제를 통해서 설명하세요.
[1단계:확인] 5. z55_errPage.jsp로 에러 페이지를 지정하고, z51_callError.jsp 지정된 페이지로 에러가 호출되게 처리해보세요.
[1단계:확인] 6. 새로운 프로젝트를 web.xml 파일과 함께 만들어서 404, 500 에러를 페이지를 지정하여 대체 화면으로 처리하세요.
[1단계:확인] 7. 위 프로젝트에 NullPointerException, ArrayIndexOutBoundsException을 처리하는 에러페이지를 만들고 web.xml에 등록하고 테스트를 통해서 해당 화면이 나타나게 하세요.
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
</head>
<body>
<%-- 1,2 --%>
<h3>월드컵 16강 진출 팀</h3>
<table id="tb01">
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
</table>

<%-- 3 --%>
<h3>팀</h3>
<table id="tb02">
	<thead>
		<tr><th>사원번호</th><th>사원명</th></tr>
	</thead>
	<tbody>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
	</tbody>
</table>
<select id="sl01">
</select>

	<%-- 3정답 --%>
	<h2>json데이터처리1(요소에 할당)</h2>
	<table id="tab01">
		<thead>
			<tr><th>사원번호</th><th>사원명</th></tr>
		</thead>
		<tbody>
			<tr><td>tds[0]</td><td>tds[1]</td></tr>
			<tr><td>tds[2]</td><td>tds[3]</td></tr>
			<tr><td>tds[4]</td><td>tds[5]</td></tr>
			<tr><td>tds[6]</td><td>tds[7]</td></tr>
			<tr><td>tds[8]</td><td>tds[9]</td></tr>
		</tbody>
	</table>
	<h2>json데이터처리2(동적요소만들기)</h2>
	<select name="dept" onchange=alert(this.value)></select> <!-- 화면의 값(부서명)이 mapping된 값(부서번호)과 다를 때 -->

<script type="text/javascript">
	//3정답
	var emps = [ 
				{empno:7800, ename:"이종길"}, 
				{empno:7801, ename:"이정단"}, 
				{empno:7802, ename:"이지수"}, 
				{empno:7803, ename:"이지원"},
				{empno:7804, ename:"이지우"}	
			   ]
	var tds = document.querySelectorAll("#tab01 td")
	emps.forEach(function(emp,idx){
		// idx=0 >> {empno:7800, ename:"이종길"}
		// idx=1 >> {empno:7801, ename:"이정단"}
		tds[idx*2].innerText = emp.empno
		tds[idx*2+1].innerText = emp.ename
	})
	
	//동적쿼리로 처리
	var depts = [
				{deptno:10, dname:"인사"}, 
				{deptno:20, dname:"재무"}, 
				{deptno:30, dname:"회계"}, 
				{deptno:40, dname:"법무"} ]
	var deptDom = document.querySelector("[name=dept]")
	var addHtml = "" //동적html은 이런식으로 하기
	depts.forEach(function(dept){
		addHtml+= "<option value='"+dept.deptno+"'>"+dept.dname+"</option>"
	})
	deptDom.innerHTML = addHtml
</script>





<%-- 
4 
- 에러 페이지 지정 처리
1. 에러가 발생했을 때 나타낼 페이지 구현
	1) 지시자 선언	
		<%@ page isErrorPage = 'true' %>
		이 페이지는 에러 처리를 위한 페이지 임을 나타낸다
		이렇게 속성값을 지정하면 예외의 기본객체의 참조변수exception을 처리할 수 있다
		ex) <%=exception.getMessage() %>
		ex) <%=exception.printStackTrace() %>
2. 에러가 발생할 가능성이 있는 페이지 구현
	1) 페이지별로 에러발생시 에러 페이지 지정
	2) 페이지 지시자 선언
		<%@ page errorPage = '만들어 둔 에러페이지 지정' %>	

- 서버단위에러 처리
1. 서버의 설정페이지 web.xml에서 응답코드(http)별로 에러페이지를 지정할 수 있다
	<error-page>
		<error-code>응답코드</error-code>			
		<location>에러페이지uri</location>
		webapp기준으로 하위에 특정한 경로에 에러페이지를 지정하여 처리
2. 서버의 설정페이지web.xml에 예외 클래스별로 에러페이지도 지정할 수 있다
	<error-page>
		<exception-type>java.lang.XXXException</exception-type>
		<location>경로지정</location>
--%>

</body>
<script type="text/javascript">
//2
var tds = document.querySelectorAll("#tb01 td")
var worldcup16 = ["폴란드", "프랑스", "잉글랜드", "세네갈", "일본", "크로아티아", "브라질", "한국", "모로코", "스페인", "포르투갈","스위스", "미국", "네덜란드", "아르헨티나", "호주"]
for(var idx=0;idx<worldcup16.length;idx++){
	tds[idx].innerText = worldcup16[idx];
}

//3
var tdss = document.querySelectorAll("#tb02 td")
var opts = document.querySelector("#sl01")
var emp = [{empno:7, ename:"손흥민"}, {empno:8, ename:"백승호"}, {empno:15, ename:"김문환"}, {empno:4, ename:"김민재"},{empno:18, ename:"이강인"}]
var dept = [{dpetno:100, dname:"미드필더부"}, {dpetno:200, dname:"공격수부"}, {dpetno:300, dname:"수비수부"}, {dpetno:400, dname:"골키퍼부"}]

emp.forEach(function(emp,idx){
	tdss[idx*2].innerText = emp.empno
	tdss[idx*2+1].innerText = emp.ename
})
for(var idx=0;idx<dept.length;idx++){
	opts.innerHTML += "<option value='"+dept[idx].dpetno+"'>"+dept[idx].dname+"</option>"
}



</script>
</html>

<%--

1) 예외파일생성
	z03_null.jsp
		isErrorPage = "true"
		<h2>객체가 null로 설정되어 발생한 에러입니다</h2>
		<%=exception.getClass().getName() %>
		<%=exception.getMessage() %>
		
	z04_arrayIndex.jsp
		isErrorPage = "true"
		<h2>배열의 index범위를 확인하세요</h2>
		<%=exception.getClass().getName() %>
		<%=exception.getMessage() %>
		
2) web.xml
	<exception-type>java.lang.NullPointerException		
	<exception-type>java.lang.ArrayIndexOutBoundsException		

--%>