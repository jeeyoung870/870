<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "inner">
	
	<!-- <a href = "writeSubArticle?b_number=${specificContent.b_number }">write sub article</a>-->
	<div class = "content main">
		<div class = "content line1">
			
			<span class = "line4 elem1">Subject : </span>
			<span class = "line4 elem2">${askAndReply.ask_title }</span>
		</div>
		<div class = "content line2">
			<span class = "line2 elem1">user_id : </span>
			<span class = "line2 elem2">${askAndReply.user_id }</span>
			<span class = "line3 elem1">reg_date :</span>
			<span class = "line3 elem2">${askAndReply.ask_date }</span>
		</div>
		<div class = "content line3">
		</div>
		<div class = "content line4">
		</div>
		<div class = "content line5">
			<span class = "line5 elem1">Content :</span>
			<span class = "line5 elem2">${askAndReply.ask_content }</span>
		</div>
		
	</div>
	<c:if test = "${askAndReply.is_replied eq 'Y'}">
		<div class = "reply">
			<div class = "line1 div">
				<span class = "line1 elem1">rep_title : </span>
				<span class = "line1 elem2">${askAndReply.rep_title }</span>
				<span class = "line1 elem3">reg_date : </span>
				<span class = "line1 elem4">${askAndReply.rep_date }</span>
			</div>
			<br/>
			<div class = "line2 div">
				<span class = "line2 elem1">sub Content: </span>
				<span class = "line2 elem2">${askAndReply.rep_content }</span>
			</div>
	
		</div>
	</c:if>
	</div>
</body>
</html>	