<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"	%>

<%-- 
ex) a04_reqSynch.html 
	z04_data.jsp
	물건명[  ] 가격[   ] 개수[  ]
	[구매]
	
	@@@를 @@@(총계)에 구매하셨습니다. 출력
--%>

"${param.pname }", ${param.price }원을  ${param.cnt }개 구매하셔서
 총 ${param.price*param.cnt} 원에 구매하셨습니다 
<%-- 요청값을 받아서 위 형식으로 만들어 다시 client로 전달 --%>  
