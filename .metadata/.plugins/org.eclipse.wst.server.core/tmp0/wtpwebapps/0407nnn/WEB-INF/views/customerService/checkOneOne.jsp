<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/customerService1.css" rel="stylesheet" />
<title>Insert title here</title>
<style>
	.singleAsk{
		padding : 10px;
		position : relative
	}
	.ask_title_box{
		width : 280px;
	}
	.is_replied_box{
		float:right;
		position : absolute;
		top : 20px;
		right : 15px;
		
	}
	.single_hr{
		background-color:#FF9A7F; 
		border: 0; 
		height: 5px;
	}
</style>
</head>
<body>
<div class ="inner">
	<c:if test = "${askList.size() eq 0}">
		<h1>there is no ask!</h1>
	</c:if>
	<c:forEach var = "ask" items = "${askList }">
		<div class = "singleAsk">
			<div class = "ask_title_box">
			<ul>
				<li><a href = "checkOneOneContent?ask_num=${ask.ask_num }">${ask.ask_title }</a>
				</li>
				<li><fmt:formatDate value = "${ask.ask_date }" pattern = "yyyy-MM-dd"/>
				</li>
			</ul>
			</div>
			<div class = "is_replied_box">
				<c:if test = "${ask.is_replied eq 'N'}">
					답변 대기
				</c:if>
				<c:if test = "${ask.is_replied eq 'Y' }">
				 	답변 완료
				</c:if>
			</div>
		</div>
		<hr class ="single_hr"/>
	</c:forEach>
</div>
</body>
</html>