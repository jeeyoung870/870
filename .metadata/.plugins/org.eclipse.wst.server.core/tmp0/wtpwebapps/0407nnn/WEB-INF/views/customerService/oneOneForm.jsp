<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	header{
		display:flex;
	}
	.title{
		text-align : center;
		font-size: 22px;
		font-style: medium;
		font-weight: 600; line-height: 52px;
	}
	.title hr {
		background-color:#FF9A7F; 
		border: 0; 
		height: 20px;
	}
</style>
</head>
<body>
<div class = "inner">
	<div class = "title">
		<span>관리자에게 문의하기!</span>
		<hr/>		
	</div>
	
	<div class = "form-group">
		<form:form method = "post" action="./doOneOne" modelAttribute = "writeOneOneVO" onsubmit = "return checkTextLength()" >	
			<label for = "userEmail">Your E-mail</label>
			<form:input type = "text" id = "userEmail" path = "userEmail" class = "form-control"/>
			<form:errors path = "userEmail"/>
			<label for = "userSubject">Your subject</label>
			<form:input type = "text" maxlength="25" id = "userSubject" path = "userSubject" class = "form-control"/>
			<form:errors path = "userSubject"/>
			<form:textarea path = "textToManager" id = "textToManager" name = "textToManager"  class = "form-control"/>
			<form:errors path = "textToManager"/>
			<input type = "submit" value = "submit" class = "form-control"/>
		</form:form>
	</div>
</div>
<script>
	function checkTextLength(){
		let input_content = document.getElementById("textToManager");
		if(input_content.length > 500){
			alert("too many text")
			return false;
		}
	}
</script>
</body>
</html>