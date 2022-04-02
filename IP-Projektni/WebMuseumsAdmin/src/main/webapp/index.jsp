<%@ page import="service.UserService" %>
<%@ page import="beans.UserBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="userBean" class="beans.UserBean" scope="session"></jsp:useBean>
    
    
<!DOCTYPE html>
<%
	if(request.getParameter("token")!=null){
		UserBean user=UserService.getUserBeanByToken(request.getParameter("token"));
		if(user.isAdmin()){
			userBean.setAdmin(true);
			userBean.setLoggedIn(true);
			
			response.sendRedirect("admin-home.jsp");
			
		}else{
			userBean.setLoggedIn(false);
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