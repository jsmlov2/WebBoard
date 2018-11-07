<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정하기
<form action="${pageContext.request.contextPath}/update" method="post">
제목 : <input type="text" name="title" value="${post.title}"/>
내용 : <input type="text" name="content" value="${post.content}"/>
<input type="submit" value="수정"/>
<input type="hidden" name="seq" value="${post.seq}"/>

</form>
</body>
</html>