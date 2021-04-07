<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type='text/css'>
a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	
}

a:active {
	text-decoration: underline;
}

a:hover {
	text-decoration: underline;
	background-image: url('text_dottdeline.gif');
	background-repeat: repeat-x;
	background-position: 50% 100%;
}

#wrap {
	height: 100vh;
}
#wrap section > div {
	    text-align: center;
}
#wrap section table {
	width: 420px;
}

#wrap section .faq-table-content {
	padding: 10px 20px;
	margin: 10px 20px;
	border: 1px solid #333;
	min-height: 300px;
	box-sizing: border-box;
}

#wrap section .faq-content-modify {
	background: #0383D8;
	width: 80px;
	text-align: center;
	color: #fff;
	padding: 5px 10px;
	border-radius: 5px;
	border: 0;
}

#wrap section .faq-content-button>td>input {
	background: #fff;
	width: 80px;
	text-align: center;
	color: #000;
	padding: 5px 10px;
	border-radius: 5px;
	border: 1px solid #333;
	cursor: pointer;
}

#wrap section .faq-content-button>td>input.faq-content-modify {
	background: #0383D8;
	color: #fff;
	border: 0;
}

</style>
</head>
<body>
	<div id="wrap">
		<section>
			<div>내용</div>
			<form>
				<table border="0" cellspacing="0" cellpadding="0" align="center">
					<tr height="30">
						<td align="center" width="125">제목</td>
						<td align="left" width="375" align="center" colspan="3">${article.subject}</td>
					</tr>
					<tr>
						<!-- <td align="center" width="125">내용</td> -->
						<td align="left" colspan="2">
							<div class="faq-table-content">${article.content}</div>
						</td>
					</tr>
					<tr height="30" class="faq-content-button">
						<td colspan="2" align="center"><input type="button"
							value="글수정" class="faq-content-modify"
							onclick="document.location.href='faqUpdateForm?num=${article.num}&p=${pageNum}'">

							<input type="button" value="글삭제" class="faq-content-delete"
							onclick="document.location.href='faqDeleteForm?num=${article.num}'">

							<input type="button" value="글목록" class="faq-content-boardlist"
							onclick="document.location.href='faqmanageboard?p=${pageNum}'">
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>