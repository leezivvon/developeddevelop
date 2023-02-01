<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    
    import="ymw.*"
    import="jyh.model.*"
    import="jds.*"
    import="hjw.*"
    import="ljw.*" 
    import="ljw.vo.*" 
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>찜꽁</title>

<link rel="stylesheet" href="/index_markup/reset.css"/>
<style type="text/css">

 	/* ㅇㅇ */
	.content{
	    width: 100%;
	    background-color: #fff;
	}
</style>


</head>
<body>

	
	<%-- 가게/신청정보 출력 --%>
	<jsp:useBean id="dao" class="ljw.WaitingStoreDao"/>
	<c:set var="store" value="${dao.firstWaiter('123-45-67890')}"/><%--가게세션값--%> 
	

	<section>
        <div class="content">
        	<div>
        		<ul>
        			<li>입장대기자의 대기번호</li>
        			<li>${store.waitingNum}</li>
        			<li>고객정보</li>
        			<li>${store.nickname}&nbsp;님</li>
        			<li>${store.waitingPerson }&nbsp;명 입장 예정</li>
        			<li>신청시간&nbsp;${store.wstarttime }</li>
        		</ul>	
        	</div>
       	
        	<div>
        		<div id="enter">입장하기</div>
        		<div id="noenter">입장취소</div>
        	</div>
        </div>
    </section>

</body>
<script type="text/javascript">
	var enterButton = document.querySelector("#enter")
	var noenterButton = document.querySelector("#noenter")
	
	//현재날짜
	var today = new Date();
	var wdate = today.getFullYear()+"/"+(today.getMonth()+1)+"/"+(today.getDate())

	
	enterButton.onclick=function(){
		var xhr = new XMLHttpRequest()
		alert("${store.userEmail}")
		xhr.open("get", "pg3007_enterO.jsp?userEmail=${store.userEmail}&wstarttimeS="+wdate, true)
		xhr.send()
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				alert("${store.nickname} 님이 입장합니다")
				location.href = location.href;//새로고침
			}
		}
	}
	
	noenterButton.onclick=function(){
		var xhr = new XMLHttpRequest()
		xhr.open("get", "pg3007_enterX.jsp?userEmail=${store.userEmail}&wstarttimeS="+wdate, true)
		xhr.send()
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				alert("${store.nickname} 님이 입장취소되었습니다")
				location.href = location.href;//새로고침
			}
		}
	}
</script>
</html>