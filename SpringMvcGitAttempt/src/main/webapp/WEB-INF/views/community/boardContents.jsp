<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/mainBoard.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
	.line1.div{
		position : relative;
		min-height : 34;
		border-bottom : 1px dotted #c18d74;
	}
	.line1.div > .line1.elem1{
	    position: absolute;
	    font-size: 12;
	    top: 0;
	    left: 0;
}
	.line1.div > .line1.elem2{
	    position: absolute;
   	 	font-size: 12;
    	top: 0;
    	left: 50;
	}
	.line1.elem3{
		left: 0;
	    position: absolute;
	    font-size: 12;
	    top: 15;
	}
	.line1.elem4{
	    position: absolute;
    	font-size: 12;
    	left: 65;
    	top: 15;
	}
	.line2.div{
		float:left;
		position : relative;
	}
	.line2.elem1{
		display:none;
	}
	.content.main > .elem1{
		display:none;
	}
	.line3.elem2{
	    position: absolute;
    	right: 0;
    	}
    .content.line2{
	    border-bottom: dotted 1px #a75d29;
	    position: relative;
    }
    .content.main {
    	margin : 10px
    }
    .line5.elem2{
    	word-break:break-all;
    }
    .line2.div > .line2.elem2{
     	word-break:break-all;
    }
</style>
</head>
<body>
	<div class = "inner">
	<a href = "goUpdateForm?b_number=${specificContent.b_number }" class = "boardBtn">update</a>
	<a href = "deleteContent?b_number=${specificContent.b_number }" class = "boardBtn">delete</a>
	<!-- <a href = "writeSubArticle?b_number=${specificContent.b_number }">write sub article</a>-->
	<div class = "content main">
		<div class = "content line1">
			<span class = "line1 elem1">Category : </span>
			<span class = "line1 elem2">[ ${specificContent.b_category } ] </span>
			<span class = "line4 elem1">Subject : </span>
			<span class = "line4 elem2">${specificContent.b_subject }</span>
		</div>
		<div class = "content line2">
			<span class = "line2 elem1">user_id : </span>
			<span class = "line2 elem2">${specificContent.user_id }</span>
			<span class = "line3 elem1">reg_date :</span>
			<span class = "line3 elem2">${specificContent.b_reg_date }</span>
		</div>
		<div class = "content line3">
		</div>
		<div class = "content line4">
		</div>
		<div class = "content line5">
			<span class = "line5 elem1">Content :</span>
			<span class = "line5 elem2">${specificContent.b_content }</span>
		</div>
		
	</div>
	<hr/>
	
	<c:forEach var = "subArticle" items = "${subArticleList }">
	<div class = "singleComment">
	
		<div class = "line1 div">
			<span class = "line1 elem1">user_id : </span>
			<span class = "line1 elem2">${subArticle.user_id }</span>
			<span class = "line1 elem3">c_reg_date : </span>
			<span class = "line1 elem4">${subArticle.c_reg_date }</span>
		</div>
		<br/>
		<div class = "line2 div">
			<span class = "line2 elem1">sub Content: </span>
			<span class = "line2 elem2">${subArticle.c_content }</span>
		</div>
	
	</div>
	</c:forEach>
	
	<form action = "writeSubArticle" method = "Post">
		<input type = "hidden" name = "b_number" value = "${specificContent.b_number }"/>
		<label for = "c_content"></label>
		<div class = "form-group">
			<textarea name = "c_content" class = "form-control">enter Comments</textarea>
			<input type = "submit" value = "write new Comment" class = "boardBtn"></input>
		</div>
	</form>
	</div>
</body>
</html>