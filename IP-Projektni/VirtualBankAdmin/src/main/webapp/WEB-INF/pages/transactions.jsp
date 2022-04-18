<%@ page import="dto.TransactionToDisplay" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <jsp:useBean id="transactionBean" type="beans.TransactionBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
<link href="styles/transactions.css" type="text/css" rel="stylesheet">
<script src="js/transactions.js" type="text/javascript"></script>
</head>
<body>
  	<div class="link-div">
	<a href="?action=bank-accounts">Bank accounts</a><br>
	<a href="?action=logout">Log out</a>
	</div>
 
	<div class="main-div">
		<div >	
			<p>Transactions :</p>				
		</div>
		
		<table>
			<tr>
				<th>Transaction ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Card number</th>
				<th>Time</th>
				<th>Amount</th>
				
			</tr>
			<% for(TransactionToDisplay transaction:transactionBean.getTransactions()){ %>
			<tr>
				<td><%= transaction.getTransactionId()%></td>
				<td><%= transaction.getFirstName()%></td>
				<td><%= transaction.getLastName()%></td>
				<td><%= transaction.getCardNumber()%></td>
				<td><%= transaction.getTime()%></td>
				<td><%= transaction.getAmount()%></td>
			
			</tr>
			<%} %>
		</table>
	</div>
</body>
</html>