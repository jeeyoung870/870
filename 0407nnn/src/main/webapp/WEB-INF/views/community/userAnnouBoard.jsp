<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/mainBoard.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	header {
		display : flex;	
	}
	#upper{
		font-size: 22px;
		font-style: medium;
		font-weight: 600; line-height: 52px;
		text-align: center;
	}
	.inner > hr{
		background-color:#FF9A7F; 
		border: 0; 
		height: 20px;
	}
</style>
</head>
<body>

	
	<div class = "inner">
		<div id = "upper"><span>공지 사항</span></div>
		<hr/>
		
		<table id = "mainTable" class="table">
			<tr>
				<td>tag</td>
				<td>제목</td>
				<td>작성자</td>
				<td>등록일</td>
				
			</tr>
				<c:forEach var = "article" items = "#{annouList }" >
					<tr>
						<td>통합 공지</td>
						<td><a href = "./manageSpecificAnnou?annou_writing_num=${article.annou_writing_num }">${article.subject }</a> </td>
						<td>관리자 </td>
						
						<td><fmt:formatDate value="${article.annou_reg_date}" pattern="yy-MM-dd HH:mm" var= "annou_date"/>
							${annou_date }
						</td>
					</tr>
				</c:forEach>
		</table>
	
		<div>
		<table>
		 
			<tr><td>
				<ul class = "pagination">
					<li><a href = "./userAnnouBoard?requestPage=${annouPaging.beginPageNumber }">${annouPaging.beginPageNumber }</a></li>
				<c:if test = "${ annouPaging.endPageNumber > 1}">
					<c:forEach begin = "${annouPaging.beginPageNumber + 1 }" end = "${annouPaging.endPageNumber - 1 }" var = "pageNumber">
				
						<li><a href = "./userAnnouBoard?requestPage=${pageNumber }">${pageNumber }</a></li>
								
					</c:forEach>
				</c:if>
				<c:if test = "${annouPaging.endPageNumber ne annouPaging.beginPageNumber}">
					<li><a href = "./userAnnouBoard?requestPage=${annouPaging.endPageNumber }">${annouPaging.endPageNumber }</a></li>
				<!-- 페이지가 하나라면 이슈가 발생할 것 1 1 로 출력 -->
				</c:if>
				</ul>
			</td>
			</tr>
		</table>
		</div>
	</div>
</body>
</html>