<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>단순 테스트</title>
</head>
<body>
<form method="POST">
	이름: <input type="text" name="name" /> <br/>
	나이: <input type="text" name="age" />
	<input type="submit" />
</form>
</body>
</html>