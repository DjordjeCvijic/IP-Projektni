<%@ page import="service.UserActionService" %>
<%@ page import="beans.UserActionBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" class="beans.UserBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<%
	if(!(userBean.isLoggedIn())) response.sendRedirect("unauthorized.jsp");

%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link href="styles/users-actions.css" type="text/css" rel="stylesheet">
<script src="js/users-actions.js" type="text/javascript"></script>
</head>
<body>
	<button class="btn" onclick="goBack()">Back</button>
	<div class="main-div">
		<div class="header-div">	
			<p>Users actions:</p>	
			<button class="btn" onClick="downloadUsersActions()">Download data</button>			
		</div>
		
		<table>
			<tr>
				<th>User action ID</th>
				<th>User action time</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Username</th>
				<th>Action</th>
				
				
				
			</tr>
			<% for(UserActionBean userAction:UserActionService.getUsersActions()){ %>
			<tr>
				<td><%= userAction.getUserActionId() %></td>
				<td><%= userAction.getTime() %></td>
				<td><%= userAction.getFirstName() %></td>
				<td><%= userAction.getLastName() %></td>
				<td><%= userAction.getUsername() %></td>
				<td><%= userAction.getAction() %></td>

			
			</tr>
			<%} %>
		</table>
	</div>

</body>
</html>