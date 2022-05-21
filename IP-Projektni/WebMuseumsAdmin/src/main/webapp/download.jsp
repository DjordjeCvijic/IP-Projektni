<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="service.UserActionService" %>
<%@ page import="beans.UserActionBean" %>

<%

		response.reset();
		response.setContentType("application/pdf");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Content-disposition", "attachment; filename=" + "users-actions.txt");
		out.clear();
		for(UserActionBean userAction:UserActionService.getUsersActions()){		
			out.write(userAction.toString());
		}
		out.flush();

		
%>