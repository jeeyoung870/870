<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
#wrap {
min-height:100vh;
}

#wrap section.myAct-view .location-bar>h1 {
	font-size: 22px;
	font-style: medium;
	font-weight: 600;
	line-height: 52px;
	text-align: center;
}

.myAct-view-category {
	padding: 10px 20px;
}

#wrap section.myAct-view #tableTest {
	width: 420px;
}

/*
#wrap section.myAct-view #tableTest tbody>tr {
	height: 60px;
	border-bottom: 1px solid #333;
	display: block;
}
*/

#wrap section.myAct-view #tableTest tbody>tr>td {
	/*line-height: 60px;*/
	
}

#wrap section.myAct-view #tableTest .myAct-view-num {
	font-weight: bold;
}

#wrap section.myAct-view #tableTest .myAct-view-subject {
	
}

/*#wrap section.myAct-view #tableTest tbody tr:first-child {
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
}
*/
#wrap section.myAct-view .location-bar hr {
	background-color: #FF9A7F;
	border: 0;
	height: 20px;
}

#myAct-paging-wrap {
	text-align: center;
    padding: 20px 0;
    margin-bottom: 50px;
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
/*게시판*/
.myAct-view-content {
	border-bottom: 1px solid #999;
}
.myAct-view-content:first-child {
	border-top: 1px solid #999;
}
.myAct-view-content:after {
	content: '';
	display: block;
	clear: both;
}

.myAct-view-num {
	width: 15%;
	float: left;
	text-align: center;
	line-height: 60px;
	font-weight: bold;
}

.myAct-view-subject {
	width: 85%;
	float: right;
	padding: 10px 5px;
	box-sizing: border-box;
}

