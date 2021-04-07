<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="${contextPath}/resources/css/managemainpage2/managemainpage2.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<style>
	.img-wrap img {
		max-width: 300px;
	}
	.input-img {
	padding: 10px 0;
	}
</style>
<script>
	// div:nth-child(4) > img
	$(document).ready(function(){
		$(".input-img").on("change",function(e){
			var name = this.name;
			var file = this.files[0];
			let reader = new FileReader();
			reader.onload = function(e) {
				var selector = "input[name='"+name+"']";
				
				$(selector).next().next().children("img").attr("src", e.target.result).width(300);
			}
			reader.readAsDataURL(file);   
			
		})
	});
</script>
</head>
<body>
	<div id="wrap">
		<section>
			<div class="location-bar">
				<h1>디자인 설정</h1>
			</div>
			<div class="inner">
				<form action="modifymainimage1" method="post"
					enctype="multipart/form-data">
					<div class="contents">
						<div class="content-title">
							<h2>메인 이미지</h2>
						</div>
							파일:<input type="file" name="main1" class="input-img"><br />
							<div class="img-wrap">
								<img id="main1" src="${contextPath}/resources/images/main0.jpg"/>
							</div>
							파일:<input type="file" name="main2" class="input-img"><br />
							<div class="img-wrap">
								<img id="main2" src="${contextPath}/resources/images/main1.jpg"/>
							</div>
							파일:<input type="file" name="main3" class="input-img"><br /> 
							<div class="img-wrap">
								<img id="main3" src="${contextPath}/resources/images/main2.jpg"/>
							</div>
							<br />
						<div class="content-title">
							<h2>배너 이미지 디자인 변경하기</h2>
						</div>
						파일:<input type="file" name="banner"  class="input-img"><br />
						<div class="img-wrap">
								<img id="banner" src="${contextPath}/resources/images/main3.jpg"/>
							</div>
					</div>

					<input type="submit" value="수정하기" class="submit" />
				</form>
			</div>
		</section>
	</div>
</body>
</html>