<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>

<form action="${pageContext.request.contextPath}/join" method="POST">
아이디: <input type="text" name="id" ><br/>
패스워드 : <input type="text" name="pw" ><br/>
이름 : <input type="text" name="name" ><br/>
이메일 : <input type="text" name="eMail" ><br/>
주소 : <input type="text" name="address" ><br/>
<input type=submit value="가입하기">
</form>

</body>
</html>