<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.inner{
		width : 420px;
		margin : 0 auto;
	}
	#writeBtn{
		flaot : right;
	}
</style>
</head>
<body>
	<div class = "inner">
		<c:if test = "${annouCount ne null}">
			총 ${annouCount }개의 공지사항이 존재합니다.
		</c:if>
		<div id = "writeBtn"><a href = "goToWriteNewAnnouncement">등록</a></div>
		<br/>
		<hr/>
		<br/>
		<select id = "searchOption" name = "searchOption">
			<option value = "general" selected>통합 검색</option>
			<option value = "subject">제목</option>
			<option value = "user_id">유저 아이디</option>
		</select>
		<input type = "text" id = "searchKeyword" name = "searchKeyword"/>
		<div id = "searchBtn">
			<img src = "${contextPath }/resources/images/searchButton.png">
		</div>
		<div id = "result">
		</div>
	</div>
	<script type = "text/javascript">
		document.getElementById("searchBtn").addEventListener("click", handleSearch)
		
		function handleSearch(event){
			event.preventDefault()
	
			let searchOption = $("#searchOption").val();
			let searchKeyword = $("#searchKeyword").val();
			let url = "searchAnnou"
			let data = {"searchOption" : searchOption, "searchKeyword" : searchKeyword}

			$.ajax({
				dataType : "json",
				data : data,
				url : url,
				method : "GET"
			}).done(function(result){
				
				let annouList = result.annouList;
				let html = ""
				for (let annou of annouList){
					html += "<div class = 'singleUnit'><span class = 'unitline1'>[ 일반 ] </span>"
					html += "<span class = 'unitline1'><a href = 'manageSpecificAnnou?annou_writing_num="+annou.annou_writing_num + "'>" + annou.subject + "</a></span><br/><br/>"
					html += "<span class = 'unitline2'> 관리자 </span> | "
					html += "<span class = 'unitline2'>" + annou.annou_reg_date + "</span><br/><br/>"
					html += "<span class = 'CRUDBox'><a href = 'goToUpdateAnnou?annou_writing_num="+annou.annou_writing_num + "'>수정</a></span>"
					html += "<span class = 'CRUDBox'><a href = 'deleteAnnou?annou_writing_num="+annou.annou_writing_num + "'>삭제</a></span></div>"
				}
				$("#result").html(html);
				
			}).fail(function(){
				console.log("You've failed")
			})
		}
		
	</script>
</body>
</html>