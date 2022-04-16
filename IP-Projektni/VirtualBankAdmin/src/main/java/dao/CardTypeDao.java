package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.CardTypeDto;
import dto.DBConnection;

public class CardTypeDao {

	
	public static CardTypeDto getCardTypeById(Integer cardTypeId) {
		
		CardTypeDto result=new CardTypeDto();
		
		Connection conn=DBConnection.getConnection();
		try {
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM card_type WHERE card_type_id=?");
			 pstmt.setInt(1, cardTypeId);
			 ResultSet rs=pstmt.executeQuery();
			  while ( rs.next() ) {
				  result.setCardTypeId(cardTypeId);
					result.setCardTypeName(rs.getString("card_type_name"));
		         }
		         rs.close();
		         pstmt.close();
		         
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
}
