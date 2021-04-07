<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<title>Insert title here</title>
<jsp:useBean id= "now" class = "java.util.Date"/>
<style>
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
/* 힐린더 */
.calBtn {
	box-sizeing: border-box;
	-moz-box-sizing: border-box;
	width: 80px;
	padding: 5px;
	overflow: hidden;
	border: 1px solid rgba(175, 175, 175, 1);
	font: normal 16px/1 "Times New Roman", Times, serif;
	color: #fff;
	text-align: center;
	-o-text-overflow: ellipsis;
	text-overflow: ellipsis;
	background: #FF3600;
	-moz-box-sizing: border-box;
}

#calendar {
	box-sizing: border-box;
    width: 350px;
    margin: 0 auto;
}

.calendar_day {
	display: inline-block;
    vertical-align: bottom;
    /* width: calc(97%/ 7); */
    /* height: calc(60%/ 5); */
    height: 68px;
    width: 50px;
    box-sizing: border-box;
    border-radius: 5px;
    /* padding: 20px; */
    font-weight: bold;
    border: 1px solid #eee;
}

#hiddenDate {
	display: none;
}

.nextMonth, .prevMonth {
	color: grey;
	font-weight: normal;
}

.hiddenCalLogs {
	display: none;
}

/* 커스텀 */
.myActivity-schedule-ul {
	display: flex;
	padding: 0 10px;
}

.myActivity-schedule-ul>li>a {
	padding: 10px 10px;
	display: block;
}

.myActivity-schedule>p {
	padding: 20px 0 10px 20px;
}

.moveToHils-div {
	text-align: center;
	padding: 40px 0 100px;
}

.myActivity-schedule-div {
	display: flex;
	align-items: center;
	justify-content: space-around;
	height: 50px;
}

.add {
	color: #FF3600;
}
</style>
</head>
<body>
<c:forEach var = "calData" items = "${hlisCalList }">
	<fmt:formatDate value="${calData.workout_reg_date }" var="calDate" pattern = "yyMMdd"/>
	<input type = "hidden" class = "workoutkey ${calDate}" value = "${calData.workout_key }"/>
	<input type = "hidden" class = "foodschedule ${calDate }" value = "${calData.food_schedule_key }"/>
