<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
 <c:forEach var="each" items="${ posts }">
	<li> <a href="${pageContext.request.contextPath}/content/${each.seq}">${ each.title}</a> 
 </c:forEach>
</ul>

<a href="${pageContext.request.contextPath}/write">글쓰기(한글 나와라!)</a>
</body>
</html>