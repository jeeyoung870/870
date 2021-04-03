<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<head>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<style type="text/css">
table {
	border-spacing: 10px;
	border-collapse: separate;
}

body {
	/* width: 420px; margin:0 auto;  */
	font-family: Noto Sans KR;
}

div {
	width: 400px;
	margin: 0 auto;
	text-align: center;
}

td, th {
	text-align: center;
}
</style>
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		// RowCheck의 크기를 rowCnt에 가져오고
		var CheckObj = document.getElementsByName("RowCheck");
		var RowCnt = CheckObj.length;

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
			if ($(".RowCheck : checked").length == RowCnt) {
				$("#allCheck").prop("checked", true);
			} else {
				$("#allCheck").prop("checked", false);
			}
		});
	});

	function deleteValue() {
		var url = "userDelete"; // 컨트롤러로 보내고자 하는 url
		var valueArr = new Array();
		var list = $("input[name='RowCheck']");
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) { //선택되 있다면 배열에 값을 저장함 
				valueArr.push(list[i].value);
			}
		}
		if (valueArr.length == 0) {
			alert("탈퇴 처리 할 회원을 선택해주세요."); // 선택이 없으면 선택 요청 출력
		} else {
			if (confirm("정말 탈퇴 처리하시겠어요?") == true) {

				$.ajax({
					url : url,
					type : 'POST',
					traditional : true,
					data : {
						valueArr : valueArr
					}, // 보낼 data의 변수 설정
					success : function(successDelete) {
						if (successDelete = 1) {
							alert("삭제했습니다.");
							location.replace("/mvc/user/manage/userPass") // 삭제 후 신고페이지 새로고침
						} else {
							alert("삭제하지 못했습니다.");
						}
					}
				});
			} else {
				return;
			}
			;
		}
	}
</script>

<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div>
		<h1>회원 목록</h1>
		<button type="button" class="btn btn-secondary"
			onclick="location.href='${contextPath}/user/user/register'">등록</button>
		<br />


		<!-- 회원 목록 출력 -->
		<table>
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" id="allCheck"
						name="allCheck">&nbsp;&nbsp;</th>
					<th scope="col">아이디 또는 이메일&nbsp;&nbsp;</th>
					<th scope="col">권한&nbsp;&nbsp;</th>
					<th scope="col">가입일</th>
			</thead>
			<br />
			<tbody>
				<!-- DB에서 가져온 UserList에서 값 각각 꺼내와서 forEach문으로 전부 출력 -->
				<c:forEach items="${UserList}" var="list">
					<tr>
						<td class="userlist"><input type="checkbox" name="RowCheck"
							id="RowCheck" value="${list.user_id}" />&nbsp;&nbsp;</td>
						<td id="userlist" class="userlist">${list.user_id}&nbsp;</td>
						<td id="userlist" class="userlist">${list.auth}&nbsp;</td>
						<td><details>
								<summary>${list.regi_date}</summary>
								<script>
									
									var start = "${list.regi_date}";
									console.log(start);
									var end = new Date();
									date = getFormatDate(end);
									console.log(date);
									
									var start_arr = start_String.split("-");
									var end_arr = start_String.split("-");
									
									var start_date = new Date(start_arr[0], Number(start_arr[1])-1, start_arr[2]);
									var end_date = new Date(start_arr[0], Number(start_arr[1])-1, start_arr[2]);
									
									var elapsedMSec = date - regi_date;
									var betweenday = (end_date.getTime() - start_date.getTime() /1000/60/60/24);
									console.log(betweenday);
									
									
									if(betweenday > 365){
										year = Math.floor(elapsedDay/365); 
										month = Math.floor((elapsedDay-(year*365))/30)
										alert(year, month)
										document.write('휴면 대상')
									} else {
										document.write('휴면 대상 아님')
									}
								</script>
							</details></td>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<!-- 선택항목 삭제하는 버튼 -->
		<button type="button" class="btn btn-secondary"
			onclick="deleteValue();">선택한 회원 탈퇴</button>
	</div>
</body>
</html>