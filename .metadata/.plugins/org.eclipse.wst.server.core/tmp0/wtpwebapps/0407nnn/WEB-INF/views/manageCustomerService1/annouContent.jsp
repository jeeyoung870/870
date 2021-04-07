<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.inner {
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
		position : absolute;
		right : 90px;
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
	
	<!-- <a href = "writeSubArticle?b_number=${specificContent.b_number }">write sub article</a>-->
	<div class = "content main">
		<div class = "content line1">
			
			<span class = "line4 elem1">Subject : </span>
			<span class = "line4 elem2">${annou.subject }</span>
		</div>
		<div class = "content line2">
			<span class = "line2 elem1">user_id : </span>
			<span class = "line2 elem2">관리자</span>
			<span class = "line3 elem1">reg_date :</span>
			<fmt:formatDate value="${annou.annou_reg_date }" var = "annou_date" pattern = "yyyy-MM-dd"/>
			<span class = "line3 elem2">${annou_date}</span>
		</div>
		<div class = "content line3">
		</div>
		<div class = "content line4">
		</div>
		<div class = "content line5">
			<span class = "line5 elem1"></span>
			<span class = "line5 elem2">${annou.content }</span>
		</div>
		
	</div>
	</div>
</body>
</html>