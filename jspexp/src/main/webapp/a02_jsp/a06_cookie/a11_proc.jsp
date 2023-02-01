<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    
    import="java.net.URLEncoder"    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script>
/*
 실제처리해주는, 요청값을 받는 페이지 >> 엔코딩
 */
</script>
</head>
<body>
<%
	String proc = request.getParameter("proc");
	String[] cidx = request.getParameterValues("cidx");
	String[] ckey = request.getParameterValues("ckey");
	String[] cval = request.getParameterValues("cval");
	if(proc!=null){ //쿠키값 화면에서 넘어올 때만 처리
		for(String cidxS:cidx){
			int idx = Integer.parseInt(cidxS);
			String key = URLEncoder.encode(ckey[idx], "UTF-8");
			String val = URLEncoder.encode(cval[idx], "UTF-8");
			// 입력값이 없을 때 check한 것에 대한 에러 방지
			if(!key.equals("")&&!val.equals("")){
				// 쿠키를 만들어서
				// 수정과 등록은 같은 프로세스로 처리되고 삭제만 setMaxAge를 0으로 추가처리한다
				Cookie c = new Cookie(key,val);
				if(proc.equals("del")){
					c.setMaxAge(0);
				}
				response.addCookie(c);	
			}
		}
	}
	//서버단에서 페이지이동 코드로 서버로 이동처리
	response.sendRedirect("a10_CookieList.jsp");
%>



</body>
<script>
/*

 */
</script>
</html>