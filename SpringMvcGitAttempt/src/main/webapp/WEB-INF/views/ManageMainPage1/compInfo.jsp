<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 정보 수정</title>
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
	#upper hr{ background-color:#81C1EB; border: 0; height: 20px; }
	/*div{ width: 420px; margin:0 auto;
	}*/
	#content hr{ background-color:#BDBDBD; border: 0; height: 1px; }
	#content{ padding: 20px; padding-top:0px;}
	#compform{ line-height:35px; }
	.textbox{ width:200px; height:40px; font-size:15px;
		font-family: Noto Sans KR;font-weight:400; border: 2px solid #0383D8;
		padding-left:8px;margin-bottom:5px;}
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>기본 정보 수정</span><hr>
</div>

<div id="content">
<span style="font-size: 19px;line-height: 52px;font-weight:500;">사업자 정보</span><hr>

<form method="post" action="compinfo" id="compform">
<fieldset>
	<br>
	상호(법인명)<br>
	<input class="textbox" type="text" name="company_name" value=${comp.company_name }><br><br>
	대표자명<br>
	<input class="textbox" type="text" name="representative_name" value=${comp.representative_name }><br><br>
	사업자 등록 번호<br>
	<input class="textbox" type="text" name="business_license_number" value=${comp.business_license_number }><br><br>
	
	사업장 소재지<br>	
	<span style="color:#A7A7A7;font-size:14px;">${comp.business_address }</span><br>
	<input type="hidden" name="business_address" value="${comp.business_address }" />
	
	<input class="textbox" type="text" id="postcode" name="postcode" placeholder="우편번호">
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	<input class="textbox" name="address" id="address" placeholder="도로명 주소"><br>
	<input class="textbox" name="d_address" id="d_address" placeholder="상세주소 입력"><br><br>
	
	대표 전화<br>
	<input class="textbox" type="text" name="phone_number" value=${comp.phone_number }><br><br>
	팩스<br>
	<input class="textbox" type="text" name="fax_number" value=${comp.fax_number }><br>
	<br><br>
	<input type="submit" value="수정하기">
	<input type="button" value="취 소" 
	onclick="javascript:location.href='${pageContext.request.contextPath}/hils/main'">
</fieldset>
</form>
</div>

<br><br><br><br><br><br><br><br>
</body>


<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode; 
            document.getElementById("address").value =  data.roadAddress;
            //커서를 상세주소 필드로 이동한다.
            document.getElementById("d_address").focus();
        }
    }).open();
}
</script>  
</html>