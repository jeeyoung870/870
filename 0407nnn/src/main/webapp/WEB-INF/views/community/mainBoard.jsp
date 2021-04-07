<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id= "now" class = "java.util.Date"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		
<link href="${contextPath}/resources/css/mainBoard.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
header{
    	display:flex;
    }
    
   td{
   	word-break:break-all;
   }
</style>
</head>
<body>
	<input type = "hidden" value = "${prev_b_category }" id = "hiddenCategory"/>
	<input type = "hidden" value = "${boardPaging.beginPageNumber }" id = "hiddenBegingPageNumber"/>
	<input type = "hidden" value = "${boardPaging.endPageNumber }" id  = "hiddenEndPageNumber"/>
	<form> 
		<input type = "hidden" value = "${param.requestPage }" id = "reqValue"/>
	</form>
	<div class = "inner">
		<h1>MainBoard!</h1>
		<div>
			<form method = "get" action = "./goToWriteForm">
				<input type = "submit" value = "write" class="boardBtn	"/>
			</form>
			<form>
				<select name = "category" id = "selectCategory" class="selectpicker">
					<option value = "general" selected = "selected">general</option>
					<option value = "ask">ask</option>
					<option value = "tip">tip</option>
				</select>
			</form>
		</div>
		<table id = "mainTable" class="table">
			<tr>
				<td>tag</td>
				<td>writing num</td>
				<td>subject</td>
				<td>writer</td>
				<td>reg_date</td>
			</tr>
				<c:forEach var = "article" items = "#{boardArticleList }" >
					<tr>
						<td><c:choose>
							<c:when test = "${article.b_category eq 'general' }">일반</c:when>
							<c:when test = "${article.b_category eq 'ask' }">질문</c:when>
							<c:when test = "${article.b_category eq 'tip' }">팁</c:when>
							<c:otherwise>에러</c:otherwise>
							</c:choose>
							</td>
						<td>${article.b_number }</td>
						<td><a href = "./showArticleContent?b_number=${article.b_number }">${article.b_subject }</a> </td>
						<td>${article.user_id } </td>
						<!-- 
						<td>${article.b_reg_date } </td>
						-->
						<td><fmt:formatDate value="${article.b_reg_date}" pattern="HH:mm" var = "if_today_reg_date"/>
							<fmt:formatDate value="${article.b_reg_date }" pattern = "MM-dd" var = "if_not_today_reg_date"/>
							<fmt:formatDate value = "${article.b_reg_date}" pattern = "yy-MM-dd" var = "to_compare_date"/>
							<fmt:formatDate value = "${article.b_reg_date }" pattern = "yy" var = "to_compare_year"/> 
							<fmt:formatDate value = "${now }" pattern = "yy-MM-dd" var = "today_day"/>
							<fmt:formatDate value = "${now }" pattern = "yy" var = "today_year"/>
							<c:choose>
								<c:when test = "${today_day eq to_compare_date }">${if_today_reg_date }</c:when>
								<c:when test = "${today_day ne to_compare_date and today_year eq to_compare_year }">${if_not_today_reg_date }</c:when>
								<c:otherwise>${to_compare_date }</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
		</table>
	
		<div>
		<table>
		 
			<tr><td>
				<ul class = "pagination">
					<li><a href = "./goBoard?requestPage=${boardPaging.beginPageNumber }">${boardPaging.beginPageNumber }</a></li>
				<c:if test = "${ boardPaging.endPageNumber > 1}">
					<c:forEach begin = "${boardPaging.beginPageNumber + 1 }" end = "${boardPaging.endPageNumber - 1 }" var = "pageNumber">
				
						<li><a href = "./goBoard?requestPage=${pageNumber }">${pageNumber }</a></li>
								
					</c:forEach>
				</c:if>
				<c:if test = "${boardPaging.endPageNumber ne boardPaging.beginPageNumber}">
					<li><a href = "./goBoard?requestPage=${boardPaging.endPageNumber }">${boardPaging.endPageNumber }</a></li>
				<!-- 페이지가 하나라면 이슈가 발생할 것 1 1 로 출력 -->
				</c:if>
				</ul>
			</td>
			</tr>
		</table>
		</div>
	</div>
	<script type = "text/javascript">
		/*$("#writeBtn").click(goToWriteForm)
		
		function goToWriteForm(){
			
		}*/	
		
		$(function(){
			$("#selectCategory").change(handleCategoryChange)
			let prev_category_value = $("#hiddenCategory").val();
			if(prev_category_value != "default"){
				$("#selectCategory option").each(function(){
					if(prev_category_value == $(this).val()){
						$(this).prop("selected", "selected");
					}
				})
				let beginPageNumber = parseInt($("#hiddenBegingPageNumber").val());
				let endPageNumber = parseInt($("#hiddenEndPageNumber").val());
				settingPagination(beginPageNumber, endPageNumber, prev_category_value);
 					
			}
		})	
		function settingPagination(beginPageNumber, endPageNumber, categoryVal){
			if(!isNaN(beginPageNumber) && !isNaN(endPageNumber)){
				console.log("called");
				let li_html = "<li><a "
				if(beginPageNumber == endPageNumber){
					li_html += "href='" + "./goBoard?requestPage=" + beginPageNumber + "&b_category=" + categoryVal + "'>" + beginPageNumber + "</a></li>"
					$(".pagination").html(li_html);
					//href = "./goBoard?requestPage=${pageNumber }">${pageNumber }</a></li>
				}else if(beginPageNumber + 1 == endPageNumber){
					li_html += "href='" + "./goBoard?requestPage=" + beginPageNumber + "&b_category=" + categoryVal + "'>" + beginPageNumber + "</a></li>"
				 	li_html += "<li><a href = '" + "./goBoard?requestPage=" + endPageNumber + "&b_category=" + categoryVal + "'>" + endPageNumber + "</a></li>"
				 	$(".pagination").html(li_html);
				}else{
					li_html += "href='" + "./goBoard?requestPage=" + beginPageNumber + "&b_category=" + categoryVal + "'>" + beginPageNumber + "</a></li>"
					for(let i = beginPageNumber + 1; i < endPageNumber ; i ++){
						li_html += "<li><a href = '" + "./goBoard?requestPage=" + i +"&b_category=" + categoryVal + "'>" + i + "</a></li>"
					}
					li_html += "<li><a href = '" + "./goBoard?requestPage=" + endPageNumber + "&b_category=" + categoryVal + "'>" + endPageNumber + "</a></li>"
					$(".pagination").html(li_html);
				}
			}
		}
		
		function handleCategoryChange(){
			
			let categoryVal = $("#selectCategory").val();
			let url = "./showBoard"
			let reqValue = $("#reqValue").val();
			let data = {"b_category" : categoryVal, "requestPage" : reqValue}
			
			$.ajax({
				data : data,
				url : url,
				dataType : "json",
				method : "POST"
			}).done(function(result){
				let htmls = ""
				htmls += "<tr><td>tag</td><td>writing num</td><td>subject</td><td>writer</td><td>b_reg_date</td></tr>"
				let today = new Date();
				result.boardArticleList.forEach(function(elem){
					if(elem.b_category == "general"){
						htmls += "<tr><td>" + "일반" + "</td>"
					}else if(elem.b_category == "tip"){
						htmls += "<tr><td>" + "팁" + "</td>"
					}else{
						htmls += "<tr><td>" + "질문" + "</td>"
					}
					htmls += "<td>" + elem.b_number + "</td>"
					htmls += "<td><a href='./showArticleContent?b_number=" + elem.b_number + "'>" + elem.b_subject + "</a></td>"
					htmls += "<td>" + elem.user_id + "</td>"
					
					let article_date_js = new Date(elem.b_reg_date);
					if(today.getDate() == article_date_js.getDate()){
						htmls += "<td>" + article_date_js.getHours() + " : " + article_date_js.getMinutes() + "</td></tr>"
					}else if(today.getFullYear() == article_date_js.getFullYear()){
						if(article_date_js.getMonth() + 1 > 10){
							htmls += "<td>" + (article_date_js.getMonth() + 1)+ " : " + article_date_js.getDate() + "</td></tr>"
						}else{
							htmls += "<td> 0" + (article_date_js.getMonth() + 1)+ " - " + article_date_js.getDate() + "</td></tr>"
						}
						
					}else{
						htmls += "<td>" + article_date_js.getFullYear() + ":" + (article_date_js.getMonth() +1) + " : " + article_date_js.getDate() + "</td></tr>"
					}
					
 				})
 				$("#mainTable > tbody:last").html(htmls)
 				if(result.isCategory != ""){
 					console.log("called")
 					let boardPaging = result.boardPaging
 					settingPagination(boardPaging.beginPageNumber, boardPaging.endPageNumber, categoryVal);
 				/*
 					let li_html = "<li><a "
 					
 				
 					if(boardPaging.beginPageNumber == boardPaging.endPageNumber){
 						li_html += "href='" + "./goBoard?requestPage=" + boardPaging.beginPageNumber + "&b_category=" + categoryVal + "'>" + boardPaging.beginPageNumber + "</a></li>"
 						$(".pagination").html(li_html);
 						//href = "./goBoard?requestPage=${pageNumber }">${pageNumber }</a></li>
 					}else if(boardPaging.beginPageNumber + 1 == boardPaging.endPageNumber){
 						li_html += "href='" + "./goBoard?requestPage=" + boardPaging.beginPageNumber + "&b_category=" + categoryVal + "'>" + boardPaging.beginPageNumber + "</a></li>"
 					 	li_html += "<li><a href = '" + "./goBoard?requestPage=" + boardPaging.endPageNumber + "&b_category=" + categoryVal + "'>" + boardPaging.endPageNumber + "</a></li>"
 					 	$(".pagination").html(li_html);
 					}else{
 						li_html += "href='" + "./goBoard?requestPage=" + boardPaging.beginPageNumber + "&b_category=" + categoryVal + "'>" + boardPaging.beginPageNumber + "</a></li>"
 						for(let i = boardPaging.beginPageNumber + 1; i < boardPaging.endPageNumber ; i ++){
 							li_html += "<li><a href = '" + "./goBoard?requestPage=" + i +"&b_category=" + categoryVal + "'>" + i + "</a></li>"
 						}
 						li_html += "<li><a href = '" + "./goBoard?requestPage=" + boardPaging.endPageNumber + "&b_category=" + categoryVal + "'>" + boardPaging.endPageNumber + "</a></li>"
 						$(".pagination").html(li_html);
 					}
 					*/
 					
 				}
 				
			}).fail(function(request, error){
				console.log("failed")
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error)
			})
		}
		function getFormatDate(date){
			
		}
		
	</script>
</body>
</html>