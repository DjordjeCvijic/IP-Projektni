<%@ page import="service.MuseumService" %>
<%@ page import="beans.MuseumBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <jsp:useBean id="userBean" class="beans.UserBean" scope="session"></jsp:useBean>
 
 
    
<!DOCTYPE html>
<%
			if(!(userBean.isLoggedIn())) response.sendRedirect("unauthorized.jsp");
%>
<html>
<head>
<meta >
<title>Home</title>
<link href="styles/style.css" type="text/css" rel="stylesheet">
<script src="js/admin-home.js" type="text/javascript"></script>


</head>
<body>
<button class="btn" onClick="openUsersAdministrationPage()">Users</button> <br>
<button class="btn" onClick="openUsersActionsPage()">Users actions</button>
<div class="main-div">
	<div class="header-div">
		<p>Museums :</p>
		
		<button class="btn" onClick="addMuseum()">Add museum</button>
			
	</div>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>Country</th>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>Phone number</th>
			<th>Type</th>
			<th></th>
			
		</tr>
		<% for(MuseumBean museum:MuseumService.getAllMuseums()){ %>
		<tr>
			<td><%= museum.getName() %></td>
			<td><%= museum.getAddress()%></td>
			<td><%= museum.getCityName()%></td>
			<td><%= museum.getCountryName()%></td>
			<td><%= museum.getLatitude()%></td>
			<td><%= museum.getLongitude()%></td>
			<td><%= museum.getPhoneNumber()%></td>
			<td><%= museum.getMuseumTypeName()%></td>
			<td><button onClick="showMuseum(<%= museum.getMuseumId()%>)" >Details</button></td>
		</tr>
		<%} %>
	</table>
</div>



</body>
</html>