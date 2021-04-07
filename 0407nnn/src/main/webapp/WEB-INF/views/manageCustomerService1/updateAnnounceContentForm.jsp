<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
	header {
		display : flex;
	}
</style>
</head>
<body>
	<form action = "updateAnnou" method = "POST" onsubmit = "return checkFormIntegrity()">
		<div class = "form-group">
		<input type = "hidden" name = "annou_writing_num" value = "${annou.annou_writing_num }"/>
		<label for = "subject">제목</label>
		<input type = "text" name = "subject" class = "form-control" value = "${annou.subject }" maxlength="12"> 
		<br/>
		<label for = "content">내용</label>
		<textarea name = "content" class = "form-control">
			${annou.content }
		</textarea>
		<br/>	
		
		<input type = "submit" value = "작성완료" class = "form-control"/>
		</div>
	</form>
	<script>
	function checkFormIntegrity(){
		let subject = document.getElementById("subject").value;
		let content = document.getElementById("content").value;
		
		if(subject && content){
			if(content.length > 500){
				alert("too many chars")
				return false;
			}else{
				alert("제출합니다!")
				return true;
			}
			
		}else{
			alert("누락된 항목이 있습니다!")
			return false;
		}
	}
	</script>
</body>
</html>