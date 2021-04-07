<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/mainBoard.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<style>
header{
    	display:flex;
    }
</style>
<body>
	<div class = "inner">
	<form action = "./updateArticle" method = "POST"> 
		
		<input type = "hidden" name = "b_number" value = "${specificContent.b_number }"/>
		<div class = "form-group">
			<label for = "b_subject">subject : </label>
			<input type = "text" name = "b_subject" value = "${specificContent.b_subject }" class = "form-control"/><br/>
		</div>
		<div class = "form-group">
			<textarea name = "b_content" class = "form-control">${specificContent.b_content }</textarea>
		</div>
		<br/>
		<input type = "submit" value = "submit"/>
	</form>
	</div>
</body>
</html>