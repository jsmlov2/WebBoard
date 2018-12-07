<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function appendTag( tag ) {
	var values = $('#tags').val();
	var newval = values.length == 0 ? tag : values +"," + tag; 
	$('#tags').val(newval);
	
	// 	<span class="tag">def</span>
	$('#tagview').append('<span class="tag">' + tag + '</span>');
	$('#tagInput').val('');
	
}
$(document).ready( function() {
	$('#tagInput').on('keypress', function(e){
		var code = e.keyCode
		if( code == 13 ) {
			e.preventDefault();
			var tag = $('#tagInput').val();
			appendTag(tag);
		}
	});
});
</script>
</head>
<body>
<h3>글쓰기</h3>
<form action="${pageContext.request.contextPath}/doWrite" method="POST">
제목 : <input type=text name="tt"></input></br>
내용 : <input type=text name="cc"></input></br>
<input id="tags" type="hidden" name="tags">
<div id="tagview">
</div>
태그 : <input type=text id="tagInput"></input>
<input type=submit value="WRITE!!!"></input>
</form>
</body>
</html>