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


	<h2>현재쿠키리스트</h2>
	<form>
	<table id="tb">
		<tr><th>선택</th><th>쿠키의 키</th><th>쿠키의 값</th></tr>
		<%
			Cookie cks[] = request.getCookies();
			for(int idx=0;idx<cks.length;idx++){
				Cookie c = cks[idx];
				if(!c.getName().equals("JSESSIONID")){
		%>
		<tr><td><input type="checkbox" name="cidx" value="<%=idx %>"/></td>
			<td><input type="text" name="ckey" value="<%=c.getName() %>"/></td>
			<td><input type="text" name="cval" value="<%=c.getValue() %>"/></td></tr>
		<%
				}
			}	
		%>	
		
	</table>
		<input type="hidden" name="proc"/>
	</form>
	
	
	<br>
	<h2>쿠키 등록</h2>
	<form method="post" action="a09_proc.jsp">
		<input type="hidden" name="proc" value="add"/>
		<input type="hidden" name="cidx" value="0"/>
 		쿠키의 key : <input type="text" name="ckey"/>
		쿠키의 value : <input type="text" name="cval"/>
	</form>
	
	<input type="button" value="쿠키추가/변경" onclick="go('add')"/>
<%--<input type="button" value="쿠키변경" onclick="go('upt')"/> --%>
<%-- 쿠키값의key가 같으면 변경이 되고 --%>
	<input type="button" value="쿠키삭제" onclick="go('del')"/>

</body>
<script type="text/javascript">

function go(proc){
	if(proc=='add'){
		document.forms[1].submit();
	}else{
		document.querySelector("[name=proc]").value=proc;
		document.forms[0].submit();
	}
}



/*
# 요청값을 통한 쿠키의 생성/수정/삭제 처리
1. 파일 정보
	1) a05_CookieList.jsp : 쿠키값 전체리스트
	2) a09_proc.jsp : 생성/수정/삭제에 따라 변경 처리
	
2. 개발 순서
 	1) 쿠키값 전체 리스트 화면
 		- 기능 버튼 처리
 			등록/수정/삭제
 		- form action="a09_proc.jsp"
 		- 기능요청값 처리 : <input type="hidden" name="proc"/>
 		- 버튼을 눌렀을 때 script처리
 			function go(proc){
 				document.querySelector("[name=proc]").value=proc
 		}
 	2) 요청값에 따른 쿠키데이터 처리(a09_proc.jsp)
 		- cidx : index로 체크된 값만 전달
 		  ckey : 쿠키의 요청 키를 전달
 		  cval : 쿠키의 요청 값을 전달
 		- proc : 쿠키의 등록/수정/삭제 처리  (add.upt.del)
 		if(proc!=null){
 			for(String cidxS:cidx){
 				// checkbox로 선택되어진 key/value
 				int idx = Integer.parseInt(cidxS);
 				String key = ckey[idx];
 				String val = ckey[cval];
 				if(proc.equals("add")||proc.equals("upt")){
 					Cookie c = new Cookie(key, val);
 					response.addCookie(c);
 				}
 				//if(proc.equals("upt")){ }
 				if(proc.equals("del")){
 	 				for(Cookie : request.getCookie()){
 	 					if(c.getName().equals(key)){
 	 						c.setMaxAge(0);
 	 						response.addCookie(c);
 	 					}
 	 				}
 				}

 			}
 		}
 		response.sendRedirect("a05_CookieList.jsp");
 		
*/

</script>
</html>