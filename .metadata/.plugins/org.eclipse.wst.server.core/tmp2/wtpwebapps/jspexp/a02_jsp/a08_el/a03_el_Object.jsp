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
# el을 활용한 VO객체 처리
1. el은 VO객체를 property라는 개념으로 접근해서 호출할 수 있다
2. 저장 시, 호출 시
	1) scope에 따른 객체로 저장
		request.setAttribute("p01", new Person());
	2) 가져올 때
		<%=p01.getName() %>  
			==>  ${p01.name}	// 필드를 호출하는것이 아님>>getName()호출>>get삭제 Name()==>name변경해서 처리
		VO
			필드를 name01로 해도 접근 가능?
			getName() == > getName88()	${p01.name88}
			==>el태그는 없으면 nullpointerException발생하지 않고 공백으로 처리된다(조건문처리하지 않더라도)						
--%>

<%
	request.setAttribute("p01", new Person("홍길동", 25, "서울"));
	
	// ex) d01 Dept()객체를 생성하고 el로 호출하세요 String dname, int deptno, String loc
	request.setAttribute("d01", new Dept("법무팀", 400, "서울 서초구" ));

%>
	<h2>이름:${p01.name }</h2>
	<h2>나이:${p01.age }</h2>
	<h2>주소:${p01.loc }</h2>
	
	<%-- ex --%>
	<h2>부서명:${d01.dname }</h2>
	<h2>부서번호:${d01.deptno }</h2>
	<h2>부서위치:${d01.loc }</h2>
	
	
	<%-- 
		***
		--vo--
		
		public Person(String name, int age, String loc) {
			this.name = name; >>> name 이게 필드
			this.age = age;
			this.loc = loc;
		}
		
		public String getName() { >> 이 getName불러오는거임
			return name;
		}
	
	** 필드에 접근하는게 아니라 getName()에 접근하는 거임
	--%>
</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>