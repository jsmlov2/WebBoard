<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
var err = {
   DUP_ID : '중복된 아이디입니다'
}
var ctxpath = '${pageContext.request.contextPath}';
$(document).ready( function(){
	$('#btnJoin').click( function() {	console.log('FIRST');
	var id = $('#id').val();
	var pw = $('#pw').val();
    var name = $('#name').val();
	var eMail = $('#eMail').val();
	var address = $('#address').val(); 
	$.ajax({
		method : 'POST',
		url : '${pageContext.request.contextPath}/joinAsync',
		data : 'id=' + id + '&pw=' + pw + '&name=' + name  + '&eMail=' + eMail + '&address=' + address,
		success : function(res){
			$('#resultCode').append('aaa');
			var results = JSON.parse(res);
		/* 	var r  = {
					success : true,
					cause : 'DUP_ID'
			} */   // r.success 는 true 갑이고, r.cause는 DUP_ID 임
 			 if(results.success){
				 console.log(results.success);
				 document.location.href=ctxpath + '/login';
				/*  for( var key in results ) {
					 // results['cause']
					 // results['success']
					 $('#resultCode').append( results[key]);
				}
				 */ 
				 
				 /*
				for(var i=0; i<results.length;i++){
					$('#resultCode').append(results[i]);
				}	
				 */
			}  else {
				alert(err[results.cause]);
			}
		}
	});				
});
});
</script>
</head>
<body>
<h1>회원가입</h1>

<%-- <form action="${pageContext.request.contextPath}/joinAsync" method="POST"> --%>
아이디: <input id="id" type="text"  name="id" ><br/>
패스워드 : <input id="pw" type="text"  name="pw" ><br/>
이름 : <input id="name" type="text"  name="name" ><br/>
이메일 : <input id="eMail" type="text"  name="eMail" ><br/>
주소 : <input id="address" type="text"  name="address" ><br/>
<input id="btnJoin" type='button' value='가입하기' >
<h1 id="resultCode"></h1>


</body>
</html>