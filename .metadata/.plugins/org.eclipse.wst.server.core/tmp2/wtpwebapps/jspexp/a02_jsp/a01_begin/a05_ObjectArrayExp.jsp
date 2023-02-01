<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspexp.vo.*"
    import="java.util.*"
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
	<%-- 팀명 선수명 성적을 Player라는 vo 클래스를 만들고 출력 처리해보세요 --%>
<% 
	List<Player> plist = new ArrayList<Player>();
	plist.add(new Player("SSG", "추신수", 0.28));
	plist.add(new Player("키움", "이정후", 0.34));
	plist.add(new Player("SSG", "오원석", 0.7));
%>
	<table border>
		<tr><th>팀명</th><th>선수명</th><th>성적</th></tr>
		<%for(Player p : plist){ %>
		<tr><td><%=p.getTname() %></td><td><%=p.getPname() %></td><td><%=p.getScore() %></td></tr>
		<%} %>
	</table>

</body>
</html>