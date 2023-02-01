<%--
2022-11-22
[1단계:개념] 1. jsp의 request 객체의 기능와 기능메서드를 기술하세요
[1단계:개념] 2. request.getParameter(), request.getParameterValues()의 차이를 기술하세요.
[1단계:확인] 3. form 하위 요소객체와 request.getParameterNames()를 이용하여 사원명/사원번호/부서이름을 등록리스트하세요
[1단계:확인] 4.(선택) form요소객체를 이용하여 학생3명의 이름입력하고 요청값을 처리하세요.
[2단계:확인] 4.(선택) form요소 객체를 이용하여 학생3명의 국어점수를 입력하고 요청값을 처리하여 합산을 출력하세요
[3단계:확인] 4.(선택) form요소객체를 이용하여 학생3명의 이름/국어/영어/수학 입력하고 요청값을 처리하세요.
               각, 학생의 평균 점수와 과목별 평균점수를 출력하세요.
[1단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명 요청하여 구매갯수와 물건명 출력
[2단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명의 가격을 계산하여 총가격 출력하세요
[3단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명과 가격 구매갯수 총계가 계산 되게 하세요.
[1단계:개념] 6. 요청값을 encoding하는 이유를 기술하고, meothod의 get방식과 post방식의 차이점을 기술하세요.
[1단계:확인] 7. post 방식으로 월드컵 A조의 팀명과 점수를 입력하고 현재 대전 결과를 출력하세요.
                     팀1    팀2 
                팀명[   ]  [    ]
                점수[   ]  [    ]
                      [결과] 
                    @@@ vs @@@
                      1 - 2
                      @@@ 승
--%>

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
<%-- 
1
request는 파라미터 읽기 메서드 즉 요청값 처리 메서드입니다

기능메서드
request.getParameter(String name)
	이름이 name인 파라미터의 값을 구한다. 존재하지 않을 경우 null로 리턴	
request.getParameterValues(String name)
	이름이 name인 모든 파라미터의 값을 배열로 구한다. 존재하지 않을 경우 null을 리턴한다
request.getParameterNames(): 웹 브라우저가 전송한 파라미터의 이름을 구한다	
request.getParameterMap()  : 웹 브라우저가 전송한 파라미터의 맵을 구한다. 맵은 파라미터 이름, 값 쌍으로 구성된다 	
--%>
<%--
2
getParameter와 다르게 getParameterValues()는 다중의 키값을 받는 요청객체로 배열로 전달한다
--%>
<%-- 3 --%>
<form>
	사원명 : <input type="text" name="ename" >
	사원번호 : <input type="text" name="empno" >
	부서이름 : <input type="text" name="dname" >
	<input type="submit" value="등록"/>
</form>
<table>
	<tr><th>목록</th><th>데이터</th></tr>
<%
Enumeration e = request.getParameterNames();
while (e.hasMoreElements()){
	String key = (String)e.nextElement();
%>
	<tr><td><%=key %></td><td><%=request.getParameter(key) %></td></tr>
<% } %>
</table>


<%-- 4-1 --%>
<h2>학생</h2>
<%
	//4-1
//	String []names = {"홍길동", "김길동", "신길동"};	

	// 4-2 인덱스만 없으며 하단에 적어도됨
	String []names= request.getParameterValues("name");
	String []kors= request.getParameterValues("kor");	
	//4-3
	String []engs= request.getParameterValues("eng");	
	String []maths= request.getParameterValues("math");	
	
%>
<form>
	<table>
		<tr><th>이름</th><th>국어</th><th>영어</th><th>수학</th></tr>
		<% for(int idx=0;idx<names.length;idx++){ %>
			<tr>
				<td><input type="text" name="name" value="<%=names[idx]  %>"></td>
				<td><input type="text" name="kor" value="<%=kors[idx]  %>"></td>
				<td><input type="text" name="eng" value="<%=engs[idx]  %>"></td>
				<td><input type="text" name="math" value="<%=maths[idx]  %>"></td>
			</tr>
		<% } %>
		<tr><td colspan="4"><input type="submit"/></td></tr>	
		
	</table>
</form>
<p align="center">
	<h3>
		<%
			int totAll=0;	// 전체평균	 // 전역변수로 선언
			
			// 4-1
			if(names!=null){
				// 4-3
				for(int idx=0;idx<names.length;idx++){
					int tot = Integer.parseInt(kors[idx])+
							  Integer.parseInt(engs[idx])+
							  Integer.parseInt(maths[idx]);
					out.print(names[idx]+", 평균:"+(tot/3)+"<br>");
				}
				
				// 4-1
//				for(String name:names){ // 초기 로딩 화면과 구분
//					out.print(name+", ");
//				}
			}
			
			//4-2
			out.print("<br>국어점수");
			if(kors!=null){
				int tot = 0;
				for(String kor:kors){
					//공백이나, null 등 숫자형에 대한 처리 ==> 0으로 처리
					int pt =0;
					try{
						pt = Integer.parseInt(kor);
						out.print(pt+" ");
					}catch(Exception ex){ }
					tot += pt;
				}
				out.print("<br>국어합산:"+tot+" /  국어평균: "+(tot/names.length));
			}
			
			out.print("<br>영어점수");
			if(engs!=null){
				int tot = 0;
				for(String eng:engs){
					//공백이나, null 등 숫자형에 대한 처리 ==> 0으로 처리
					int pt =0;
					try{
						pt = Integer.parseInt(eng);
						out.print(pt+" ");
					}catch(Exception ex){ }
					tot += pt;
				}
				out.print("<br>영어합산:"+tot+" /  영어평균: "+(tot/names.length));
			}
			
			out.print("<br>수학점수");
			if(maths!=null){
				int tot = 0;
				for(String math:maths){
					//공백이나, null 등 숫자형에 대한 처리 ==> 0으로 처리
					int pt =0;
					try{
						pt = Integer.parseInt(math);
						out.print(pt+" ");
					}catch(Exception ex){ }
					tot += pt;
				}
				out.print("<br>수학합산:"+tot+" /  수학평균: "+(tot/names.length));
			}
			
			out.print("<br>전체과목학생 평균: "+(totAll/3));
		%>
	</h3>
</p>
<%-- 5-1 --%>
<%-- 5-2 --%>
<%-- 5-3 --%>
<%--
6 
웹브라우저와 웹서버가 다른 인코딩방식을 사용해서 웹브라우저에서 한글이 깨지기 때문에 encoding을 한다

form 데이터 처리 방식은 method 속성
	1) get방식 : url 주소창에 쿼리스트링으로 전송을 한다, tomcat 서버에서 요청값 encoding을 처리
	2) post방식: 요청 몸체에서 쿼리스트링을 숨겨서 전송한다, 직접적으로 코드를 통해 encoding을 처리
				request.setCharacterEncoding("utf-8")
--%>
<%--
[1단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명 요청하여 구매갯수와 물건명 출력
[2단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명의 가격을 계산하여 총가격 출력하세요
[3단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명과 가격 구매갯수 총계가 계산 되게 하세요.

[1단계:확인] 7. post 방식으로 월드컵 A조의 팀명과 점수를 입력하고 현재 대전 결과를 출력하세요.
                     팀1    팀2 
                팀명[   ]  [    ]
                점수[   ]  [    ]
                      [결과] 
                    @@@ vs @@@
                      1 - 2
                      @@@ 승
--%>
<%-- 7 --%>
<h2>월드컵 결과</h2>
<form  method="post">
	<table>
		<tr><th></th><th>팀1</th><th>팀2</th></tr>
		<tr><th>팀명</th><td><input type="text" name="tname"></td>
						<td><input type="text" name="tname"></td></tr>
		<tr><th>점수</th><td><input type="text" name="point" value="0"></td>
						<td><input type="text" name="point" value="0"/></td></tr>
		<tr><td colspan="3"><input type="submit" name="결과"></td></tr>				
	</table>
</form>
<%
	String tnames[] = request.getParameterValues("tname");
	String points[] = request.getParameterValues("point");
	
	// 나중에 예외처리 알아서 하삼
	if(tnames!=null){
		out.print(tnames[0]+" vs "+tnames[1]+"<br>");
		out.print(points[0]+" : "+points[1]+"<br>");
		
		int pt1 = Integer.parseInt(points[0]);
		int pt2 = Integer.parseInt(points[1]);
		
		String result = "무승부";
		if(pt1>pt2) result = tnames[0]+" 승";
		if(pt1<pt2) result = tnames[1]+" 승";
		out.print(result);
	}
	
%>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>