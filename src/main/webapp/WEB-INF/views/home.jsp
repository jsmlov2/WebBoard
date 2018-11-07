<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<%
	Object  s = request.getAttribute("serverTime");
	if ( s == null ) {
		s = session.getAttribute("serverTime");
		if ( s == null ) {
			s = application.getAttribute("serverTime");
		}
		
		s = "";
	}
%>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
