<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="service.VirtualTourService" %>
   <%@page import="beans.VirtualTourBean" %>
    
<!DOCTYPE html>
<%


%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="styles/museum.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/museum.js"></script>
</head>
<body>

<div class="main-div">
	<div class="header-div">
		<p>Virtual tours :</p>
		<button class="btn" onClick="addVirtualTour(<%= request.getParameter("id") %>)">Add virtual toure</button>
	</div>
	<div class="list-div">
		<%for(VirtualTourBean tourBean:VirtualTourService.getAllVirtualToursInMuseum(request.getParameter("id"))) {%>
			<div class="element-div">
				<h4>Name: <%= tourBean.getName() %></h4>
				<h4>Duration: <%= tourBean.getDuration() %></h4>
				<h4>Start: <%= tourBean.getStartDateTime()%></h4>
				<button class="btn" onClick="deleteVirtualTour(<%= tourBean.getName() %>,<%= tourBean.getVirtualTourId() %>)">delete</button>
		</div>
	
		<%} %>
		
	</div>
	

</div>


</body>
</html>