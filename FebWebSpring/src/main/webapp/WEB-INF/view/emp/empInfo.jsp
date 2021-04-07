<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>사원 정보</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script>
$(function(){	//ready function
	var url="depts.do";
	$.ajax({
		type:"post"		
		,url:url	//controller요청	
		,dataType:"json" })
		//args : ajax요청을 거쳐 돌아온 json형식의 deptList()결과물
		.done(function(args){	/* 응답이 성공 상태 코드를 반환하면 호출되는 함수 */
			 for(var i=0; i < args.length; i++) {
				 $("#dept").append("<option value='"+args[i].deptno+"'>"+args[i].dname+"</option>");
			 }
 			})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
});	//ready 끝

//두번째 option만드는 메소드
function selectDept(){
	var deptno=$("#dept").val();
	//deptno가 빈문자열이라면,(::사원선택::이라면)
	if(deptno=="") {	                
		$("#emp option").each(function() {	//option태그 갯수만큼 반복
			// 요소:eq(n) --> n번째에 위치하는 문서 객체를 선택
			$("#emp option:eq(1)").remove();	//사원이름란 초기화(1번인덱스 지우기)
		});
		return;
	}
	//dept선택된값이 있으면,
	var url="emps.do";
	var params="deptno="+deptno;	//ajax요청에 실어보낼 프로퍼티
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"})
		.done(function(args){
			$("#emp option").each(function() {	
				$("#emp option:eq(0)").remove();	//0번째 option내용을 모두 지우기
			});

			 $("#emp").append("<option value=''>::사원선택::</option>");
			 
			 for(var idx=0; idx<args.length; idx++) {	
				 //EMPNO, ENAME 꼭 대소문자 맞춰서 입력 / 선택한 부서의 사원이름들 출력
				 $("#emp").append("<option value='"+args[idx].EMPNO+"'>"+args[idx].ENAME+"</option>");	
			 } 
		})
	    .fail(function(e) {
	    	alert(e.status);
	    });	
}

function selectEmp(){
	//사원번호 저장
	var empno=$("#emp").val();

	var url="empOne.do";
	var params="empno="+empno;

	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"})
		.done(function(args){
		
			var empno = "사원번호 : "+args.empno+"<br>";
			var ename = "사원 이름 : "+args.ename+"<br>";
			var job = "직급 : "+args.job+"<br>";
			var mgr = "상사 번호 : "+args.mgr+"<br>";
			var hiredate = "입사일 : "+args.hiredate+"<br>";
			var sal = "급여 : "+args.sal+"<br>";
			var comm = "커미션 : "+args.comm+"<br>";
			var deptno = "부서 번호 : "+args.deptno+"<br>";
			
			$("#empInfo").text("");//기존 내용 제거
			$("#empInfo").html(empno+ename+job+mgr+hiredate+sal+comm+deptno);
		})
	    .fail(function(e) {
	    	alert(e.responseText);
	    });	
}
</script>

</head>
<body>
<!-- onchange로 선택이 될때마다 selectDept()실행 -->
<select id="dept" onchange="selectDept()">
  <option value="">::부서선택::</option>
</select>

<select id="emp" onchange="selectEmp()">
  <option value="">::사원선택::</option>
</select>

<hr>
<div id="empInfo">
	
</div>
</body>
</html>