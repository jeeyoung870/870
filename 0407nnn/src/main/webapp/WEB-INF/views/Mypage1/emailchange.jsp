<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 변경</title>
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
	
	#emchange{ line-height:35px; width:fit-content; margin:0 auto; }
	.textbox{ width:250px; height:40px; font-size:15px;
		font-family: Noto Sans KR;font-weight:400; border: 2px solid #FF3600;
		padding-left:8px;margin-bottom:5px;}
	.frmbtn{ width:90px; height:35px; color:white; background-color:#FF3600;
		border:0;outline:0; margin-left:80px; border-radius: 1em;}
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>E-mail 변경</span><hr>
</div>
<div id="emchange">

<form action="emailchanged" method="post" onsubmit="return pwCheck()" >
	<div id="check">
		<br>변경할 E-mail 입력<br>
		<input type="email" id="newmail" name="newmail" class="textbox"/><br>
		<button onclick="return mailcheck()" class="frmbtn">인증번호 전송</button>
		<div id ="checkPlus"></div>
	</div>
	<input type="hidden" id="user_id" name="user_id" value="${user}">
	<br><input type='submit' value='인증 확인' class="frmbtn" >
	
</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br>

</body>


<script type="text/javascript">
function mailcheck() {
	if($("#newmail").val() == "" || $("#newmail").val() == null){
		alert("이메일을 입력해 주세요.");
		return false;
	}else{
		var params = "newmail="+$("#newmail").val();
		$.ajax({
			  url: 'mailcheck',
			  type: 'post',
			  data: params,
			  dataType: 'json',
			  error : function(error) {
			        alert("Error!");
			    },
			    success : function(data) {
			    	 //console.log("args"+data)
					 $("#plus").remove(); 
					 $("#checkPlus").html("<div id='plus'><br>E-mail 확인용 인증번호가 전송되었습니다.<br>인증번호 입력<br><input type='text' id='checknum' name='checknum' />" 
							 + "<br><input type='hidden' class='textbox' id='random' name='random' value="+data+" />" +"</div>");
				  
			    },
			    complete : function() {
			        //alert("complete!");    
			    }
		});
		return false;
	}	  
}

function pwCheck(){
	var user_id = $("#user_id").val();
	var random = $("#random").val();
	
	if($("#checknum").val() == random){
		alert("인증 성공. E-mail이 변경됩니다.");
		return true;
	}else {
		alert("인증번호가 올바르지 않습니다. 재인증해 주세요.");
		return false;
	}
}
</script>
</html>