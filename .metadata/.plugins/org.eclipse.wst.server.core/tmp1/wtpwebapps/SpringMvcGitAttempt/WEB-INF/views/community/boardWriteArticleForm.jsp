<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/mainBoard.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/app/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body><!-- 커스텀 폼태그 사용가능 -->
	<div class = "inner">
	<form:form method = "post" action = "./doWrite" modelAttribute = "writeArticleModel" id = "writeArticleForm">
		<label for = "b_subject">enter your subject</label>
		<form:input type = "text" path = "b_subject"></form:input>
		<form:select name = "category" path = "category" class="selectpicker">
			<form:option value = "general" selected="selected">general</form:option>
			<form:option value = "ask">ask</form:option>
			<form:option value = "tip">tip</form:option>
		</form:select> 
		<textarea name = "b_content" id = "ir1" rows="10" cols="100" style ="min-width:260px;width:100%">
		에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.
		</textarea>
		<input type = "submit" value = "submit" id = "submitBtn" class = "boardBtn"></input>
	</form:form>
	</div>
	
</body>
<script type="text/javascript">
		
		var oEditors = [];
		
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: "ir1",
			sSkinURI: "/app/se2/SmartEditor2Skin.html",
			fCreator: "createSEditor2"
			
		});
		
		$("#submitBtn").click(submitContents)
		function submitContents(event){
			event.preventDefault()
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			
			try{
				$("#writeArticleForm").submit()
			}catch(e){}
		}
		
	</script>
</html>
