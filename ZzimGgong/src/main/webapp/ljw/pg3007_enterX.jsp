<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" 
     
    import="jyh.model.*"
    import="hds.*"
    import="ymw.*"
    import="ljw.*"
    import="ljw.vo.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />

 

 	<jsp:useBean id ="enXdao" class="ljw.WaitingStoreDao"/>
	<jsp:useBean id ="enX" class="ljw.vo.WaitingStore"/>
	
	
	${enX.setUserEmail(param.userEmail) }
	${enX.setResnum('123-45-67890') } <%-- 가게 세션입력 --%>
	${enX.setWstarttimeS(param.wstarttimeS) }
	
	${enXdao.cancelWStore(enX) }