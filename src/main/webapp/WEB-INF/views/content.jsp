<%@page import="github.sunkeun.webboard.dto.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#tagview {
	margin : 8px 0;
}
.tag {
	border: 1px solid #abc;
	background-color: #efefef;
	padding : 2px 4px;
	border-radius: 4px;
}
</style>
<script type="text/javascript">
function goTo ( ) {
	console.log ( 'hi');
}
</script>
</head>
<body>
<%--=
	Post p = request.getAttribute("post");
	if ( p == null) {
		out.write("글 없ㅇ므!);
	} else {
		
	}
--%>
<c:if test="${ empty post }">
글 없음!
</c:if>

<c:if test="${ not empty post }">
<h3> ${post.seq} :  ${post.title}</h3>
내용 : <p>${post.content}</p>
<div id="tagview">
<c:forEach items="${post.tags}" var="t">
	<span class="tag">${t}</span>
</c:forEach>
</div>
<!--<input type="button" onClick="${pageContext.request.contextPath}/delete" value="글삭제" > -->
<%--
query string 방식  
<form action="${pageContext.request.contextPath}/delete" method="post">
<input type="hidden" name="seq" value="${post.seq}">
<input type="submit"  value="글삭제" >
</form> --%>

<form action="${pageContext.request.contextPath}/delete/${post.seq}" method="post">
<input type="submit"  value="글삭제" >
</form>

<%-- <a href="${pageContext.request.contextPath}/update?seq=${post.seq}">수정하기</a> --%>
<a href="${pageContext.request.contextPath}/update/${post.seq}">수정하기</a> 
</c:if>

</body>
</html>