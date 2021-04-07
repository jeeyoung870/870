/**
 * 
 */
var globalSelectedCaloryPerServing;
var globalCaloryList = new Map();

$("#foodInput").change(handleFoodInput)
$("#foodInput").focus(function(){
	document.getElementById("foodSearchResult").classList.toggle("show")
})

function handleFoodInput(){
	let keyword = $("#foodInput").val();
	let url = "http://openapi.foodsafetykorea.go.kr/api/b1f9ae7246c94079953e/I2790/json/1/30/DESC_KOR=" + keyword
	$.ajax({
		dataType : "json",
		url : url,
		method : "get"
	}).done(function(result){
		let resultArray = result["I2790"].row
		let htmls = "<select id = 'selectFood'>"
		for(let elem of resultArray){
			let foodName = elem.DESC_KOR
			let foodCaloryPerOne = elem.NUTR_CONT1
			globalCaloryList[foodName] = foodCaloryPerOne;
			htmls += "<option value ='" + foodName + "'>" + foodName + "</option>"
		}
		htmls += "</select>"
		$("#foodSearchResult").html(htmls)
	}).fail(function(){
		$("#failCode").text("입력하신 키워드에 해당하는 식품명이 존재하지 않습니다.")
	})
}
/*
function handleFoodFocus(){
	document.getElementById("foodSearchResult").classList.toggle("show")
}
*/
$(document).on("change", "#selectFood", () =>{
	globalSelectedCaloryPerServing = globalCaloryList[$("#selectFood :selected").val()]
})
/*
function handleSelectFood(){
}
*/
$("#caloryGoal").change(handleCaloryGoal)
function handleCaloryGoal(){
	let caloryGoal = $("#caloryGoal").val()
	console.log("logging" + caloryGoal);
	if(isNaN(caloryGoal)){
		$("#failCode").text("잘못된 입력 값!")
	}else{
		document.getElementById("food_goal").value = caloryGoal
		//document.getElementById("backgroundBar").style.width = parseInt(caloryGoal)	 + "px"
	}
}	

$("#pushFoodBtn").click(handleFoodPush)
function handleFoodPush(){
	let selectedFood = $("#selectFood :selected").val();
	let consumeAmount = $("#consumeAmount").val();
	
	if(isNaN(consumeAmount) || isNaN(globalSelectedCaloryPerServing)){
		$("#failCode").text("드신 양을 정확히 입력해 주십시오")
	}else if(!selectedFood){
		$("#failCode").text("음식이 입력되지 않았습니다.")
	}else{
		//수정 필요
		let message = selectedFood + ":" + parseInt(globalSelectedCaloryPerServing) * parseInt(consumeAmount) + ":" + parseInt(consumeAmount) + ","
		document.getElementById("foodSchedule").value += message;
		handleCaloryCalculate()	
	}
}

//$("#foodSchedule").change(handleCaloryCalculate)
function handleCaloryCalculate(){
	let inputedSchedule = $("#foodSchedule").val()
	let commaProcessedInputArray = inputedSchedule.split(",")
	let totalCalory = 0;
	
	for(let elem of commaProcessedInputArray){
		let colonProcessedInput = elem.split(":")[1]
		if(!isNaN(colonProcessedInput)){
			totalCalory += parseInt(colonProcessedInput)	
		}
	}
	document.getElementById("totalCalory").value = totalCalory;
	
	let caloryGoal = $("#caloryGoal").val()
	if(isNaN(caloryGoal)){
		$("#failCode").text("목표 칼로리 양을 정확히 입력해 주십시오")
	}else{
		let barRatio = totalCalory * 100 / caloryGoal 
		document.getElementById("caloryBar").style.width = parseInt(barRatio) + "%"
		$("#caloryBar").html("<span>" +  Math.round(barRatio) + "%</span>")
	}
}