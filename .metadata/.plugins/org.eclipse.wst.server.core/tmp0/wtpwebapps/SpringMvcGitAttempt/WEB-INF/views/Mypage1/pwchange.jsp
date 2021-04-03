<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
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
	div{ width: 420px; margin:0 auto;
	}
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>비밀번호 변경</span><hr>
</div>
<div>
<form action="pwchanged" method="post" onsubmit="return pwCheck()">
	기존 비밀번호 입력<br>
	<input type="password" id="oldp" name="oldp"/><br><br>
	새 비밀번호 입력<br>
	<input type="password" id="newp" name="newp"/><br>
	새 비밀번호 확인<br>
	<input type="password" id="checkp" name="checkp"/>
	<input type="hidden" id="user_id" name="user_id" value="${user.get(0)}">
	<input type='submit' value='변경하기'>
	
</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function pwCheck(){
	var passwd = ${user.get(1)};
	if(passwd != $("input#oldp").val()){
		alert("기존 비밀번호가 틀렸습니다.");
		return false;
	}else if($("input#newp").val().length < 4){
		alert("비밀번호는 4자 이상이어야 합니다.");
		return false;
	}else if($("input#newp").val() != $("input#checkp").val()){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}else{
		alert("비밀번호가 변경됩니다.");
	}
}

</script>
</html>