<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    import="jspexp.vo.*"  
    import="jspexp.a13_database.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<style>
	.selectBox1 * { 
		box-sizing:border-box;
		list-style:none;
	}
	.selectBox1{
		position:relative;
		width: 110px;
		height: 32px;
		border-radius:16px;
		border:2px solid #da6e85;
		background: url('../index_markup/img/select_arrow.png') no-repeat 92% 50%;
		background-size:12px;
		margin-right:10px;
	}
	.selectBox1 .label{
		border:none;
		line-height:32px; /* 가로 정렬은 이게 제일 쉬운 듯 */
		background:transparent;
		margin-left:11px;
		font-weight:600;
	}
	.selectBox1>.optionList{
		position:absolute;
		top:32px;
		width:100%;
		background:#da6e85;
		color:#333;
		border-radius:16px;
		
	}

	.selectBox1>.optionList>.option{
 		border-bottom:1px dashed #fff; 
		padding: 5px 10px;
		font-size:14px;
	}
	.selectBox1>.optionList>.option:last-child{
		/* 마지막 줄은 삭제 */
		border-bottom:none;
	}
	
	.selectBox1>.optionList>li:hover{
		
		background:#92263D;
		color:#fff;
	}
    

</style>
</head>
<body>


<div class="selectBox1">
	<button class="label">가게 정렬</button>
	<ul class="optionList">
		<li class="option">가까운 순</li>
		<li class="option">평점 높은 순</li> <%-- 별점 높은 순으로 수정할 수도 有 --%>
		<li class="option">리뷰 많은 순</li>
	</ul>
</div>

</body>
<script>
/* 일반함수 */
const label = document.querySelector('.label');
const options = document.querySelectorAll('.optionItem');
// 클릭한 옵션의 텍스트를 라벨 안에 넣음
const handleSelect = function(item) {
  label.innerHTML = item.textContent;
  label.parentNode.classList.remove('active');
}
// 옵션 클릭시 클릭한 옵션을 넘김
options.forEach(function(option){
  option.addEventListener('click', function(){handleSelect(option)})
})
// 라벨을 클릭시 옵션 목록이 열림/닫힘
label.addEventListener('click', function(){
  if(label.parentNode.classList.contains('active')) {
    label.parentNode.classList.remove('active');
  } else {
    label.parentNode.classList.add('active');
  }
});
결과

</script>
</html>