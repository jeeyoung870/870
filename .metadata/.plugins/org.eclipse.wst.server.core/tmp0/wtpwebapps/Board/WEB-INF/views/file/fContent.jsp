<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>자료실</title>
<style type="text/css">
<!--
a:link { color:black; text-decoration:none; }
a:visited {  }
a:active { text-decoration:underline; }
a:hover { text-decoration:underline; background-image:url('text_dottdeline.gif'); background-repeat:repeat-x; background-position:50% 100%; }
-->
</style>
<style>
<!--
@font-face {font-family:굴림; src:url();}
body,td,a,div,p,pre,input,textarea {font-family:굴림;font-size:9pt;}
-->
</style>
</head>
<body>
<center>
<b>글내용 보기</b><br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center"> 
  <tr height="30">
    <td align="center" width="125" >글번호</td>
    <td align="center" width="125" align="center">${article.num}</td>
    <td align="center" width="125" >조회수</td>
    <td align="center" width="125" align="center">${article.readcount}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" >작성자</td>
    <td align="center" width="125" align="center">${article.writer}</td>
    <td align="center" width="125"  >작성일</td>
    <td align="center" width="125" align="center">${article.reg_date}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" >글제목</td>
    <td align="center" width="375" align="center" colspan="3">${article.subject}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" >파일</td>
    <td align="left" width="375" colspan="3" >
      <c:forEach var="fdt" items="${fdto}" >
      	<a href="downFile?no=${fdt.no}"><pre>${fdt.origName} nununu</pre></a>
      </c:forEach>
    </td>
  </tr>
  <tr>
    <td align="center" width="125" >글내용</td>
    <td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
  </tr>
  <tr height="30">     
    <td colspan="4"  align="right" >
  <input type="button" value="글수정"
       onclick="document.location.href='fUpdateForm?num=${article.num}&p=${pageNum}'">
   &nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="글삭제"
       onclick="document.location.href='fDeleteForm?num=${article.num}&p=${pageNum}'">
   &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" value="답글쓰기"
       onclick="document.location.href='fWriteForm?num=${article.num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
   &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="button" value="글목록"
       onclick="document.location.href='flist?p=${pageNum}'">
    </td>
  </tr>
</table> 
</form>
</center>
</body>
</html>