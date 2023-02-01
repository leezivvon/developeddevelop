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
.selectBox2 * { box-sizing: border-box; }
.selectBox2 {
  position: relative;
  width: 150px;
  height: 35px;
  border-radius: 4px;
  border: 2px solid lightcoral;
  background: url('https://freepikpsd.com/media/2019/10/down-arrow-icon-png-7-Transparent-Images.png') calc(100% - 7px) center no-repeat;
  background-size: 20px;
  cursor: pointer;
}

.selectBox2:after {
  content: '';
  display: block; 
  width: 2px;
  height: 100%; 
  position: absolute; 
  top: 0; 
  right: 35px;
  background: lightcoral;
}

.selectBox2 .label {
  display: flex;
  align-items: center;
  width: inherit;
  height: inherit;
  border: 0 none;
  outline: 0 none;
  padding-left: 15px;
  background: transparent;
  cursor: pointer;
}

.selectBox2 .optionList {
  position: absolute; 
  top: 28px;
  left: 0;
  width: 100%;
  background: lightcoral;
  color: #fff;
  list-style-type: none;
  padding: 0;
  border-radius: 6px;
  overflow: hidden;
  max-height: 0;
  transition: .3s ease-in;
}

.selectBox2.active .optionList {
  max-height: 500px;
}

.selectBox2 .optionItem {
  border-bottom: 1px dashed rgb(170, 72, 72);
  padding: 5px 15px 5px;
  transition: .1s;
}

.selectBox2 .optionItem:hover {
  background: rgb(175, 93, 93);
}

.selectBox2 .optionItem:last-child {
  border-bottom: 0 none;
}


</style>
</head>
<body>

<div class="selectBox2 ">
  <button class="label">fruits 🍊</button>
  <ul class="optionList">
    <li class="optionItem">apple</li>
    <li class="optionItem">orange</li>
    <li class="optionItem">grape</li>
    <li class="optionItem">melon</li>
  </ul>
</div>

</body>
<script>
/* 일반함수 */
var label = document.querySelector('.label');
var options = document.querySelectorAll('.optionItem');
// 클릭한 옵션의 텍스트를 라벨 안에 넣음
var handleSelect = function(item) {
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


</script>
</html>