<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String user_id = request.getParameter("user_id");
	
	if (user_id == null) {
		user_id = "";
	}
	
	// 데이터베이스 연동을 통한 아이디 중복검사 결과를 얻어오는 과정에 대한 가정
	//"select id from 테이블 where id = " + user_id;
	boolean result = false;
	String ids [] = {"jquery", "jyjy", "vomitup"};
	for (String i : ids) {
		if (user_id.equals(i)) {
			result = true;
		}
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<id_check>
	<result><%=result%></result>
</id_check>