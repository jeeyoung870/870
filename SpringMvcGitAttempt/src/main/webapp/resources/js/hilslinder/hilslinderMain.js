/**
 * 
 */
//var globalWorkoutRepository;
//var globalCaloryPerHourRepository;

$("#workoutInput").focus(handleFocusing)
$("#workoutInput").focusout(handleFocusOut)

function handleFocusing(){
	let url = "./getWorkoutCategory"
	$.ajax({
		dataType : "json",
		method : "POST",
		url : url,
	}).done(function(result){
		let htmls = "<select id='selectCategory1'>";
		for (let elem of result.categoryList){
			htmls += "<option value ='" + elem.workout_category + "'>" + elem.workout_category + "</option>"
		}
		htmls += "</select><select id='selectCategory2'></select>" 
		
		$("#workoutSearchOutput").html(htmls)
		document.getElementById("workoutSearchOutput").classList.toggle("show")
		
	}).fail(function(){
		
	})
}
function handleFocusOut(){
	//document.getElementById("workoutSearchOutput").classList.remove("show")
}
$(document).on("change", "#selectCategory1", handleSelectCategory)
function handleSelectCategory(){
	let url = "./selectCategory1"
	let data = "category1=" + $("#selectCategory1 :selected").val()
	console.log(data)
	
	$.ajax({
		dataType : "json",
		method : "POST",
		url : url,
		data : data
	}).done(function(result){
		let htmls = ""
		let secretWorkHtmls = "<form><select id = 'secretWorkRepository'>"
		let secretCaloryHtmls = "<select id = 'secretCaloryRepository'>"
		//globalWorkoutRepository = result.workoutList;
		for(let elem of result.workoutList){
			htmls += "<option value ='" + elem.gymnastics + "'>" + elem.gymnastics + "</option>" 
			secretWorkHtmls += "<option value ='" + elem.gymnastics + "'>" + elem.gymnastics + "</option>" 
			secretCaloryHtmls += "<option value ='" + elem.pound_155 + "'>" + elem.pound_155 + "</option>" 
		}
		secretWorkHtmls += "</select>"
		secretCaloryHtmls += "</select></form>"
		
		$("#secretRepository").html(secretWorkHtmls + secretCaloryHtmls)
		
		$("#selectCategory2").html(htmls)
		
	}).fail(function(){
		console.log("You've failed")
	})
}

$(document).on("change", "#selectCategory2", handleSelectCategory2)
function handleSelectCategory2(){
	let selectedVal = $("#selectCategory2 :selected").val()
	let category2 = document.getElementById("secretWorkRepository")

	let index = 0;	
	for(let elem of category2.options){
		if(selectedVal == elem.value){	
			console.log("called");
			$("#secretWorkRepository option:eq(" + (index) + ")").attr("selected", "selected");
			$("#secretCaloryRepository option:eq(" + (index) + ")").attr("selected", "selected");
		}
		index += 1
	}
	/*
	for(let elem of globalWorkoutRepository){
		if(selectedVal == elem.gymnastics){
			globalCaloryPerHourRepository = [selectedVal ,elem.pound_155];
		}
	}
	*/
	document.getElementById("workoutInput").value = selectedVal
}

$("#pushWorkoutBtn").click(handlePush)
function handlePush(){
	//let userInputHour = $("#workoutHour").val()
	let userInputMinutes = $("#workoutMinute").val()

	if(isNaN(userInputMinutes)){
		
	}else{
	
		let result = (parseInt(userInputMinutes)) * ($("#secretCaloryRepository option:selected").val()) / 30
		let message = $("#secretWorkRepository option:selected").val() + ":" + result
		//let result = (userInputMinutes) * globalCaloryPerHourRepository[1] / (30)
		//let message = globalCaloryPerHourRepository[0] + ":" + result + ","
		
		//htmls = "<div class = 'hillinderUnit'>" + message + "</div>"
		let htmls = document.createElement("div")
		htmls.setAttribute("class", "hilslinderUnit")
		htmls.appendChild(document.createTextNode(message))
		document.getElementById("hilslinderBox").appendChild(htmls)
		
		
		document.getElementById("workout_one_day").value += message + ","
	}
}

document.getElementById("imageFile").addEventListener("change" ,(event)=>{
	const img_id = document.getElementById("thumb_img");
	img_id.src = window.URL.createObjectURL(event.target.files[0]) 
	})
		