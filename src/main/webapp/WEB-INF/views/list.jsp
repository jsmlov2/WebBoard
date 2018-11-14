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
<c:if test="${not empty Member }">
	<div>
		<span>안녕하세요 ${Member.name }님</span>
		<span><a href="${pageContext.request.contextPath}/logout">로그아웃</a></span>
	</div>
</c:if>
<c:if test="${empty Member }">
	<div><a href="${pageContext.request.contextPath}/login">로그인</a></div>
</c:if>
<ul>
 <c:forEach var="each" items="${ posts }">
	<li> <a href="${pageContext.request.contextPath}/content/${each.seq}">${ each.title}</a> 
 </c:forEach>
</ul>

<a href="${pageContext.request.contextPath}/write">글쓰기(한글 나와라!)</a>
</body>
</html>