<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready( function() {
	$.ajax({
		method : 'GET',
		url : '${pageContext.request.contextPath}/listAsync',
		success : function( res ) {
			// [{"title": "first" }, {}, ..{} ]
			var posts = JSON.parse( res );
			for ( var i = 0 ; i < posts.length ; i ++ ) {
				$('#posts').append('<li>' + posts[i].title + '</li>');
			}
		}
	});
});
</script>
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
<h3>비동기로 로드한 글내용</h3>
<ul id="posts"></ul>
<a href="${pageContext.request.contextPath}/write">글쓰기(한글 나와라!)</a>
</body>
</html>