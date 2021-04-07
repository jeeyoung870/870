<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<%
	String dormancy_id = request.getParameter("id");
%>
<html>
<head>
</style>
<meta charset="EUC-KR">
<title>신고하기</title>
</head>
<body>
<form action=userDormancy method="POST" class="form">
				# 아이디 " <%= dormancy_id %> " 님을 휴면 설정합니다.<br/> 
				<input
					type="hidden" name="user_id" value="<%= dormancy_id %>">
				<a></a>
					<button class="btn btn-danger" type="submit" id="submit">휴면 설정하기</button>
</form>
</body>
</html>