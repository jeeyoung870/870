<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="info" value="${userInfo[0]}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	#upper img{position: absolute; left:18px; margin-top:13px; height:27px;}
	#upper hr{ background-color:#FF9A7F; border: 0; height: 20px; }
	
	.plus{ height:22px; float:right; margin-right:20px; margin-top:17px;}
	
	#usersetmenu{ width: 420px; margin:0 auto;}
	#usersetmenu .mframe hr{ background-color:#BDBDBD; border: 0; height: 1px; }
	/* #menu ul li ul a:link {
  	color:#FF3600;
	} */
	#usersetmenu a:link {
  	color : black;
	}
	#usersetmenu a:visited {
  	color : black;
	}
	#usersetmenu a:hover {
  	color : #FF3600;
	}
	
	.mframe{
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
	
	#toggle1 > button, #toggle2 > button{
	font-family: Noto Sans;
	border: none;
  	border-radius: 4px;
  	padding: 3px;
	color: white;
	background-color:#FF9A7F;
	}
</style>
</head>



<body>
<!-- 설정 및 회원정보 클릭시 이동하는 페이지 -->
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>설정 및 회원정보</span><hr>
</div>

<div id="usersetmenu">
<ul>
					<li><a href="#" class="mframe">계정<img class="plus"
							src="resources/images/usersetting/plus.png"
							alt="arrow" /><hr></a>
						<ul class="sub">
							<li>ID<br>
							<span> 
							<!-- 현재ID출력 -->
							${info.user_id}
							<input type="hidden" id="user_id" value="${info.user_id}" />
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
							<a href="emailchange?user_id=${info.user_id}">변경하기</a>
							</div>
							</span></li><hr>
							<li>Phone<br>
							<span>
							<c:out value="${info.user_phone}"/>
							<div style="display:inline;float:right;margin-right:20px;">
							<a href="phonechange?user_id=${info.user_id}">변경하기</a>
							</div>
							</span></li><hr>
							<li><a href="leave?user_id=${info.user_id}">회원 탈퇴</a></li>
						</ul>
						<hr>
					</li>

					<li><a href="#" class="mframe">힐린더 설정<img class="plus"
							src="resources/images/usersetting/plus.png"
							alt="arrow" /><hr></a>
						<ul class="sub">
							<li>힐린더 비공개<br>
								<span>
								현재 나를 팔로우 중인 사람들만 내 힐린더를<br>볼 수 있습니다.
								<div style="display:inline;float:right;margin-right:20px;">
								<input type="hidden" id="is_hellinder_open" value="${info.is_hellinder_open}"/>
								<div id="toggle1">
								<button value="N" onclick="page_move('hilopenchange', 'N')">on</button>
								&nbsp;&nbsp;
								<button value="Y" onclick="page_move('hilopenchange', 'Y')">off</button>
								</div>
								</div>
								</span>
							</li><hr>
							<li>게시판 연동<br>
								<span>
								힐린더 갱신 시, 타임라인과 커뮤니티(일반)에<br>동시에 업로드됩니다.${info.is_withboard}
								<div style="display:inline;float:right;margin-right:20px;">
								<input type="hidden" id="is_withboard" value="${info.is_withboard}"/>
								<div id="toggle2">
								<button value="Y" onclick="page_move('hilwithboard', 'Y')">on</button>
								&nbsp;&nbsp;
								<button value="N" onclick="page_move('hilwithboard', 'N')">off</button>
								</div>
								</div>
								</span>
							</li>
						</ul>
						<hr>
					</li>

					<li><a href="#" class="mframe">지역 설정<img class="plus"
							src="resources/images/usersetting/plus.png"
							alt="arrow" /><hr></a>
						<ul class="sub">
							<li>위치<br>
							<span>
							<c:if test="${info.location == null}">
							나의 관심지역을 설정하세요.
							</c:if>
							${info.location}
							<div style="display:inline;float:right;margin-right:20px;">
							<a href="locset?user_id=${info.user_id}">설정하기</a>
							</div>
							</span>
							</li>
					</ul>
						<hr>
					</li>
					
					<li><!-- <a href="logout" class="mframe">로그아웃</a>  -->
					<a href="${contextPath}/hils/j_spring_security_logout" 
					class="mframe" >로그아웃</a>
					<hr> </li>
</ul>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
$(function () {
	$(".sub").hide();
	$("#usersetmenu>ul>li>a").click(function(){
		if($(this).next().is(":visible"))
		{
			$(this).next().stop().slideUp(200);

		}else{
			$(".sub").stop().slideUp(500);
			$(this).next().stop().slideDown(200);
		};
	});
	
	//힐린더 기존 설정값에 해당하는 버튼을 다홍색으로 변경
	var is_hellinder_open = $("#is_hellinder_open").val();
	var is_withboard = $("#is_withboard").val();
	var toggle1 = "#toggle1 > button[value="+is_hellinder_open+"]";
	var toggle2 = "#toggle2 > button[value="+is_withboard+"]";
	$(toggle1).css({"background-color":"#FF3600"});
	$(toggle2).css({"background-color":"#FF3600"});
	
});

//post방식으로 url에 form 데이터 전송하기
function page_move(url, some_data) {
    var form = document.createElement("form");
    var input = new Array();
    form.action = url;
    form.method = "post";

    input[0] = document.createElement("input");
    input[0].setAttribute("type", "hidden");
    input[0].setAttribute('name', "data");
    input[0].setAttribute("value", some_data);
    form.appendChild(input[0]);
    input[1] = document.createElement("input");
    input[1].setAttribute("type", "hidden");
    input[1].setAttribute('name', "user_id");
    input[1].setAttribute("value", $("#user_id").val());
    form.appendChild(input[1]);
    
    document.body.appendChild(form);
    form.submit();
}
</script>
</html>