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
<!DOCTYPE html>

<%-- 가게 세션  받고 --%>

 	<jsp:useBean id ="enOdao" class="ljw.WaitingStoreDao"/>
	<jsp:useBean id ="enO" class="ljw.vo.WaitingStore"/>
	
	
	${enO.setUserEmail(param.userEmail) }
	${enO.setResnum('123-45-67890') } <%-- 가게 세션입력 --%>
	${enO.setWstarttimeS(param.wstarttimeS) }
	
	${enOdao.enterWStore(enO) }
