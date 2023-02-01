<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="ymw.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜꽁</title>
<link rel="stylesheet" href="../index_markup/reset.css">
<style type="text/css">

    /* ㅇㅇ */
    .content{
        width: 100%;
        min-height: 500px;
        background-color: #fff;
    }


</style>

<script type="text/javascript">
	console.log("내용1")
</script>
</head>
<body>

<div class="wrapper">
    <header>
        <h1 class="logo"><img src="../index_markup/img/main_logo.png" alt=""></h1>
         <nav class="gnb">
            <ul>
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
            </ul>
         </nav>
    </header>
    <style>
    	.content{
        width: 100%;
        min-height: 500px;
        padding: 0px 10px;
        background-color: #fff;
	    }
	    .sch{
	    		padding-top:10px;
	    		display:flex;
	    	}
	   	.schBtn>button{
	  		width: 40px;
		    height: 40px;
		    border: 1px solid gray;
		    border-radius: 9px;
		    cursor:pointer;
	   	}
	   	.schInp{
	   		width: 100%;
		    height: 40px;
		    margin-left: -1px;
		    border: 1px gray solid;
		    border-radius: 0px 6px 6px 0px;
		    background: white;
	   	}
	   	.schInp>input{
	   		padding: 0px 10px;
		    width: 93%;
		    height: 100%;
		    border: none;
	   	}
	   	h3,h5{
	   		padding-top: 10px;
	   	}
	   	.recKeyword{
	   		display:flex;
	   		justify-content: flex-start;
	   		gap: 10px;
	   	}
	   	.recKeyword>li{
	   		border:1px solid gray;
	   		background:white;
	   		padding: 5px;
	   		border-radius: 10px;
	   	}
	   	.popSch>li{
	   		padding: 0px 0px 7px 25px;
	   	}
	   	.schInp>button{
	   		background-color: black;
		    color: white;
		    padding: 3px;
		    border-radius: 9px;
		    text-align: center;
		    cursor:pointer;
	   	}
	   	input[type=text]:focus{
	   		outline:none;
	   	}
	   	.appKind{
	   		padding-top: 20px;
	   	}
		.appKind>ul{
			padding-top:10px;
			display:flex;
			gap: 10px;
		}
		.arrKind>ul{
			padding-top: 10px;
			display: flex;
			gap: 10px;
			align-items: flex-start;
			flex-direction: column;
			flex-wrap: wrap;
			align-content: flex-end;
			padding-right: 20px;
		}
		.appKind>ul>li{
			border: 2px solid #601986;
			padding:3px;
			border-radius: 9px;
			font-weight: 600;
			cursor:pointer;
		}
		.arrKind{
			display: flex;
	    	align-items: flex-end;
		}
		.arrKind>select{
			width: 100px;
		    font-size: 15px;
		    font-weight: 900;
		    border: 2px solid #601986;
		    border-radius: 9px;
		    height: 30px;
		}
		.storeInfo{
			display: flex;
			padding-top: 20px;
			flex-wrap: wrap;
			justify-content: space-between;
		}
		.storeInfoDiv{
			width:200px;
			padding-bottom:20px;
		}
		.storeInfo img{
			width:200px;
			height:150px;
		}
		header{
			position: sticky;
			top: 0;
		}
	
		.sch_wrapper{
			position: sticky;
		    top: 46px;
		    background: white;
		}
		.arr{
			display:flex;
			justify-content: space-between;
		}
		.asss{
			height:1000px;
		}
		.scrollMenu{
			display:flex;
			justify-content: space-around;
		}
		.scrollMenu>div{
		    border: 2px solid #601986;
		    border-radius: 9px;
		    padding: 10px;
		    cursor: pointer;
		}
		.menu{
			display: flex;
    		gap: 10px;
		}
		.menuImg img{
			width:150px;
			height:100px;
		}
		.menuInfo {
		    display: flex;
		    flex-direction: column;
		    justify-content: space-between;
		    padding-top: 4px;
		}
		.menuInfo>span:nth-child(2){
			color:red;
		}
		.allMenu{
			padding-top: 10px;
			display: flex;
			flex-direction: column;
			gap: 20px;
		}
		.show{
			display:flex;
			justify-content: center;
			padding: 20px 0px;
		}
		.show>button{
		    padding: 6px;
		    border: 2px solid #601986;
		    border-radius: 9px;
		    background: white;
		    font-size: 14px;
		    font-weight: 900;
		    cursor: pointer;
		}
		.storeImg>img{
			width:100%;
			height:150px;
		}
		.reviews{
			display: flex;
			flex-direction: column;
		}
		.reviews>div{
			display: flex;
			flex-direction: column;
			padding-top: 30px;
			gap: 3px;
		}
		.reviews span{
			font-size: 14px;
			color: darkgray;
		}
		.storeInformation1{
			padding-top:20px;
		}
		.storeInformation2{
			display: flex;
			gap: 20px;
		}
		.storeInformation2>div{
			display: flex;
			flex-direction: column;
			gap: 10px;
		}
		.pickList{
			padding-top:20px;
		}
		.pickList>ul{
			display:flex;
			justify-content: space-evenly;
		}
		.pickList>ul>li{
			padding: 4px;
			border: 1px solid black;
			border-radius: 9px;
		}
		.resBar{
       		background: white;
		    position: sticky;
		    bottom: 0px;
		    padding: 30px 0px;
       	}
       	.resList{
       		display: flex;
   			justify-content: space-around;
       	}
       	.resList>div{
   		    font-size: 30px;
		    border: 1px solid #601986;
		    padding: 8px;
		    background: #601986;
		    border-radius: 8px;
		    color: white;
		    cursor: pointer;
       	}
       	.revAndCnt{
   			display: flex;
   		}
   		.revAndCnt img{
   			width:15px;
   			height:15px;
   		}
   		.scoAndCnt{
   			padding-left:10px;
   		}
   		.star{
			display:flex;
			gap:2px;
		}
		.star img{
			width:15px;
			height:15px;
			margin-top:1px;
		}
    </style>
