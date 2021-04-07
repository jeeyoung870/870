<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>영화 정보</title>
</head>
<body>
<h1>영화 정보</h1>
<h3>${actorList.movieInfoResult.movieInfo.movieNm }</h3>
<b>영제 :</b> ${ actorList.movieInfoResult.movieInfo.movieNmEn}<br>
<b>감독 :</b>
<c:forEach items="${actorList.movieInfoResult.movieInfo.directors}" var="director">
 ${director.peopleNm }&nbsp;&nbsp;
</c:forEach>
<br>
<b>상영시간 :</b> ${actorList.movieInfoResult.movieInfo.showTm } 분<br>
<b>개봉일자 :</b> ${actorList.movieInfoResult.movieInfo.openDt } 년<br>
<br>

<b>출연진</b><br>
<c:forEach items="${actorList.movieInfoResult.movieInfo.actors}" 
var="actor">
이름 : ${actor.peopleNm} &nbsp;&nbsp;영문명 : ${actor.peopleNmEn } <br>
<%-- <a href="movieinfo/actor?movieCd=${movie.movieCd}">${movie.movieNm}</a><br> --%>
</c:forEach>
</body>
</html>