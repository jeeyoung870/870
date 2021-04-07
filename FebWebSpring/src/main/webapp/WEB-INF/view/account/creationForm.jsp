<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>계정 생성</title>
</head>
<body> 
	<spring:hasBindErrors name="command" />
	<form:errors path="command" /><!-- command의 글로벌 에러 -->
	<form method="post">
	<!-- ${command.id} : 폼 제출전에 입력한 값이 있다면, 그대로 출력해줌 -->
		아이디: <input type="text" name="id" value="${command.id}" />
		<!--messageBundle로 지정된 파일에서 에러코드 검색해 출력 required.command.id -->
		<form:errors path="command.id" />
		<br /> 이름: <input type="text" name="name" value="${command.name}" />
		<form:errors path="command.name" />
		<br /> 우편번호: <input type="text" name="address.zipcode"
			value="${command.address.zipcode}" />
		<form:errors path="command.address.zipcode" />
		<br /> 주소1: <input type="text" name="address.address1"
			value="${command.address.address1}" />
		<form:errors path="command.address.address1" />
		<br /> 주소2: <input type="text" name="address.address2"
			value="${command.address.address2}" />
		<form:errors path="command.address.address2" />
		<br /> <input type="submit" />
	</form>
</body>
</html>