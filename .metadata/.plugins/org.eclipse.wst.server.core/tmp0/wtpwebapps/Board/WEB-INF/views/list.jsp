<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
</head>
<body>
<center>
<b>글목록(전체 글:${list.count})</b>
<table width="700">
  <tr>
    <td align="right" >
       <a href="writeForm">글쓰기</a>
    </td>
  </tr>
</table>

<c:if test="${list.count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${list.count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
    <tr height="30" >
      <td align="center"  width="50"  >번 호</td>
      <td align="center"  width="250" >제   목</td>
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td>
      <td align="center"  width="50" >조 회</td>
      <td align="center"  width="100" >IP</td>   
    </tr>

   <c:forEach var="article" items="${list.boardList}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
    <td  width="250" >
  <c:if test="${article.re_level > 0}">
  <img src="resources/images/level.gif" width="${5 * article.re_level}" height="16">
    <img src="resources/images/re.gif">
  </c:if>
  <c:if test="${article.re_level == 0}">
    <img src="resources/images/level.gif" width="${5 * article.re_level}" height="16">
  </c:if>
          
      <a href="content?num=${article.num}&p=${list.requestPage}">
          ${article.subject}</a>
          <c:if test="${article.readcount >= 20}">
            <img src="resources/images/hot.gif" border="0"  height="16">
  </c:if>
</td>
    <td align="center"  width="100">
       ${article.writer}
</td>
    <td align="center"  width="150">
    <fmt:formatDate value="${article.reg_date}" type="date" dateStyle="long"/> 
</td>
    <td align="center"  width="50">${article.readcount}</td>
    <td align="center" width="100" >${article.ip}</td>
  </tr>
  </c:forEach>
</table>
</c:if>

<c:if test="${list.count > 0}">
  	<c:if test="${list.p.beginPageNumber > 10}">
			<a href="list?p=${list.p.beginPageNumber-1}&per=${per}">이전</a>
	</c:if>
	<c:forEach var="pno" begin="${list.p.beginPageNumber}" end="${list.p.endPageNumber}">
		<a href="list?p=${pno}&per=${per}">[${pno}]</a>
	</c:forEach>
		<c:if test="${list.p.endPageNumber < list.p.totalPageCount}">
			<a href="list?p=${list.p.endPageNumber + 1}&per=${per}">다음</a>
		</c:if>
</c:if>
</center>

<form:form modelAttribute="list" method="get" style="float:right; margin-right: 30%; display: inline;">
	<%-- <form action="list" method="get" style="float:right; margin-right: 30%; display: inline;"> --%>
		<form:select path="per" onchange="this.form.submit()"  >
		<%-- <select  onchange="this.form.submit()" value="${list.per} " > --%>
			<option value="4">4개씩 보기</option>
			<option value="8">8개씩 보기</option>
			<option value="10">10개씩 보기</option>
		</form:select>
</form:form>

</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('option[value=${per}]').prop("selected", true);
}); 
</script>
<!-- <script type="text/javascript">
$("#selectPer").change(function (){
	var per = $(this).val();
	$.ajax({
		type:"get",
		url:"list",
		data:"per="+per,
		datatype:"json"
	}).done().fail(function(e) {
		//alert(e.status);
	});
});
</script> -->
</html>