<script type="text/javascript">
	console.log("내용2")
</script>    
    <section>
        <div class="content">
        	<div class="sch_wrapper">
	        	<div class="sch">
	        		<div class="schBtn">
	        			<button type="button" onclick="back()">이전</button>
	        		</div>
	        	</div>
        	</div>
        	<jsp:useBean id="schList" class="ymw.dao.StoreInfo" scope="session"/>
        	<c:set var="store" value="${schList.detailStore(param.snum) }"/>
        	<c:set var="storeR" value="${schList.StoreReview(param.snum) }"/>
        	<div class="storeImg">
        		<img src="data:image/jpeg;base64,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">
        	</div>
        	<h3>${store.res_name }</h3>
        	<h5>${store.res_address }</h5>
        	<h5 class="revAndCnt">
        	<c:set var="starCnt" value="0"/>
			<c:forEach var="i" begin="1" end="${storeR.sco }">
				<c:set var="starCnt" value="${i }"/>
				<span><img src="https://cdn-icons-png.flaticon.com/512/956/956100.png"></span>
			</c:forEach>
			<c:forEach var="i" begin="1" end="${5-starCnt }">
				<c:set var="starCnt" value="${i }"/>
				<span><img src="https://cdn-icons-png.flaticon.com/512/1828/1828970.png"></span>
			</c:forEach>
			<span class="scoAndCnt">${storeR.sco } (${storeR.cnt})</span>
			</h5>
        	<%--<h5><img width="12px" height="12px" src="https://cdn-icons-png.flaticon.com/512/956/956100.png"></h5>--%>
        	<br><hr><br>
        	<div class="scrollMenu">
        		<div class="allMenuSc">전체메뉴</div>
        		<div class="allMenuSc">리뷰</div>
        		<div class="allMenuSc">매장정보</div>
        	</div>
        	<br><hr><br>
 <script type="text/javascript">
	console.log("내용3")
