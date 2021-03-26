<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="EUC-KR">
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
		<form:form method = "get" action = "searchArticleManager" modelAttribute = "managerSearchVO">
			<form:select path="b_category">
				<form:option value = "general" selected="selected">general</form:option>
				<form:option value = "ask">ask</form:option>
				<form:option value = "tip">tip</form:option>
			</form:select>
			<form:input type = "date" path = "start_date"/>
			<form:input type = "date" path = "end_date"/>
			<form:select path = "search_option">
				<form:option value = "title" selected = "selected">title</form:option>
				<form:option value = "user_id" >user_id</form:option>
			</form:select>
			
			<form:input type = "text" path = "search_keyword"/>
			<label for = "search_keyword">검색어 입력</label>
		</form:form>
		<div id = "result">
		
		
		</div>
	</div>
	
</body>
</html>