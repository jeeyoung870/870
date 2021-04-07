<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#wrap {
	height: 80vh;
}

#wrap section>div.location-bar>h1 {
	font-size: 22px;
	font-style: medium;
	font-weight: 600;
	line-height: 52px;
	text-align: center;
}

#wrap section .location-bar hr {
	background-color: #FF9A7F;
	border: 0;
	height: 20px;
}
</style>
</head>
<body>
	<div id="wrap">
		<section>
			<div class="location-bar">
				<h1>�� ����</h1>
				<hr />
			</div>
			<div>
				<a href="${contextPath }/manageCustomerService/userAnnouBoard">���� ����</a><br> 
				<a href="faqIntro">FAQ</a><br>
				<a href="${contextPath}/customerService/goOneOneForm">1 �� 1 ���� �ϱ�</a><br /> 
				<a href="${contextPath}/customerService/goCheckOneOne">1 �� 1 ���� ����</a><br />
			</div>
		</section>
	</div>

</body>
</html>