<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"  
    import="jspexp.a13_database.*"  
    import="jspexp.a13_database.vo.*"  

    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 a06_EmpList.jsp
*/
</script>

</head>
<%--
# 서버로 요청값을 넘기기전에 client단 프로그램유효성check처리 순서 
1. type="submit" ==> type="button"
2. onclick="send()" ==> 전송되기전에 이벤트 핸들러 함수로check 후 전송될 수 있게 함수 호출
3. function send(){
		// DOM 객체 호출
		var in01Obj = document.querySelector("[name=num01]");
		var in01 = in01Obj.value
		if(in01 == '' ){ //공백인지 여부 check
		
		}
		if(isNaN(in01)){ // 숫자형이 아닌지 여부check
		
		}
		==> 숫자형은 둘 다 check하는 if
		if(in01 == '' || isNaN(in01)){
			alert("공백이거나 숫자형이 아닙니다")// 메세지 처리
			in01Obj.value=""; in01Obj.focus();
			return;	//진행프로세스 중단
		}
		// type="submit"를 클릭한 것과 동일한 효과 처리
		document.querySelector("form").submit();
	}
--%>
<body>
<%
//form 이 나타나기 전에 위로 올려서
String ename=request.getParameter("ename"); if(ename==null) ename="";
String job=request.getParameter("job"); if(job==null) job="";
String frSal=request.getParameter("frSal"); if(frSal==null) frSal="0";
String toSal=request.getParameter("toSal"); if(toSal==null) toSal="0";
double frSalD = Double.parseDouble(frSal);
double toSalD = Double.parseDouble(toSal);

A02_EmpDao dao = new A02_EmpDao();
Emp sch = new Emp(ename, job, frSalD, toSalD);
%>
<h2>사원정보</h2>
<form id="frm01">
	<table>
		<col width="40%">
		<tr><th>사원명</th><td colspan="2"><input type="text" name="ename" value="<%=ename%>"/></td></tr>
		<tr><th>직책명</th><td colspan="2"><input type="text" name="job" value="<%=job%>"/></td></tr>
		<tr><th>급여</th><td><input type="text" name="frSal" value="<%=frSal%>"/></td>
						<td><input type="text" name="toSal" value="<%=toSal%>"/></td></tr>
		<tr><td colspan="3"><input type="button" onclick="send()" value="검색"/></td></tr>
	</table>

</form>
<script type="text/javascript">
	function send(){
		// 사전에 전송되기 전에 데이터유효성 check해서 전송
		var frSalObj = document.querySelector("[name=frSal]");
		var toSalObj = document.querySelector("[name=toSal]");
		// isNan() : 숫자형 데이터인지를 확인
		// Is not a number?
		// 숫자형일 때 false
		// 숫자형이 아닐 때 ture
		// frSalObj.value =="" : 데이터를 입력하지 않을 때
		// "".trim() : 공백제거
		if(( frSalObj.value.trim()=="" ) || isNaN(frSalObj.value)){
			alert("공백이거나 숫자형 데이터가 아닙니다.")
			frSalObj.value="";
			frSalObj.focus();
			return;	// 프로세스 진행 방지 
		}
		if(( toSalObj.value.trim()=="" ) || isNaN(toSalObj.value)){
			alert("공백이거나 숫자형 데이터가 아닙니다.")
			frSalObj.value="";
			frSalObj.focus();
			return;	// 프로세스 진행 방지 
		}
		
		if(Number( frSalObj.value ) > Number( toSalObj.value )){
			alert("시작범위가 마지막 범위보다 크네요")
			frSalObj.value=""
			toSalObj.value=""
			frSalObj.focus()
			return;
		}
		// 모든 유효성이 check되었을 때 서버로 전송처리
		// submit()을 클릭한 것과 동일한 효과처리
		// document.querySelector("form").submit() 전체form적용
		document.querySelector("#frm01").submit()	//form이 여러 개일때 지정해서
		
		alert("전송");
		
		alert( "공백인 경우: "+ ( frSalObj.value.trim()=="" ) );
		alert( "숫자형이 아닐 경우: "+isNaN(frSalObj.value) );
	}
</script>

<table>
	<tr>
		<th>사원번호</th><th>사원명</th><th>직책명</th><th>관리자번호</th><th>급여</th><th>부서번호</th>
	</tr>
	<% 
	for(Emp e:dao.getEmpSch(sch)){
	%>
	<tr>
		<td><%=e.getEmpno() %></td>
		<td><%=e.getEname() %></td>
		<td><%=e.getJob() %></td>
		<td><%=e.getMgr() %></td>
		<td><%=e.getSal() %></td>
		<td><%=e.getDeptno() %></td>
	</tr>
	<%} %>
</table>

</body>

</html>