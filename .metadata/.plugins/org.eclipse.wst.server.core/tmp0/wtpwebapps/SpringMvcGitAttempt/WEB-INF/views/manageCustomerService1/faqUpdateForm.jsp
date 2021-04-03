<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${contextPath}/resources/js/script.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="/app/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	<b>글수정</b>
	<br>
	<form method="post" name="writeform" action="faqManageBoard"
		onsubmit="return writeSave()">
		<input type="hidden" name="_method" value="put" />
		<table width="420" border="1" cellspacing="0" cellpadding="0"
			align="center">
			<input type="hidden" name="num" value="${article.num}">
			<tr>
				<td>카테고리</td>
				<td>
					<select id="category" name="category">
						<option value="general">::글목록선택::</option>
						<option value="계정문제">계정 문제</option>
						<option value="커뮤니티">커뮤니티</option>
						<option value="모바일">모바일</option>
						<option value="기능">기능</option>
						<option value="통계">통계</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="70" align="center">제 목</td>
				<td align="left" width="330"><input type="text" size="40"
					maxlength="50" name="subject" value="${article.subject}"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" id="faqSmartEditor"
						rows="10" cols="100" style="min-width: 260px; width: 100%">${article.content}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit" value="글수정"
					id="submitBtn" class="boardBtn"></input>
					<input type="button" value="목록보기" OnClick="window.location='faqmanageboard'">
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var oEditors = [];

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "faqSmartEditor",
			sSkinURI : "/app/se2/SmartEditor2Skin.html",
			fCreator : "createSEditor2"

		});

		$("#submitBtn").click(submitContents);

		function submitContents(event) {
			event.preventDefault()
			oEditors.getById["faqSmartEditor"]
					.exec("UPDATE_CONTENTS_FIELD", []);

			try {
				$("#faqWriteForm").submit()
			} catch (e) {
			}
		}
	</script>
</body>
</html>