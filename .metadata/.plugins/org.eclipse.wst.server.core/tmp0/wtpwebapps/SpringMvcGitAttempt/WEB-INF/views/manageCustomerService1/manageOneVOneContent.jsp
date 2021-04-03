<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/resources/css/default.css" rel="stylesheet" />
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.inner{
	width : 420px;
	margin : 0 auto;
}
</style>
</head>
<body>
<div class = "inner">
<table>
		<tr>
			<td>is_replied : </td>
			<td>${askAndReplyList.is_replied }</td>
		</tr>
		<tr>
			<td>user_id : </td>
			<td>${askAndReplyList.user_id }</td>
		</tr>
		<tr>
			<td>ask_date :</td>
			<td>${askAndReplyList.ask_date }</td>
		</tr>
		<tr>
			<td>Subject : </td>
			<td>${askAndReplyList.ask_title }</td>
		</tr>
		<tr>
			<td>Content :</td>
			<td>${askAndReplyList.ask_content }</td>
		</tr>
		
	</table>
	<c:if test = "${askAndReplyList.is_replied eq 'Y' }">
		<table>
			<tr>
			<td>
				${askAndReplyList.rep_title }
				</td>
			</tr>
			<tr>
			 	<td>${askAndReplyList.rep_content }</td>
			 </tr>
			<tr>
			<td>
				${askAndReplyList.rep_date }
			</td>
			</tr>
			
		</table>
	</c:if>
	</div>
	<c:if test = "${askAndReplyList.is_replied eq 'N' }">
	<form action = "writeReply" method = "Post">
		<input type = "hidden" name = "ask_num" value = "${askAndReplyList.ask_num }"/>
		<label for = "c_content"></label>
		<input type = "text" name = "rep_title"/>
		<div class = "form-group">
			<textarea name = "rep_content" class = "form-control">enter Comments</textarea>
			<input type = "submit" value = "write Reply" class = "boardBtn"></input>
		</div>
	</form>
	</c:if>
</body>
</html>