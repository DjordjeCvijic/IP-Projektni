<%@page import="beans.UserInfoBean"%>
<%@ page import="service.UserService" %>
<%@ page import="beans.UserBean" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" class="beans.UserBean" scope="session" ></jsp:useBean>
<!DOCTYPE html>
<%
	if(!(userBean.isLoggedIn())) response.sendRedirect("unauthorized.jsp");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="styles/users.css" type="text/css" rel="stylesheet">
<script src="js/admin-home.js" type="text/javascript"></script>
</head>
<body>
	<div class="main-div">
		<div class="header-div">
			<p>Users :</p>				
		</div>
		
		<table>
			<tr>
				<th>User id</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Username</th>
				<th>Email</th>
				<th>User status</th>
				<th></th>
				
			</tr>
			<% for(UserInfoBean user:UserService.getUsers()){ %>
			<tr>
				<td><%= user.getUserId()%></td>
				<td><%= user.getFirstName()%></td>
				<td><%= user.getLastName()%></td>
				<td><%= user.getUsername()%></td>
				<td><%= user.getEmail()%></td>
				<td><%= user.getUserStatusId()%></td>
				
			</tr>
			<%} %>
		</table>
	</div>

</body>
</html>