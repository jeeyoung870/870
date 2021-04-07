<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>홈 메인</title>
</head>
<body>
<!-- home/main 요청에 대한 뷰페이지 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="name"/> 님, 
</sec:authorize>
홈 메인 화면입니다.
<a href="<c:url value='/index'/>">[/index로 이동]</a>
</body>
</html>