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
제목 : <input type=text name="tt"></input></br>
내용 : <input type=text name="cc"></input></br>
태그 : <input type=text name="tag"></input>
<input type=submit value="WRITE!!!"></input>
</form>
</body>
</html>