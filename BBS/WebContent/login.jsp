<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--어느 환경에서도 자동으로 레이아웃을 맞춰주는 반응형 메타태그-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<nav class="navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<!--우측상단 아이콘의 짝대기 세개 만들기-->
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹사이트</a>
		</div>
		<!-- button의 target위치와 같은 id를 가진 div생성 -->
		 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		 	<ul class="nav navbar-nav">
		 		<li><a href="main.jsp">메인</a></li>
		 		<li><a href="bbs.jsp">게시판</a></li>
		 	</ul>
		 	<ul class="nav navbar-nav navbar-right">
		 		<li class="dropdown">
		 			<!-- # : 현재 가리키는 링크가 없음을 의미 -->
		 			<a href="#" class="dropdown-toggle"
		 				data-toggle="dropdown" role="button" aria-haspopup="true"
		 				aria-expanded="false">접속하기<span class="caret"></span></a>
		 		</li>
		 	</ul>
		 </div>
	</nav>
	<script src="https://code.jquery-3.1.1.min.js"></script>
	<!--Webcontent-js의 bootstrap.js파일 참조-->
	<script src="js/bootstrap.js"></script>
</body>
</html>