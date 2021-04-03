<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
	
	
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>타임라인</span><hr>
</div>
</body>
</html>