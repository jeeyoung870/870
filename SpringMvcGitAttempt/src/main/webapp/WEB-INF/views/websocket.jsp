<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<title>Insert title here</title>
<script type = "text/javascript">
	let url = window.location.host;
	let pathname = window.location.pathname;
	let appCtx = "/mvc"
	
	let root = url + appCtx;
	
	let ws = new WebSocket("ws://" + root + "/community/echo-ws");
	
	ws.onopen = function(){
		$("#chatStatus").text("Info : connection Opened");
		
		$("input[name=chatInput]").on('keydown', function(event){
			if(event.keyCode == 13){
				let msg = $("input[name=chatInput]").val();
				ws.send(msg)
				$("input[name=chatInput]").val()
			
			}
		})
	}
	ws.onmessage = function(event){
		$("textarea").eq(0).prepend(event.data + "\n")
	}
	ws.onclose = function(event){
		$("#chatStatus").text("Info : connection closed");
	}
	
</script>
</head>
<body>
<p>
<div id='chatStatus'></div>
<textarea name="chatMsg" rows="5" cols="40"></textarea>
<p>
메시지 입력 : <input type="text" name="chatInput">

</body>
</html>