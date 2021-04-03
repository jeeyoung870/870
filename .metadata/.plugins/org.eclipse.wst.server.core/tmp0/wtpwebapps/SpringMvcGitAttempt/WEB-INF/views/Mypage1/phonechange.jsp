<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 변경</title>
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
<span>연락처 변경</span><hr>
</div>
<div>
현재 연락처 <br><div id="oldphone">${user.user_phone}</div> <br><br>
<form action="phonechanged" method="post" onsubmit="return checkPhone()">
변경 연락처 <br>
<input type="text" name="newphone" id="newphone" />
<input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />
<input type="submit" value="변경하기" />
</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function checkPhone(){
	var oldphone = $("#oldphone").text();
	//원래 연락처와 같다면,
	if(oldphone == $("input#newphone").val()){
		alert("이미 사용중인 연락처입니다.");
		return false;
	}
	
	//입력받은 연락처가 users_register 테이블에 존재하는지 검사
	var params = "newphone="+$("#newphone").val();
	$.ajax({
		  url: 'phonecheck',
		  type: 'post',
		  data: params,
		  dataType: 'json',
		  })
		  .done( function(args) {
			  //다른 사용자와 중복하는 연락처라면,
			  if(${user.user_phone} != $("input#newphone").val() && args > 0){
				  alert("변경할 수 없는 연락처입니다.");
				  return false;
			  }else{
				  alert("연락처가 변경됩니다.");
				  return true;
			  }
		  })
		  .fail(function(e) {
		  	alert(e.responseText );
			})
	
}

</script>
</html>