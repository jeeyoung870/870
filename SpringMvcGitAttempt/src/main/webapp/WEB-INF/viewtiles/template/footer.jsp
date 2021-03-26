<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<style>
#area {
	width: 420px; margin:0 auto;
	background-color: #EBEBEB; text-align:center;
	font-family: Noto Sans KR;
	font-style: regular;
	font-size: 10px;
	color:#6B6B6B;
}
#text{
	padding: 30px;
}
</style>

<div id="area">
<%-- <tiles:importAttribute name="menuList" />
<c:forEach var="menu" items="${menuList}">${menu} </c:forEach>  --%>
	<div id="text">
		<!-- 회사명 -->
		<span id="c_name" style='color:black'></span><br><br>
	대표이사 : <span id="r_name"></span><br>
	사업자번호 : <span id="bNum"></span><br>
	사업장소재지 : <span id="bAddr"></span><br><br>
	대표전화 : <span id="phone"></span><br>
	팩스 : <span id="fax"></span>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
$(function() {
	$.ajax({
		  url: 'footerInfo',
		  type: 'post',
		  dataType: 'json',
		  })
		  .done( function(args) {
		    $("#c_name").append(args[0].company_name);
		    $("#r_name").append(args[0].representative_name);
		    $("#bNum").append(args[0].business_license_number);
		    $("#bAddr").append(args[0].business_address);
		    $("#phone").append(args[0].phone_number);
		    $("#fax").append(args[0].fax_number);
		  })
		  .fail(function(e) {
		  	alert(e.responseText );
			})
});
</script>

