<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 
    import="jspexp.a13_database.*"
   %>
<%-- 
jspexp.a13_database.A06_PareparedDao    checkId
데이터가 있으면 true, 없으면 false

{"hasMember":true}
{"hasMember":flase}
--%>   
<jsp:useBean id="dao"  class="jspexp.a13_database.A06_PareparedDao"></jsp:useBean>
{"hasMamber":${dao.checkId(param.id) }}
