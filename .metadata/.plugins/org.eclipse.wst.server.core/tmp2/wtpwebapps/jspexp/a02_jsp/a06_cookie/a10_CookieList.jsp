<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    
    import="java.net.URLDecoder"    
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
//디코드해야하는페이지

# 쿠키 수정하기
1. 기존에 쿠키의 키를 다른 값으로 할당하고, 다시 response객체로 전달한다. 
 --%>
	<h2>현재 쿠키 리스트</h2>
	<form method="post" action="a11_proc.jsp">
	<table id="tb">
		<tr><th>선택</th><th>쿠키의 키</th><th>쿠키의 값</th></tr>
		<%
		Cookie cks[] = request.getCookies();
		log("## 쿠키 개수 ##"+cks.length);
		for(int idx=0;idx<cks.length;idx++){
			Cookie c = cks[idx];
			String key =URLDecoder.decode(c.getName(), "UTF-8");
			String val =URLDecoder.decode(c.getValue(), "UTF-8");
		%> 
		<tr><td><input type="checkbox" name="cidx" 
					value="<%=idx%>"/></td>
			<td><input type="text" name="ckey" 
					value="<%=key.equals("JSESSIONID")?"":key %>"/></td>  
			<td><input type="text" name="cval" 
					value="<%=key.equals("JSESSIONID")?"":val %>"/></td></tr>
		<%
		}

		%>
	</table>
	<input type="hidden" name="proc"/>
	</form>
	
	<input type="button" value="쿠키추가/변경" onclick="go('add')"/>
	<%-- 쿠키의 값이 key같으면 변경이 되고 다르면 추가 --%>
	<input type="button" value="쿠키삭제" onclick="go('del')"/> 
</body>

<script>
function go(proc){	
	// ex) a10, a11 한글 encoding/decoding처리하세요
	//check를 하여야 다음 페이징 전송되게 처리
	var ckDoms = document.querySelectorAll("[name=cidx]");
	var isCheck = false
	for(var idx=0;idx<ckDoms.length;idx++){
		console.log(ckDoms[idx].checked)
		if(ckDoms[idx].checked){
			isCheck=true;
		}
	}
	if(!isCheck){
		alert("선택된 쿠키값이 없네요\n선택하여야 처리가 가능합니다");
		return;
	}
	document.querySelector("[name=proc]").value=proc;
	//DOM객체의 아래와 같이 요소객체로 배열로 설정하는 경우도 있다
	document.forms[0].submit();
	//=document.querySelector("form").submit();
}

</script>
</html>