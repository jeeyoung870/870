<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">

<!-- 구글 로그인 설정 -->
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="682293530114-lsru175992b90da5c2c292i6orlcdr1b.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js?onload=renderButton"
	async defer></script>

<!-- 네이버 로그인 설정 -->
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<title>HiLS 로그인</title>
</head>
<body>
	<!-- 대충 타일 부분 -->
	<div
		style="background-color: #f70000; width: 100%; height: 50px; text-align: center; color: white;">
		<h3>HiLS</h3>
	</div>

	<!-- 구글 로그인 -->
	<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
	<script type="text/javascript">
		function onSignIn(googleUser) {
			// Useful data for your client-side scripts:
			var profile = googleUser.getBasicProfile();
			console.log("ID: " + profile.getId()); // Don't send this directly to your server!
			console.log('Full Name: ' + profile.getName());
			console.log("Image URL: " + profile.getImageUrl());
			console.log("Email: " + profile.getEmail());

			// The ID token you need to pass to your backend:
			var id_token = googleUser.getAuthResponse().id_token;
			var userName = profile.getName();
			var email = profile.getEmail();
			var userImg = profile.getImageUrl();

			sessionStorage.setItem('id_token', id_token);
			console.log(sessionStorage.getItem("id_token"));
			sessionStorage.setItem('email', email);
			console.log(sessionStorage.getItem("email"));
			sessionStorage.setItem('userImg', userImg);
			console.log(sessionStorage.getItem("userImg"));
			sessionStorage.setItem('userName', userName);
			console.log(sessionStorage.getItem("userName"));

			let data = {
				"id_token" : id_token,
				"email" : email,
				"userImg" : userImg,
				"enabled" : 1,
				"userName" : userName
			}
			
			let url = "/test/user/login/insertDB"

			$.ajax({ //컨트롤러와 통신.
				dataType : "json",
				method : "POST",
				url : url,
				data : data
			}).done(function() {
				console.log("success!")
			})

			// 로그인 후 페이지 이동 경로 설정 ( href 대신에 replace 를 사용하면 페이지기록이 남지 않아 뒤로가기 시, 이동 불가. 보안이나 도배글 방지용으로 유용. 
			document.location.href = "/test/mainPage.jsp"
		}
	</script>


	<%-- <%try {
	// 드라이버 로딩
	String driver = "oracle.jdbc.driver.OracleDriver";
	Class.forName(driver);

	// SQL Login
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "hils";
	String password = "1234";

	// 연결
	Connection conn = DriverManager.getConnection(url, id, password);
	System.out.println(conn + ": conn연결확인.");
	System.out.println(conn.getClass() + ": conn.getClass() 확인.");

	// DB에 데이터 넣기
	// 쿼리 실행을 위한 statement 혹은 prepareStatement 객체 생성 
	pstmt = conn.prepareStatement("insert into userData values (?, ?, ?, ?, ?");

	// String insertDB = "insert into userData (id_token, userName, email, userImg, ENABLED) values ( ${id_token} ,  , 650 )";

	System.out.println(pstmt + ": pstmt1");
	System.out.println(pstmt.getClass() + ": pstmt.getClass() 확인.");

	pstmt.setString(1, id_token);
	pstmt.setString(2, userName);
	pstmt.setString(3, email);
	pstmt.setString(4, userImg);
	pstmt.setString(5, 1);

	pstmt.executeUpdate();

} finally {
	if (pstmt != null)
		try {
			pstmt.close();
		} catch (SQLException ex) {
		}
	if (conn != null)
		try {
			conn.close();
		} catch (SQLException ex) {
		}
%> --%>



	<!-- ============================== 구글 로그인 (컨트롤러) ============================================ -->

	<%-- 	<br>
	<!-- 구글 로그인 화면으로 이동 시키는 URL -->
	<div id="google_login" style="text-align: center">
		<a href="${google_url}"><img width="230"
			src="${pageContext.request.contextPath}/resources/img/loginImg.png" /></a>
	</div>
 --%>
	<!-- ======================================================================== -->

	<!-- 네이버 로그인 화면으로 이동 시키는 URL -->
	<!-- 네이버 로그인 화면에서 ID, PW를 올바르게 입력하면 callback 메소드 실행 요청 -->
	<div id="naver_id_login">
		<a href="${naver_url}"><img width="200"
			src="${pageContext.request.contextPath}/resources/img/naver_w_in.PNG" /></a>
	</div>
</body>
</html>
