<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- <tiles:importAttribute name="menuList" />
<c:forEach var="menu" items="${menuList}">${menu} </c:forEach>  --%>

<html>
<head>
<link href="${contextPath}/resources/css/static/default.css"
	rel="stylesheet" />
<link href="${contextPath}/resources/css/static/header/header.css"
	rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="${contextPath}/resources/js/static/header/header.js"></script>
<style>
</style>
<script type = "text/javascript">
	var socket = null;

		
	let url = window.location.host;
	//let url = "172.16.3.94:8080"
	let pathname = window.location.pathname;
	let appCtx = "/mvc"
	
	let root = url + appCtx;
		
	socket = new WebSocket("ws://" + root + "/hils/noti");	
	$(document).ready(function(){
		$.ajax({
			url : "sendNoti"
		})
	})
	
	socket.onopen = function(event){
		console.log("connection opened")
	}
	
	socket.onmessage = function(event){
		console.log(event.data)
	}
	socket.onerror = function(event){
		console.log("error occured")
	}
	socket.onclose = function(event){
		console.log("connection closed")
	}

</script>
</head>
<body>
	<header>
		<h2>
			<a href="#"></a>
		</h2>
		<button class="hamburger">&#9776;</button>
		<div class="logo">
			<a href="main">LOGO</a>
			
			<div class = "notification">
				<img src = "${contextPath }/resources/images/notification/ring.png">
			</div>
		</div>
	</header>
	<div class="menu">
		<span><a href="#" class="if1">회원가입 / 로그인</a></span>
		<ul>
			<li>
				<a href="mypage">마이페이지</a>
			</li>
			<li>
				<a href="myalarm">내 알림</a>
			</li>
			<li>
				<a href="myActivitySchedule">나의 활동</a>
			</li>
			
			<li><a href="#" class="iframe">커뮤니티</a>
				<ul class="sub">
					<li><a href = "${contextPath}/community/goBoard">게시판</a></li>
					<li><a href = "#">공지사항	</a>
					<!-- <li><a href="#">test</a></li> -->
				</ul></li>

			<li><a href="#" class="iframe">타임라인</a>
				<ul class = "sub">
					<li><a href ="${contextPath }/timeLine1/goHilslinderCal">힐린더</a>
					<li><a href = "timeline">타임라인	</a>
				</ul>
				<!-- <ul class="sub">
					<li><a href="#">test</a></li>
					<li><a href="#">test</a></li>
					<li><a href="#">test</a></li>
				</ul> -->
				</li>

			<li><a href="custcenter" class="iframe">고객센터</a>
				<ul class = "sub">
					<li><a href = "${contextPath}/customerService/goOneOneForm">1 대 1 문의 하기</a></li>
					<li><a href = "${contextPath}/customerService/goCheckOneOne">1 대 1 문의 내역</a></li>
				</ul></li>
				<!-- <ul class="sub">
					<li><a href="faqview">FAQ1</a></li>
				</ul></li> -->
			<li><a href="#" class="iframe">(Hyojin)관리자페이지</a>
				<ul class="sub">
					<li><a href="compinfo">기본 정보 수정</a></li>
					<li><a href="modifymainimage">디자인설정</a></li>
					<li><a href="faqmanageboard">FAQ 관리</a></li>
					<li><a href="${contextPath }/manageCustomerService/goToOneVOneBoard">1 대 1 문의</a></li>
					<li><a href = "${contextPath }/manageCommunity/goToManageBoard">게시판 관리</a></li>
					<li><a href = "${contextPath }/manageCustomerService/goToAnnouncement">공지사항 관리</a></li>
				</ul></li>
				
			<li>
			<a href="usersetting" class="iframe">설정 및 회원정보</a>
			</li>
			<li>
			<a href="logout" class="iframe">로그아웃</a>
			</li>
			
		</ul>
		<button class="cross">&#735;</button>
	</div>



</body>
</html>