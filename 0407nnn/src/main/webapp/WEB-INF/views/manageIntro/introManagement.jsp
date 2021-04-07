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
#wrap .location-bar > h1 {
	background: #fff;
}

#wrap #myChart {
	display: block;
	height: 210px;
	width: 380px;
	margin: 0 auto;
	background: #fff;
    margin: 5px 0;
}
.manage-intro-content {
	background:#fff;
	padding: 0 20px;
}
.manage-intro-content > div {border-bottom: 1px solid #eee;}
.manage-intro-content-subject{    
	height: 40px;
    line-height: 40px;
}
.manage-intro-content-div {
	height: 30px;
    line-height: 30px;
    font-size:12px;
}
.manage-intro-content-subject:after,.manage-intro-content-div:after {
	content:'';
	clear:both;
	display:block;
}
.manage-intro-content-subject > div:first-child,.manage-intro-content-div > div:first-child {
	float:left;
}
.manage-intro-content-subject > div:last-child,.manage-intro-content-div > div:last-child {
	float:right;
}
.manage-intro-content-subject > div > h2 {
	font-size: 16px;
}
.manage-intro-content-subject > div:last-child{
	color: #888;
    font-size: 14px;
}
.manage-intro-content-div > div:first-child {
	
}
#wrap > section > div.manage-intro-content > div > div > span {
	color: red;
}
</style>
</head>
<body>
	<div id="wrap">
		<section>
			<div class="location-bar">
				<h1>관리자 페이지</h1>
			</div>
			<canvas id="myChart"></canvas>
			<div class="manage-intro-content">
				<div class="manage-intro-content-subject">
					<div>
						<h2>문의 답변 관리</h2>
					</div>
					<div class="manage-intro-date">
					</div>
				</div>
				<div class="manage-intro-content-div">
					<div>문의/답변</div>
					<div><span>1</span>/20건</div>
				</div>
				<div class="manage-intro-content-div">
					<div>신고</div>
					<div><span>1</span>/20건</div>
				</div>
			</div>
			<script>
				function getTodayDate() {
					let today = new Date();   
					
					let year = today.getFullYear(); // 년도
					let month = today.getMonth() + 1;  // 월
					let date = today.getDate();  // 날짜
					let day = today.getDay();  // 요일
					
					let week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
	
					let todayLabel = year + '년 ' + month + '월' + date + '일 ' + week[day];
				    
				    return todayLabel;
				}

				$(".manage-intro-date:last").html(getTodayDate());
				
				let url2 = "subscriberStatistics"
				$.ajax({
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