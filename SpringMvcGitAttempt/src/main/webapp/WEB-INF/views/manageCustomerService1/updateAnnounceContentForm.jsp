<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "updateAnnou" method = "POST">
		<label for = "subject">제목</label>
		<input type = "text" name = "subject" value = "${annou.subject }"> 
		<br/>
		<label for = "content">내용</label>
		<textarea name = "content">
			${annou.content }
		</textarea>
		<br/>	
		
		<input type = "submit" value = "작성완료"/>
	</form>
</body>
</html>