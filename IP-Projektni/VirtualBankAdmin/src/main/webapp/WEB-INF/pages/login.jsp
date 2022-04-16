<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="styles/login.css" type="text/css" rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div class="main-div">
		<form method="POST" action="?action=login">
			<label>Username: </label> 
			<input type="text" name="username" />
			<br/>
			<label>Password: </label> 
			<input type="password" name="password" />
			<br/>
			<input type="submit" name="submit"  value="Log in" />
			<br/>
			<label><%=session.getAttribute("notification")!=null?session.getAttribute("notification"):""%></label>
		</form>
	
	</div>
</body>
</html>