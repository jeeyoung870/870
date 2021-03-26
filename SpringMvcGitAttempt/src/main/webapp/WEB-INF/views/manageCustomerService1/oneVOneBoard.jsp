<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
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
	<table id = "mainTable" class="table">
			<tr>
				<td>ask_num</td>
				<td>user_id</td>
				<td>ask_title</td>
			
				<td>ask_date</td>
				<td>is_replied</td>
			</tr>
				<c:forEach var = "ask" items = "#{askList }" >
					<tr>
						<td>${ask.ask_num} </td>
						<td>${ask.user_id}</td>
						<td><a href = "./showAskContent?ask_num=${ask.ask_num }">${ask.ask_title }</a> </td>
						<td>${ask.is_replied } </td>
						<!-- 
						<td>${article.b_reg_date } </td>
						-->
						<td><fmt:formatDate value="${ask.ask_date}" pattern="yy-MM-dd HH:mm"/></td>
					</tr>
				</c:forEach>
		</table>
		<table>
		
			<tr><td>
				<ul class = "pagination">
					<li><a href = "./showOneVOneBoard?requestPage=${boardPaging.beginPageNumber }">${boardPaging.beginPageNumber }</a></li>
				<c:if test = "${ boardPaging.endPageNumber ne 1}">
					<c:forEach begin = "${boardPaging.beginPageNumber + 1 }" end = "${boardPaging.endPageNumber - 1 }" var = "pageNumber">
				
					<li><a href = "./showOneVOneBoard?requestPage=${pageNumber }">${pageNumber }</a></li>
								
					</c:forEach>
				</c:if>
				<c:if test = "${boardPaging.endPageNumber ne boardPaging.beginPageNumber}">
					<li><a href = "./showOneVOneBoard?requestPage=${boardPaging.endPageNumber }">${boardPaging.endPageNumber }</a></li>
				<!-- 페이지가 하나라면 이슈가 발생할 것 1 1 로 출력 -->
				</c:if>
				</ul>
			</td>
			</tr>
		</table>
	</div>
</body>
</html>