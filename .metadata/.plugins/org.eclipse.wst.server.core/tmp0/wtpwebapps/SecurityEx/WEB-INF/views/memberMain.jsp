<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>멤버 메인</title>
</head>
<body>
<!-- member/main 요청에 대한 뷰페이지 -->
멤버(연결 계정: <sec:authentication property="name"/>) 메인 화면입니다.
<a href="<c:url value='/index'/>">[/index로 이동]</a>
</body>
</html>