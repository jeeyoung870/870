<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 완료</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<style type="text/css">
div{font-family: Noto Sans KR; }
</style>
<style type="text/css">
	body{
		/* width: 420px; margin:0 auto;  */
		font-family: Noto Sans KR;
	}
	#upper{
		font-size: 22px;
		font-style: medium;
		font-weight: 600; line-height: 52px;
		text-align: center;
	}
	#upper img{position: absolute; left:18px; margin-top:13px; height:27px;}
	#upper hr{ background-color:#FF9A7F; border: 0; height: 20px; }
	
	#goodbye{ line-height:28px; width: 380px; margin:0 auto; }
	.frmbtn{ width:90px; height:35px; color:white; background-color:#FF3600;
		border:0; margin-left:145px; border-radius: 1em;}
	.frmbtn > a { color:white; }
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>탈퇴 완료</span><hr>
</div>
<div id="goodbye">
<br>지금까지 HILS를 이용해주셔서 감사합니다.<br><br>
<button class="frmbtn" ><a href="main">메인으로</a></button>

<br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
<script>
$(document).ready(function() {
	//로그아웃
	sessionStorage.clear();
}
</script>
</html>