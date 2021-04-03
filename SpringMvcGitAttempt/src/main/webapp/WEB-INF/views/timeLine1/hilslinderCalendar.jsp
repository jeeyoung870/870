<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<jsp:useBean id= "now" class = "java.util.Date"/>
<style>
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
#calendar{
box-sizing: border-box;
    width: 350px;
    margin: 0 auto;
}
.calendar_day{
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
#hiddenDate{
	display : none;
}
.nextMonth,.prevMonth{
	color : grey;
	font-weight : normal;
}
.hiddenCalLogs{
	
}
.month{
	text-align : center;
	color : grey;
}
.myActivity-schedule-div {
	display: flex;
	align-items: center;
	justify-content: space-around;
	height: 50px;
}
</style>
</head>
<body>
	<c:forEach var = "calData" items = "${ calDataList}">
		<input type = "hidden" class = "hiddenCalLogs" value = "${calData }"/>
	</c:forEach>
	<input type = "hidden" value = "${month }" id = "newMonth">
	<input type = "hidden" value = "${year }" id = "newYear">
	<input type = "date" value = "" id = "hiddenDate" name = "date">
 <div class = "myActivity-schedule-div">
 	<a href = "" id = "prev" class = "calBtn">이전 달로</a>
	
	<c:choose>
		<c:when test = "${month ne null }">
		<div class = "month">
			${month }월 입니다,
		</div>
		</c:when>
		<c:otherwise>
			<fmt:formatDate value="${now }" pattern = "MM" var = "today"/>
			<div class = "month">
				<c:out value = "${today }"/>월 입니다.
			</div>
		</c:otherwise>
	</c:choose>
	<div>
		<a href = "" id = "next" class = "calBtn">다음 달로</a>	
	</div>
</div>
	<div class = "inner">
		<div id = "calendar">
		</div>
	</div>
	<a href = "" id = "moveToHils" class = "calBtn">날짜 선택</a>
	<script type = "text/javascript" src = "${contextPath}/resources/js/hilslinder/hilslinderCalSetDate.js"></script>
	<script type = "text/javascript">
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
		
		if(isNaN(newYear) && isNaN(newMonth)){
			if(today.getMonth() == 12){
				prev.href = "goHilslinderCalChange?month=" + (today.getMonth()) + "&year=" + today.getFullYear()
				next.href = "goHilslinderCalChange?month=" + 1 + "&year=" + (today.getFullYear() + 1)
		 		
			}else if(today.getMonth == 1){
				prev.href = "goHilslinderCalChange?month=" + 12 + "&year=" + (today.getFullYear() - 1)
				next.href = "goHilslinderCalChange?month=" + (today.getMonth() + 2) + "&year=" + today.getFullYear()
		 		
			}else{
				prev.href = "goHilslinderCalChange?month=" + (today.getMonth()) + "&year=" + today.getFullYear()
				next.href = "goHilslinderCalChange?month=" + (today.getMonth() + 2) + "&year=" + today.getFullYear()
		 		
			}
		}else{
			if(newMonth == 12){
				prev.href = "goHilslinderCalChange?month=" + (newMonth - 1) + "&year=" + newYear
				next.href = "goHilslinderCalChange?month=" + 1 + "&year=" + (newYear + 1)
		 		
			}else if(newMonth == 1){
				prev.href = "goHilslinderCalChange?month=" + 12 + "&year=" + (newYear - 1)
				next.href = "goHilslinderCalChange?month=" + (newMonth + 1) + "&year=" + newYear
		 		
			}else{
				prev.href = "goHilslinderCalChange?month=" + (newMonth - 1) + "&year=" + newYear
				next.href = "goHilslinderCalChange?month=" + (newMonth + 1) + "&year=" + newYear
		 		
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
			let list = []
			let html = ""
			$(".hiddenCalLogs").each(function() {
				let targetDate = $(this).val()
				let testIsTenth = parseInt(targetDate.slice(-2));
				console.log(testIsTenth);
				let productDate = ""
				if(testIsTenth - 10 == 0){
					productDate = targetDate.slice(0, -2) + "0" + (testIsTenth - 1)
				}else if((testIsTenth - 20 == 0) || (testIsTenth - 30 == 0)){
					console.log("called")
					productDate = targetDate.slice(0, -2) + "" +  (testIsTenth - 1)
				}else{
					productDate = targetDate.slice(0, -1) + (parseInt(targetDate[targetDate.length - 1]) - 1);
				}
				console.log(productDate)
				$(".thisMonthDate").each(function(){
					if($(this).attr("id") == productDate){
						console.log("found")
						
						html += "<img src ='/mvc/resources/images/fist.png' style = 'width:100%;'/>"
						$(this).html(html)	
						$(this).parent("div").removeClass("thisMonth")
						$(this).parent("div").addClass("disabled")
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
					todayValue += today.getFullYear() + "0" +  (today.getMonth() + 1) + "0" +  (today.getDate() - 1);
				}else{
					todayValue += today.getFullYear() + "0" +  (today.getMonth() + 1) + (today.getDate() - 1);
				}
				
			}else{
				if(today.getDate() < 10){
					todayValue += today.getFullYear() + (today.getMonth() + 1) + "0" + (today.getDate() - 1);
				}
				else{
					todayValue += today.getFullYear() + (today.getMonth() + 1) + (today.getDate() - 1);
				}
				
			}
			$(".thisMonthDate").each(function(){
				if($(this).attr("id") < todayValue){
					console.log("outdateDate Founded")
					$(this).parent("div").removeClass("thisMonth")
					$(this).parent("div").addClass("prevMonth")
				}
			})
		}
		
		
	</script>
	
</body>
</html>