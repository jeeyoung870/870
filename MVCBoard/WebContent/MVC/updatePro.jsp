<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}"> <!-- 비번이 맞아서 수정된경우 -->
<meta http-equiv="Refresh" content="0;url=list.do?pageNum=${pageNum}" >
</c:if>
<c:if test="${check==0}"> <!-- 비번이 틀렸을경우 -->
비밀번호가 다릅니다.
<br>
<a href="javascript:history.go(-1)">[글수정 폼으로 돌아가기]</a>
</c:if>