<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>일별 박스오피스</title>
</head>
<body>
<h1>일별 박스오피스</h1>
<c:forEach items="${boxOfficeList.boxOfficeResult.dailyBoxOfficeList}" 
var="movie">
${movie.rank}위 : <a href="movieinfo/actor?movieCd=${movie.movieCd}">${movie.movieNm}</a><br>

</c:forEach>
</body>
</html>