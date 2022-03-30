<%@ page import="service.UserService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" class="beans.UserBean" scope="session"></jsp:useBean>
    
    
<!DOCTYPE html>
<%
	if(request.getParameter("token")!=null){
		userBean=UserService.getUserBeanByToken(request.getParameter("token"));
		if(userBean.isAdmin()){
			userBean.setLogedIn(true);
			response.sendRedirect("museums.jsp");
		}else{
			response.sendRedirect("unauthorized.jsp");
		}
		
		
	}else{
		response.sendRedirect("unauthorized.jsp");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>