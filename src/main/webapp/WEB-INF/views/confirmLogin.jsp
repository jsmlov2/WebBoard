<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
/*
 {
	'ready' : [fm]
}

ready[0]();


 */
$(document).ready( function() {
	console.log('FIRST');
	$('#btnLogin').click( function() {
		var id = $('#id').val();
		var pw = $('#pw').val();
		console.log ( id, pw);
		// id=1&pw=1
		$.ajax({
			method : 'POST',
			url : '${pageContext.request.contextPath}/doLoginAsyn',
			data : 'id=' + id + '&pw=' + pw,
			success : function(res) {
				var obj = JSON.parse(res);
				if ( obj.success ) {
					location.href='${pageContext.request.contextPath}/list';
				} else {
					alert('아이디 패스워드 확인!');
				}
				console.log(res, obj );
			}
		});
	});
});
</script>
</head>
<body>
가입되었습니다.

<%-- <form action="${pageContext.request.contextPath}/doLogin" method="post">
</form> --%>

<h2>로그인 </h2>
id : <input id="id" type='text' name = 'id'>
pwd : <input id="pw" type="password" name = 'pw'>
<input id="btnLogin" type='button' value='로그인' >
</body>
</html>
<%
	session.removeAttribute("error");
%>