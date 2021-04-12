<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 변경</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/mypage1/cropper.css" rel="stylesheet" />
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
	#result{width:fit-content;}
	#result > img { width: 150px; margin:0 auto; }
	
	.container { width:420px;
      margin: 20px auto;
      max-width: 640px;
    }
    .them_img > img {
      max-width: 100%;
    }
    .cropper-view-box,
    .cropper-face {
      border-radius: 50%;
    }
    .frmbtn{ width:90px; height:35px; color:white; background-color:#FF3600;
		border:0; margin-left:145px; border-radius: 1em;}
	.frmbtn > a { color:white; }
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>프로필 사진 변경</span><hr>
</div>

<div class="container">
    <h3>&nbsp;&nbsp;&nbsp;&nbsp;프로필용으로 사진 자르기</h3>
    <br>
    <div class="upload">
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	<label for="photoBtn">사진 첨부하기</label><br>&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="file" name="photoBtn" accept="image/jpeg, image/png" capture="camera" id="photoBtn">
    	<input type="file" id="ttt" style="display:none" >
    </div>
    <br>
    <div class="them_img">
      <img id="image" src="resources/images/usersetting/imgbox.png" >
    </div>
    <p>
      <input type="hidden" id="user_id" value="${user_id}">
      <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <button type="button" id="button" class="frmbtn">등록하기</button>
    </p>
    <h3>&nbsp;&nbsp;&nbsp;&nbsp;Result</h3>    
    <div id="result"></div>
</div>

<br><br><br><br><br><br><br><br>

<script src="${contextPath}/resources/js/mypage1/cropper.js"></script>
  <script>
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

   $(function(){
	   //크롭 전 이미지 미리보기
	   $('#photoBtn').on('change', function(){
	        $('.them_img').empty().append('<img id="image" src="">');
	        var image = $('#image');
	        var imgFile = $('#photoBtn').val();
	        var fileForm = /(.*?)\.(jpg|jpeg|png)$/;
	   
	        if(imgFile.match(fileForm)) {
	        	var reader = new FileReader(); 
	        	reader.onload = function(event) { 
	        		image.attr("src", event.target.result);
	        		 var image2 = document.getElementById('image');
	     	        var button = document.getElementById('button');     
	     	        var result = document.getElementById('result');
	     	        var croppable = false;
	     	        var cropper = new Cropper(image2, {
	     	          aspectRatio: 1,
	     	          viewMode: 1,
	     	          ready: function () {
	     	            croppable = true;
	     	          },
	     	        });

	     	        button.onclick = function () {
	     	          var croppedCanvas;
	     	          var roundedCanvas;
	     	          var roundedImage;

	     	          if (!croppable) {
	     	            return;
	     	          }

	     	          // Crop
	     	          croppedCanvas = cropper.getCroppedCanvas();

	     	          // Round
	     	          roundedCanvas = getRoundedCanvas(croppedCanvas);

	     	          // Show
	     	          roundedImage = document.createElement('img');
	     	          //toDataURL : 그림 데이터를 리턴
	     	          roundedImage.src = roundedCanvas.toDataURL()
	     	          result.innerHTML = '';
	     	          result.appendChild(roundedImage);
	     	          
	     	          //toBlob으로 png이미지 만들기
	     	         roundedCanvas.toBlob((blob) => {
	     	        	  const formData = new FormData();
	     	        	  var user_id = $('#user_id').val();

	     	        	  // Pass the image file name as the third parameter if necessary.
	     	        	  formData.append('croppedImage', blob/*, 'example.png' */);
	     	        	  
	     	        	  
	     	        	  
	     	        	  
	     	        	/* 실패한..input type='file'로 submit()하려는 시도  
	     	        	//blob을 file객체로 변환하는 메소드
	     	        	 function blobToFile(theBlob, fileName){
	     	        	    //A Blob() is almost a File() - it's just missing the two properties below which we will add
	     	        	    theBlob.lastModifiedDate = new Date();
	     	        	    theBlob.name = fileName;
	     	        	    return theBlob;
	     	        	}
	     	        	 //document.getElementById('ttt').files[0] = blob;
	     	        	var form = document.createElement("form");
	     	           var input = new Array();
	     	         	const target = document.getElementById('ttt');
	     	        	target.files[0] = blobToFile(blob, "exex.png");
	     	           form.action = 'saveIamge?user_id='+user_id;
	     	           form.method = "post";
	     	           form.enctype="multipart/form-data";
	     	          form.encoding="multipart/form-data";
	     	        form.appendChild(target);
	     	           document.body.appendChild(form);
	     	           form.submit();
	     	        	 console.log("blob test"); */

	     	        	 
	     	        	 
	     	        	 
	     	        	 
	     	        	  // Use `jQuery.ajax` method for example    
	     	     		  $.ajax( {
	     	        	    method: 'POST',
	     	        	    url: 'saveIamge?user_id='+user_id,
	     	        	    data: formData,
	     	        	   dataType: 'json',
	     	        	    processData: false,
	     	        	    contentType: false,
	     	        	    success(msg) {
	     	        	      console.log('Upload success');
	     	        	      alert(msg);
	     	        	      window.location.href = 'profilechange?user_id='+user_id;
	     	        	    },
	     	        	    error() {
	     	        	      console.log('Upload error');
	     	        	    },
	     	        	  });
	     	        	} )
	     	         
	     	        }; 
	        		}	    
	        		reader.readAsDataURL(event.target.files[0]);
	        	
	        	} else{
	            	alert("이미지 파일(jpg, png형식의 파일)만 올려주세요");
	            	$('#photoBtn').focus();
	            	return; 
	        	}
	    })
    });
  </script>
</body>
</html>