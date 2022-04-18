<%@page import="beans.UserInfoBean"%>
<%@ page import="service.UserService" %>
<%@ page import="beans.UserBean" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" class="beans.UserBean" scope="session" ></jsp:useBean>
<!DOCTYPE html>
<%
	if(!(userBean.isLoggedIn())) response.sendRedirect("unauthorized.jsp");

	if((request.getParameter("userId")!=null)&&(request.getParameter("statusId")!=null)){
		
		UserService.saveUserStatus(request.getParameter("userId"), request.getParameter("statusId"));
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link href="styles/users.css" type="text/css" rel="stylesheet">
<script src="js/users.js" type="text/javascript"></script>
</head>
<body>
	<button class="btn" onclick="goBack()">Back</button>
	<div class="main-div">
		<div class="header-div">
			<span id="informations"> </span>	
			<p>Users :</p>				
		</div>
		
		<table>
			<tr>
				<th>User ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Username</th>
				<th>Email</th>
				<th>User status</th>
				<th>User Password</th>
				
			</tr>
			<% for(UserInfoBean user:UserService.getUsers()){ %>
			<tr>
				<td><%= user.getUserId()%></td>
				<td><%= user.getFirstName()%></td>
				<td><%= user.getLastName()%></td>
				<td><%= user.getUsername()%></td>
				<td><%= user.getEmail()%></td>
				<td>
					<select  id="select<%= user.getUserId()%>" onchange="selectChance('button<%= user.getUserId()%>')">
						<option value="1" <%if(user.getUserStatusId()==1){ %>selected<%} %> >Not approved</option>
						<option value="2" <%if(user.getUserStatusId()==2){ %>selected<%} %>>Approved</option>
						<option value="3"<%if(user.getUserStatusId()==3){ %>selected<%} %>>Blocked</option>
					</select>
					<button disabled="disabled" id="button<%= user.getUserId()%>" onclick="saveUserStatus('select<%= user.getUserId()%>',<%= user.getUserId()%>)" >SAVE</button>
				</td>	
				<td>
					<button   onclick="resetPassword('<%= user.getUserId()%>','<%= user.getUsername()%>')" >Reset password</button>
				</td>
			</tr>
			<%} %>
		</table>
	</div>

</body>
</html>