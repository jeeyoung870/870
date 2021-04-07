<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link href="${contextPath}/resources/css/static/default.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/static/layout/layout.css" rel="stylesheet" />
</head>
<body>
	<div class="bg"></div>
	<div class="layout_wrap">
		<tiles:insertAttribute name="headerManage" />
		<tiles:insertAttribute name="bodyManage" />
		<tiles:insertAttribute name="footerManage" />
	</div>
</body>
</html>