</script>       	
        	<div class="sc1">	<%-- 메뉴 div --%>
        		<h3>전체메뉴</h3>
        		<div class="allMenu">
        		<c:set var="menuArray" value="${fn:split(schList.StoreMenu(param.snum).menuname,'/')}" />
        		<c:set var="priceArray" value="${fn:split(schList.StoreMenu(param.snum).price,'/')}" />
        		<c:set var="doneLoop" value="false" />

        		<c:forEach var="g" begin="0" end="${fn:length(menuArray)-1}" varStatus="status">
        			<c:if test="${not doneLoop }">
        				<div class="menu">
		        			<div class="menuImg">
		        				<img src="data:image/jpeg;base64,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">
		        			</div>
		        			<div class="menuInfo">
		        				<span>${menuArray[g]}</span>
		        				<span>${priceArray[g] }원</span>
		        				<span></span>
		        			</div>
		        		</div>
	        			<c:if test="${g>=1 }">
					        <c:set var="doneLoop" value="true" />
					    </c:if>
					</c:if>
        		</c:forEach>
       			</div>
       			<div class="show">
       				<button>메뉴 전체보기</button>
       			</div>
       			<br><hr><br>
       		</div>
       		<div class=sc2>	<%-- 리뷰 div --%>
       			<h3>리뷰 <span>${storeR.cnt}</span></h3>
       			<div class="reviews">
       			<%-- 123-45-67895 
       			http://localhost:7080/ymw/pg0012.jsp?resnum=123-45-67895
       			
       			--%>

       			<c:set var="reviews" value="${schList.userReview(param.resnum)}" />
        		<c:set var="doneLoop" value="false" />

        		<c:forEach var="g" begin="0" end="${fn:length(reviews)-1}" varStatus="status">
        			<c:if test="${not doneLoop }">
        				<div class="menu">
		        			<div>
		       					<div class="star">
		       						<c:if test="${fn:length(reviews)>0}">
		       						<c:set var="starCnt" value="0"/>
				        				<c:forEach var="i" begin="1" end="${reviews[g].star_sco }">
				        					<c:set var="starCnt" value="${i }"/>
				        					<span><img src="https://cdn-icons-png.flaticon.com/512/956/956100.png"></span>
				        				</c:forEach>
				        				<c:forEach var="i" begin="1" end="${5-starCnt }">
				        					<c:set var="starCnt" value="${i }"/>
				        					<span><img src="https://cdn-icons-png.flaticon.com/512/1828/1828970.png"></span>
				        				</c:forEach>
			       						 ${reviews[g].star_sco }
			       					</c:if>
		       					</div>
		       					<div>
		       						<span>${reviews[g].nickname }</span>
		       					</div>
		       					<div>
		       						${reviews[g].review_content }
		       					</div>
		       				</div>
		        		</div>
	        			<c:if test="${g>=2 }">
					        <c:set var="doneLoop" value="true" />
					    </c:if>
					</c:if>
        		</c:forEach>
       			</div>
       			<div class="show">
       				<button>리뷰 더보기</button>
       			</div>
       		</div>
<script type="text/javascript">
	console.log("내용4")
</script>       		
       		<div class=sc3>	<%-- 매장정보 div --%>
       			<h3>영업정보</h3>
       			<div class="storeInformation1">
       				<div class="storeInformation2">
       					<div>
       						<span>운영시간</span>
       						<span>휴식시간</span>
       						<span>휴무일</span>
       						<span>전화번호</span>
       						<span>보증금</span>
       					</div>
       					<div>
       						<span>${store.business_hours }</span>
       						<span>${store.day_off }</span>
       						<span>${store.break_time }</span>
       						<span>${store.res_phonenum }</span>
       						<span>${store.deposit }원</span>
       					</div>
       				</div>
       				<div class="show">
       				</div>
       			</div>
<script type="text/javascript">
	console.log("내용5")
</script>         			
       			<h3>매장 Pick</h3>
       			<c:set var="moodArray" value="${fn:split(schList.StoreRespick(param.snum).mood,'/')}" />
       			<c:set var="purposeArray" value="${fn:split(schList.StoreRespick(param.snum).purpose,'/')}" />
       			<c:set var="food_typeArray" value="${fn:split(schList.StoreRespick(param.snum).food_type,'/')}" />
       			<c:set var="table_typeArray" value="${fn:split(schList.StoreRespick(param.snum).table_type,'/')}" />
       			
       			<div class="pickList">
       				<ul>
       				</ul>
       			</div>
       			<div class="show">
   					<button style="border:none">매장 Pick 더보기</button>
   				</div>
       			<h3>편의시설</h3>
       			<div class="pickList">
       				<ul>
       					<c:set var="convenientArray" value="${fn:split(store.convenient,'/')}" />
		        		<c:set var="doneLoop" value="false" />
		
		        		<c:forEach var="g" begin="0" end="${fn:length(convenientArray)-1}" varStatus="status">
		        			<c:if test="${not doneLoop }">
		        				<c:if test="${not convenientArray[g].equals(\"-\") }">
		        					<li>${ convenientArray[g]}</li>
		        				</c:if>
			        			<c:if test="${g>=1 }">
							        <c:set var="doneLoop" value="true" />
							    </c:if>
							</c:if>
		        		</c:forEach>
       				</ul>
       			</div>
       			<div class="show">
   					<button style="border:none">편의시설 더보기</button>
   				</div>
       		</div>
       	<c:set var="waiting" value="${schList.detailStore(param.snum).waiting}" />
       	<c:set var="reservation" value="${schList.detailStore(param.snum).reservation}" />
        <div class="resBar">
        	<div class="resList">
        		<div class="waiting">
        			원격 줄서기
        		</div>
        		<div class="reservation">
        			즉시 예약
        		</div>
        	</div>
        </div>
   		</div>
   		
    </section>
<script type="text/javascript">
	console.log("내용5")
