<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
</style>
</head>
<body>
	<div id="wrap">
		<section class="faq-view">
			<div class="location-bar">
				<h1>Test</h1>
				<hr>
			</div>
			<div class="faq-view-category">
				<form>
					<input type="hidden" value="${param.requestPage}" id="reqValue" />
				</form>
				<form>
					<select name="category" id="selectCategory" class="selectpicker">
						<option value="general" selected="selected">카테고리 선택</option>
						<option value="0">계정 문제</option>
						<option value="1">커뮤니티</option>
						<option value="2">모바일</option>
						<option value="3">기능</option>
						<option value="4">통계</option>
						<option value="5">기타</option>
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
									<c:out value="Q${number+1}" /> 
							</td>
							<td width="300" class="faq-view-subject"><a
								href="faqViewContent?num=${article.num}&p=${list.requestPage}">${article.subject}</a>
							</td>
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
	<script type="text/javascript">
		$(function() {
			$("#selectCategory").change(handleCategoryChange)
			console.log("calling")
		})

		function handleCategoryChange() {
			console.log("calling ajax")
			let categoryVal = $("#selectCategory").val();
			let url = "faqviewjson"
			let reqValue = $("#reqValue").val();
			let data = {
				"category" : categoryVal,
				"requestPage" : reqValue
			}

			$
					.ajax({
						data : data,
						url : url,
						dataType : "json",
						method : "POST"
					})
					.done(
							function(result) {
								console.log(result)
								let htmls = "";
								let pazing = "";
								htmls += "";
								result.faqList
										.forEach(function(elem) {
											htmls += "<tr><td align='center' width='100' class='faq-view-num'>Q"
													+ elem.num + "</td>"
											htmls += "<td width='300'  class='faq-view-subject'><a href='./faqViewContent?num="
													+ elem.num
													+ "&p="
													+ result.requestPage
													+ "'>"
													+ elem.subject
													+ "</a></td>"
										})
								$("#tableTest > tbody:last").html(htmls);

								let list = result.pazing;
								if (list.beginPageNumber > 10) {
									pazing += "<a href=" + "'faqboard?p="
											+ list.beginPageNumber - 1
											+ "'>이전</a>";
								}

								for (let pno = list.beginPageNumber; pno <= list.endPageNumber; pno++) {

									pazing += "<a href='faqboard?p=${pno}'>["
											+ pno + "]</a>";
								}

								if (list.endPageNumber < list.totalPageCount) {
									pazing += "<a href='faqboard?p="
											+ list.endPageNumber + 1
											+ "'>다음</a>"
								}

								$("#faq-paging-wrap:last").html(pazing);
							}).fail(
							function(request, error) {
								console.log("failed")
								alert("code:" + request.status + "\n"
										+ "message:" + request.responseText
										+ "\n" + "error:" + error)
							})
		}
	</script>
</body>
</html>