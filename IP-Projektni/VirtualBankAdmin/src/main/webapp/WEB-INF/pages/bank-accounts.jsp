<%@ page import="dto.BankAccountDto" %>
<%@ page import="beans.BankAccountBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bankAccountBean" type="beans.BankAccountBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank accounts</title>
<link href="styles/bank-accounts.css" type="text/css" rel="stylesheet">
<script src="js/bank-accounts.js" type="text/javascript"></script>
</head>
<body>
	<div class="link-div">
	<a href="?action=transactions">Transactions</a><br>
	<a href="?action=logout">Log out</a>
	</div>

	<div class="main-div">
		<div >	
			<p>Bank accounts :</p>				
		</div>
		
		<table>
			<tr>
				<th>Bank Account ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Card number</th>
				<th>Card type</th>
				<th>Pin</th>
				<th>Expiration date</th>
				<th>Account balance</th>
				<th>Status</th>
				
			</tr>
			<% for(BankAccountDto bankAccount:bankAccountBean.getAllBankAccounts()){ %>
			<tr>
				<td><%= bankAccount.getBankAccountId()%></td>
				<td><%= bankAccount.getFirstName()%></td>
				<td><%= bankAccount.getLastName()%></td>
				<td><%= bankAccount.getCardNumber()%></td>
				<td><%= bankAccount.getCardType()%></td>
				<td><%= bankAccount.getPinNumber()%></td>
				<td><%= bankAccount.getExpirationDate()%></td>
				<td><%= bankAccount.getAccountBalance()%></td>
				
				<td>
					<select  id="select<%= bankAccount.getBankAccountId()%>" onchange="selectChance('button<%= bankAccount.getBankAccountId()%>')">
						<option value="1" <%if(bankAccount.isActive()){ %>selected<%} %> >Active</option>
						<option value="0" <%if(!bankAccount.isActive()){ %>selected<%} %>>Inactive</option>
					</select>
					<button disabled="disabled" id="button<%= bankAccount.getBankAccountId()%>" onclick="saveBankAccountStatus('select<%= bankAccount.getBankAccountId()%>',<%= bankAccount.getBankAccountId()%>)" >SAVE</button>
				</td>	
				
			</tr>
			<%} %>
		</table>
	</div>	

</body>
</html>