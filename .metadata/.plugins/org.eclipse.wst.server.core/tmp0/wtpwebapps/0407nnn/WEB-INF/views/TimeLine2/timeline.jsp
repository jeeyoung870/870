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
	
    #mypageprofile > img, #mypagehilendar > img {
      max-width: 100%;
    }
    #mypageprofile, #mypagehilendar{ padding-top:30px; width: 420px; margin:0 auto; }
	#mypagehilendar > div{ width: 420px; margin:0 auto; }
	.p123{ width: 420px; margin:0 auto; }
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
    .temp > img{width: 100%; opacity:0.5;}
    
 	#workouthil, #diethil {height:230px; overflow:hidden; position: relative;
 						    border: 2px solid #FF3600; left: -2px;} 
 	#workouthil > img{width:100%; position:absolute; }
  	#multiply{  position: absolute;
    top: 0; left: 0; width: 100%; }
 	#workoutInfo { color:black; position:absolute; margin: 25 auto; width: 420px;}
 	#dietInfo { color:black; margin: 25 auto; display:inline-block; text-align: center;}
 	#kcalsum {font-size: 22px;font-weight: 600;} 
 	
 	#foodlist { background-color:white; /* border: 1px solid #FF3600;  */
 				width:140px; padding:15px; font-size:12px; text-align:left;
 				float:right; margin-right:20px;} 
 	#goalandeat{ width: 195px; float: left; margin-left: 20px; text-align:center;}
 	#percent { width: fit-content; line-height: 50px; margin: 0 auto;}
 	
    .dietInfo-content:after {
		content:'';
		display:block;
		clear:both;    
    }
    .tlbtn{ width: fit-content; margin:0 auto; margin-top: 15px;
    background-color: #FF3600; padding: 6px 15px; border:0;outline:0;
    border-radius: 1em; }
    .tlbtn > a {color:white}
    #pimg{width:55px;}
    #nomorehil{ width: fit-content; margin:0 auto; }
    #more6hilbtn{width: fit-content; margin:0 auto;}
    #totopbtn{ background-color:lightgray;color:white; border:0;font-weight:600;
    margin:0 auto; padding: 6px 15px; font-size:18px; border-radius: 1em;border:0;outline:0; }
    #refreshimg { transition: all ease 0.5s; }
    #refreshimg:hover { transform: rotate( 180deg ); }
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>타임라인</span><hr>
<a href="${contextPath }/timeLine1/goHilslinderCal" 
style="color:#FF3600;font-size:20px;">내 힐린더 작성하기</a>
</div>
<hr>

<div class="tlbtn" style="background-color:white;">
<a href="timeline">
	<img id="refreshimg" src="resources/images/usersetting/refresh.png" style="width:30px;">
</a>
</div>

<!-- <div id="hilslide">
<ul>
<li>
<a href="#" class="mframe">클릭</a>
<ul class="openhil">
<li>
miimimmimiimmimimi
</li>
</ul>
</li>
</ul>
</div> -->

<div id="hilappend">
<c:forEach var="i" items="${hilinfo}" >

<div id="mypagehilendar">
&nbsp;&nbsp;&nbsp;&nbsp;<img id="pimg" src="resources/images/profilepic/${i.get(0).profile_img}">
&nbsp;&nbsp; ${i.get(0).user_id} &nbsp;&nbsp;
<span style="font-size:15px;color:gray;">
<fmt:formatDate value="${i.get(0).workout_reg_date}" pattern="YY.MM.dd HH:mm" />
</span>


	<div id="workouthil" >	
		<div class="temp">
			<img src="${contextPath}/tempRepository/${i.get(0).workout_certi_path }">
			<div id="multiply">
			<div id="workoutInfo">
				<c:set var="workSum" value="0" />
				<center>WORKOUT<br><br>
				<c:forEach var="item" items="${i.get(1)}" >
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
					<c:forEach var="item" items="${i.get(2)}" >
						<c:out value="${item.food_identifier}"/>
						<c:out value=" ${item.food_amount} 개 "/>
						<c:out value=" (${item.food_calory} kcal)" /><br>
						<c:set var="dietSum" value="${dietSum + item.food_calory }" />
					</c:forEach>
				</div>
			<div id="goalandeat">
			목표 ${i.get(2)[0].food_goal} kcal<br>
			섭취 ${dietSum} kcal<br>
			</div>
			</div>
			<br>		
			<div>
			<div style="width:420px; height:15px; background-color:white;">
				<c:set var="ssum" value="${dietSum / i.get(2)[0].food_goal * 100 }" />
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
</div>
</c:forEach>