</c:forEach>
	<div id="wrap">
		<section>
			<div class="location-bar">
				<h1>내 힐린더 조회</h1>
				<hr />
			</div>
			<div>
				<ul class="myActivity-schedule-ul">
					<li><a href="myActivitySchedule" class="add">내 힐린더</a></li>
					<li><a href="viewMyPost">내 작성글</a></li>
				</ul>
				<hr />
			</div>
			<div class="myActivity-schedule">
				<p>지난 힐린더를 조회할 수 있어요.</p>
				<div class="myActivity-schedule-content">
					<c:forEach var="calData" items="${calDataList}">
						<input type="hidden" class="hiddenCalLogs" value="${calData }" />
					</c:forEach>
					<input type="hidden" value="${month }" id="newMonth"> <input
						type="hidden" value="${year }" id="newYear"> <input
						type="date" value="" id="hiddenDate" name="date">

					<div class="myActivity-schedule-div">
						<div>
							<a href="" id="prev" class="calBtn">이전 달로</a>
						</div>
						<c:choose>
							<c:when test="${month ne null}">
								<div class="month">${month }</div>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${now }" pattern="MM" var="today" />
								<div class="month">
									<c:out value="${today }" />
								</div>
							</c:otherwise>
						</c:choose>
						<div>
							<a href="" id="next" class="calBtn">다음 달로</a>
						</div>
					</div>


					<div class="inner">
						<div id="calendar"></div>
					</div>

					<div class="moveToHils-div">
						<div>
							<a href="" id="moveToHils" class="calBtn">날짜 선택</a>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script type="text/javascript"
		src="${contextPath}/resources/js/mypage2/myActCalSetDate.js"></script>
	<script type="text/javascript">
		// 힐린더
		let newMonth = parseInt(document.getElementById("newMonth").value)
		let newYear = parseInt(document.getElementById("newYear").value)
		console.log(newMonth, newYear);
		
		const today = new Date();
		const setFixDayCount = number =>{
			let fixNum = ""
			if(number <= 10){
				fixNum = "0" + (number - 1)
			}else{
				fixNum = number - 1;
			}
			return fixNum
		}
		//today.getMonth is 0 - 11 not 1 - 12
		
		//change href of 'a' tag in 'next' and 'prev'
		let prev = document.getElementById("prev")
		let next = document.getElementById("next")
		//이번 달 다음 달 a href를 넣어준다.
		if(isNaN(newYear) && isNaN(newMonth)){
			if(today.getMonth() == 12){
				prev.href = "myActCalChange?month=" + (today.getMonth()) + "&year=" + today.getFullYear()
				next.href = "myActCalChange?month=" + 1 + "&year=" + (today.getFullYear() + 1)
		 		
			}else if(today.getMonth == 1){
				prev.href = "myActCalChange?month=" + 12 + "&year=" + (today.getFullYear() - 1)
				next.href = "myActCalChange?month=" + (today.getMonth() + 2) + "&year=" + today.getFullYear()
		 		
			}else{
				prev.href = "myActCalChange?month=" + (today.getMonth()) + "&year=" + today.getFullYear()
				next.href = "myActCalChange?month=" + (today.getMonth() + 2) + "&year=" + today.getFullYear()
		 		
			}
		}else{
			if(newMonth == 12){
				prev.href = "myActCalChange?month=" + (newMonth - 1) + "&year=" + newYear
				next.href = "myActCalChange?month=" + 1 + "&year=" + (newYear + 1)
		 		
			}else if(newMonth == 1){
				prev.href = "myActCalChange?month=" + 12 + "&year=" + (newYear - 1)
				next.href = "myActCalChange?month=" + (newMonth + 1) + "&year=" + newYear
		 		
			}else{
				prev.href = "myActCalChange?month=" + (newMonth - 1) + "&year=" + newYear
				next.href = "myActCalChange?month=" + (newMonth + 1) + "&year=" + newYear
		 		
			}
		}
		

		if(isNaN(newMonth) || ((today.getMonth() + 1) == newMonth && today.getFullYear() == newYear)){
		
			let isToday = true;
			if(today.getMonth() + 1 < 10){
				setCalendarData(today.getFullYear(), "0" + (today.getMonth() + 1), isToday)
			}else{
				setCalendarData(today.getFullYear(), "" + (today.getMonth() + 1), isToday)
			}
		}else if((today.getMonth()+1) != newMonth || today.getFullYear() != newYear){
			
			let isToday = false;
			if(newMonth < 10){
				setCalendarData(newYear, "0" + newMonth, isToday)
			}else{
				setCalendarData(newYear, "" + newMonth, isToday)
			}
		}
		
		setCalImage();
		changePassedDay();
		///////////////////////////////////////////////////////////////////////////////////////////
			
		//let thisMonthList = document.querySelectorAll("calendar_day thisMonth")
		
		$(".calendar_day.thisMonth").click(function(){
			if($("#clicked")){
				$("#clicked").css("background-color", "")
			}
			$(".calendar_day.thisMonth").removeAttr("id")
			
			$(this).attr("id", "clicked")
			$("#clicked").css("background-color", "#0383D8")
			document.getElementById("moveToHils").href = "goToHilsWithDate?date=" + $("#clicked > span")[1].id
		})
		
		
		function setCalImage(){
			
			let html = ""
			$(".hiddenCalLogs").each(function() {
				let targetDate = $(this).val()
				
				let testIsTenth = parseInt(targetDate.slice(-2));
				
				// span id가 현재 날짜 - 1 이기 때문에 가공을 해 주셔야 합니다
				let productDate = ""
				// 날짜가 10인 경우 그 날짜를 다 꺼내와서 -1 하고 앞에 "0"을 붙여줍니다
				if(testIsTenth - 10 == 0){
					productDate = targetDate.slice(0, -2) + "0" + (testIsTenth - 1)
				//날짜가 20, 30인 경우 그 날짜를 다 꺼내와서 -1
				}else if((testIsTenth - 20 == 0) || (testIsTenth - 30 == 0)){
					console.log("called")
					productDate = targetDate.slice(0, -2) + "" +  (testIsTenth - 1)
				//날짜가 20,30,10이 아닌 경우 가장 마지막 숫자만 꺼내와서 -1
				}else{
					productDate = targetDate.slice(0, -1) + (parseInt(targetDate[targetDate.length - 1]) - 1);
				}
			
				$(".thisMonthDate").each(function(){
					if($(this).attr("id") == productDate){
						
						html += "<a href='myActCal?workout_reg_date=" + targetDate + "' >"
						html += "<img src ='/mvc/resources/images/fist.png' style = 'width:100%;'/>"
						html += "</a>"
						$(this).html(html)	
						
						
					}
				})
				html = ""
			});		
		}
		
		function changePassedDay(){
			const today = new Date();
			let todayValue = ""
			if(today.getMonth() + 1 < 10){
				if(today.getDate() < 10){
					todayValue += today.getFullYear() + "0" +  (today.getMonth() + 1) + "0" + (today.getDate() - 1);
				}else{
					todayValue += today.getFullYear() + "0" +  (today.getMonth() + 1)  + (today.getDate() - 1);
				}
				
			}else{
				if(today.getDate() < 10){
					todayValue += today.getFullYear() + (today.getMonth() + 1) + "0" + (today.getDate() - 1);
				}else{
					todayValue += today.getFullYear() + (today.getMonth() + 1) + (today.getDate() - 1);
					
				}
				
			}
			$(".thisMonthDate").each(function(){
				if($(this).attr("id") < todayValue){
					console.log("outdateDate Founded")
					/*$(this).parent("div").removeClass("thisMonth")
					$(this).parent("div").addClass("prevMonth")*/
				}
			})
		}
		
	</script>

</body>
</html>