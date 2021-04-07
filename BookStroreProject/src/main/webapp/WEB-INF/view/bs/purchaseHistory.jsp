<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구매내역 확인</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function findSales(){
	var category=$("#category").val();
	var word = $("#word").val();
	var url="purchaseHistory.do";
	var params="category="+category+"&"+"word="+word;	//ajax요청에 실어보낼 프로퍼티
	
	if(word == ""){
		alert("값을 입력하세요.");
		return false;
	}
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"})
		.done(function(args){
			if (category == 1) {
				$("#result").html("");
				 for(var idx=0; idx<args.length; idx++) {	
					 $("#result").append("<h3>"+word+" 검색결과</h3>"+"bookname= "+args[idx].bookname+"   publisher= "+args[idx].publisher + 
							 "   price= "+ args[idx].price+"   saleprice= " + args[idx].saleprice);	
				 } 
			} else if (category == 2) {
				$("#result").html("");
					 $("#result").append("<h3>"+word+" 고객님 구매내역</h3>"+"<h4>구매 횟수= "+args[0][0].count+"회" +
							 "&nbsp;&nbsp;&nbsp;총 구매 가격= "+args[0][0].saleprice+"</h4><br>");
					 for(var i=0; i<args[1].length; i++){
						 var a = args[1][i];
						 $("#result").append((i+1)+". 구매 날짜= "+a.orderdate+"&nbsp;&nbsp;&nbsp;책 이름= "+a.bookname+
								 "&nbsp;&nbsp;&nbsp;출판사= "+a.publisher+"&nbsp;&nbsp;&nbsp;구매 가격= "+a.saleprice+"<br>");
					 }
			}else{
				$("#result").html("");
				$("#result").append(args[0]);
			}
		})
	    .fail(function(e) {
	    	alert(e.status);
	    });	
			
}

</script>

</head>
<body>
<h1>구매내역 확인</h1>
<select id="category">
	<option value="0"><center>~검색 조건~</center></option>
	<option value="1">책 이름</option>
	<option value="2">고객 이름</option>
</select>
&nbsp;&nbsp;
<input type="text" id="word" value="입력">
<button onclick="findSales()">검색</button>

<br><hr>
<div id="result"></div>
</body>
</html>