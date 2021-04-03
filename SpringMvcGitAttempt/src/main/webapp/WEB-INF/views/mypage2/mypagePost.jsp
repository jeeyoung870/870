<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<style>
#wrap {
	height: 100vh;
}

#wrap section.faq-view .location-bar>h1 {
	font-size: 22px;
	font-style: medium;
	font-weight: 600;
	line-height: 52px;
	text-align: center;
}

.faq-view-category {
	padding: 10px 20px;
}

#wrap section.faq-view #tableTest {
	width: 420px;
}

#wrap section.faq-view #tableTest tbody tr {
	height: 60px;
	line-height: 60px;
	border-bottom: 1px solid #333;
	display: block;
}

#wrap section.faq-view #tableTest .faq-view-num {
	font-weight: bold;
}

#wrap section.faq-view #tableTest .faq-view-subject {
	
}

#wrap section.faq-view #tableTest tbody tr:first-child {
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
}

#wrap section.faq-view .location-bar hr {
	background-color: #FF9A7F;
	border: 0;
	height: 20px;
}

#faq-paging-wrap {
	text-align: center;
}

/* 커스텀 */
.myActivity-schedule-ul {
	display: flex;
	padding: 0 10px;
}

.myActivity-schedule-ul>li>a {
	padding: 10px 10px;
	display: block;
}

.add {
	color: #FF3600;
}
</style>
</head>
<body>
	<div id="wrap">
		<section class="faq-view">
			<div class="location-bar">
				<h1>나의 활동</h1>
				<hr>
			</div>
				<div>
				<ul class="myActivity-schedule-ul">
					<li><a href="myActivitySchedule">내 힐린더</a></li>
					<li><a href="viewMyPost" class="add">내 작성글</a></li>
				</ul>
				<hr />
			</div>
			<div class="faq-view-category">
				<form>
					<input type="hidden" value="${param.requestPage}" id="reqValue" />
				</form>
				<form>
					<select name="category" id="selectCategory" class="selectpicker">
						<option value="general" selected="selected">카테고리 선택</option>
						<option value="0">ask</option>
						<option value="1">tip</option>
						<option value="2">모바일</option>
					</select>
				</form>
			</div>
			<c:if test="${list.count == 0}">
				<table id="tableTest" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="center">게시판에 저장된 글이 없습니다.</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${list.count > 0}">
				<table id="tableTest" cellpadding="0" cellspacing="0" align="center">
					<c:forEach var="article" items="${list.boardList}">
						<tr height="30">
							<td align="center" width="100" class="faq-view-num">
									<c:set var="number" value="${number - 1}" />
									<c:out value="${number+1}" /> 
							</td>
							<td width="300" class="faq-view-subject"><a
								href="faqViewContent?num=${article.b_number}&p=${list.requestPage}">${article.b_subject}</a>
							</td>
						</tr>
						<tr>
							<td>${article.user_id}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

			<c:if test="${list.count > 0}">
				<div id="faq-paging-wrap">
					<c:if test="${list.p.beginPageNumber > 10}">
						<a href="faqboard?p=${list.p.beginPageNumber-1}">이전</a>
					</c:if>
					<c:forEach var="pno" begin="${list.p.beginPageNumber}"
						end="${list.p.endPageNumber}">
						<a href="faqboard?p=${pno}">[${pno}]</a>
					</c:forEach>
					<c:if test="${list.p.endPageNumber < list.p.totalPageCount}">
						<a href="faqboard?p=${list.p.endPageNumber + 1}">다음</a>
					</c:if>
				</div>
			</c:if>
		</section>
	</div>
</body>
</html>