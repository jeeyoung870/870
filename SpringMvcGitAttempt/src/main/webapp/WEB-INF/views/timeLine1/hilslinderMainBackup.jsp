<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<label for = "userInput">enter some exercise name</label>
		<input type = "text" id = "userInput"/>
		<input type = "submit" value = "search" id = "searchBtn"/>
	</form>
	<table id = "searchOutput">
		<tr>
			<td>workoutName</td>
			<td>burning per half-hour(70kg)</td>
			<td></td>
		</tr>
		
	</table>
	<form>
		<textarea readonly id = "beforeSubmit"></textarea>
		<input type = "submit" value = "submit"/>
	</form>
	<script type = "text/javascript">
		$("#searchBtn").click(handleSearchEvent)
		function handleSearchEvent(event){
			event.preventDefault()
			let url = "./doWorkoutSearch"
			let data = "userInput=" + $("#userInput").val()
			
			$.ajax({
				url : url,
				data : data,
				dataType : "json",
				method : "POST"
			}).done(function(result){
				htmls = ""
				htmls += "<tr><td>workoutName</td><td>burning per half-hour(70kg)</td><td></td></tr>"
				result.workoutList.forEach(function(elem){
					htmls += "<tr><td>" + elem.gym_activities + "</td>"
					htmls += "<td>" + elem.pound_155 + "</td>"
					htmls += "<td>" + "담기" + "</td></tr>"
				})
				$("#searchOutput").html(htmls)
			}).fail(function(){
				console.log("You'va failed")
			})
			
			
		}
		
	
	</script>
</body>
</html>