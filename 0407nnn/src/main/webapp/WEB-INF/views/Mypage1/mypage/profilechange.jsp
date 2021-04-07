<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
    #mypageprofile, .p123, .innerdiv { width: 380px; }
    #mypageprofile {display:block; padding-bottom: 40px; }
    .p123{width: 420px; display:block; padding-top:30px; }
    .defaultimg {width:120px; display:inline-block;}
 	.pimgbtn {height:30px;}
 	.btnbtn{ height:40px; }
 	.textbox{ width:150px; height:40px; font-size:15px;
		font-family: Noto Sans KR;font-weight:400; border: 2px solid #FF3600;
		padding-left:8px;margin-bottom:5px;}
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>프로필 수정하기</span><hr>
</div>
<div id="mypageprofile">
<center>
   <div class="innerdiv">
	<div class="p123">
	<img src="resources/images/profilepic/${pInfo.profile_img}" class="defaultimg" id="pimg">
	</div>
	<div class="p123">
	<!-- 이미지변경버튼 -->
	<a href ="pimgchange?user_id=${pInfo.user_id}" ><img class="pimgbtn" src="resources/images/usersetting/changebtn.png" ></a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- 이미지삭제버튼 -->
	<img class="pimgbtn" src="resources/images/usersetting/del.png" onclick="delimg()"/>
	</div>
	
	
  </div>
  
  <form action="savePInfo" name="userProfile" method="POST" onsubmit="return profileSubmit()">
  	<input type="hidden" name="user_id" id="user_id" value="${pInfo.user_id}">
	  <div class="p123">
	  	키 (cm)<br>
	  	<input type="number" name="height" id="height" value="${pInfo.height }" class="textbox"/><br><br>
	  	체중 (kg)<br>
	  	<input type="number" name="weight" id="weight" value="${pInfo.weight }" class="textbox"/><br><br>
	  	한줄 소개<br>
	  	<textarea cols="35" rows="4" name="introduce" id="introduce" 
	  	style="font-size:15px;font-family: Noto Sans KR;font-weight:400; border: 2px solid #FF3600;
		padding-left:8px;padding-right:8px;margin-bottom:5px;">${pInfo.introduce }</textarea>
	  </div>
  

  <div class="p123">
  <!-- 취소버튼 -->
  <a href="mypage"><img class="btnbtn" src="resources/images/usersetting/refuse.png" ></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <!-- 적용버튼 -->
  <input type="image" class="btnbtn" src="resources/images/usersetting/submit.png"  
  style="vertical-align: top;"/> 
  </form>
  </div>
  </center>
</div>
<br><br>



<script src="${contextPath}/resources/js/mypage1/cropper.js"></script>
  <script>
  function profileSubmit() {
	  var height = $("#height").val();
	  var weight = $("#weight").val();
	  if(height && weight){
			alert("프로필이 변경됩니다.");
			return true;
		}else{
			alert("키와 체중을 입력해 주세요.");
			return false;
		} 
  }
  
  function delimg(){
	  window.location.href='delpImg?user_id='+$("#user_id").val();
  }
  
  
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