<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>영화인 검색결과</title>
</head>
<body>
<h3>
${artistList.peopleListResult.peopleList[0].peopleNm} 영화인 검색결과 ${artistList.peopleListResult.totCnt} 명<br>
</h3>
<table align="center" width="70%" >
	<tr>
		<th>이름</th><th>직무</th>
	</tr>
	<c:forEach var="people" items="${artistList.peopleListResult.peopleList}">
		<tr align="center" id="${people.peopleCd}">
			<td  >
				<!-- anchor태그를 클릭시 같은페이지 같은 스크롤위치에서 showFilmo함수 실행 -->
				<!-- this.onclick=null; -> onclick메소드 한번만 실행 -->
				<a href="javascript:void(0);" onclick="showFilmo(${people.peopleCd}); 
				this.onclick=null; return false;"
				id="anchor">${people.peopleNm}</a>
			</td>
			<td>
				${people.repRoleNm }
			</td>
		</tr>
		<tr class="invisibleTr">
			<td colspan='2'></td>
		</tr>
	</c:forEach>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
/* 영화인 상세정보 조회 API로 필모 조회하기 */
function showFilmo(peopleCd) {
	//속성값 가져와서 비교하기
	if($("#invisibleTr").prop("display") == "none"){
		//속성값 변경하기
		$("#invisibleTr").attr("display", "block");
	}else {
		$("#invisibleTr").attr("display", "none");
		/* return false; */
	}
	//var peopleCd = $("#anchor").val();
	/* 영화인 상세정보 조회 API */
	var url ="http://kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleInfo.json?key=f5eef3421c602c6cb7ea224104795888&peopleCd="+peopleCd;
	
	$.ajax({
		type:"get",		/* rest방식 API는 get방식으로 요청해야 한다. */
		url:url,
		dataType:"json"
	})
	.done(function(args) {
		/* var peopleCd = $("#anchor").val(); */
		var filmos = args.peopleInfoResult.peopleInfo.filmos;
		/* #peopleCd의 바로 아래 위치한 형제태그 tr( + tr)의 자식태그 td 선택(> td) */
		var id= "#"+peopleCd+" + tr > td";
		$(id).append("<b>필모그래피</b><br>");
		for(var i=0; i<filmos.length; i++){
			$(id).append("작품명 : "+ filmos[i].movieNm + " / "
					+ "담당파트 : " + filmos[i].moviePartNm+"<br>" );
		} 
	
	})
	.fail(function (e) {
		alert(e.status);
	});
	
}
</script>
</html>