<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" var = "nowDate"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link rel = "stylesheet" href = "${contextPath}/resources/css/hilslinderMain.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>

	header{
    	display:flex;
    }
	select{
	 	color : black;
	}
	#hiddenDate{
		display: none;
	}
	.inner{
		padding : 10px;
	}
	#thumb_img{
		height : 100px;
		width : 100px;
	}	
	.col-sm-4 {
		margin : 10px;
		background : #FF9A7F;
		opacity :50%;
		border-radius : 20px / 20px;
	}
	.row{
		border : 0.5px solid grey;
		margin : 5px;
		 
	}
	.col-sm-7{
		margin : 5px;
	}
	h1{
		text-align : center;
		color : grey;
		
	}
</style>
</head>
<body>
<h1>${nowDate }</h1>
<div class = "inner">

	<form enctype="multipart/form-data" action = "submitHilslinder" method = "post" onsubmit = "return checkFormIntegrity()">
		<div class = "row">
			<div id = "divgroup1">
				<div id = "form-group1" class = "col-sm-7">
					
					<input type = "text" id = "hiddenDate" value = "${nowDate}" name = "date"/>
					<div class = "popup form-group">
						<label for = "workoutInput">운동 선택</label>
						<input type = "text" readonly id = "workoutInput" class = "form-control"/>
						<div id = "workoutSearchOutput" class = "popuptext">
							
						</div>
						<div class = "dummy"></div>
					</div>
					<!-- 
					<label for = "workoutHour">enter workout hours</label>
					<input type = "text" id = "workoutHour"/>
					-->
					<div class = "form-group">
						<label for ="workoutMinute">운동 시간</label>
						<input type = "text" id = "workoutMinute" class = "form-control"/> 분
					
						<button type = "button" id = "pushWorkoutBtn" class = "form-control">push</button>
						<textarea name = "workout_one_day" id = "workout_one_day" readonly class = "form-control"></textarea>	
					</div>
				</div>
				<div id = "form-group3" class = "col-sm-4">	
					<input type = "file" name = "imageFile" id = "imageFile" accept = "image/*" class = "form-control-file"/>
					<img src = "#" alt = "이미지를 올리시면 썸네일이 표시됩니다." id = "thumb_img"/>
					<div id = "hilslinderBox">
						
					</div>
				</div>
			</div>
		</div>
		<div class = "row">
			<div id = "divgroup2">
				<div id = "form-group2">
					<div class = "popup">
						<div id = "backgroundBar" class = "progress">
							<div id ="caloryBar" class = "progress-bar" role="progressbar" aria-valuenow="70"
			  aria-valuemin="0" aria-valuemax="100" style="width:1%"></div>
						</div>
					</div>
						<div id = "form-group" class = "col-sm-7">
							<label for = "caloryGoal">목표 칼로리 : </label>
							<input type = "text" id = "caloryGoal" class = "form-control"/>
							<label for = "foodInput">음식 입력</label>
							<input type = "text" id = "foodInput" class = "form-control"/>
								<div id = "foodSearchResult" class = "popuptext long">
								
								</div>
								<div class = "dummy"></div>
							<span id = "failCode">*</span>	
							<label for = "consumeAmount">몇 인분 드셨습니까?</label>
							<input type = "text" id = "consumeAmount" name = "consumeAmount" class = "form-control"/>
							<button type = "button" id = "pushFoodBtn" class = "form-control">push</button>
						</div>
						<div id = "form-group" class = "col-sm-4">
							<textarea name = "foodSchedule" id = "foodSchedule" readonly class = "form-control"></textarea>
							<input type ="text" readonly id = "totalCalory" class = "form-control">
							<input type = "hidden" name = "food_goal" id = "food_goal" value = ""/>
							<input type = "submit" value = "submit" class = "form-control"/>
						</div>
				</div>
			</div>
		</div>
	</form>
	<div id = "secretRepository">
		
	</div>
</div>
	<script src="${contextPath}/resources/js/hilslinder/hilslinderMainFoodScehdule.js"></script>			
	<script src="${contextPath}/resources/js/hilslinder/hilslinderMain.js"></script>
	<script type = "text/javascript">
		function checkFormIntegrity(){
			let workout_one_day = document.getElementById("workout_one_day").value;
			let imageFile = document.getElementById("imageFile").value;
			let foodSchedule = document.getElementById("foodSchedule").value;
			if(workout_one_day && imageFile && foodSchedule){
				alert("제출합니다!")
				return true;
			}else{
				alert("누락된 항목이 있습니다.!")
				return false;
			}
		}
	</script>
</body>
</html>