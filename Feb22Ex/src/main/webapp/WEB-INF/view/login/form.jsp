<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<!-- form:form -> html form 태그 생성. method="post"가 기본값 -->
	<form:form modelAttribute="loginCommand"> 
	loginCommand라는 이름의 model객체를 가져옴(@ModelAttribute)
	<%-- <form:form commandName="loginCommand"> --%>
		<form:errors element="div" />	<!-- 글로벌 에러 있으면 출력 -->
		아이디: <form:input path="userId" />
		<!-- ㄴ이렇게 됨.-> <input id="userId" name="userId" type="text" value=""> -->
		<form:errors path="userId" element="div" /><!-- userId에 대한 필드에러 -->
		<br />
		암호: <form:password path="password" showPassword="false" />
		<form:errors path="password" element="div"/><!-- password에 대한 필드에러 -->
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>