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
<script type="text/javascript">
/*
 
*/
</script>

</head>
<body>
	<h4>총비용 계산</h4>
	<%
	String prod = request.getParameter("prod01");
	String priceS = request.getParameter("price01");
	String cntS = request.getParameter("cnt01");
	
	int price = Integer.parseInt(priceS);
	int cnt =  Integer.parseInt(cntS); 
	int tot = price*cnt;
	
	
	if( prod!=null ){
		if(tot>=100000){
	%>
			<jsp:forward page="z41_mvp.jsp"/>
	<% 	}else{	%>
			<jsp:forward page="z42_normal.jsp"/>
	<% 	}	%>
	<%
	} %>



<%-- 3-2단계 정답 --%>
<%
String pricee = request.getParameter("pricee"); if(pricee==null) pricee="0";
String cntt = request.getParameter("cntt"); if(cntt==null) cntt="0";
int priceI = Integer.parseInt(pricee);
int cntI = Integer.parseInt(cntt);
int tott = priceI*cntI;
request.setAttribute("tott",tott);
String page01 = "z42_normal.jsp";
if(tott>=100000){
	page01 = "z41_mvp.jsp";
}
%>

<jsp:forward page="<%=page01 %>"/>



</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>