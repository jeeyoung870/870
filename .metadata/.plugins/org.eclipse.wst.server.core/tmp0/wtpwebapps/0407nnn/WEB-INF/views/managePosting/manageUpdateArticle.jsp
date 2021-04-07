<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
	header{
		display:flex;
	}
	.inner{
		width : 420px;
		margin : 0 auto;
	}
</style>
</head>
<body>
<div class = "inner">
<form action = "managerUpdateArticle" method = "POST" onsubmit = "return handleExceededChars()">
		<div class = "form-group">
		<input type = "hidden" name = "b_number" value = "${article.b_number }"/>
		<label for = "subject">제목</label>
		<input type = "text" name = "subject" class = "form-control" value = "${article.b_subject }" maxlength = "75"> 
		<br/>
		<label for = "content">내용</label>
		<textarea name = "content" id = "ir1" class = "form-control">
			${article.b_content }
		</textarea>
		<br/>	
		
		<input type = "submit" value = "작성완료" class = "form-control"/>
		</div>
	</form>
</div>
<script>
function handleExceededChars(){
	let b_content_input = document.getElementById("ir1").value;
	if(b_content_input.length > 1000){
		alert("too many chars!");
		return false;
	}
}

</script>
</body>
</html>