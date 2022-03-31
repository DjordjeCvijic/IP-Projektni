<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <jsp:useBean id="museumBean" class="beans.MuseumBean" scope="request"></jsp:useBean>
 
  <jsp:setProperty property="name" name="museumBean" param="name"/>
  
<!DOCTYPE html>
<%
	if(request.getParameter("submit")!=null){
		System.out.println("usao u prvi if");
		if("".equals(request.getParameter("username"))){
		session.setAttribute("message", "sva polja nisu unesena");
		}
		
	}else{
		session.setAttribute("message", "");
	}

%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="styles/add-museum-style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="main-div">
	<h2>Enter data of new museum</h2>
	<form action="add-museum.jsp" method="POST">
		<label >Name:</label>
		<input type="text" name="username" />
		<label >Address:</label>
		<input type="text" name="address" />
		<label >Latitude:</label>
		<input type="text" name="latitude" />
		<label >Longitude:</label>
		<input type="text" name="longitude" />
		
		<input type="submit" name="submit" value="Add museum"/>
	</form>
	<p><%=session.getAttribute("message").toString() %></p>
	
</div>

</body>
</html>