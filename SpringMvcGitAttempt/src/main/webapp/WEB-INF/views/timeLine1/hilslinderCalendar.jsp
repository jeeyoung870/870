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
<link rel = "stylesheet" href = "${contextPath}/resources/css/hilslinderMain.css">
<jsp:useBean id= "now" class = "java.util.Date"/>
<style>
.calBtn {
   -webkit-box-sizing: content-box;
  -moz-box-sizing: content-box;
  box-sizing: content-box;
  width: 80px;
  padding: 5px;
  overflow: hidden;
  border: 1px solid rgba(175,175,175,1);
  font: normal 16px/1 "Times New Roman", Times, serif;
  color: rgba(122,176,191,1);
  text-align: center;
  -o-text-overflow: ellipsis;
  text-overflow: ellipsis;
  background: #ffffff;
  -webkit-box-shadow: 2px 2px 1px 0 rgba(0,0,0,0.3) ;
  box-shadow: 2px 2px 1px 0 rgba(0,0,0,0.3) ;
  text-shadow: 1px 1px 1px rgba(0,0,0,0.2) ;
}
#calendar{
box-sizing: border-box;
}
.calendar_day{
	display : inline-block;
	vertical-align: bottom;
    width: calc(97% / 7);
    height: calc(40% / 5);
    box-sizing: border-box;
    border-radius: 5px;
    padding: 20px;
    font-weight : bold
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
</style>
</head>
<body>
	<c:forEach var = "calData" items = "${ calDataList}">
		<input type = "hidden" class = "hiddenCalLogs" value = "${calData }"/>
	</c:forEach>
	<input type = "hidden" value = "${month }" id = "newMonth">
	<input type = "hidden" value = "${year }" id = "newYear">
	<input type = "date" value = "" id = "hiddenDate" name = "date">
 	<a href = "" id = "prev" class = "calBtn">이전 달로</a>
	<a href = "" id = "next" class = "calBtn">다음 달로</a>
	<c:choose>
		<c:when test = "${month ne null }">
		<div class = "month">
			${month }
		</div>
		</c:when>
		<c:otherwise>
			<fmt:formatDate value="${now }" pattern = "MM" var = "today"/>
			<div class = "month">
				<c:out value = "${today }"/>
			</div>
		</c:otherwise>
	</c:choose>
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
				let productDate = targetDate.slice(0, -1) + (parseInt(targetDate[targetDate.length - 1]) - 1);
				console.log(productDate)
				$(".thisMonthDate").each(function(){
					if($(this).attr("id") == productDate){
						console.log("found")
						
						html += "<img src ='/mvc/resources/images/fist.png' style = 'width:100%;'/>"
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
				todayValue += today.getFullYear() + "0" +  (today.getMonth() + 1) + (today.getDate() - 1);
			}else{
				todayValue += today.getFullYear() + (today.getMonth() + 1) + (today.getDate() - 1);
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