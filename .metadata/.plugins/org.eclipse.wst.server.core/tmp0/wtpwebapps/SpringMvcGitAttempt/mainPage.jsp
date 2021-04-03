<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인페이지</title>
</head>
<body>

	<script>
		if (sessionStorage.email == null) {
			document.write('<a href="user/login/SocialLogin">로그인</a>')
		} else {
			document.write('<a href="user/login/logout">로그아웃</a>')
		}
	</script>
	<div>
		<a href = "/mvc/hils/main">go to index</a>
	</div>
	<a href="user/user/register">1111</a>
	<!-- ====================================================================== -->

	<!-- 테스트를 위한 신고 페이지 이동 버튼
	(나중에 관리자 페이지의 신고관리 버튼으로 이동)-->
	<a href="report/report/select">신고 관리</a>

	<!-- ====================================================================== -->

	<!-- 신고내용입력창 -->
	<form action="report/report/insertDBReport" method="get">
		<div>
			신고내용 입력: <input type="text" name="contents" />
		</div>
		<input type="hidden" name="reporterName"
			value="sessionStorage.getItem("userName")">
		<div>
			<input type="submit" value="전송" />
		</div>
	</form>

</body>
</html>