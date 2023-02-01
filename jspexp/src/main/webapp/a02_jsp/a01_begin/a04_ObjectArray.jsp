<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspexp.vo.Dept"
    
    import="java.util.*"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 객체형 List 처리
	/* 
	1. 구조 만들기/import처리
	2. 리스트로 데이터 넣기
	3. 반복문 처리하기
	*/
	List<Dept> dlist = new ArrayList<Dept>();
	dlist.add(new Dept("인사", 10, "서울"));
	dlist.add(new Dept("회계", 20, "부산"));
	dlist.add(new Dept("총무", 10, "제주도"));
	for(int idx=0;idx<dlist.size();idx++){
		Dept d = dlist.get(idx);
		log(d.getDeptno()+":"+d.getDname()+":"+d.getLoc());
	}
%>
	<table border>
		<tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
		<%for(Dept d:dlist){ %>
		<tr><td><%=d.getDeptno() %></td><td><%=d.getDname() %></td><td><%=d.getLoc() %></td></tr>
		<%} %>
	</table>

	
</body>
</html>