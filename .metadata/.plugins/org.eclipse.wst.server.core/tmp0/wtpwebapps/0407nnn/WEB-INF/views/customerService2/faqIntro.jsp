<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap .location-bar {
	border-bottom: 1px solid #333;
}

#wrap section.faq>div.location-bar>h1 {
	text-align: center;
	padding: 10px 0;
	font-size: 18px;
}

#wrap section.faq>div.faq-intro-content {
	padding: 20px 75px;
}

#wrap section.faq img {
	height: 100px;
}

#wrap section.faq .faq-container {
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 20px 0;
}

#wrap section.faq .faq-intro-text {
	text-align: center;
	padding-top: 20px;
	font-weight: bold;
	color: #FF3600;
	font-size: 24px;
}

#wrap section.faq a {
	display: block;
}

#wrap section.faq img {
	display: block;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id="wrap">
		<section class="faq">
			<div class="location-bar">
				<h1>FAQ</h1>
			</div>
			<div class="faq-intro-content">
				<div class="faq-container">
					<div>
						<a href="faqViewCategory?category=0"> <img
							src="${contextPath}/resources/images/faq/faq1.png">
							<p class="faq-intro-text">계정문제</p>
						</a>
					</div>
					<div>
						<a href="faqViewCategory?category=1"> <img
							src="${contextPath}/resources/images/faq/faq2.png">
							<p class="faq-intro-text">커뮤니티</p>
						</a>
					</div>
				</div>
				<div class="faq-container">
					<div>
						<a href="faqViewCategory?category=2"> <img
							src="${contextPath}/resources/images/faq/faq3.png">
							<p class="faq-intro-text">모바일</p>
						</a>
					</div>
					<div>
						<a href="faqViewCategory?category=3"> <img
							src="${contextPath}/resources/images/faq/faq4.png">
							<p class="faq-intro-text">기능</p>
						</a>
					</div>
				</div>
				<div class="faq-container">
					<div>
						<a href="faqViewCategory?category=4"> <img
							src="${contextPath}/resources/images/faq/faq5.png">
							<p class="faq-intro-text">통계</p>
						</a>
					</div>
					<div>
						<a href="faqViewCategory?category=5"> <img
							src="${contextPath}/resources/images/faq/faq6.png">
							<p class="faq-intro-text">기타</p>
						</a>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>