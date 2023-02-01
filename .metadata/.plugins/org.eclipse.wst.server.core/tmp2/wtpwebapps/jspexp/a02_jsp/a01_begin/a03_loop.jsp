<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
# jsp에서 조건문과 반복문 처리
1. 반복문 처리
	1) 자바코드는 scriptlet에 넣고 출력하는 부분은 expression에 넣어 구분하여 처리
	2) 처리 순서 
		- 한 단위 기본코드를 만든다
		- 출력할 부분을 index0으로 처리해본다
		- 출력내용을 위아래에 java코드는 <%%>로 감싸준다
		- 반복문의 기본 형식을 아래 위로 넣는다
		- index부분을 변수로 처리해준다
--%>	
<% 
	String[] arry={"사과", "바나나", "딸기"};
	//for(String fruit:arry){
	//	System.out.println(fruit);
	//}
%>
	<%for(String fruit:arry){ %>
		<h2><%=fruit %></h2>
	<% }%>
	
	
	<%-- ex) 가격을 배열 만들고 반복문을 통해서 h3로 출력하세요  --%>
<% 
	int[] arry02={1500, 2000, 2500};
	//for(int price : arry02){
	//	System.out.println(price);
	//}
	// 정답
	int prices[]={2000, 4000, 6000};
	for(int idx=0;idx<prices.length;idx++){
		System.out.println(prices[idx]);
	}
%>	
	<%for(int price : arry02){%>
		<h3><%=price %></h3>
	<%}%>
	
	<!-- 정답 -->
		<h3><%=prices[0] %></h3>
		
		<%for(int idx=0;idx<prices.length;idx++){%>
			<h3><%=prices[idx] %></h3>
		<%}%>
	
	
<% 
int pricess[]={8000, 10000, 12000};
for(int idx=0;idx<pricess.length;idx++){
	System.out.println(arry[idx]+": "+pricess[idx]);
}
%>
	<%for(int idx=0;idx<pricess.length;idx++){%>
		<h3><%=pricess[idx] %></h3>
	<%}%>
	<h3>물건의 정보</h3>
	<style>
		td{text-align:center;}
	</style>	
	<%-- 중간에 ctrl+s를 누르면서 에러가 나는지 확인 --%>
	<table width="50%" style="border-collapse:collapse" border>
		<tr><th>no</th><th>물건명</th><th>가격</th></tr>
		<%for(int idx=0;idx<pricess.length;idx++){%>
		<tr><td><%=idx+1 %></td><td><%=arry[idx] %></td><td><%=pricess[idx] %></td></tr>
		<%}%>
	</table>
	
	
<%-- ex) 사원명 사원번호 부서번호를 각각 배열만들고 for문을 통해서 출력 처리하세요 --%>
<%
	String []ename ={"진화영", "오인주", "오인경", "최도일"};
	int []empno ={7001, 7002, 7003, 1001};
	int []deptno ={801, 801, 802, 100};
%>
	<h2>사원정보</h2>
	<table width="50%" style="border-collapse:collapse" border>
		<tr><th>사원명</th><th>사원번호</th><th>부서번호</th></tr>
		<%for(int idx=0;idx<ename.length;idx++){%>
		<tr><td><%=ename[idx] %></td><td><%=empno[idx] %></td><td><%=deptno[idx] %></td></tr>
		<%}%>
	</table>
	
	
</body>
</html>