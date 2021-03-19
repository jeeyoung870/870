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
				<li>${ask.ask_title }
				</li>
				<li><fmt:formatDate value = "${ask.ask_date }" pattern = "yyyy-mm-dd"/>
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
	</c:forEach>
</div>
</body>
</html>