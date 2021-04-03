<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<%
	String reporter_id = (String) session.getAttribute("Email");
	String reported_id = request.getParameter("id");
%>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<style type="text/css">
#report {
	border: 17px solid lightblue;
	padding: 5px 20px;
	position: absolute;
	top: 35%;
	left: 50%;
	width: 390px;
	height: 480px;
	margin-left: -195px;
	margin-top: -170px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

h1 {
	font-size: 25px;
	padding-bottom: 20px;
}

.form {
	width: 300px;
}

.form>div {
	display: flex;
	justify-content: center;
	padding-bottom: 7px;
	align-items: left;
}

label {
	text-align: left
}

input {
	padding: 5px;
}
</style>
<meta charset="EUC-KR">
<title>신고하기</title>
</head>
<body>
	<div id="report">
		<h1>신고 내용 작성</h1>

		<section id="container">
			<form action=reportWrite method="POST" class="form">

				<!-- ========================================================================================== -->
				<!-- 게시글 작성자 정보를 어떻게 가져와야할지.. -->
				<label class="control-label">신고대상: <%= reported_id %></label><br/> 
				<!-- ========================================================================================== -->
				<label class="control-label" for="userPass">신고내용</label>
				<textarea style="resize: none;" class="form-control" rows="10"
					placeholder="신고내용을 간략히 적어주세요" name="r_content" required></textarea>
				<br /> 
								
				<!-- 작성자, 신고대상자 이메일 -->
				<input type="hidden" name="reported_user" value="<%= reported_id %>"><a></a>
				<input
					type="hidden" name="reporter_user" value="<%=reporter_id%>">
				<a></a>
				<div class="button">
					<button class="btn btn-danger" type="submit" id="submit">신고하기</button>
				</div>
			</form>
		</section>
	</div>
</body>
</html>