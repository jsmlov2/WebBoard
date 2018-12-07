<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	var intervalID = setInterval(function(){
		alert('<p>' + new Date() + '</p>');
	},1000);
	
	setTimeout(function(){
		clearInterval(intervalID);
	}, 10000);

	
</script>
</head>
<body>

</body>
</html>