</script>    
    <footer>
        <nav class="footer_nav">
            <ul>
                <li><a href="#">서비스 이용약관</a></li>
                <li><a href="#">개인정보 처리방침</a></li>
                <li><a href="#">제휴 문의</a></li>
                <li><a href="#">채용 공고</a></li>
            </ul>
        </nav>
        <p class="jjim_info">
            (주) 찜꽁<br>
            대표 : 이지원<br>
            주소 : 서울특별시 마포구 월드컵북로 21 2층 풍성빌딩<br>
            사업자등록번호 : 202212142126<br>
            개인정보담당 : service@jjimggong.co.kr
        </p>

    </footer>
</div>
<script type="text/javascript">
	console.log("내용6")
</script>	
	<%-- 원격줄서기 
	http://localhost:7080/ymw/pg0012.jsp?resnum=123-45-67895&snum=123-45-67895
	param.snum >> resnum으로 통일
	
	--%>
	<jsp:useBean id="dao" class="ljw.WaitingDao"/>			
	<c:set var="countResnum" value="${dao.countWaiting(param.snum)}"/>
	countResnum:${ countResnum}
	
	
<script type="text/javascript">
console.log("내용2")


	var waiting = document.querySelector(".waiting")
	console.log(waiting)
	var reservation = document.querySelector(".reservation")
	if(${waiting}==0){
		waiting.style.background="lightgray";
		waiting.style.color = "gray";
		waiting.style.border = "none";
		waiting.style.cursor = "default";
	}
	if(${waiting}==1){
		waiting.onclick = function(){
			location.href="https://www.naver.com"
		}
	}
	if(${reservation}==0){
		reservation.style.background="lightgray";
		reservation.style.color = "gray";
		reservation.style.border = "none";
		reservation.style.cursor = "default";
	}
	if(${reservation}==1){
		reservation.onclick = function(){
			location.href="https://www.naver.com"
		}
	}
	let pList = [];
	<c:forEach var="mood" items="${moodArray}" varStatus="status">
		if("${mood}"!="-"){
			pList.push("${mood}");
		}
	</c:forEach>
	<c:forEach var="purpose" items="${purposeArray}" varStatus="status">
		if("${purpose}"!="-"){
			pList.push("${purpose}");
		}
	</c:forEach>
	<c:forEach var="food_type" items="${food_typeArray}" varStatus="status">
		if("${table_type}"!="-"){
			pList.push("${food_type}");
		}
	</c:forEach>
	<c:forEach var="table_type" items="${table_typeArray}" varStatus="status">
		if("${table_type}"!="-"){
			pList.push("${table_type}");
		}
		
	</c:forEach>
	var pickList = document.querySelector(".pickList>ul")
	pList.forEach(function(pick,idx){
		if(idx<=2){
			pickList.innerHTML += "<li>"+pick+"</li>"
		}
	})
	var allMenuSc = document.querySelectorAll(".allMenuSc")
	var morePage = document.querySelectorAll(".show")
	morePage.forEach(function(page,idx){
		page.onclick = function(){
			if(idx==0){
				location.href="./pg0013.jsp?snum=${param.snum }"
			}
			else if(idx==1){
				location.href="./pg0014.jsp?snum=${param.snum }"
			}
			else if(idx==2){
				location.href="./pg0015.jsp?snum=${param.snum }"
			}
			else if(idx==3){
				location.href="./pg0016.jsp?snum=${param.snum }"
			}
			else if(idx==4){
				location.href="./pg0017.jsp?snum=${param.snum }"
			}
		}
	})
	function back(){
		history.back()
	}
	allMenuSc.forEach(function(sc,idx){
		sc.onclick = function(){
			var location1 = document.querySelector(".sc"+(idx+1)).offsetTop;
			window.scrollTo({top:location1-96, behavior:'smooth'});
		}
	})
	
	
	//원격줄서기Tab
	/*
	var aplyrmtline = document.querySelector("#rmtlineletsgo");
	aplyrmtline.addEventListener("click", function(){
			var result = confirm("대기인원 ${countResnum}명/t 예상대기시간/t ${5+countResnum*5}분/n원격줄서기를 신청하시겠습니까?")
			if(result==true){
				location.href="../ljw/pg3004.jsp?resnum=${param.snum}";
			}
	*/
	
	waiting.onclick = function(){
		alert('줄서기');
		
	
      var result = confirm("대기인원 ${countResnum}명/n 예상대기시간/t ${5+countResnum*5}분/n 원격줄서기를 신청하시겠습니까?")
      if(result==true){
    	  location.href="/ljw/pg3004.jsp?resnum=${param.snum}&=${countResnum}";
      }
   }	
</script>

</body>


</html>