<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
   	import="jspexp.vo.*"  
    import="jyh.model.*"
    import="hds.*"
    import="ymw.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즉시 예약</title>
<link rel="stylesheet" href="/index_markup/reset.css">
<style type="text/css">

    /* ㅇㅇ */
    .content{
        width: 100%;
        background-color: #fff;
    }
    
    /* 지원 */   
	nav.searchmenu{
		width: 100%;
		background-color: #fff;
		display: block
	}
	.search {
		padding-top:20px;
		display:flex;
		width:60%;
		margin:0 auto; /* 가운데정렬 */
		justify-content: center; /* 가운데정렬 */
	}

	nav.searchmenu>.search>form>input[type=text]{
		background-color:#E1E5F2;
		height:40px;
		border-radius:12px 0px 0px 12px;
		border:none;
		display:block;
		padding-left:20px;
		width:300px;
	}
	
	nav.searchmenu>.search>form>input[placeholder]{
		color:#4C4C47;
		font-size:12px;
		font-weight:400;
	}
	nav.searchmenu>.search>form>button{
		background-color:#E1E5F2;
		height:40px;
		width:40px;
		border:none;
		display:none;
	}
	nav.searchmenu>.search>div>button{
		background-color:#E1E5F2;
		height:40px;
		width:40px;
		border-radius:0px 12px 12px 0px;
		border:none;
	}
	nav.searchmenu>.search>div>button>img{
		height:20px;
		width:20px;
	}
	nav.searchmenu>.menu{
		display:flex;
	    justify-content:center;
	    gap:60px;
	    padding-top:20px;
	    padding-bottom:20px;
	    font-size:18px;
	    font-weight:800;
	    color:#4C4C47;
	}
	nav.searchmenu>.menu>li:hover{
		color:#601986;
	}
	#choice{
		color:#601986;
		font-weight:900;
	}
	
    .myloc{
    	display:flex;
	    justify-content:center;
	    background-color:#E1E5F2;
	    width:100%;
	    height:25px;
    }
    .myloc>input[type="text"]{
	    background-color:#E1E5F2;
	    border:none;
	    margin:0px auto;
	    width:70%;
    }
    .myloc>input[placeholder]{
		color:#4C4C47;
		font-size:12px;
		font-weight:400;
		text-align:center;
	}


	.storeInfo2{
		display:flex;
		padding:20px;
		flex-wrap:wrap;
		justify-content:space-between;
	}
	.storeInfo2>.storeInfoDiv2{
		width:200px;
		padding-bottom:20px;
	}
	.storeInfo2>.storeInfoDiv2>.storeImage{
		width:100%;
		height:100px;
		border-radius:5px;
		border:0.5px solid #4C4C47;
	}
	.storeInfo2>.storeInfoDiv2 img{
		display:block;
		height:98.5px;
		margin:0 auto;
	}
	.storeInfo2>.storeInfoDiv2>.storeDetail{
		color:#333;
		padding-top:5px;
		padding-left:3px;
	}
	
	/* 상단 고정 */
	header{
		position:sticky;
		top:0;
		z-index:999;
	}
	nav.searchmenu{
		position:sticky;
		top:46px;
		z-index:999;
		background-color:#fff;
	}
	
	/* select */
	select{
		-webkit-appearance: none;
 		-moz-appearance: none;
		appearance: none;
	}
	/* IE에서 화살표 제거 */
	select::-ms-expand{
		display:none;
	}
	.array{
		display:flex;
		flex-flow:row-reverse;
		padding-top:10px;
		gap:10px;
	}
	.selectBox * { box-sizing:border-box; color:#333;}
	.selectBox{
		width: 180px;
		height: 32px;
		border-radius:16px;
		border:2px solid #601986;
		background: url('../index_markup/img/select_arrow.png') no-repeat 92% 50%;
		background-size:12px;
		margin-right:10px;
		text-align: center;
		padding-right: 13px;
	}
	
	input:focus {outline: none};
	select:focus {outline: none};
    
    /*
    솜 css
    */
    
    
    
</style>
</head>
<body>
<%
     memberDTO loginUser = (memberDTO)session.getAttribute("sesID");
  %>

<div class="wrapper">
    <c:if test="${empty sesID }">
       <header class="head1">
           <h1 class="logo"><a href="/ljw/pg0000.jsp"><img src="/index_markup/img/main_logo.png" alt=""></a></h1>
            <nav class="gnb">
               <ul>
                   <li><a href="/jyh/views/login.jsp">로그인</a></li>
                   <li><a href="/jyh/views/insertMember.jsp">회원가입</a></li>
               </ul>
            </nav>
       </header>
    </c:if>
    <c:if test="${not empty sesID }">
       <header class="head2">
        <h1 class="logo"><a href="/ljw/pg0000.jsp"><img src="/index_markup/img/main_logo.png" alt=""></a></h1>
         <nav class="gnb">
            <ul>
                <li><a href="/myInfoController"><img src="/index_markup/img/myPageImg.png" alt=""></a></li>
            </ul>
         </nav>
    </header>
    </c:if>
    
    <section>
        <div class="content">
        
        	<nav class="searchmenu">
		    	<div class="search" onclick="location.href='/ymw/pg0001.jsp'"> <!-- .search onclick>>link -->
		    		<form>
		    			<input type="text" placeholder="매장이름을 검색하세요" >
		    			<button type="button"></button>
		    		</form>	
		    		<div>
		    			<button type="button"><img src="../index_markup/img/search_icon.png" alt=""></button>
		    		</div>
		    	</div>
		    	<ul class="menu">
		    		<li id="choice" onclick="location.href='/hds/res_index.jsp'" >즉시예약</li>
		    		<li onclick="location.href='/ljw/pg3001.jsp'">원격줄서기</li>
		    		<li onclick="location.href='/ljw/pg3005.jsp'">주문현황</li>
		    	</ul>
		    </nav>
		    
	    	<div class="myloc">
	    		<input type="text" placeholder="현재 위치를 입력하세요"/>
	    	</div>
	    	
	    	<div class="array">
	    		<select class="selectBox">
	    			<option class="option">별점 높은 순</option>
	    			<option class="option">리뷰 많은 순</option>
	    			<option class="option">현재 위치와 가까운 순</option>  		
	    		</select>
	    	</div>
	    	
	    	<style>
	    	
	    		.res_info_wrapper{
	    			display: flex;
	    			flex-wrap: wrap;
	    			justify-content: space-evenly;
	    		}
	    	
	    		.res_info_box{
	    			width:200px;
	    			margin: 20px 0;
	    			padding-top: 20px;
	    			border: 1px solid #601986;
	    			border-radius: 10px;
	    		}
	    		
	    		.img_box{
	    			background-color: red;
	    			margin: auto;
	    			width: 120px;
				    height: 120px;
	    		}
	    		
	    		.text_box{
	    			margin: 20px 0;
			    	padding-left: 20px;
			    	font-family: inherit;
	    		}
	    		
	    		.info_title{
	    			font-size: 20px;
	    			font-weight: 600;
	    			cursor: pointer;
	    		}
	    	
	    	</style>
	    	
	    	<div class="res_info_wrapper">
	    		<div class="res_info_box">
	    			<div class="img_box">
	    				<img alt="" src="../index_markup/img/yeondon_img.png">
	    			</div>
	    			<div class="text_box">
	    				<ul>
	    					<li class="info_title" onclick="location.href='pg_1001.jsp?resnum=123-45-67890'">연돈</li>
	    					<li>☆ 5.0</li>
	    					<li>일식</li>
	    					<li>용오로 84</li>
	    				</ul>
	    			</div>
	    		</div>
	    		<div class="res_info_box">
	    			<div class="img_box">
	    				<img alt="" src="../index_markup/img/dowon_img.png">
	    			</div>
	    			<div class="text_box">
	    				<ul>
	    					<li class="info_title" onclick="location.href='pg_1001.jsp?resnum=123-45-67894'">도원</li>
	    					<li>☆ 4.8</li>
	    					<li>중식</li>
	    					<li>토금북로 30</li>
	    				</ul>
	    			</div>
	    		</div>
	    		<div class="res_info_box">
	    			<div class="img_box">
	    				<img alt="" src="../index_markup/img/heajang_img.png">
	    			</div>
	    			<div class="text_box">
	    				<ul>
	    					<li class="info_title" onclick="location.href='pg_1001.jsp?resnum=123-45-67893'">은희네 해장국</li>
	    					<li>☆ 3.2</li>
	    					<li>한식</li>
	    					<li>토금북로 32</li>
	    				</ul>
	    			</div>
	    		</div>
	    		<div class="res_info_box">
	    			<div class="img_box">
	    				<img alt="" src="../index_markup/img/dong_img.png">
	    			</div>
	    			<div class="text_box">
	    				<ul>
	    					<li class="info_title" onclick="location.href='pg_1001.jsp?resnum=123-45-67891'">동화가든</li>
	    					<li>☆ 5.0</li>
	    					<li>한식</li>
	    					<li>토금북로 22</li>
	    				</ul>
	    			</div>
	    		</div>


	    	</div>
        	
        </div>
    </section>
    
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

</body>
<script>
/*

 */
</script>
</html>