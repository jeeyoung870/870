<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#upper{
		font-size: 22px;
		font-style: medium;
		font-weight: 600; line-height: 52px;
		text-align: center;
	}
	#upper hr{
		background-color:#FF9A7F; 
		border: 0; 
		height: 20px;
	}
	.content{
		padding: 10px;
	}
	.content:hover{	
		color : #FF3600;
	}
	.content_hr{
		background-color:#FF9A7F; border: 0; height: 2px;
	}
	.hide{
		background-color : beige;
		text-align : center;
	}
	.hide>li>a:hover{
		color:#FF3600;
	}
	#confirmAllNoti{
		text-align : center;	
	}
	#confirmAllNoti>span>a:hover{
		color : #FF3600;
	}
</style>
</head>
<body>
	<div class = "inner">
	<div id = "upper">
	<span>알림 페이지 입니다.</span>
	<hr/>
	</div>
	<div  id = "notiTable">
		<ul>
			<c:if test = "${notiDataList ne null}">
				<c:forEach var = "notiData" items = "${notiDataList}">
					<c:set var = "notiDate" value="${fn:replace(fn:split(notiData, ':' )[1], '/', '') }"/>
					<c:set var = "noti_identifer" value = "${fn:split(notiData,  ':')[2]}"/>
					<li>
						<div class = "content"><span>${notiData}</span>
								
						</div>
						<hr class = "content_hr"/>
						<c:choose>
						<c:when test = "${noti_identifer eq null or noti_identifier eq ''}">
							<ul class = "hide">
								<li class = "deleteNoti"><a href = "deleteSpecificNoti?rawDate=${notiDate}">알림 확인</a> 
							</ul>
						</c:when>
						<c:otherwise>
							<ul class = "hide">
								<li class = "deleteNoti"><a href = "deleteSpecificNoti?rawDate=${notiDate}&noti_identifier=${noti_identifier}">알림 확인</a> 
							</ul>
						</c:otherwise>
						</c:choose>
					</li>
					<hr class = "content_hr"/>
				</c:forEach>
			</c:if>
		</ul>
	</div>
		<div id = "confirmAllNoti">
			<span><a href = "deleteEveryNoti">알림 전체 확인</a></span>
		</div>
	</div>
	<script>
	$(function () {
		$(".hide").hide();
		$(".content").click(function(){
			console.log("called")		
			if($(this).next().next().is(":visible"))
			{
				$(this).next().next().stop().slideUp(200);

			}else{
				$(".hide").stop().slideUp(500);
				$(this).next().next().stop().slideDown(200);
			};
		});
	});
	</script>
</body>
</html>