<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="<%=request.getContextPath()%>/resources/css/style_home.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<h1 style="text-align: center">Invalid Login Attempt!</h1>
	<!-- 	<a href="/EZComm" class="btn btn-success" align="center">return to login page</a> -->
	<center>
		<form action="/EZComm">
			<input type="submit" value="return to login page" />
		</form>
	</center>
</body>
</html>