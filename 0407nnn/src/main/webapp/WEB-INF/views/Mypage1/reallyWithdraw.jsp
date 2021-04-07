<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
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
	
	#reallyWithdraw{ line-height:28px; width: 380px; margin:0 auto; }
	.textbox{ width:250px; height:40px; font-size:15px;
		font-family: Noto Sans KR;font-weight:400; border: 2px solid #FF3600;
		padding-left:8px;margin-bottom:5px;}
	.frmbtn{ width:90px; height:35px; color:white; background-color:#FF3600;
		border:0; border-radius: 1em; }
	.frmbtn > a { color:white; }
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>회원 탈퇴</span><hr>
</div>
<div id="reallyWithdraw">
<br>
정말로 탈퇴하시겠어요?<br>
작성하신 게시글은 삭제되지 않으니, 신중하게 결정해<br>주세요.<br><br>
<button class="frmbtn" style="margin-left:90px;">
<a href="leavesure?user_id=${user_id }">탈퇴</a></button>
&nbsp;&nbsp;
<button class="frmbtn" ><a href="usersetting">탈퇴 취소</a></button><br>

<br><br><br><br><br><br><br><br><br><br><br>

</div>
</body>
</html>