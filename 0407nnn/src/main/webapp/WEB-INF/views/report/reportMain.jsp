<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
table {
	width: 420;
	font-size: 10pt;
	text-align: center;
}

summary {
	cursor: pointer;
	outline: none;
}

.reportContents2 {
	border-bottom: 2px solid #444444;
	line-height: 25px;
}

th {
	line-height: 40px;
	border-bottom: 2px solid #444444;
	text-align: center;
}

td {
	padding: 5 0 0 0;
}

.report {
	text-align: center;
}

header {
	display: flex;
}

.morecontent {
	width: 370px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.morecontent2 {
	height: 55px;
	width: 370px;
	overflow: scroll;
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
			if (confirm("정말 삭제하시겠어요?") == true) {

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
							location.replace("/mvc/report/ReportPass") // 삭제 후 신고페이지 새로고침
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
	
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="${contextPath}/report/boardList?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>
<meta charset="EUC-KR">
<title>신고 및 제재 관리</title>
</head>
<body>
	<div class="report">
		<h2>신고 관리</h2>
		<!-- 신고한 게시글 목록 출력 -->
		<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 8}">selected</c:if>>8줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> <!-- 옵션선택 끝 -->
		<table>
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" id="allCheck"
						name="allCheck"></th>
					<th scope="col">번호</th>
					<th scope="col" style="text-align: center">신고대상</th>
					<th scope="col" style="text-align: center">신고자</th>
					<th scope="col">신고게시글</th>
					<th scope="col">신고일</th>
				</tr>
			</thead>
			<tbody>
				<!-- DB에서 가져온 ReportList에서 값 각각 꺼내와서 forEach문으로 전부 출력 -->
				<c:forEach items="${ReportList}" var="report">
					<tr>
						<td rowspan="2" class="reportContents"><input type="checkbox"
							name="RowCheck" id="RowCheck" value="${report.r_number}" /></td>
						<td rowspan="2" class="reportContents">${report.r_number}</td>

						<td style="text-align: center">${report.reported_user}</td>
						<td style="text-align: center">${report.reporter_user}</td>
						<td style="text-align: center"><a href="http://localhost:8090/mvc/community/showArticleContent?b_number=${report.r_board_num}">해당 글로 이동</a></td>
						<td><fmt:formatDate value="${report.r_regi_date}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td colspan="4" class="reportContents2" style="text-align: left">
							<details>
								<summary>
									<div class="morecontent">
										<strong>&nbsp;&nbsp;사유: </strong>${report.r_content}</div>
								</summary>
									<strong>※ 상세내용 ※</strong>
								<div class="morecontent2"><p>${report.r_content}</p></div>
							</details>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="${contextPath}/report/boardList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="${contextPath}/report/boardList?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="${contextPath}/report/boardList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>

		<br />
		<!-- 선택항목 삭제하는 버튼 -->
		<input type="button" value="선택항목 삭제" class="btn btn-secondary"
			onclick="deleteValue();">
	</div>
</body>
</html>