.myAct-view-subject>.myAct-view-subject-userInfo {
	color: #888;
}
</style>
</head>
<body>
	<div id="wrap">
		<section class="myAct-view">
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
			<div class="myAct-view-category">
				<form>
					<input type="hidden" value="${param.requestPage}" id="reqValue" />
				</form>
				<form>
					<select name="category" id="selectCategory" class="selectpicker">
						<option value="#" selected="selected">카테고리 선택</option>
						<option value="general">general</option>
						<option value="ask">ask</option>
						<option value="tip">tip</option>
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
				<div id="tableTest"> 
					<c:forEach var="article" items="${list.boardList}">
						<div height="30" class="myAct-view-content">
							<div rowspan="2" class="myAct-view-num">
								${article.b_number}
							</div>
							<div class="myAct-view-subject">
								<c:choose>
									<c:when test="${fn:length(article.b_subject) > 10}">
										<div>
											<a href="./showArticleContent?b_number=${article.b_number}"><c:out value="${fn:substring(article.b_subject,0,23)}" />....</a>
										</div>
									</c:when>
									<c:otherwise>
										<div>
											<a href="./showArticleContent?b_number=${article.b_number}"><c:out value="${article.b_subject}" /></a>
										</div>
									</c:otherwise>
								</c:choose>
								<div class="myAct-view-subject-userInfo">${article.user_id} | ${article.b_reg_date}</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>

			<c:if test="${list.count > 0}">
				<div id="myAct-paging-wrap">
					<c:if test="${list.p.beginPageNumber > 10}">
						<a href="viewMyPost?p=${list.p.beginPageNumber-1}"">이전</a>
					</c:if>
					<c:forEach var="pno" begin="${list.p.beginPageNumber}"
						end="${list.p.endPageNumber}">
						<a href="viewMyPost?p=${pno}" >[${pno}]</a>
					</c:forEach>
					<c:if test="${list.p.endPageNumber < list.p.totalPageCount}">
						<a href="viewMyPost?p=${list.p.endPageNumber + 1}">다음</a>
					</c:if>
				</div>
			</c:if>
		</section>
	</div>
	<script type="text/javascript">
		$(function() {
			// 카테고리를 선택하면 다음 함수를 실행한다.
			$("#selectCategory").change(handleCategoryChange)
		})

		function handleCategoryChange() {
			let categoryVal = $("#selectCategory").val();
			let url = "viewMyPostJson"
			let reqValue = $("#reqValue").val();
			let data = {
				"category" : categoryVal,
				"requestPage" : reqValue
			}
			$.ajax({
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
								
								result.MyActBoardList
										.forEach(function(elem) {
											
											htmls += "<div height='30' class='myAct-view-content'>"
											      + "<div rowspan='2' class='myAct-view-num'>"
											      + elem.b_number
											      + "</div>"
											      + "<div class='myAct-view-subject'>"
											if((elem.b_subject).length > 10){
											 htmls += "        <div>"
												   + "         <a href='./showArticleContent?b_number="+elem.b_number+"'>"+(elem.b_subject).substr(0,23) +"....</a>"
											       + "        </div>"
											} else{
											 htmls += "        <div>"
											       + "          <a href='./showArticleContent?b_number="+elem.b_number+"'>"+elem.b_subject+"</a>"
											       + "        </div>" 
											}
											 htmls += "<div class='myAct-view-subject-userInfo'>" + elem.user_id + " | "+elem.b_reg_date+"</div>"
											       + "</div>"
											       + "</div>"
										})
								$("#tableTest:last").html(htmls);

								let list = result.pazing;
								if (list.beginPageNumber > 10) {
									pazing += "<a href=" + "'viewMyPost?category="+result.category+"&p="
											+ list.beginPageNumber - 1
											+ "'>이전</a>";
								}

								for (let pno = list.beginPageNumber; pno <= list.endPageNumber; pno++) {
									// onclick="handleCategoryChange()"
									// pazing += "<a href='viewMyPost?category="+result.category+"&p="+pno+"'>["
									 pazing += '<a href=#none onclick=handleCategoryChangePazing("' + pno +'","'+ result.category + '")>' 
											  + "["+ pno + "]</a>";
								}

								if (list.endPageNumber < list.totalPageCount) {
									pazing += "<a href='viewMyPost?category="+result.category+"&p="
											+ list.PendPageNumber + 1
											+ "'>다음</a>"
								}

								$("#myAct-paging-wrap:last").html(pazing);

							}).fail(
							function(request, error) {
								console.log("failed")
								alert("code:" + request.status + "\n"
										+ "message:" + request.responseText
										+ "\n" + "error:" + error)
							})
		}
		
		function handleCategoryChangePazing(requestPage,category){
			let url = "viewMyPostJson";
			let data = {
				"p" : requestPage,
				"category" : category
			}
			$.ajax({
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
								
								result.MyActBoardList
										.forEach(function(elem) {
											
											htmls += "<div height='30' class='myAct-view-content'>"
											      + "<div rowspan='2' class='myAct-view-num'>"
											      + elem.b_number
											      + "</div>"
											      + "<div class='myAct-view-subject'>"
											if((elem.b_subject).length > 10){
											 htmls += "        <div>"
												   + "         <a href='./showArticleContent?b_number="+elem.b_number+"'>"+(elem.b_subject).substr(0,23) +"....</a>"
											       + "        </div>"
											} else{
											 htmls += "        <div>"
											       + "          <a href='./showArticleContent?b_number="+elem.b_number+"'>"+elem.b_subject+"</a>"
											       + "        </div>" 
											}
											 htmls += "<div class='myAct-view-subject-userInfo'>" + elem.user_id + " | "+elem.b_reg_date+"</div>"
											       + "</div>"
											       + "</div>"
										})
								$("#tableTest:last").html(htmls);

								let list = result.pazing;
								if (list.beginPageNumber > 10) {
									pazing += "<a href=" + "'viewMyPost?category="+result.category+"&p="
											+ list.beginPageNumber - 1
											+ "'>이전</a>";
								}

								for (let pno = list.beginPageNumber; pno <= list.endPageNumber; pno++) {
									// onclick="handleCategoryChange()"
									// pazing += "<a href='viewMyPost?category="+result.category+"&p="+pno+"'>["
									 pazing += '<a href="#" onclick="handleCategoryChangePazing(' + pno +','+ category + ')">' 
											  + pno + "]</a>";
								}

								if (list.endPageNumber < list.totalPageCount) {
									pazing += "<a href='viewMyPost?category="+result.category+"&p="
											+ list.PendPageNumber + 1
											+ "'>다음</a>"
								}

								$("#myAct-paging-wrap:last").html(pazing);

							}).fail(
							function(request, error) {
								console.log("failed")
								alert("code:" + request.status + "\n"
										+ "message:" + request.responseText
										+ "\n" + "error:" + error)
							})
							return false;
			
		}
	</script>
</body>
</html>