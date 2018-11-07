<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3>
<form action="${pageContext.request.contextPath}/doWrite" method="POST">
<input type=text name="tt"></input>
<input type=text name="cc"></input>
<input type=submit value="WRITE!!!"></input>
</form>
</body>
</html>