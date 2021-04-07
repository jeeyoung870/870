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
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />


<head>
<style type="text/css">
details summary::-webkit-details-marker {
	font-size: 20px;
	margin-right: 5px;
}
summary {
	cursor: pointer;
	outline: none;
}
table {
	border-spacing: 8px;
	border-collapse: separate;
	margin: auto;
	Padding-left: 25px;
}
body {
	/* width: 420px; margin:0 auto;  */
	font-family: Noto Sans KR;
}
.list {
	width: 300px;
	margin: 0 auto;
	text-align: center;
}
td {
	text-align: center;
}
th {
	text-align: center;
	border-bottom: 2px solid #444444;
}
.foo {
	color: #2E944B;
}
header {
	display: flex;
}
.regi {
	float: right;
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
	// 휴면 설정
	function dormancyValue() {
		var url = "userDormancy"; // 컨트롤러로 보내고자 하는 url
		var user_id = "${list.user_id}";

		$.ajax({
			url : url,
			type : 'POST',
			traditional : true,
			data : user_id
		});
	};
	
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="${contextPath}/user/userSelect?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>

<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div class="list">
		<h1>회원 목록</h1>
	</div>
	<div class="regi">
		<button type="button" class="btn btn-secondary"
			onclick="location.href='${contextPath}/user/user/register'">
			<strong>등록</strong>
		</button>
	</div>
	<br /><br />
	<!-- 표시 갯수 선택 -->
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 8}">selected</c:if>>8줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 13}">selected</c:if>>13줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 16}">selected</c:if>>16줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div><br>
	
	<div class="list">
		<!-- 회원 목록 출력 -->
		<table id="table_id">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" id="allCheck"
						name="allCheck"></th>
					<th scope="col">아이디 또는 이메일</th>
				</tr>
			</thead>
			<tbody>
				<!-- DB에서 가져온 UserList에서 값 각각 꺼내와서 forEach문으로 전부 출력 -->
				<c:forEach items="${UserList}" var="list">
					<tr>
						<td class="userlist"><input type="checkbox" name="RowCheck"
							id="RowCheck" value="${list.user_id}" /></td>

						<td class="userlist content" id="${list.user_id }"
							style="text-overflow: ellipsis; overflow: hidden"><details >
								<summary>【 ${list.user_id} 】&nbsp;</summary>
								<span><strong>권한: </strong>${list.auth}</span>
								<br />
								<span><strong>가입일: </strong>${list.regi_date}</span>
								<br />
								<span> <script>
									// 마지막 로그인 및 계정활성화 정보
									var last_date = "${list.last_date}";
									var enabled = "${list.enabled}";
									var user_id = "${list.user_id}";

									// 현재일자를 yyyy-mm-dd 형식으로 변환
									function getToday() {
										var date = new Date();
										var year = date.getFullYear();
										var month = ("0" + (1 + date.getMonth()))
												.slice(-2);
										var day = ("0" + date.getDate())
												.slice(-2);

										return year + "-" + month + "-" + day;
									}
									var today_date = getToday();
									console.log("오늘날짜: " + today_date);

									// 현재일자 빼기 가입일자
									function getDateDiff(today_date, last_date) {
										var arrDate1 = today_date.split("-");
										var getDate1 = new Date(
												parseInt(arrDate1[0]),
												parseInt(arrDate1[1]) - 1,
												parseInt(arrDate1[2]));
										var arrDate2 = last_date.split("-");
										var getDate2 = new Date(
												parseInt(arrDate2[0]),
												parseInt(arrDate2[1]) - 1,
												parseInt(arrDate2[2]));

										var getDiffTime = getDate1.getTime()
												- getDate2.getTime();

										return Math.floor(getDiffTime
												/ (1000 * 60 * 60 * 24));
									}
									var date_diff = getDateDiff(today_date,
											last_date);
									console.log("비로그인 일수: " + date_diff);
									console.log("현재 계정 상태: " + enabled);

									document
											.write('<input type = "hidden" id = "' + user_id + '" value = "' + date_diff + ":" + enabled + '"/>')

									// 휴면설정
									if (date_diff > 365) {
										if (enabled == 1) {
											document.write(
													'<strong>비로그인 일수:</strong> '
															+ date_diff + ' 일',
													'<br>')
											document
													.write('<button class="btn btn-info" onclick="popupOpen2();" type="button">휴면설정</button>')
											function popupOpen2() {
												var popUrl2 = "${contextPath}/user/userDormancy?id=${list.user_id}"
												var popOption2 = "width=500, height=30, top=150, left=550, resizable=no, scrollbars=yes, status=no;";
												var p = window.open(popUrl2,
														"popup2", popOption2);
												p.focus();
											}
										} else if (enabled == 0) {
											document
													.write('<button class="btn btn-info" onclick="popupOpen3();" type="button">휴면해제</button>')
											function popupOpen3() {
												var popUrl3 = "${contextPath}/user/userDormancyCancle?id=${list.user_id}"
												var popOption3 = "width=500, height=30, top=150, left=550, resizable=no, scrollbars=yes, status=no;";
												var p = window.open(popUrl3,
														"popup3", popOption3);
												p.focus();
											}
										}
									} else {
										if (enabled == 0) {
											document.write(
													'<strong>비로그인 일수:</strong> '
															+ date_diff + ' 일',
													'<br>')
											document
													.write('<button class="btn btn-info" onclick="popupOpen4();" type="button">휴면해제</button>')
											function popupOpen4() {
												var popUrl4 = "${contextPath}/user/userDormancyCancle?id=${list.user_id}"
												var popOption4 = "width=500, height=30, top=150, left=550, resizable=no, scrollbars=yes, status=no;";
												var p = window.open(popUrl4,
														"popup4", popOption4);
												p.focus();
											}
										} else {
											document.write("휴면대상아님")
										}
									}
								</script>
								</span>
							</details></td>
				</c:forEach>
			</tbody>
		</table>
	<script>
		// 위의 스크립트에서 값들을 꺼내온 다음에 해당 값들에 대해서 스타일 적용
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {

							document
									.querySelectorAll(".content")
									.forEach(
											function(elem) {
												console.log(elem
														+ "this is called")
												var span_hidden = elem.children[0].children[5].children[1]
												var hidden_raw_value = span_hidden.value;
												var hidden_diff_date = hidden_raw_value
														.split(":")[0];
												var hidden_enabled = hidden_raw_value
														.split(":")[1];
												var hidden_user_id = span_hidden.id;

												if (hidden_diff_date > 365) {
													document
															.getElementById(hidden_user_id).style.backgroundColor = '#FF4500';
												} else {
													if (hidden_enabled == 0) {
														document
																.getElementById(hidden_user_id).style.backgroundColor = '#FFDEAD';
													} else {
														document
																.getElementById(hidden_user_id).style.backgroundColor = '#FFFFFF';
													}
												}
											})
						})
	</script>
	
		<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="${contextPath}/user/userSelect?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="${contextPath}/user/userSelect?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="${contextPath}/user/userSelect?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
	
	<!-- 선택항목 삭제하는 버튼 -->
		<button type="button" class="btn btn-secondary"
			onclick="deleteValue();">선택한 회원 탈퇴</button>
	</div>
</body>
</html>