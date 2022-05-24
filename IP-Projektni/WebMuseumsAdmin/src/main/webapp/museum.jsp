<%@page import="service.VirtualTourService" %>
<%@page import="service.MuseumService" %>
<%@page import="beans.VirtualTourBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:useBean id="userBean" class="beans.UserBean" scope="session"></jsp:useBean>
 
<!DOCTYPE html>
<%
	if(!(userBean.isLoggedIn())) response.sendRedirect("unauthorized.jsp");
	if(request.getParameter("deleteVirtualTourId")!=null){
		VirtualTourService.deleteVirtualTourById(Integer.valueOf(request.getParameter("deleteVirtualTourId")));
	}
	if(request.getParameter("deleteMuseum")!=null){
		
		MuseumService.deleteMuseumById(Integer.valueOf(request.getParameter("id")));
		response.sendRedirect("admin-home.jsp");
	}

%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Virtual tours</title>
<link href="styles/museum.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/museum.js"></script>
</head>
<body>
<button class="btn" onClick="returnToAdminHome()">Back</button>
<br/>
<button class="btn" onClick="deleteMuseum(<%= request.getParameter("id") %>)">Delete museum</button>
<div class="main-div">
	
	<div class="header-div">
		<p>Virtual tours :</p>
		<button class="btn" onClick="addVirtualTour(<%= request.getParameter("id") %>)">Add virtual tour</button>
	</div>
	<div class="list-div">
		<%for(VirtualTourBean tourBean:VirtualTourService.getAllVirtualToursInMuseum(request.getParameter("id"))) {%>
			<div class="element-div">
				<h4>Name: <%= tourBean.getName() %></h4>
				<h4>Duration: <%= tourBean.getDuration() %></h4>
				<h4>Start: <%= tourBean.getStartDateTime()%></h4>
				<button class="btn" onClick="deleteVirtualTour(<%=request.getParameter("id") %>,<%= tourBean.getVirtualTourId() %>)">Delete</button>
		</div>
	
		<%} %>
		
	</div>
	

</div>


</body>
</html>