</div><!-- hilappend -->
<div id="nomorehil"></div>
<br><br>

<div id="more6hilbtn">
<button onclick="more6hil();" class="tlbtn" 
style="color:white; border:0;">더보기</button><br><br>
<button id="totopbtn" onClick="javascript:window.scrollTo(0,0)" >TOP</button>
</div>

<br><br>

</body>

<script src="${contextPath}/resources/js/mypage1/cropper.js"></script>
<script>
$(document).ready(function() { 
	  //id="pimg"를 원형으로 보여주기
    var croppedCanvas = document.getElementById("pimg");
    // Round
    var roundedCanvas = getRoundedCanvas(croppedCanvas);
    // Show
    document.getElementById("pimg").src = roundedCanvas.toDataURL(); 
    //alert(pimg.src)   
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


//날짜 format
function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '.' + month + '.' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}

var last = 6;
function more6hil(){
	last += 6;
	$.ajax({
      type: "POST",
      url: "timeline?last="+last,
      dataType: 'json',
	// name=John&location=Boston,    (파라미터 방식)
      success:function(data) {
    	  if(data.length == 0){
    		  const elem = document.getElementById('nomorehil');
    		  elem.innerText = '';
    		  elem.innerText = '\n\n최근 힐린더는 여기까지에요.';
    		  //$( "#nomorehil" ).append("최근 힐린더는 여기까지에요.");
    	  }
    	  for(var i of data){
    		  var date = getFormatDate(new Date(i[0].workout_reg_date));
    		  var workSum = 0;
    		  for(var j of i[1]){
    			  var append1 = j.workout_name+" - "+
    					  j.workout_hours+" kcal <br>";
    			  workSum += j.workout_hours;
    		  }
    		  var dietSum = 0;
    		  for(var k of i[2]){
    			  var append2 = k.food_identifier+" "+k.food_amount+"개 ("+k.food_calory+" kcal<br>";
    			  dietSum += k.food_calory;
    		  }
    		  var ssum = dietSum / i[2][0].food_goal * 100;
    		  var roundsum = ssum.toFixed(1);
    		  
    		  $( "#hilappend" ).append(
    				  "<div id='mypagehilendar'>"+
    				 "&nbsp;&nbsp;&nbsp;&nbsp;<img id='pimg' src='resources/images/profilepic/"+i[0].profile_img+"'>"
    				 +"&nbsp;&nbsp; "+i[0].user_id+" &nbsp;&nbsp;"
    				 +"<span style='font-size:15px;color:gray;'>"
             		 +date+"</span>"
             		 +"<div id='workouthil' >"
        			 +"<div class='temp'>"+
        			 "<img src='${contextPath}/tempRepository/"+i[0].workout_certi_path+"'>"+
    				"<div id='multiply'>"+
    				"<div id='workoutInfo'><center>WORKOUT<br><br>"+append1+
    				  "<span id='kcalsum' >총 "+workSum+" kcal 소비 </span></center>"+
    				  "</div></div></div></div><br>"+
    				  "<div id='diethil' style='background-color:#FFD6CC;'>"+
    				  "<div class='temp'>"+
    				  "<div id='dietInfo' >DIET<br>"+
    				  "<div class='dietInfo-content'>"+
    				  "<div id='foodlist'>"+append2+
    				  "</div><div id='goalandeat'>"+
    				  "목표 "+i[2][0].food_goal+" kcal<br>"+
    				  "섭취 "+dietSum+" kcal<br>"+
    				  "</div></div><br></div>"+
    				  "<div style='width:420px; height:15px; background-color:white;'>"+
    				  "<div style='width:"+roundsum+ "%; max-width:100%;"+
    				  "color:white;font-size:10px; text-align:center; "+
    				  "height:15px; background-color:#FF3600; position:absolute;'>"+
    				  roundsum+"</div></div> "+
    				  "<div id='percent'><span id='kcalsum' >"+
    				  "달성률 "+roundsum+" %"+
    				  "</span>"+
    				  "</div></div></div></div></div></div>"
    			);
    	  }
      }
      });
}


 
$(function () {
	$(".openhil").hide();
	$("#hilslide>ul>li>a").click(function(){
		if($(this).next().is(":visible"))
		{	//$(this).children('img.plus').attr("src", "resources/images/usersetting/plus.png");
			$(this).next().stop().slideUp(200);
		}else{
			$(".sub").stop().slideUp(500);
			//$(this).children('img.plus').attr("src", "resources/images/usersetting/minus.png");
			$(this).next().stop().slideDown(200);
		};
	});
});
</script>
</html>