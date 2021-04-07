/**
 * 
 */
//켈린더를 만드는 함수
	function setCalendarData(year, month, isTodayMonth){
		let html = ""
		const today = new Date();
		
		const todayValue = today.getDate();
		const setDate = new Date(year, month - 1, 1)
		
		const firstDayOfThisMonth = setDate.getDate()
		
		//무슨 요일인지 불러온다	0 - 6 (0 is Sunday)			
		const firstDayName = setDate.getDay()
		
		if(isTodayMonth){
			var lastDayOfThisMonth = new Date(year, today.getMonth() + 1, 0).getDate()
			var lastDayOfPrevMonth = new Date(year, today.getMonth(), 0).getDate()
		}else{
			var lastDayOfThisMonth = new Date(year, month, 0).getDate()	
			var lastDayOfPrevMonth = new Date(year, month - 1, 0).getDate()
		}
		let startDayCount = 1
		let lastDayCount = 1
		
		for (let weekindex = 0; weekindex < 6 ; weekindex++){
			for(let weekdayindex = 0 ; weekdayindex < 7 ; weekdayindex++){
				//첫 주이고, 아직 달이 시작되지 않았을 때
				if(weekindex==0 && weekdayindex < firstDayName){
					if (weekdayindex == 0){
						html += "<div class = 'calendar_day prevMonth'><span>" + (lastDayOfPrevMonth - (firstDayName - 1) 
						+ weekdayindex) + "</span><span></span></div>"
					}else if(weekdayindex == 6){
						html += "<div class = 'calendar_day prevMonth'><span> " + (lastDayOfPrevMonth - (firstDayName - 1)
						 + weekdayindex) + "</span><span></span></div>"
					}else {
						html += "<div class = 'calendar_day prevMonth'><span> " + (lastDayOfPrevMonth - (firstDayName - 1)
						 + weekdayindex) + "</span><span></span></div>"
					}
				}else if(weekindex==0 && weekdayindex == firstDayName){
					if(weekdayindex == 0){
						html += "<div class = 'calendar_day thisMonth'><span>" + startDayCount + "</span><span id='" 
						+ year + month + setFixDayCount(startDayCount++) + "' class = 'thisMonthDate'></span></div>";
					}else if(weekdayindex == 6){
						html += "<div class = 'calendar_day thisMonth'><span>" + startDayCount + "</span><span id='" 
						+ year + month + setFixDayCount(startDayCount++) + "' class = 'thisMonthDate'></span></div>";
					}else{
						html += "<div class = 'calendar_day thisMonth'><span>" + startDayCount + "</span><span id='"
						 + year + month + setFixDayCount(startDayCount++) + "' class = 'thisMonthDate'></span></div>";
					}
				}else if(weekindex > 0 && startDayCount <= lastDayOfThisMonth){
					if(weekdayindex == 0){
						html += "<div class = 'calendar_day thisMonth'><span> " + startDayCount + "</span><span id='"
						 + year + month + setFixDayCount(startDayCount++) + "' class = 'thisMonthDate'></span></div>";
					}else if(weekdayindex == 6){
						html += "<div class = 'calendar_day thisMonth'><span>" + startDayCount + "</span><span id='"
						 + year + month + setFixDayCount(startDayCount++) + "' class = 'thisMonthDate'></span></div>";
					}else{	
						html += "<div class = 'calendar_day thisMonth'><span>" + startDayCount + "</span><span id='"
						 + year + month + setFixDayCount(startDayCount++) + "' class = 'thisMonthDate'></span></div>";
					}
				//마지막 주이고, 달이 끝난 후
				}else if(startDayCount > lastDayOfThisMonth){
					if(weekdayindex == 0){
						html += "<div class = 'calendar_day nextMonth'><span>" + (lastDayCount++) + "</span><span></span></div>";
					}else if(weekdayindex == 6){
						html += "<div class = 'calendar_day nextMonth'><span> " + (lastDayCount++) + "</span><span></span></div>";
					}else{
						html += "<div class = 'calendar_day nextMonth'><span>" + (lastDayCount++) + "</span><span></span></div>";
					}
				}
			}
		}
		document.querySelector("#calendar").insertAdjacentHTML("beforeend", html)
	}