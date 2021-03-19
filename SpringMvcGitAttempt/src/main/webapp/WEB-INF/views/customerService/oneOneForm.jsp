<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	관리자에게 문의하기!
	<form:form method = "post" action="./doOneOne" modelAttribute = "writeOneOneVO">	
		<label for = "userEmail">Your E-mail</label>
		<form:input type = "text" id = "userEmail" path = "userEmail"/>
		<label for = "userSubject">Your subject</label>
		<form:input type = "text" id = "userPhone" path = "userSubject"/>
		<textarea id = "textToManager" name = "textToManager"></textarea>
		<input type = "submit" value = "submit"/>
	</form:form>
</body>
</html>