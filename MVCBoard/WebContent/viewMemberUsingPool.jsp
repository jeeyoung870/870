<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<html>
<head><title>부서 목록</title></head>
<body> 

MEMBER 테이블의 내용
<table width="100%" border="1">
<tr>
	<td>부서번호</td><td>부서이름</td><td>위치</td>
</tr>
<%
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		//커넥션을 사용할땐 기존 db 주소가 아닌 커넥션 풀의 주소를 사용한다.
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		String query = "select * from board";
		conn = DriverManager.getConnection(jdbcDriver);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) {
%>
<tr>
	<td><%= rs.getInt(1) %></td>
	<td><%= rs.getString(2) %></td>
	<td><%= rs.getString(3) %></td>
</tr> 
<%
		}
	} finally {
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>
</table>

</body>
</html>
