<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

<style>
#wrap {
	height: 100vh;
}

#wrap section>div>h1 {
	text-align: center;
	padding: 10px 0;
	font-size: 18px;
}

#wrap .location-bar {
	border-bottom: 1px solid #efefef;
}

#wrap #myChart {
	display: block;
	height: 210px;
	width: 380px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id="wrap">
		<section>
			<div class="location-bar">
				<h1>신규 회원가입 현황</h1>
			</div>
			<canvas id="myChart"></canvas>
			<div class="location-bar">
				<h1>주요 일정</h1>
			</div>
			<script>
				let url2 = "subscriberStatistics"
				$
						.ajax({
							url : url2,
							dataType : "json",
							type : "POST",
							error : function(error) {
								alert("Error!");
							},
							success : function(processedList) {
								var ctx = document.getElementById('myChart');
								var myChart = new Chart(
										ctx,
										{
											type : 'line',
											data : {
												labels : [ '1월', '2월', '3월',
														'4월', '5월', '6월', '7월',
														'8월', '9월', '10월',
														'11월', '12월' ], //chartLabels // labels: Object.keys(data),
												datasets : [ {
													label : '신규 회원가입자 수',
													data : processedList.list, // chartData //  data: Object.values(data)
													backgroundColor : [
															'rgba(255, 99, 132, 0.2)',
															'rgba(54, 162, 235, 0.2)',
															'rgba(255, 206, 86, 0.2)',
															'rgba(75, 192, 192, 0.2)',
															'rgba(153, 102, 255, 0.2)',
															'rgba(255, 159, 64, 0.2)' ],
													borderColor : [
															'rgba(255, 99, 132, 1)',
															'rgba(54, 162, 235, 1)',
															'rgba(255, 206, 86, 1)',
															'rgba(75, 192, 192, 1)',
															'rgba(153, 102, 255, 1)',
															'rgba(255, 159, 64, 1)' ],
													borderWidth : 1
												} ]
											},
											options : {
												scales : {
													yAxes : [ {
														ticks : {
															beginAtZero : true
														}
													} ]
												}
											}
										});
							}
						})
			</script>
		</section>
	</div>
</body>
</html>