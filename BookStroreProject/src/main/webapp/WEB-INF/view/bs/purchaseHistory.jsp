<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���ų��� Ȯ��</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function findSales(){
	var category=$("#category").val();
	var word = $("#word").val();
	var url="purchaseHistory.do";
	var params="category="+category+"&"+"word="+word;	//ajax��û�� �Ǿ�� ������Ƽ
	
	if(word == ""){
		alert("���� �Է��ϼ���.");
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
					 $("#result").append("<h3>"+word+" �˻����</h3>"+"bookname= "+args[idx].bookname+"   publisher= "+args[idx].publisher + 
							 "   price= "+ args[idx].price+"   saleprice= " + args[idx].saleprice);	
				 } 
			} else if (category == 2) {
				$("#result").html("");
					 $("#result").append("<h3>"+word+" ���� ���ų���</h3>"+"<h4>���� Ƚ��= "+args[0][0].count+"ȸ" +
							 "&nbsp;&nbsp;&nbsp;�� ���� ����= "+args[0][0].saleprice+"</h4><br>");
					 for(var i=0; i<args[1].length; i++){
						 var a = args[1][i];
						 $("#result").append((i+1)+". ���� ��¥= "+a.orderdate+"&nbsp;&nbsp;&nbsp;å �̸�= "+a.bookname+
								 "&nbsp;&nbsp;&nbsp;���ǻ�= "+a.publisher+"&nbsp;&nbsp;&nbsp;���� ����= "+a.saleprice+"<br>");
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
<h1>���ų��� Ȯ��</h1>
<select id="category">
	<option value="0"><center>~�˻� ����~</center></option>
	<option value="1">å �̸�</option>
	<option value="2">�� �̸�</option>
</select>
&nbsp;&nbsp;
<input type="text" id="word" value="�Է�">
<button onclick="findSales()">�˻�</button>

<br><hr>
<div id="result"></div>
</body>
</html>