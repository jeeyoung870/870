<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="${contextPath}/resources/css/manageCustomerService1/manageCustomerService1.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<style>
table .table-subject {
	padding: 20px 20px 10px;
	font-size: 18px;
}

table .table-subject>a>span {
	font-weight: bold;
	padding-right: 10px;
}

table .table-writer {
	padding: 5px 20px 20px;
	font-size: 12px;
}

table .table-button>td {
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
	border-right: 1px solid #333;
}

table .table-button>td:nth-child(2) {
	border-right: 0;
}

table .table-button>td>a {
	display: block;
	padding: 10px 0;
}

.pagebar {
	
}
</style>
</head>
<body>
	<div id="wrap">
		<section>
			<div class="location-bar">
				<h1>FAQ</h1>
			</div>
			<div class="inner graybackground">
				<div class="section-container">
					<b>[총 FAQ 게시글: ${list.count}개]</b> <a class="Registration"
						href="faqRegistration">등록</a>
				</div>
				<div class="section-container">
					<form method="post" name="writeform" action="faqmanageboard">
						<select id="category" name="category">
							<option value="general">::통합검색::</option>
							<option value="subject">제목</option>
							<option value="content">내용</option>
						</select> 
						<input type="text" size="30" maxlength="30" name="searchWord"> 
						<input type="submit" value="검색">
					</form>
				</div>
			</div>

			<c:if test="${list.count == 0}">
				<table id="tableTest" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="center">게시판에 저장된 글이 없습니다.</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${list.count > 0}">
				<table id="tableTest" border="0" cellpadding="0" cellspacing="0"
					align="center">
					<c:forEach var="article" items="${list.boardList}">
						<tr height="30">
							<td colspan="2" class="table-subject"><a
								href="faqContent?num=${article.num}&p=${list.requestPage}"><span>[${article.category}]</span>${article.subject}</a>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="table-writer">관리자</td>
						</tr>
						<tr class="table-button">
							<td align="center"><a
								href='faqUpdateForm?num=${article.num}&p=${pageNum}'>수정</a></td>
							<td align="center"><a
								href='faqDeleteForm?num=${article.num}'>삭제</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

			<div class="page-container">
				<c:if test="${list.count > 0}">
					<c:if test="${list.p.beginPageNumber > 10}">
						<a href="faqmanageboard?p=${list.p.beginPageNumber-1}">이전</a>
					</c:if>
					<c:forEach var="pno" begin="${list.p.beginPageNumber}"
						end="${list.p.endPageNumber}">
						<a href="faqmanageboard?p=${pno}">[${pno}]</a>
					</c:forEach>
					<c:if test="${list.p.endPageNumber < list.p.totalPageCount}">
						<a href="faqmanageboard?p=${list.p.endPageNumber + 1}">다음</a>
					</c:if>
				</c:if>
			</div>

		</section>
	</div>
</body>
</html>