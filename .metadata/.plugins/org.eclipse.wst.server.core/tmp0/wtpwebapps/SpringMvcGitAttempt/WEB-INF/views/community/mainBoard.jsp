<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
		
<link href="${contextPath}/resources/css/mainBoard.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
header{
    	display:flex;
    }
</style>
</head>
<body>
	
	<form>
		<input type = "hidden" value = "${param.requestPage }" id = "reqValue"/>
	</form>
	<div class = "inner">
		<h1>MainBoard!</h1>
		<div>
			<form method = "get" action = "./goToWriteForm">
				<input type = "submit" value = "write" class="boardBtn	"/>
			</form>
			<!-- 
			<button type = "button" id = "generalCategory" value = "general">general</button>
			<button type = "button" id = "askCategory" value = "ask">ask</button>
			<button type = "button" id = "tipCategory" value = "tip">tip</button>
			<button type = 'button' id = "writeBtn" value = "write">write</button>
			-->
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
						<td>${article.b_category} </td>
						<td>${article.rownum }</td>
						<td><a href = "./showArticleContent?b_number=${article.b_number }">${article.b_subject }</a> </td>
						<td>${article.user_id } </td>
						<!-- 
						<td>${article.b_reg_date } </td>
						-->
						<td><fmt:formatDate value="${article.b_reg_date}" pattern="yy-MM-dd HH:mm"/></td>
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
			console.log("calling")
		})	
		
		function handleCategoryChange(){
			console.log("calling ajax")
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
				console.log(result.boardArticleList)
				result.boardArticleList.forEach(function(elem){
					htmls += "<tr><td>" + elem.b_category + "</td>"
					htmls += "<td>" + elem.b_number + "</td>"
					htmls += "<td><a href='./showArticleContent?b_number=" + elem.b_number + "'>" + elem.b_subject + "</a></td>"
					htmls += "<td>" + elem.uesr_id + "</td>"
					htmls += "<td>" + elem.b_reg_date + "</td></tr>"
 				})
 				$("#mainTable > tbody:last").html(htmls)
			}).fail(function(request, error){
				console.log("failed")
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error)
			})
		}
		
	</script>
</body>
</html>