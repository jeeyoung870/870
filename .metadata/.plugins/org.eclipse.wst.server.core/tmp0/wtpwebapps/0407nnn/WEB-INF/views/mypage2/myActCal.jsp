<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap .location-bar #upper {
	position: relative;
}

#wrap .location-bar #upper img {
	position: absolute;
	left: 18px;
	margin-top: 13px;
	height: 27px;
}

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

#wrap section  .myActivity-content .date {
	margin-left: 20px;
	padding: 10px 0;
	color: #333;
	font-size: 14px;
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

.add {
	color: #FF3600;
}

.myActivity-content #hilendar #workouthil {
	width: 380;
	background: #FFD6CC;
	margin: 0 auto;
}

.temp:after {
	clear: both;
	display: block;
	content: '';
}

.hilendar-img {
	width: 50%;
	float: left;
}
.hilendar-img > img {
	    width: 100%;
	    max-height: 300px;
}

#multiply {
	width: 50%;
	float: right;
}
#multiply #workoutInfo {
	padding:20px 0;
}

.dietInfo-subject {
	text-align: center;
	padding: 20px 0;
	font-weight: bold;
}

.dietInfo-content {
	width: 90%;
	margin: 0 auto;
}

#foodlist {
	width: 50%;
	float: right;
	background: #fff;
	border: 1px solid #333;
	box-sizing: border-box;
	padding: 10px;
	font-size: 14px;
}

.dietInfo-content:after {
	clear: both;
	display: block;
	content: '';
}
#percent {
	text-align: center;
    padding: 20px 0;
    font-weight: bold;
    color: red;
}
</style>
</head>
<body>
	<div id="wrap">
		<section>
			<div class="location-bar">
				<div id="upper">
					<img alt="뒤로가기" src="resources/images/usersetting/arrow.png"
						onclick="history.back()">
				</div>
				<h1>나의 활동</h1>
				<hr />
			</div>
			<div>
				<ul class="myActivity-schedule-ul">
					<li><a href="myActivitySchedule" class="add">내 힐린더</a></li>
					<li><a href="viewMyPost">내 작성글</a></li>
				</ul>
				<hr />
			</div>
			<div class="myActivity-content">
				<h3 class="date">
					<fmt:formatDate value="${woInfo1.workout_reg_date}"
						pattern="yyyy / MM / dd E요일" />
				</h3>
				<!--<div id="profile">
					 <div id="innerprofile">
						<div class="p123" style="width: fit-content;">
							<img src="resources/images/profilepic/${mpInfo.profile_img}"
								class="defaultimg" id="pimg">
						</div>
						<div class="p123"
							style="width: fit-content; text-align: center; line-height: 30px">
							${mpInfo.user_id}<br> 팔로잉 | 팔로워
						</div>
					</div> 
					<div class="p123">
						<br>키 ${mpInfo.height } cm | 체중 ${mpInfo.weight } kg <a
							href="profilechange?user_id=${mpInfo.user_id}">
						</a>
					</div>
				</div>-->

				<div id="hilendar">
					<div id="workouthil">
						<div class="temp">
							<div class="hilendar-img">
								<img
									src="${contextPath}/tempRepository/${woInfo1.workout_certi_path }">
							</div>
							<div id="multiply">
								<div id="workoutInfo">
									<c:set var="workSum" value="0" />
									<center>
										WORKOUT<br> <br>
										<c:forEach var="item" items="${woInfo2}">
											<c:out value="${item.workout_name} - " />
											<c:out value=" ${item.workout_hours} kcal" />
											<br>
											<c:set var="workSum" value="${workSum + item.workout_hours }" />
										</c:forEach>
										<span id="kcalsum">총 ${workSum} kcal 소비 </span>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div id="diethil"
						style="background-color: #EEE; width: 380px; margin: 0 auto; border: 1px solid #333;">
						<div class="temp">
							<div id="dietInfo">
								<div class="dietInfo-subject">식단 HILENDAR</div>
								<div class="dietInfo-content">
									<div id="foodlist">
										<c:set var="dietSum" value="0" />
										<c:forEach var="item" items="${dInfo}">
											<c:out value="${item.food_identifier}" />
											<c:out value=" ${item.food_amount} 개 " />
											<c:out value=" (${item.food_calory} kcal)" />
											<br>
											<c:set var="dietSum" value="${dietSum + item.food_calory }" />
										</c:forEach>
									</div>
									<div id="goalandeat">
										목표 ${dInfo[0].food_goal} kcal<br> 섭취 ${dietSum} kcal<br>
									</div>
								</div>
								<br>
								<div>
									<div
										style="width: 100%; height: 15px; background-color: white; position: relative">
										<c:set var="ssum"
											value="${dietSum / dInfo[0].food_goal * 100 }" />
										<div
											style="width:${ ssum+(0.1-(ssum%0.1))%0.1 }%;
													color:white;font-size:10px; text-align:center; 
													height:15px; background-color:#FF3600; position:absolute; ">
											${ ssum+(0.1-(ssum%0.1))%0.1 }%</div>
									</div>

									<div id="percent">
										<span id="kcalsum"> 달성률 <fmt:formatNumber
												value="${ ssum+(0.1-(ssum%0.1))%0.1 }" type="number" />%
										</span>
									</div>
								</div>

							</div>
						</div>
					</div>
					<br> <br>
				</div>
			</div>
		</section>
	</div>
</body>
</html>