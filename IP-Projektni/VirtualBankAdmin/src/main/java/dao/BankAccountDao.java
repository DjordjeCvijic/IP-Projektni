package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dto.BankAccountDto;

public class BankAccountDao {
	
	public static List<BankAccountDto> getAllBankAccounts(){
		List<BankAccountDto> resulList=new LinkedList<BankAccountDto>();
		Connection conn=DBConnection.getConnection();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM bank_account");
			while(rs.next()) {
				BankAccountDto bankAccountDto=new BankAccountDto();
				bankAccountDto.setAccountBalance(rs.getDouble("account_balance"));
				bankAccountDto.setBankAccountId(rs.getInt("bank_account_id"));
				bankAccountDto.setCardNumber(rs.getString("card_number"));
				bankAccountDto.setCardType(CardTypeDao.getCardTypeById(rs.getInt("card_type_id")).getCardTypeName());
				bankAccountDto.setExpirationDate(rs.getString("expiration_date"));
				bankAccountDto.setFirstName(rs.getString("first_name"));
				bankAccountDto.setLastName(rs.getString("last_name"));
				bankAccountDto.setPinNumber(rs.getInt("pin_number"));
				bankAccountDto.setActive(rs.getBoolean("active"));
				resulList.add(bankAccountDto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resulList;
	}
	
	public static BankAccountDto getBankAccountById(Integer bankAccountId){
		BankAccountDto result=new BankAccountDto();
		Connection conn=DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM bank_account WHERE bank_account_id=?");
			 pstmt.setInt(1, bankAccountId);
			 ResultSet rs=pstmt.executeQuery();
			 
			while(rs.next()) {
				
				result.setAccountBalance(rs.getDouble("account_balance"));
				result.setBankAccountId(rs.getInt("bank_account_id"));
				result.setCardNumber(rs.getString("card_number"));
				result.setCardType(CardTypeDao.getCardTypeById(rs.getInt("card_type_id")).getCardTypeName());
				result.setExpirationDate(rs.getString("expiration_date"));
				result.setFirstName(rs.getString("first_name"));
				result.setLastName(rs.getString("last_name"));
				result.setPinNumber(rs.getInt("pin_number"));
				
				
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static void updateBankAccountStatus(Integer bankAccountId, boolean selectedValue) {
		Connection conn=DBConnection.getConnection();
		try {
			 PreparedStatement st = conn.prepareStatement("UPDATE bank_account SET active = ? WHERE bank_account_id = ?");
			 st.setBoolean(1, selectedValue);
			 st.setInt(2, bankAccountId);
			 st.executeUpdate();
			 st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
