<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- spring:message ->messageSource에 등록한 파일에서 텍스트를 찾아옴 -->
<title><spring:message code="login.form.title"/></title>
</head>
<body>
<!-- login = @ModelAttribute에서 전달받은 LoginCommand객체 -->
<form:form modelAttribute="login">
<form:errors/>
<p>
	<label for="loginType">
		<spring:message code="login.form.type"/>
	</label>
	<form:select path="loginType" items="${loginTypes }"/>
</p>
<p>
	<label for="id">
		<spring:message code="login.form.id"/>
	</label>
	<form:input path="id" />
	<form:errors path="id"/>
</p>
<p>
	<label for="password">
		<spring:message code="login.form.password" />
	</label>
		<form:password  path="password"/>
		<form:errors path="password" />
</p>
<p>
	<input type="submit" value="<spring:message code="login.form.submit" />">
</p>

</form:form>
</body>
</html>