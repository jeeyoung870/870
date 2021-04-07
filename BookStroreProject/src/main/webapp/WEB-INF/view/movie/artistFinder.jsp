<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>영화인 검색</title>
</head>
<body>
<h1>영화인 검색</h1>
<form action="find/artist" method="get" onsubmit="check()">
<input type="text" name="peopleNm" id="peopleNm" />
<input type="submit" value="찾기">
</form>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function check() {
	if($("#peopleNm").val() == "") {
		alert("값을 입력하세요.");
		return false; //리턴값이 false라면 submit 동작취소 
	}
	//리턴값이 true이면 submit진행
	return true;
}
</script>
</html>