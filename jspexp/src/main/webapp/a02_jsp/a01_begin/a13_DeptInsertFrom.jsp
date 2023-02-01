<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    

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

1. 초기화면(페이지가 이동되었을 때)
	a13_DeptInsertFrom.jsp
	요청값이 없음
	
2. 입력값이 있는 화면(등록 처리시)
	a13_DeptInsertFrom.jsp?deptno=&dname=&loc=

3. 위 두가지처리 화면을 구분하기 위해서 
	String deptnoS = request.getParameter("deptno");
	if(deptnoS==null){// 초기화면
		
	}else{ // 입력버튼을 클릭한 화면
		
	}
		
 # alt+space+m
 화살표 방향기 (위로)
 
*/
</script>

</head>
<body>
	<h3>부서정보등록</h3>
	<%
	// 초기 로딩되었을 때도 수행되지만 요청값이 없기에 조건에 해당하지 않기에 화면로딩만 된다
	// 입력값을 입력 후 submit 클릭 시 조건에 해당하기에 DB처리를 할 수 있게 된다
	String deptno = request.getParameter("deptno");
	int deptnoInt = 0;
	if(deptno!=null && !deptno.equals("")) {
		// check1 : deptno.length(); 
		try{
			// 부서번호:[이십오]  ==> 0
			deptnoInt = Integer.parseInt(deptno);
		}catch(Exception e){
			//check2 : log(e.getMessage());
			log(e.getMessage());
		}
	}
	String dname = request.getParameter("dname"); if(dname==null) dname="";
	String loc = request.getParameter("loc"); if(loc==null) loc="";
	
	boolean isInsert = false;
	// 입력 후 등록 버튼을 클릭했을 때 처리할 내용
	// 조건이 입력 후 submit으로 요청값을 호출 했을 때와 초기 화면을 구분하여 조건 처리 
	if(deptno!=null && !deptno.equals("")){
		// 입력을 위한 VO객체 생성
		Dept ins = new Dept(deptnoInt, dname, loc);
		// 매개변수 입력 Dao 기능메서드에 전달
		A06_PareparedDao dao = new A06_PareparedDao();
		dao.insertDept(ins);
		isInsert = true;
	}
	%>
	<script>
	// jsp(java코드)==>js로 전환되어 js의 여러가지 프로그램 처리
		var isInsert = <%=isInsert %>; // var isInsert = true;
		if( isInsert ){
			// 확인 시 조회 화면으로 이동, 취소 시 현재 등록 화면에서 계속 등록 가능하도록 처리
			if(confirm("등록성공\n조회화면으로 이동하시겠습니까?")){
				location.href="a12_DeptList.jsp";
			}
		}
		function ckValid(){
			var deptno = document.querySelector("[name=deptno]")
			var deptnoV = deptno.value.trim();
			var dname = document.querySelector("[name=dname]")
			var dnameV = dname.value.trim();
			var loc = document.querySelector("[name=loc]")
			var locV = loc.value.trim();
			//if(deptno.value)
			if(deptnoV=="" || isNaN(deptnoV)){
				alert("부서번호는 공백이 아니거나 숫자형이어야 합니다")
				deptno.value=""; // 지우는거
				deptno.focus()
				return;
			}
			if(dname==""){
				alert("부서명은 공백이 아니어야 합니다")
				dname.focus()
				return;
			}if(locV==""){
				alert("부서 위치는 공백이 아니어야 합니다")
				loc.focus()
				return;
			}
			document.querySelector("form").submit();
		}
	</script>
	
	<form>
		부서번호 <input type="text" name="deptno"/>
		부서명 <input type="text" name="dname"/>
		부서위치 <input type="text" name="loc"/>
		<input type="button" onclick="ckValid" value="등록">
	</form>



</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>