<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../view/color.jspf"%>
<!-- color.jspf : 모든 페이지에 공통으로 사용할 색상 지정 파일 -->
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="${bodyback_c}">
<!-- <center> : 이 태그로 둘러싸인 내용을 center align시킨다 -->
<center><b>글목록(전체 글:${count})</b>
<table width="700">
  <tr>
    <td align="right" bgcolor="${value_c}">
       <!-- 요청명시작에 /가없다면, 현재파일과 같은경로(MVC폴더)안의 파일이라는 뜻이다! -->
       <a href="writeForm.do">글쓰기</a>
    </td>
  </tr>
</table>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<!-- c:forEach로 글목록 한 줄씩 화면에 출력하기 -->
<c:if test="${count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="50"  >번 호</td>
      <td align="center"  width="250" >제   목</td>
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td>
      <td align="center"  width="50" >조 회</td>
      <td align="center"  width="100" >IP</td>   
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
    <td  width="250" >
  <c:if test="${article.re_level > 0}">	<!-- 답변글이라면, -->
  <!-- 투명한 공백이미지(답변글 제목앞의 들여쓰기된 공간) -->
  <img src="images/level.gif" width="${5 * article.re_level}" height="16">  
    <img src="images/re.gif">
  </c:if>
  <c:if test="${article.re_level == 0}">
    <img src="images/level.gif" width="${5 * article.re_level}" height="16">
  </c:if>
          <!-- 링크 : 글번호 선택, 현재 요청페이지번호 -->
      <a href="content.do?num=${article.num}&pageNum=${currentPage}">
          ${article.subject}</a>
          <!-- 20보다 조회수가 크다면,hot.hif를 붙여준다 -->
          <c:if test="${article.readcount >= 10}">
            <img src="images/hot.gif" border="0"  height="16">
  		  </c:if>
</td>
    <td align="center"  width="100">
    	<!-- 작성자를 클릭하면 자동으로 메일을 보내는 기능 -->
       <a href="mailto:${article.email}">${article.writer}</a>
	</td>
    <td align="center"  width="150">
    <!-- fmt:formatDate으로 작성일자를 년.월.일로 출력 -->
    <fmt:formatDate value="${article.reg_date}" type="date"
    											 dateStyle="long"/> 
	</td>
    <td align="center"  width="50">${article.readcount}</td>
    <td align="center" width="100" >${article.ip}</td>
</tr>
  </c:forEach>
</table>
</c:if>

<!-- 페이지 목록 구현 (숫자 10만 바꿔서 사용가능) -->
<c:if test="${count > 0}">
<!-- pageCount : 전체 페이지 수
	pageBlock : 아래 나올 페이지 최대 번호 수(이 숫자 넘으면 다음으로 짤림) -->
	<!-- 나머지 페이지가 있다면, 1페이지를 늘려준다.(글갯수 101개일경우, 10+1페이지가 나오도록 지정) -->
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <!-- 최대 10개 페이지까지 보여주겠다 -->
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <!-- 10 : pageBlock설정값과 같은숫자 -->
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <!-- 전체 페이지 개수보다 endPage값이 크다면, -->
   <c:if test="${endPage > pageCount}">
   		<!-- 가지고 있는 페이지 숫자만큼만 보여주기 -->
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
   		<!-- 10개 전페이지로 이동 -->
        <a href="list.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
   	   <!-- 페이지번호를 쭉 출력하고 숫자 클릭하면 해당 페이지로 이동하기 -->
       <a href="list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
   		<!-- 10개 다음페이지로 이동 -->
        <a href="list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>

<form> <!-- get방식으로 데이터를 현재 url에 전달한다(현재페이지 재요청)
		현재 url뒤에 ?searchn=선택번호&search=검색키워드 붙어서 요청 -->
<select name="searchn">
<option value="0">작성자</option>
<option value="1">제목</option>
<option value="2">내용</option>
</select>
<!-- 검색내용 입력받기 -->
<input type="text" name="search" size="15" maxlength="50" /> 
<input type="submit" value="검색" />&nbsp;
<!-- Controller로 돌아가 ListAction이 실행 -> list.jsp가 실행된다 -->
<input type="button" value="목록보기" OnClick="window.location='list.do'">	
</form>

</center>
</body>
</html>