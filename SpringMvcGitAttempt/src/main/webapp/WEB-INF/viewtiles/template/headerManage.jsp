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
<link href="${contextPath}/resources/css/static/header/headerManage.css"
	rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="${contextPath}/resources/js/static/header/header.js"></script>
<style>
</style>
<script type="text/javascript">
	var socket = null;

	let url = window.location.host;
	//let url = "172.16.3.94:8080"
	let pathname = window.location.pathname;
	let appCtx = "/mvc"

	let root = url + appCtx;

	socket = new WebSocket("ws://" + root + "/hils/noti");
	$(document).ready(function() {
		$.ajax({
			url : "sendNoti"
		})
	})

	socket.onopen = function(event) {
		console.log("connection opened")
	}

	socket.onmessage = function(event) {
		console.log(event.data)
	}
	socket.onerror = function(event) {
		console.log("error occured")
	}
	socket.onclose = function(event) {
		console.log("connection closed")
	}
</script>
</head>
<body>
	<header>
		<div>
			<button class="hamburger">&#9776;</button>
		</div>
		<div class="logo">
			<a href="manageIntro"> <img
				src="${contextPath }/resources/images/static/WHITE.png">
			</a>
		</div>
		<div class="notification">
			<img
				src="${contextPath }/resources/images/notification/whitering.png">
		</div>
	</header>
	<div class="menu">
		<div class="user-id-container">
			<div>(대표관리자)님</div>
		</div>
		<ul>
			<li><a href="#" class="iframe">메인페이지 관리</a>
				<ul class="sub">
					<li><a href="compinfo">기본 정보 수정</a></li>
					<li><a href="modifymainimage">디자인설정</a></li>
				</ul></li>
			<li><a href="#" class="iframe">회원 관리</a>
				<ul class="sub">
					<li><a href="compinfo">기본 정보 수정</a></li>
					<li><a href="modifymainimage">디자인설정</a></li>
				</ul></li>
			<li><a href="#" class="iframe">게시글 관리</a>
				<ul class="sub">
					<li><a href="compinfo">기본 정보 수정</a></li>
					<li><a href="modifymainimage">디자인설정</a></li>
				</ul></li>
			<li><a href="#" class="iframe">고객센터</a>
				<ul class="sub">
					<li><a href="faqmanageboard">FAQ 관리</a></li>
					<li><a
						href="${contextPath }/manageCustomerService/goToOneVOneBoard">1
							대 1 문의</a></li>
					<li><a href="${contextPath }/manageCommunity/goToManageBoard">게시판
							관리</a></li>
					<li><a
						href="${contextPath }/manageCustomerService/goToAnnouncement">공지사항
							관리</a></li>
				</ul></li>
			<li><a href="logout" class="iframe">로그아웃</a></li>
		</ul>
		<button class="cross">&#735;</button>
	</div>				

</body>
</html>