<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <jsp:useBean id="museumBean" class="beans.MuseumBean" scope="request"></jsp:useBean>
 
  <jsp:setProperty property="name" name="museumBean" param="name"/>
  <jsp:setProperty property="address" name="museumBean" param="address"/>
  <jsp:setProperty property="countryName" name="museumBean" param="country"/>
  
<!DOCTYPE html>
<%
	if(request.getParameter("submit")!=null){

		if("".equals(request.getParameter("name"))){
		session.setAttribute("message", "sva polja nisu unesena");
		}else{
			session.setAttribute("message", "");
			System.out.println(museumBean.getName());
			System.out.println(museumBean.getAddress());
			System.out.println(museumBean.getCountryName());
		}
		
	}else{
		session.setAttribute("message", "");
	}
	response.setHeader("Access-Control-Allow-Origin", "*"); 
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="styles/add-museum-style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/add-museum.js"></script>
</head>
<body onload="getCountres()">
<div class="main-div">
	<h2>Enter data of new museum</h2>
	<form action="add-museum.jsp" method="POST">
		<label >Museum name:</label>
		<input type="text" name="name" />
		<label >Address:</label>
		<input type="text" name="address" />
		<label >Country:</label>
		<select id="country_select" name="country" onchange="getRegions()">
		</select>
		<label >Region:</label>
		<select id="region_select" oncancel="getCites()">
		</select>
		
		
		<input type="submit" name="submit" value="Add museum"/>
	</form>
	<p><%=session.getAttribute("message").toString() %></p>
	
</div>

</body>
</html>