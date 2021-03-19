<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="info" value="${userInfo[0]}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>설정 및 회원정보</title>
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
	#upper img{position: absolute; left:570px;margin-top:13px; height:27px;}
	#upper hr{ background-color:#FF9A7F; border: 0; height: 20px; }
	
	.plus{ height:22px; float:right; margin-right:20px; margin-top:17px;}
	
	#menu{ width: 420px; margin:0 auto;}
	#menu .iframe hr{ background-color:#BDBDBD; border: 0; height: 1px; }
	/* #menu ul li ul a:link {
  	color:#FF3600;
	} */
	#menu a:link {
  	color : black;
	}
	#menu a:visited {
  	color : black;
	}
	#menu a:hover {
  	color : #FF3600;
	}
	
	.iframe{
	font-size: 16px;
	font-style: medium;
	font-weight: 450; line-height: 58px;
	margin-left:18px
	}
	.sub{
	background-color:#F2F2F2;
	}
	.sub li{font-size: 14px;
	font-weight: 450; line-height: 25px;
	margin-left:18px; padding-top:13px; padding-bottom:13px;}
	.sub hr{ background-color:white; border: 0; height: 2px; }
	.sub li span{ color : #575757; font-weight: 400;}
	
</style>
</head>



<body>
<!-- 설정 및 회원정보 클릭시 이동하는 페이지 -->
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>설정 및 회원정보</span><hr>
</div>

<div id="menu">
<ul>
					<li><a href="#" class="iframe">계정<img class="plus"
							src="resources/images/usersetting/plus.png"
							alt="arrow" /><hr></a>
						<ul class="sub">
							<li>ID<br>
							<span> 
							<!-- 현재ID출력 -->
							${info.user_id}
							</span></li><hr>
							<li>Password<br>
							<span>
							<c:out value="${info.password}"/>
							<div style="display:inline;float:right;margin-right:20px;">
							<a href="pwchange?user_id=${info.user_id}">변경하기</a>
							</div>
							</span></li><hr>
							<li>E-mail<br>
							<span>
							<c:out value="${info.user_email}"/>
							<div style="display:inline;float:right;margin-right:20px;">
							<a href="emailchange">변경하기</a>
							</div>
							</span></li><hr>
							<li>Phone<br>
							<span>
							<c:out value="${info.user_phone}"/>
							<div style="display:inline;float:right;margin-right:20px;">
							<a href="phonechange">변경하기</a>
							</div>
							</span></li><hr>
							<li><a href="leave">회원 탈퇴</a></li>
						</ul>
						<hr>
					</li>

					<li><a href="#" class="iframe">힐린더 설정<img class="plus"
							src="resources/images/usersetting/plus.png"
							alt="arrow" /><hr></a>
						<ul class="sub">
							<li>힐린더 비공개</li><hr>
							<li>게시판 연동</li>
						</ul>
						<hr>
					</li>

					<li><a href="#" class="iframe">지역 설정<img class="plus"
							src="resources/images/usersetting/plus.png"
							alt="arrow" /><hr></a>
						<ul class="sub">
							<li>위치<br>
							<span>
							<c:if test="${info.location == null}">
							나의 관심지역을 설정하세요.
							</c:if>
							<c:out value="${info.user_phone}"/>
							<div style="display:inline;float:right;margin-right:20px;">
							<a href="locset">설정하기</a>
							</div>
							</span>
							</li>
					</ul>
						<hr>
					</li>
					
					<li><a href="logout" class="iframe">로그아웃</a> <hr> </li>
</ul>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
$(function () {
	$(".sub").hide();
	$("#menu>ul>li>a").click(function(){
		if($(this).next().is(":visible"))
		{
			$(this).next().stop().slideUp(200);

		}else{
			$(".sub").stop().slideUp(500);
			$(this).next().stop().slideDown(200);
		};
	});
});
</script>
</html>