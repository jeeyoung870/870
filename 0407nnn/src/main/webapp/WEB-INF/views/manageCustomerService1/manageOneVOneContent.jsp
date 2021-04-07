<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.inner{
	width : 420px;
	margin : 0 auto;
}
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
	.line3.elem1{
		position: absolute;
		right : 100px;
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
    header{
    	display:flex;
    }
</style>
</head>
<body>
<div class = "inner">
<div class = "content main">
		<div class = "content line1">
			<span class = "line1 elem1">is_replied : </span>
			<span class = "line1 elem2">[ ${askAndReplyList.is_replied } ] </span>
			<span class = "line4 elem1">Subject : </span>
			<span class = "line4 elem2">${askAndReplyList.ask_title }</span>
		</div>
		<div class = "content line2">
			<span class = "line2 elem1">user_id : </span>
			<span class = "line2 elem2">${askAndReplyList.user_id }</span>
			<span class = "line3 elem1">reg_date :</span>
			<span class = "line3 elem2">
			<fmt:formatDate value="${askAndReplyList.ask_date }" var = "ask_date" pattern = "yy-MM-dd-HH"/>
			${ask_date }</span>
		</div>
		<div class = "content line5">
			<span class = "line5 elem1"></span>
			<span class = "line5 elem2">${askAndReplyList.ask_content }</span>
		</div>

	<c:if test = "${askAndReplyList.is_replied eq 'Y' }">
	<div class = "singleComment">
	
		<div class = "line1 div">
			<span class = "line1 elem1">user_id : </span>
			<span class = "line1 elem2">관리자</span>
			<span class = "line1 elem3">TITLE : </span>
			<span class = "line1 elem4">${askAndReplyList.rep_title }</span>
		</div>
		<br/>
		<div class = "line2 div">
			<span class = "line2 elem1">sub Content: </span>
			<span class = "line2 elem2">${askAndReplyList.rep_content }</span>
		</div>
	
	</div>
	
	</c:if>
	</div>
	<c:if test = "${askAndReplyList.is_replied eq 'N' }">
	<form action = "writeReply" method = "Post">
		<div class = "form-group">
		<input type = "hidden" name = "ask_num" value = "${askAndReplyList.ask_num }"/>
		<label for = "c_content"></label>
		<input type = "text" name = "rep_title" class = "form-control"/>
		<div class = "form-group">
			<textarea name = "rep_content" class = "form-control" class = "form-control">enter Comments</textarea>
			<input type = "submit" value = "write Reply" class = "boardBtn form-control"></input>
		</div>
		</div>
	</form>
	</c:if>
</div>
</body>
</html>