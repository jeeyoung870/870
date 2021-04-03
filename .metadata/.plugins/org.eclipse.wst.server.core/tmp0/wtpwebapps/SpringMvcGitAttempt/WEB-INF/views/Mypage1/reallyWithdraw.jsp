<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<style type="text/css">
div{font-family: Noto Sans KR; width: 420px; margin:0 auto;}
</style>
</head>
<body>
<div>
정말로 탈퇴하시겠습니까? 게시글은 안지워지고 어쩌구저쩌구...<br>
<a href="leavesure">네</a><br> 
<a href="usersetting">아니오</a><br>

</div>
</body>
</html>