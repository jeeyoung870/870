<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href = "${contextPath}/community/goBoard">GoToBoard</a>
	<a href = "${contextPath}/timeLine1/goHilslinderMain">goToHilsLinder</a>
	<a href = "${contextPath}/customerService/goOneOneForm">gotoOneOneForm</a>
	<a href = "${contextPath}/customerService/goCheckOneOne">goCheckOneOne</a>
	<a href = "${contextPath }/timeLine1/goHilslinderCal">gotoHilsCalendar</a>
</body>
</html>