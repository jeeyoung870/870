<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel = "stylesheet" href = "${contextPath}/resources/css/hilslinderMain.css">
<style>
#calendar{
box-sizing: border-box;
}
.calendar_day{
	display : inline-block;
	vertical-align: bottom;
    width: calc(97% / 7);
    height: calc(98% / 5);
    box-sizing: border-box;
    border-radius: 5px;
    padding: 20px;
    background : beige;
}
</style>
</head>
<body>
	<div class = "inner">
		<div id = "calendar">
		</div>
	</div>
	<script>
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
		if(today.getMonth() + 1 < 10){
			setCalendarData(today.getFullYear(), "0" + (today.getMonth() + 1))
		}else{
			setCalendarData(today.getFullYear(), "" + (today.getMonth() + 1))
		}
		
		function setCalendarData(year, month){
			let html = ""
			
			const setDate = new Date(year, month - 1, 1)
			
			const firstDayOfThisMonth = setDate.getDate()
			
			const firstDayName = setDate.getDay()
			
			const lastDayOfThisMonth = new Date(today.getFullYear(), today.getMonth() + 1, 0).getDate()
			
			const lastDayOfPrevMonth = new Date(today.getFullYear(), today.getMonth(), 0).getDate()
			
			let startDayCount = 1
			let lastDayCount = 1
			
			for (let weekindex = 0; weekindex < 6 ; weekindex++){
				for(let weekdayindex = 0 ; weekdayindex < 7 ; weekdayindex++){
					if(weekindex==0 && weekdayindex < firstDayName){
						if (weekdayindex == 0){
							html += "<div class = 'calendar_day'><span>" + (lastDayOfPrevMonth - (firstDayName - 1) + weekdayindex) + "</span><span></span></div>"
						}else if(weekdayindex == 6){
							html += "<div class = 'calendar_day'><span> " + (lastDayOfPrevMonth - (firstDayName - 1) + weekdayindex) + "</span><span></span></div>"
						}else {
							html += "<div class = 'calendar_day'><span> " + (lastDayOfPrevMonth - (firstDayName - 1) + weekdayindex) + "</span><span></span></div>"
						}
					}else if(weekindex==0 && weekdayindex == firstDayName){
						if(weekdayindex == 0){
							html += "<div class = 'calendar_day'><span>" + startDayCount + "</span><span id='" + year + month + setFixDayCount(startDayCount++) + "'></span></div>";
						}else if(weekdayindex == 6){
							html += "<div class = 'calendar_day'><span>" + startDayCount + "</span><span id='" + year + month + setFixDayCount(startDayCount++) + "'></span></div>";
						}else{
							html += "<div class = 'calendar_day'><span>" + startDayCount + "</span><span id='" + year + month + setFixDayCount(startDayCount++) + "'></span></div>";
						}
					}else if(weekindex > 0 && startDayCount <= lastDayOfThisMonth){
						if(weekdayindex == 0){
							html += "<div class = 'calendar_day'><span> " + startDayCount + "</span><span id='" + year + month + setFixDayCount(startDayCount++) + "'></span></div>";
						}else if(weekdayindex == 6){
							html += "<div class = 'calendar_day'><span>" + startDayCount + "</span><span id='" + year + month + setFixDayCount(startDayCount++) + "'></span></div>";
						}else{
							html += "<div class = 'calendar_day'><span>" + startDayCount + "</span><span id='" + year + month + setFixDayCount(startDayCount++) + "'></span></div>";
						}
					}else if(startDayCount > lastDayOfThisMonth){
						if(weekdayindex == 0){
							html += "<div class = 'calendar_day'><span>" + (lastDayCount++) + "</span><span></span></div>";
						}else if(weekdayindex == 6){
							html += "<div class = 'calendar_day'><span> " + (lastDayCount++) + "</span><span></span></div>";
						}else{
							html += "<div class = 'calendar_day'><span>" + (lastDayCount++) + "</span><span></span></div>";
						}
					}
				}
			}
			document.querySelector("#calendar").insertAdjacentHTML("beforeend", html)
		}
	</script>
</body>
</html>