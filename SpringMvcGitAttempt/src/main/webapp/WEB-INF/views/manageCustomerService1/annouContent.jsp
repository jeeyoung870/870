<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	.inner {
		width : 420px;
		margin : 0 auto;	
	}
</style>
</head>
<body>
	<div class = "inner">
	
	<!-- <a href = "writeSubArticle?b_number=${specificContent.b_number }">write sub article</a>-->
	<div class = "content main">
		<div class = "content line1">
			
			<span class = "line4 elem1">Subject : </span>
			<span class = "line4 elem2">${annou.subject }</span>
		</div>
		<div class = "content line2">
			<span class = "line2 elem1">user_id : </span>
			<span class = "line2 elem2">관리자</span>
			<span class = "line3 elem1">reg_date :</span>
			<span class = "line3 elem2">${annou.annou_reg_date}</span>
		</div>
		<div class = "content line3">
		</div>
		<div class = "content line4">
		</div>
		<div class = "content line5">
			<span class = "line5 elem1">Content :</span>
			<span class = "line5 elem2">${annou.content }</span>
		</div>
		
	</div>
	</div>
</body>
</html>