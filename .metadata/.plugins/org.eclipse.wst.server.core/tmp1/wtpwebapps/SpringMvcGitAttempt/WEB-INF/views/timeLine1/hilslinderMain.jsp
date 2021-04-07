<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel = "stylesheet" href = "${contextPath}/resources/css/hilslinderMain.css">
</head>
<body>
<div class = "inner">
	<form enctype="multipart/form-data" action = "submitHilslinder" method = "post">
		<div class = "popup">
			<input type = "text" readonly id = "workoutInput"/>
			<div id = "workoutSearchOutput" class = "popuptext">
				
			</div>
			<div class = "dummy"></div>
		</div>
		<!-- 
		<label for = "workoutHour">enter workout hours</label>
		<input type = "text" id = "workoutHour"/>
		-->
		<label for ="workoutMinute">enter workout minutes</label>
		<input type = "text" id = "workoutMinute"/>
		<button type = "button" id = "pushWorkoutBtn">push</button>
		<textarea name = "workout_one_day" id = "workout_one_day" readonly></textarea>
		<input type = "file" name = "imageFile" id = "imageFile" accept = "image/*"/>
		<input type = "submit" value = "submit"/>
	</form>
		<img src = "#" alt = "이미지를 올리시면 썸네일이 표시됩니다." id = "thumb_img"/>
		<div id = "hilslinderBox">
			
		</div>
		
		
	<form action = "uploadFoodSchedule" method = "post">
		<div class = "popup">
			<div id = "backgroundBar">
				<div id ="caloryBar">&nbsp;</div>
			</div>
			<label for = "caloryGoal">your goal! : </label>
			<input type = "text" id = "caloryGoal"/>
			<label for = "foodInput">enter your foodInput</label>
			<input type = "text" id = "foodInput"/>
				<div id = "foodSearchResult" class = "popuptext">
				
				</div>
				<div class = "dummy"></div>
			<span id = "failCode">*</span>
			<label for = "consumeAmount">몇 인분 드셨습니까?</label>
			<input type = "text" id = "consumeAmount" name = "consumeAmount"/>
			<button type = "button" id = "pushFoodBtn">push</button>
			<textarea name = "foodSchedule" id = "foodSchedule" readonly></textarea>
			<input type ="text" readonly id = "totalCalory">
			<input type = "submit" value = "submit"/>
		</div>
	</form>
	<div id = "secretRepository">
		
	</div>
</div>
	<script src="${contextPath}/resources/js/hilslinderMainFoodScehdule.js"></script>			
	<script src="${contextPath}/resources/js/hilslinderMain.js"></script>
</body>
</html>