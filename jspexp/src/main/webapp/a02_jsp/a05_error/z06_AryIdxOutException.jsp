<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    
    isErrorPage="true"  
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body style="background-image:url('img06.jpg');color:white;">

<h2 align="center">예외 발생</h2>
<h2 align="center">ArrayIndexOutBoundsException</h2>
<h2 align="center">배열의 범위를 넘었습니다</h2>
<h2 align="center"><%=exception.getClass().getName() %></h2>
<h2 align="center"><%=exception.getMessage() %></h2>



</body>
</script>
</html>