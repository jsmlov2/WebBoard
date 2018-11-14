<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
가입되었습니다.

<form action="${pageContext.request.contextPath}/doLogin" method="post">
<h2>로그인 </h2>
id : <input type='text' name = 'id'>
pwd : <input type="password" name = 'pw'>

<input type='submit' value='로그인'>
</form>
</body>
</html>