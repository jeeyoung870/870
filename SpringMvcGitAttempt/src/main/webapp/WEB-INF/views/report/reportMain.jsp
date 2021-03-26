<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<style>
td, th {
	text-align: center;
}
</style>
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		// RowCheck의 크기를 rowCnt에 가져오고
		var checkObj = document.getElementsByName("RowCheck");
		var rowCnt = checkObj.length;

		// allcheck 클릭 시, check_listArr 에 RowCheck 만큼을 넣고
		// for문으로 RowCheck의 길이만큼 반복해서 체크함.
		$("#allCheck").click(function() {
			if ($("#allCheck").is(":checked")) {
				$("input[name='RowCheck']").prop("checked", true);
			} else {
				$("input[name='RowCheck']").prop("checked", false);
			}
		});

		// RowCheck 클릭 시, RowCheck의 체크된 글의 수와 현재 글 수가 같으면 allCheck true, 아니면 false 
		$("input[name='RowCheck']").click(function() {
			if ($(".RowCheck : checked").length == rowCnt) {
				$("#allCheck").prop("checked", true);
			} else {
				$("#allCheck").prop("checked", false);
			}
		});
	});

	function deleteValue() {
		var url = "deleteDBReport"; // 컨트롤러로 보내고자 하는 url
		var valueArr = new Array();
		var list = $("input[name='RowCheck']");
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) { //선택되 있다면 배열에 값을 저장함 
				valueArr.push(list[i].value);
			}
		}
		if (valueArr.length == 0) {
			alert("삭제할 항목을 선택해주세요."); // 선택이 없으면 선택 요청 출력
		} else {
			var check = confirm("정말 삭제하시겠어요?");

			$.ajax({
				url : url, //전송url
				type : 'POST', //포스트 방식
				traditional : true,
				data : {
					valueArr : valueArr
				}, // 보낼 data의 변수 설정
				success : function(successDelete) {
					if (successDelete = 1) {
						alert("삭제했습니다.");
						location.replace("/mvc/report/report/ReportPass") // 삭제 후 신고페이지 새로고침
					} else {
						alert("삭제하지 못했습니다.");
					}
				}
			});
		}
	}
</script>
<meta charset="EUC-KR">
<title>신고 및 제재 관리</title>
</head>
<body>
	<h1>제재 관리</h1>
	<div id="insert">
		<a href="report/reportPage">등록</a>
	</div>
	<br />
	<select name="Search">
		<option value="id">아이디 검색</option>
		<option value="id">내용 검색</option>
	</select>
	<input type="text" placeholder="검색어 입력">
	<button>검색</button>
	<br />
	<br />

	<!-- 신고한 게시글 목록 출력 -->
	<table>
		<thead>
			<tr>
				<th scope="col"><input type="checkbox" id="allCheck"
					name="allCheck"></th>
				<th scope="col">번호&nbsp;&nbsp;</th>
				<th scope="col">신고대상 아이디 (혹은 이름, 이메일)&nbsp;&nbsp;</th>
				<th scope="col">사유&nbsp;&nbsp;</th>
				<th scope="col">신고자&nbsp;&nbsp;</th>
				<th scope="col">신고일</th>
				<!-- 				
				<th scope="col">내용 확인</th>
				<th scope="col">제재 현황</th>
 -->
		</thead>
		<tbody>
			<!-- DB에서 가져온 ReportList에서 값 각각 꺼내와서 forEach문으로 전부 출력 -->
			<c:forEach items="${ReportList}" var="report">
				<tr>
					<td class="reportContents"><input type="checkbox"
						name="RowCheck" id="RowCheck" value="${report.r_number}" /></td>
					<td class="reportContents">${report.r_number}&nbsp;</td>
					<td class="reportContents">${report.reported_user}&nbsp;</td>
					<td class="reportContents">${report.r_content}&nbsp;</td>
					<td class="reportContents">${report.reporter_user}&nbsp;</td>
					<td><fmt:formatDate value="${report.r_reg_date}"
							pattern="yyyy-MM-dd" /></td>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<!-- 선택항목 삭제하는 버튼 -->
	<input type="button" value="선택항목 삭제" class="btn btn-secondary"
		onclick="deleteValue();">

</body>
</html>