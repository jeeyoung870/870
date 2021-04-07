<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
header{
	display:flex;
}
.inner{
	width : 420px;
	margin : 0 auto;
}
.singleUnit{
	width : 420px;
	line-height : 2em;
	padding : 10px;
}
.unitline1{
	font-weight : bold;
}

.singleUnit hr{
	background-color:#FF9A7F; 
	border: 0; 
	height: 5px;
	margin : 0;
}

.CRUDBox{
	display :block;
	width : 180px;
	text-align : center;
	border : dotted 1px grey;
	float : left;	
}
</style>
</head>
<script>
		function handleDisappearAndAppear(){
			$(".hide2").hide();
			$(".singleUnit").click(function(){
				console.log("called")		
				if($(this).next().is(":visible")){
					$(this).next().stop().slideUp(200);
				}else{
					console.log("called")
					$(".hide2").stop().slideUp(500);
					$(this).next().stop().slideDown(200);
				};
			});
		}	
		function handleSearch(){
			let b_category = $("#b_category :selected").val()
			let search_option = $("#search_option :selected").val()
			let start_date = $("#start_date").val()
			let end_date = $("#end_date").val()
			let search_keyword = $("#search_keyword").val()
			let data = {"b_category" : b_category, "search_option" : search_option, 
						"prepro_start_date" : start_date, "prepro_end_date" : end_date, "search_keyword" : search_keyword
			}
			let url = "searchArticleManager"
			$.ajax({
				dataType : "json",
				method : "GET",
				data : data,
				url : url
			}).done(function(result){
				let searchResultList = result.searchResultList;
				let html = ""
				for(let searchResult of searchResultList){
					html += "<div class = 'singleUnit'><span class = 'unitline1'>[" + searchResult.b_category + "] </span>"
					html += "<span class = 'unitline1'>" + searchResult.b_subject + "</span><br/>"
					html += "<span class = 'unitline2'>" + searchResult.user_id + "</span> | "
					html += "<span class = 'unitline2'>" + searchResult.b_reg_date + "</span><br/><hr/></div>"
					html += "<div class = 'hide2'><span class = 'CRUDBox'><a href = 'goToManagerUpdateArticle?b_number=" + searchResult.b_number + "'>수정</a></span>"
					html += "<span class = 'CRUDBox'><a href = 'managerDeleteArticle?b_number=" + searchResult.b_number + "'>삭제	</a></span></div><hr/>"
				}  
				
				document.getElementById("result").innerHTML = html;
				handleDisappearAndAppear();
			}).fail(function(){
				console.log("You've Failed")
			})
			
		}
	
		</script>
<body>
	<div class = "inner">
		<form autocomplete="off">
			<div class = "form-group">
				<select name = "b_category" id = "b_category" class = "form-control">
					<option value = "general" selected>일반</option>
					<option value = "ask">질문</option>
					<option value = "tip">팁</option>
				</select>
	 			<select name = "search_option" id = "search_option" class = "form-control">
	 				<option value = "user_id">아이디</option>
	 				<option value = "b_subject" selected>제목</option> 
	 			</select>
	 		</div>
	 			<div class = "form-row">
		 			<div class = "col-md-5">
						<input type = "date" id = "start_date" name = "start_date" class = "form-control"/>
					</div>
					<div class = "col-md-2">
						 ~
					 </div>
					 <div class = "col-md-5">
				
						<input type = "date" id = "end_date" name = "end_date" class = "form-control"/>
					</div>
				</div>
			<div class = "form-group">
				<input type = "text" id = "search_keyword" name = "search_keyword" class = "form-control"/>
				<input type = "button" id = "searchBtn" value = "search!" onclick = "handleSearch()" class = "form-control"/>
			</div>
		</form>
		<div id = "result">
		</div>
	</div>
	
</body>
</html>