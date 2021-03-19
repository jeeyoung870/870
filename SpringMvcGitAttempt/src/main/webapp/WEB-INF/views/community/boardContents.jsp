<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/mainBoard.css" rel="stylesheet" />
</head>
<body>
	<div class = "inner">
	<a href = "goUpdateForm?b_number=${specificContent.b_number }" class = "boardBtn">update</a>
	<a href = "deleteContent?b_number=${specificContent.b_number }" class = "boardBtn">delete</a>
	<!-- <a href = "writeSubArticle?b_number=${specificContent.b_number }">write sub article</a>-->
	<table>
		<tr>
			<td>Category : </td>
			<td>${specificContent.b_category }</td>
		</tr>
		<tr>
			<td>user_id : </td>
			<td>${specificContent.user_id }</td>
		</tr>
		<tr>
			<td>reg_date :</td>
			<td>${specificContent.b_reg_date }</td>
		</tr>
		<tr>
			<td>Subject : </td>
			<td>${specificContent.b_subject }</td>
		</tr>
		<tr>
			<td>Content :</td>
			<td>${specificContent.b_content }</td>
		</tr>
	</table>
	<hr/>
	
	<c:forEach var = "subArticle" items = "${subArticleList }">
	<div class = "singleComment">
	<table>
		<tr>
			<td>user_id : </td>
			<td>${subArticle.user_id }</td>
			<td>c_reg_date : </td>
			<td>${subArticle.c_reg_date }</td>
		</tr>
		<tr>
			<td>sub Content: </td>
			<td>${subArticle.c_content }</td>
		</tr>
	</table>
	</div>
	</c:forEach>
	
	<form action = "writeSubArticle" method = "Post">
		<input type = "hidden" name = "b_number" value = "${specificContent.b_number }"/>
		<label for = "c_content">Comments Form</label>
		<textarea name = "c_content">enter Comments</textarea>
		<input type = "submit" value = "write new Comment" class = "boardBtn"></input>
	</form>
	</div>
</body>
</html>