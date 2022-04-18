<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="service.MuseumTypeService" %>
<%@ page import="dto.MuseumTypeDto" %>
<%@ page import="service.MuseumService" %>
  <jsp:useBean id="museumBean" class="beans.MuseumBean" scope="request"></jsp:useBean>
  <jsp:useBean id="userBean" class="beans.UserBean" scope="session"></jsp:useBean>
 
  <jsp:setProperty property="name" name="museumBean" param="name"/>
  <jsp:setProperty property="address" name="museumBean" param="address"/>
  <jsp:setProperty property="countryName" name="museumBean" param="country"/>
  <jsp:setProperty property="cityName" name="museumBean" param="city"/>
  <jsp:setProperty property="latitude" name="museumBean" param="latitude"/>
  <jsp:setProperty property="longitude" name="museumBean" param="longitude"/>
   <jsp:setProperty property="phoneNumber" name="museumBean" param="phoneNumber"/>
   <jsp:setProperty property="museumTypeName" name="museumBean" param="museum_type"/>
   
   
<!DOCTYPE html>
<%
	if(!(userBean.isLoggedIn())) 
		response.sendRedirect("unauthorized.jsp");

	if(request.getParameter("cancel")!=null)
		response.sendRedirect("admin-home.jsp");
	
	if(request.getParameter("submit")!=null){

		if(("".equals(request.getParameter("name")))
				||"".equals(request.getParameter("address"))
				||"".equals(request.getParameter("country"))
				||"".equals(request.getParameter("city"))
				||"".equals(request.getParameter("latitude"))
				||"".equals(request.getParameter("longitude"))
				||"".equals(request.getParameter("phoneNumber"))
				||"".equals(request.getParameter("museum_type"))){
			session.setAttribute("message", "sva polja nisu unesena");
		}else{
			session.setAttribute("message", "");			
			
			MuseumService.addMuseum(museumBean);
			response.sendRedirect("admin-home.jsp");
			
		}
		
	}else{
		session.setAttribute("message", "");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add museum</title>
<link href="styles/add-page-style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/add-museum.js"></script>
</head>
<body onload="getCountres()">
<div class="main-div">
	<h2>Enter data of new museum</h2>
	<form action="add-museum.jsp" method="POST">
		<label >Museum name:</label>
		<input type="text" name="name" />
		<label>Museum type</label>
		<select name="museum_type">
		<%for(MuseumTypeDto museumType:MuseumTypeService.getAllMuseumTypes()) {%>
			<option value="<%= museumType.getMuseumTypeId() %>"><%= museumType.getName() %></option>
			<%}%>
		</select>
		<label >Address:</label>
		<input type="text" name="address" />
		<label >Country:</label>
		<select id="country_select" name="country" onchange="getRegions()">
		</select>
		<label >Region:</label>
		<select id="region_select" onchange="getCites()">
		</select>
		<label>City</label>
		<select id="city_select" name="city" onchange="getLatLng()">
		</select>
		<label >Latitude:</label>
		<input type="text" name="latitude" id="latitude"/>
		<label >Longitude:</label>
		<input type="text" name="longitude" id="longitude"/>
		<label >Phone number:</label>
		<input type="text" name="phoneNumber"/>
		
		
		<input type="submit" name="submit" value="Add museum"/>
		<input type="submit" name="cancel" value="Cancel" style=" background-color:red;"/>
	</form>
	<p><%=session.getAttribute("message").toString() %></p>
	
</div>

</body>
</html>