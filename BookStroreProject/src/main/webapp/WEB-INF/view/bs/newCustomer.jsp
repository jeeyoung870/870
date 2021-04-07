<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>고객 등록</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
$(function(){
	//custid 자동지정하기
	var url="newCustid.do";
	$.ajax({
		type: "post",
		url : url,
		dataType : "json",
	}).done(
	function(number){
		$("#custid").val(number);
	}
	).fail( function(e){
		alert(e.responseText);
	})
});

</script>
</head>
<body>
<h1>고객 등록</h1>
<spring:hasBindErrors name="command" />
<form:errors path="command" />
<form action="addCust.do" method="post">
	고객 번호 : <input type="text" id="custid" name="custid" value="" readonly="readonly"><br>
	고객 이름 : <input type="text" name="name" value="${command.name}">
	<form:errors path="command.name" /><br>
	고객 주소 : <input type="text" name="address" value="${command.address}">
	<form:errors path="command.address" /><br>
	고객 전화 : <input type="text" name="phone" value="${command.phone}">
	<form:errors path="command.phone" /><br>
	<input type="submit" value="등록"/><br>
	<%-- <div name="addResult">
		<form:errors path="command.addResult" />
	</div> --%>
</form>
</body>
</html>