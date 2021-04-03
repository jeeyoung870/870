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
<script type="text/javascript">
	var socket = null;
	
	
	let url = window.location.host;
	
	let pathname = window.location.pathname;
	let appCtx = "/mvc"
	
	let root = url + appCtx;
		
	socket = new WebSocket("ws://" + root + "/websocket/noti-ws");
		
	$(document).ready(function(){
		$(".notification > img").click(handleNotiClicked);
	})
	
	
	function handleNotiClicked(){
		let notiNumber = $("#notiNumber").text();
		console.log("called")
		if (!(notiNumber == "")){
			console.log("if passed")
			$("#notificationResultForm").submit();
		}else{
			
		}
		}
		
		
	socket.onopen = function(event){
		console.log("connection opened")
	}
	
	socket.onmessage = function(event){
		console.log(event.data)
		let notiNumber = $("#notiNumber").text();
		let html = "<input class = 'recievedNoti' name='notiData'"
		if (!notiNumber || notiNumber == ""){
			$("#notiNumber").text("1");
			html += "value='" + event.data + "'></input>"
		
		}else{
			$("#notiNumber").text(parseInt(notiNumber) + 1);
			html += "value='" + event.data + "'></input>"
		
		}
		$("#notificationResultForm").append(html);
	}
	socket.onerror = function(event){
		console.log("error occured")
	}
	socket.onclose = function(event){
		console.log("connection closed")
		alert(event.code)
	}

</script>
</head>
<body>
	<header>
		<div>
			<button class="hamburger">&#9776;</button>
		</div>
		<div class="logo">
			<a href="main"> <img
				src="${contextPath }/resources/images/static/WHITE.png">
			</a>
		</div>
		<div class="notification">
			<img
				src="${contextPath }/resources/images/notification/whitering.png">
		</div>
	</header>
	<div class="menu">
		<span><a href="#" class="if1">회원가입 / 로그인</a></span>
		<ul>
			<li><a href="mypage">마이페이지</a></li>
			<li><a href="myalarm">내 알림</a></li>
			<li><a href="myActivitySchedule">나의 활동</a></li>

			<li><a href="#" class="iframe">커뮤니티</a>
				<ul class="sub">
					<li><a href="${contextPath}/community/goBoard">게시판</a></li>
					<li><a href="#">공지사항 </a> <!-- <li><a href="#">test</a></li> -->
				</ul></li>
			<li><a href="#" class="iframe">타임라인</a>
				<ul class="sub">
					<li><a href="${contextPath }/timeLine1/goHilslinderCal">힐린더</a>
					<li><a href="timeline">타임라인 </a>
				</ul>
			</li>
			<li><a href="custcenter" class="iframe">고객센터</a></li>
			<li><a href="usersetting" class="iframe">설정 및 회원정보</a></li>
			<li><a href="manageIntro">관리자 페이지</a></li>
			<li><a href="logout" class="iframe">로그아웃</a></li>
		</ul>
		<button class="cross">&#735;</button>
	</div>



</body>
</html>