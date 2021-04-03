<%@ page contentType="text/html; charset=UTF-8"%>
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
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<style type="text/css">
	body{
		/* width: 420px; margin:0 auto;  */
		font-family: Noto Sans KR;
	}
	#upper{
		font-size: 22px;
		font-style: medium;
		font-weight: 600; line-height: 52px;
		text-align: center;
	}
	#upper img{position: absolute; left:18px; margin-top:13px; height:27px;}
	#upper hr{ background-color:#FF9A7F; border: 0; height: 20px; }
	div { width: 420px; margin:0 auto;
	}
    #mypageprofile > img, #mypagehilendar > img {
      max-width: 100%;
    }
    
    #mypageprofile, #mypagehilendar{ padding-top:30px;}
    #mypageprofile { width:380px; padding-top:30px;}
    #innerprofile {display:inline-block; width: 380px;}
    
    .defaultimg {width:120px; }
 	#changebtn {height:30px;float:right; margin-right: 40px;}
 	
 	.temp {width: 100%;
    height: 250px;
    position: relative;
    overflow: auto;
    }
    .temp::-webkit-scrollbar{ display: none; }
    .temp > img{width: 100%;}
    
 	#workouthil, #diethil {height:230px; overflow:hidden; position: relative;
 						    border: 2px solid #FF3600; left: -2px;} 
 	#workouthil > img{width:100%; position:absolute; }
  	#multiply{  mix-blend-mode: exclusion; position: absolute;
    top: 0; left: 0; width: 100%; }
 	#workoutInfo { color:white; position:absolute; margin: 25 auto;}
 	#dietInfo { color:black; margin: 25 auto; display:inline-block; text-align: center;}
 	#kcalsum {font-size: 22px;font-weight: 600;} 
 	
 	#foodlist { background-color:white; /* border: 1px solid #FF3600;  */
 				width:140px; padding:15px; font-size:12px; text-align:left;
 				float:right; margin-right:20px;} 
 	#goalandeat{ width: 195px; float: left; margin-left: 20px; text-align:center;}
 	#percent { width: fit-content; line-height: 50px; }
 	/* #workInfo{ mix-blend-mode: normal;
    background: url(resources/images/profilepic/jyjy1616915516797.png) no-repeat center center;
    background-size: cover; }
 	#temp {width: 100%;
    height: 250px;
    position: relative;
    overflow: auto;
    }
    #multiply{color: #fff; 
    background: rgba(0,0,0,0.2);
	}	
    #temp > img{width: 100%;}
    #diethil{height: 200px;}
    #dietInfo { display:inline; } */
    .dietInfo-content:after {
		content:'';
		display:block;
		clear:both;    
    }
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>마이페이지</span><hr>
</div>
<div id="mypageprofile">
   <div id="innerprofile">
	<div class="p123" style="width: fit-content;">
	<img src="resources/images/profilepic/${mpInfo.profile_img}" class="defaultimg" id="pimg">
	</div>
	<div class="p123"  style="width: fit-content;text-align:center;line-height:30px">
	${mpInfo.user_id}<br> 팔로잉 | 팔로워
	</div>
  </div>
  <div class="p123">
	<br>키 ${mpInfo.height } cm | 체중 ${mpInfo.weight } kg 
	<a href ="profilechange?user_id=${mpInfo.user_id}" ><img id="changebtn" src="resources/images/usersetting/pchange.png" ></a>
  </div>
  <div style="width: 380px;">
  <br>
  <c:if test="${mpInfo.introduce == null}">
  	<span style="color:#A7A7A7">한줄 소개를 입력하세요.</span>
  </c:if>
  ${mpInfo.introduce}<br>
  </div>
</div>

<div id="mypagehilendar">
<h3 style="margin-left:20px; color:#FF3600;">
최근 힐린더<br>
<fmt:formatDate value="${woInfo1.workout_reg_date}" pattern="yyyy / MM / dd E요일" />
</h3>
<br>
	<div id="workouthil" >
		
		<div class="temp">
			<img src="${contextPath}/tempRepository/${woInfo1.workout_certi_path }">
			<div id="multiply">
			<div id="workoutInfo">
				<c:set var="workSum" value="0" />
				<center>WORKOUT<br><br>
				<c:forEach var="item" items="${woInfo2}" >
					<c:out value="${item.workout_name} - "/>
					<c:out value=" ${item.workout_hours} kcal"/><br>
					<c:set var="workSum" value="${workSum + item.workout_hours }" />
				</c:forEach>
				<span id="kcalsum" >총 ${workSum} kcal 소비 </span>
			</div>
			</div>
		</div>
		
	</div>
<br>
	<div id="diethil" style="background-color:#FFD6CC;">
		<div class="temp">
			<div id="dietInfo" >
				DIET<br>
			<div class="dietInfo-content">
				<div id="foodlist">
					<c:set var="dietSum" value="0" />
					<c:forEach var="item" items="${dInfo}" >
						<c:out value="${item.food_identifier}"/>
						<c:out value=" ${item.food_amount} 개 "/>
						<c:out value=" (${item.food_calory} kcal)" /><br>
						<c:set var="dietSum" value="${dietSum + item.food_calory }" />
					</c:forEach>
				</div>
			<div id="goalandeat">
			목표 ${dInfo[0].food_goal} kcal<br>
			섭취 ${dietSum} kcal<br>
			</div>
			</div>
<br>		
			<div>
			<div style="width:420px; height:15px; background-color:white;">
				<c:set var="ssum" value="${dietSum / dInfo[0].food_goal * 100 }" />
				<div style="width:${ ssum+(0.1-(ssum%0.1))%0.1 }%; max-width:100%;
				color:white;font-size:10px; text-align:center; 
				height:15px; background-color:#FF3600; position:absolute; ">
				<fmt:formatNumber value="${ ssum+(0.1-(ssum%0.1))%0.1 }" type="number"/>
				</div> 
			</div>
			
			<div id="percent">
				<span id="kcalsum" >
				달성률 <fmt:formatNumber value="${ ssum+(0.1-(ssum%0.1))%0.1 }" type="number"/>%
				</span>
			</div>
			</div>
			
			</div>
		</div> 
	</div>
<br><br>
</div>


<script src="${contextPath}/resources/js/mypage1/cropper.js"></script>
  <script>
  $(document).ready(function() { 
	  //id="pimg"를 원형으로 보여주기
      var croppedCanvas = pimg;
      // Round
      var  roundedCanvas = getRoundedCanvas(croppedCanvas);
      // Show
      pimg.src = roundedCanvas.toDataURL(); 
  });
  
  //사진 업로드
   function getRoundedCanvas(sourceCanvas) {
      var canvas = document.createElement('canvas');
      var context = canvas.getContext('2d');
      var width = sourceCanvas.width;
      var height = sourceCanvas.height;

      canvas.width = width;
      canvas.height = height;
      context.imageSmoothingEnabled = true;
      context.drawImage(sourceCanvas, 0, 0, width, height);
      context.globalCompositeOperation = 'destination-in';
      context.beginPath();
      context.arc(width / 2, height / 2, Math.min(width, height) / 2, 0, 2 * Math.PI, true);
      context.fill();
      return canvas;
    }

   
  </script>
</body>
</html>