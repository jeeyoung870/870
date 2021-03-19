<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<link href="${contextPath}/resources/css/static/default.css"
	rel="stylesheet" />
<link href="${contextPath}/resources/css/mainpage/main.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script>
	let weatherApi = "http://api.openweathermap.org/data/2.5/weather?id=1835848&appid=dd11141cd9e0952ebf50893a2d1f6cc1&units=metric";
	$
			.ajax({
				url : weatherApi,
				dataType : "json",
				type : "GET",
				async : "false",
				success : function(data) {
					//console.log(data);       
					//alert(data.list[0].main.temp_min)
					let $minTemp = data.main.temp_min;
					let $maxTemp = data.main.temp_max;
					let $cTemp = data.main.temp;
					//let $cDate = data.dt;
					let $wIcon = data.weather[0].icon;

					let $now = new Date(Date.now());
					let $time = $now.getHours() + ':' + $now.getMinutes();

					$("#section1 h2").append($time);
					$("#section1 .ctemp").prepend($cTemp);
					$("#section1 .clowtemp").append($minTemp);
					$("#section1 .chightemp").append($maxTemp);
					$("#section1 .cicon")
							.append(
									'<img src="http://openweathermap.org/img/wn/'+ $wIcon +'.png">');
				}
			})
</script>
</head>
<body>
	<figure id="visual">
		<div class="inner">
			<div class="textContents">
				<h1>HILS</h1>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
				<a href="#">자세히보기</a>
				<div></div>
			</div>
			<section class="autoplay visual">
				<div>
					<img src="${contextPath}/resources/images/main0.jpg">
				</div>
				<div>
					<img src="${contextPath}/resources/images/main1.jpg">
				</div>
				<div>
					<img src="${contextPath}/resources/images/main2.jpg">
				</div>
			</section>
		</div>
	</figure>
	<div id="wrap">
		<section id="section1">
			<div class="inner">
				<div class="section1-container">
					<h2 class="time"></h2>
					<div class="cicon item"></div>
					<div class="section1-temptable">
						<div class="ctemp item">° - Seoul</div>
						<div class="section1-temptable2">
							<div class="clowtemp item">최저:</div>
							<div>/</div>
							<div class="chightemp item">최고:</div>
						</div>
					</div>
				</div>
			</div>
			<div class="section-divider"></div>
		</section>
		<section id="section2">
			<div class="inner">
				<h1>이 달의 운동왕</h1>
				<div class="section2-container">
					<div class="usertable">test</div>
					<div class="usertable">test</div>
					<div class="usertable">test</div>
				</div>
			</div>
			<div class="section-divider"></div>
		</section>
		<section id="section3">
			<div class="inner">
				<h1>최신글</h1>
				<div class="section3-container">
					<div class="item">test</div>
					<div class="item">test</div>
				</div>
				<div class="section3-container">
					<div class="item">test</div>
					<div class="item">test</div>
				</div>
			</div>
			<div class="section-divider"></div>
		</section>
		<section id="section4">
			<img src="${contextPath}/resources/images/main3.jpg">
			<div class="inner">
				<div class="textContents">
					<h1>HILS</h1>
					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Non
						numquam atque eligendi, maxime, voluptatibus distinctio doloribus
						voluptates dolore eveniet exercitationem, laudantium a enim itaque
						modi id quos nostrum et officia?</p>
					<a href="#">자세히보기</a>
				</div>
			</div>
		</section>
		<section id="section5">
				<section class="autoplay visual">
					<div>
						<img src="http://placehold.it/150x150" />
					</div>
					<div>
						<img src="http://placehold.it/150x150" />
					</div>
					<div>
						<img src="http://placehold.it/150x150" />
					</div>
				</section>
		</section>
	</div>
	<script type="text/javascript">
		$('.autoplay').slick({
			slidesToShow : 1,
			slidesToScroll : 1,
			autoplay : true,
			autoplaySpeed : 3000,
		});
	</script>
</body>
</html>