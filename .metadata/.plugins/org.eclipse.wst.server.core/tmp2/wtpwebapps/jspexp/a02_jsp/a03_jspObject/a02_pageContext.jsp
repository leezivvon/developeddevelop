<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"   
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

<%-- 
# PageContext 기본객체
1. 다른 기본객체에 대한 접근 메서드 제공을 하는 객체이다
2. session scope로는 page범위로 설정되는 객체이다
	setAttribute("페이지범위설정키", 페이지범위설정값) : 페이지 범위 설정
	getAttribute("페이지범위설정키"); : 저장된 페이지 범위 데이터가져오기
	
3. 기능 메서드
	getRequest() : request기본객체를 가져온다
	getPesponse() : response기본객체를 가져온다
	getSession() : session기본객체를 가져온다
	getServletContext() : application 객체를 가져온다
	getServletConfig() : config기본 객체를 가져온다
	getOut() : out 기본객체를 가져온다
	getException() : exception 기본객체를 가져온다
	getPage() : get 기본객체를 가져온다

--%>
<%
// 페이지 범위 데이터 설정

// 자바의 최상위 객체인 Object형식으로 저장이 된다
// Object str01 = "안녕하세요"; 이것을 str01이란 이름으로 저장
// 문자열인  Object객체의 toString()으로 저장된 문자열을 처리하기에 출력이 가능하다
// 그 외 다른 유형은 typeCastion을 선언하여야 한다
Integer numWrap = 25;	//primitive ==> wrapper으로 자동할당 autoBoxing
Object num01 = numWrap;
//Object num01 = new Integer(25);	

//저장된 내용을 사용하기 위해 casting하여야 한다
Integer wap01 = (Integer)num01;
int num02 = wap01;	// autoUnboxing  		///??

Object ob01 = new Person("마길동", 25, "서울"); // 상위=하위 저장
// 다시 저장된 것을 사용하려면 casting이 필요하다
Person p02 = (Person)ob01;

pageContext.setAttribute("str01","안녕하세요");
pageContext.setAttribute("num01",25);
pageContext.setAttribute("num02",5);

pageContext.setAttribute("obj01",new Person("홍길동", 25, "서울"));

%>

<h1>페이지범위 문자열:<%=pageContext.getAttribute("str01") %></h1>
<h1>페이지범위 숫자:<%=pageContext.getAttribute("num01") %></h1>
<h1>페이지범위 숫자연산:<%=((Integer)pageContext.getAttribute("num01")+
						(Integer)pageContext.getAttribute("num02") )%></h1>
<%-- 
setAttribute로 설정되는 내용은 기본적으로 Object로 저장되기에 고유의 유형(숫자, boolean 등) 형식을
사용하거나 특정 객체 유형인 경우에는 객체타입으로 변환해주어야 한다 
--%>
<%
//페이지 범위 저장객체 가져오기
Person p01 = (Person)pageContext.getAttribute("obj01");
%>

<h1>페이지범위 객체(속성1): <%=p01.getName() %></h1>
<h1>페이지범위 객체(속성2): <%=p01.getAge() %></h1>
<h1>페이지범위 객체(속성3): <%=p01.getLoc() %></h1>


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>