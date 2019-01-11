<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#issue {
    border: 1px solid #ccc;
    padding: 4px 8px;
    border-radius: 6px;
}
#issue .tab {
	float: left;
    width: 50%;
}
.posts {
	clear:both;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function getIssue(portal) {
	$.ajax({
		method: 'GET',
		url: '${pageContext.request.contextPath}/issues/' + portal,
		success: function(res) {
			// [ 'dd', 'xxx'']
			if(!res.success) {
				alert(res.cause);
				return;
			}
			var issue = $('#' + portal); // #naver
			issue.empty();
			for(var i = 0 ; i < res.data.length ; i++) {
				issue.append(`<div class="kw">${ '${res.data[i]}' }</div>`);
			}
			console.log(res);
		}
	});
}
$(document).ready( function() {
	$.ajax({
		method : 'GET',
		url : '${pageContext.request.contextPath}/listAsync',
		success : function( res ) {
			// [{"title": "first" }, {}, ..{} ]
			//var posts = JSON.parse( res );
			var posts = $('#posts');
			for ( var i = 0 ; i < res.length ; i ++ ) {
				posts.append('<li>' + res[i].title + '</li>');
			}
		}
	});
	getIssue('daum');
	getIssue('naver');
	// getIssue('naver');
	
	var call = setInterval(function() {
		getIssue('daum');
		getIssue('naver');
		// call();
	}, 10*1000);
	
	
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
<div id="issue">
	<div id="daum" class="tab">
	</div>
	<div id="naver" class="tab">
	</div>
<!-- 
	<div class="kw">감자</div>
	<div class="kw">감자</div>
	<div class="kw">감자</div>
	<div class="kw">감자</div>
 -->
</div>
<ul class="posts">
 <c:forEach var="each" items="${ posts }">
	<li> <a href="${pageContext.request.contextPath}/content/${each.seq}">${ each.title}</a> 
 </c:forEach>
</ul>
<h3>비동기로 로드한 글내용</h3>
<ul id="posts"></ul>
<a href="${pageContext.request.contextPath}/write">글쓰기(한글 나와라!)</a>
</body>
</html>