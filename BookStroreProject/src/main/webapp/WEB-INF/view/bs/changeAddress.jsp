<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주소 변경</title>
</head>
<body>
<h1 align="center">고객 주소 변경</h1>
<!-- <form action="changeAddress.do" method="post">
변경 주소 : <input type="text" name="changeAddr">
<input type="submit" value="변경">
</form> -->
<form method="post">
<fieldset>
	<input name="address" id="address" placeholder="도로명 주소">
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	<input name="d_address" id="d_address" placeholder="상세주소 입력"><br>
	<input type="hidden" id="custid" name="custid" value="${custid}" ><br>
	<input type="submit" value="수정하기">
	<input type="button" value="취 소" 
	onclick="javascript:location.href='${pageContext.request.contextPath}/menu.jsp'">
</fieldset>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            /* document.getElementById('sample6_postcode').value = data.zonecode; */
            document.getElementById("address").value =  data.roadAddress;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("d_address").focus();
        }
    }).open();
}
</script>
</html>