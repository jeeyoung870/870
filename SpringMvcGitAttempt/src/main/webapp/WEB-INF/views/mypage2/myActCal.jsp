<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</style>
</head>
<body>
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
			<div>
				<div id="upper">
					<img alt="뒤로가기" src="resources/images/usersetting/arrow.png"
						onclick="history.back()"> <span>마이페이지</span>
					<hr>
				</div>
				<div id="profile">
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
							href="profilechange?user_id=${mpInfo.user_id}"><img
							id="changebtn" src="resources/images/usersetting/pchange.png"></a>
					</div>
					<div style="width: 380px;">
						<br>
						<c:if test="${mpInfo.introduce == null}">
							<span style="color: #A7A7A7">한줄 소개를 입력하세요.</span>
						</c:if>
						${mpInfo.introduce}<br>
					</div>
				</div>

				<div id="hilendar">
					<h3 style="margin-left: 20px; color: #FF3600;">
						최근 힐린더<br>
						<fmt:formatDate value="${woInfo1.workout_reg_date}"
							pattern="yyyy / MM / dd E요일" />
					</h3>
					<br>
					<div id="workouthil">

						<div class="temp">
							<img
								src="${contextPath}/tempRepository/${woInfo1.workout_certi_path }">
							<div id="multiply">
								<div id="workoutInfo">
									<c:set var="workSum" value="0" />
									<center>
										WORKOUT<br>
										<br>
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
					<div id="diethil" style="background-color: #FFD6CC;">
						<div class="temp">
							<div id="dietInfo">
								DIET<br>
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
										style="width: 420px; height: 15px; background-color: white;">
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
					<br>
					<br>
				</div>
			</div>
		</section>
	</div>
</body>
</html>