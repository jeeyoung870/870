<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.inner{
		width : 420px;
		margin : 0 auto;
	}
</style>
</head>
<body>
<div class = "inner">
<form action = "managerUpdateArticle" method = "POST">
		<input type = "hidden" name = "b_number" value = "${article.b_number }"/>
		<label for = "subject">제목</label>
		<input type = "text" name = "subject" value = "${article.b_subject }"> 
		<br/>
		<label for = "content">내용</label>
		<textarea name = "content">
			${article.b_content }
		</textarea>
		<br/>	
		
		<input type = "submit" value = "작성완료"/>
	</form>
</div>
</body>
</html>