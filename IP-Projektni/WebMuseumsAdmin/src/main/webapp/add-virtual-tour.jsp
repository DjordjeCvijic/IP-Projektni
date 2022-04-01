<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <jsp:useBean id="virtualTourBean" class="beans.VirtualTourBean" scope="request"></jsp:useBean>
 <jsp:setProperty property="name" name="virtualTourBean" param="name"/>
 <jsp:setProperty property="duration" name="virtualTourBean" param="duration"/>
 <jsp:setProperty property="youtubeUrl" name="virtualTourBean" param="youtubeUrl"/>
 
<!DOCTYPE html>
<%
	if(request.getParameter("cancel")!=null){
		response.sendRedirect("museum.jsp");
	}
if(request.getParameter("submit")!=null){

	if(("".equals(request.getParameter("name")))
			||"".equals(request.getParameter("duration"))
			||"".equals(request.getParameter("youtubeUrl"))
			||"".equals(request.getParameter("date"))
			||"".equals(request.getParameter("time"))){
		session.setAttribute("message", "sva polja nisu unesena");
	}else{
		String dateTime=request.getParameter("date")+"T"+request.getParameter("time");
		virtualTourBean.setStartDateTime(dateTime);
		session.setAttribute("message", "");
		System.out.println(virtualTourBean.getName());
		System.out.println(virtualTourBean.getDuration());
		System.out.println(virtualTourBean.getYoutubeUrl());
		System.out.println(virtualTourBean.getStartDateTime());
		
		
	}
	
}else{
	session.setAttribute("message", "");
}


%>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="styles/add-page-style.css" rel="stylesheet">
</head>
<body>
<div class="main-div">
	<h2>Enter data of new virtual tour</h2>
	<form action='add-virtual-tour.jsp?museumId="+<%=request.getParameter("museumId") %>+"'" method="POST">
		<label >Virtual tour name:</label>
		<input type="text" name="name" />
		<label >Virtual tour duration:</label>
		<input type="number" name=duration />
		<label >YouTube link:</label>
		<input type="text" name="youtubeUrl" />
		<label >Date of start:</label>
		<input type="date" name="date" />
		<label >Time of start:</label>
		<input type="time" name="time" />
		
		<input type="submit" name="submit" value="Add museum"/>
		<input type="submit" name="cancel" value="Cancel" style=" background-color:red;"/>
	</form>
	<p><%=session.getAttribute("message").toString() %></p>
	</div>
</body>
</html>