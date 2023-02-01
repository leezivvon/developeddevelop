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
2022-11-25
[2단계:확인] 1. [jsp] 회원등록리스트(회원아이디,회원명,포인트,권한(select-관리자/일반사용자/방문객))로 출력 리스트를 처리하세요.
--%>
<%
List<Member> mlist = new ArrayList<Member>();
mlist.add(new Member("abcd01","이지원",1000,"일반사용자"));
mlist.add(new Member("efgh02","이지둘",2000,"방문객"));
mlist.add(new Member("ijkl03","이지셋",3000,"관리자"));
mlist.add(new Member("mnop04","이지포",4000,"일반사용자"));
mlist.add(new Member("prxt05","이지오",5000,"방문객"));
%>
<form>
<table>
	<col width="10%"><col width="25"><col width="25%"><col width="20%"><col width="20%">
	<tr><th>선택</th><th>회원아이디</th><th>회원명</th><th>포인트</th><th>권한</th></tr>
<%
	for(int idx=0;idx<mlist.size();idx++){ 
	Member m = mlist.get(idx);
%>
		<tr><td><input type="checkbox" name="ck" value="<%=idx %>"></td>
			<td><input type="text" name="id" value="<%=m.getId() %>"></td>
			<td><input type="text" name="name" value="<%=m.getName() %>"></td>
			<td><input type="text" name="point" value="<%=m.getPoint() %>"/></td>
			<td><select name="deptno">
					<option <%=m.getAuth().equals("일반사용자")?"selected":"" %> >일반사용자</option>
					<option <%=m.getAuth().equals("방문객")?"selected":"" %> >방문객</option>
					<option <%=m.getAuth().equals("관리자")?"selected":"" %> >관리자</option>
				</select>
			</td></tr>
	<%} %>		
	<tr><td colspan="5"><input type="submit" value="등록"></td></tr>
</table>
</form>

</body>
</html>