<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>위치 설정</title>
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
<span>위치 설정</span><hr>
</div>
<div>
위치 설정<br>
<form method="post" action="locset">
<fieldset>
	<input name="address" id="address" placeholder="도로명 주소">
	<input type="text" id="postcode" name="postcode" placeholder="우편번호">
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	<!-- <input name="d_address" id="d_address" placeholder="상세주소 입력"><br> -->
	<input type="hidden" id="user_id" name="user_id" value="${user_id}" ><br>
	<input type="submit" value="수정하기">
	<input type="button" value="취 소" 
	onclick="javascript:location.href='${pageContext.request.contextPath}/hils/usersetting'">
</fieldset>
</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode; 
            document.getElementById("address").value =  data.roadAddress;
            // 커서를 상세주소 필드로 이동한다.
            //document.getElementById("d_address").focus();
        }
    }).open();
}
</script>
</html>