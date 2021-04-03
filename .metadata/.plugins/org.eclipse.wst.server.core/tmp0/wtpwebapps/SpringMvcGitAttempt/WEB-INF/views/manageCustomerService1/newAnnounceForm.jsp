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
		margin : 0 auto;
		width : 420px;
	}
</style>
</head>
<body>
	<div class = "inner">
		<form action = "writeNewAnnouncement" method = "POST" onsubmit = "return checkFormIntegrity()">
			<div class = "form-group">
				<label for = "subject">제목 :</label>
				<input type = "text" name = "subject" class = "form-control" id = "subject"/>
				<textarea name = "content" class = "form-control" id = "content">
				공지 사항의 내용을 입력하세요.
				</textarea>
				<input type = "submit" value = "submit" class = "form-control"/>
			</div>
		</form>
	</div>
	
	<script>
		function checkFormIntegrity(){
			let subject = document.getElementById("subject").value;
			let content = document.getElementById("content").value;
			
			if(subject && content){
				alert("제출합니다!")
				return true;
			}else{
				alert("누락된 항목이 있습니다!")
				return false;
			}
		}
			
	</script>
</body>
</html>