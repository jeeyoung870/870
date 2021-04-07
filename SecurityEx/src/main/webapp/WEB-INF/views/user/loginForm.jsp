<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
<c:if test="${param.error == 'true' }">
<strong>아이디와 암호가 일치하지 않습니다.</strong>
</c:if>
<form action="<c:url value='/user/login'/>" method="post">
	<label for="name">사용자ID</label>:
    <input type="text" name="userid" /> 
    <br/>
    
    <label for="password">암호</label>:
    <input type="password" name="password" /> 
    <br/>
    <!-- 인증토큰 같이 전송 -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="submit" value="로그인" />
</form>
</body>
</html>