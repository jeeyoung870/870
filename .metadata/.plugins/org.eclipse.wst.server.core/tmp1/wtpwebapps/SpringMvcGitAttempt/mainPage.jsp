<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
이건 로그인페이지로 하고 로긴 jsp는 로그인처리 페이지로 
	<!-- ============================================================================================== -->
	
	<a href="user/login/G/Glogin">구글 로그인 테스트(컨트롤러)<br/><br/></a>
	
	<a>===================================================<br/><br/></a>
	
	<a href="user/login/Nlogin">소셜 로그인 테스트<br/></a>
	
	<a href="user/login/login">소셜 로그인 테스트<br/></a>
	
	<a href="user/login/logout">로그아웃 테스트<br/><br/></a>
	
	<a>===================================================<br/><br/></a>
	
	<a href="user/login/login">로그인 jsp 페이지 이동 테스트<br/><br/></a>
	<a href="regi/member/regist">회원가입(스프링 커스텀 태그)</a><br>

	<!-- ============================================================================================= -->

	<c:choose>
		<c:when test="${sessionScope.id_token eq null}">
			<a href="user/login/Nlogin"> 로그인 버튼 전환 테스트 <br/><br/></a>
		</c:when>
		<c:otherwise>
		${sessionScope.id_token}님이 로그인 중입니다.
			<a href="user/login/logout"> 로그아웃 버튼 전환 테스트 <br/><br/></a>
		</c:otherwise>
	</c:choose>

</body>
</html>