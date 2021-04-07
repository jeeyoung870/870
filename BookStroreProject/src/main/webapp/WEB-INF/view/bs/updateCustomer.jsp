<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>고객정보 수정</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<!-- <script type="text/javascript">
$(function() {
	var url = "custList.do";
	$.ajax({
		type: "post",
		url : url,
		dataType : "json",
	}).done(
	function(list){
		for(var i; i<list.length; i++){
			$("#table").append("<tr><td><a href='bs/changeAddress.do'>"+list[i].name+"</a></td>" + 
					"<td>"+list[i].address+"</td>"+"<td>"+list[i].phone+ "</tr>");
		}
	}
	).fail( function(e){
		alert(e.responseText);
	})
});
</script> -->
</head>
<body>
<h1 align="center">고객정보 수정</h1>
<div align="center">수정할 고객의 이름을 클릭하세요.</div><br><br>
<table id="table" align="center" border="1" width="60%">
<tr>
<th>이름</th><th>주소</th><th>전화번호</th>
</tr>
<c:forEach var="cust" items="${allCust}">
		<tr>
		<td><a href="changeAddress.do?custid=${cust.custid}">${cust.name}</a></td>
		<td>${cust.address}</td>
		<td>${cust.phone}</td>
	</c:forEach>
</table>
</body>
</html>