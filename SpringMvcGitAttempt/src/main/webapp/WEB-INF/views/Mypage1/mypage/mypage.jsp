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
	div { width: 420px; margin:0 auto;
	}
	
    img {
      max-width: 100%;
    }
</style>
</head>
<body>
<div id="upper">
<img alt="뒤로가기" src="resources/images/usersetting/arrow.png" onclick="history.back()">
<span>마이페이지</span><hr>
</div>
<div>
프로필 수정
</div>



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
	     	          roundedImage.src = roundedCanvas.toDataURL()
	     	          result.innerHTML = '';
	     	          result.appendChild(roundedImage);
	     	          
	     	         croppedCanvas.toBlob((blob) => {
	     	        	  const formData = new FormData();

	     	        	  // Pass the image file name as the third parameter if necessary.
	     	        	  formData.append('croppedImage', blob/*, 'example.png' */);

	     	        	  // Use `jQuery.ajax` method for example
	     	        	  $.ajax( {
	     	        	    method: 'POST',
	     	        	    url: 'saveIamge',
	     	        	    data: formData,
	     	        	    processData: false,
	     	        	    contentType: false,
	     	        	    success() {
	     	        	      console.log('Upload success');
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