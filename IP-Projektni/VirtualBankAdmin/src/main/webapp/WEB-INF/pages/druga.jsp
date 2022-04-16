<%@ page import="dto.BankAccountDto" %>
<%@ page import="beans.BankAccountBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="bankAccountBean" type="beans.BankAccountBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%for(BankAccountDto bankAccount:bankAccountBean.getAllBankAccounts()){ %>
		<p><%=bankAccount.getFirstName()%></p>
	
	<%} %>
</body>
</html>