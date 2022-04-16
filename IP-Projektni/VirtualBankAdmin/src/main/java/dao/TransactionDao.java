package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dto.BankAccountDto;
import dto.DBConnection;
import dto.TransactionDto;

public class TransactionDao {

	
	public static List<TransactionDto> getAllTransactions(){
		
		List<TransactionDto> resulList=new LinkedList<TransactionDto>();
		Connection conn=DBConnection.getConnection();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM transactions");
			while(rs.next()) {
				TransactionDto transactionDto=new TransactionDto();
				transactionDto.setAmount(rs.getDouble("amount"));
				transactionDto.setBankAccountId(rs.getInt("bank_account_id"));
				transactionDto.setTime(rs.getTimestamp("time"));
				transactionDto.setTransactionId(rs.getInt("transaction_id"));
				resulList.add(transactionDto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resulList;
		
	}
}
