package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VirtualTourTicketDao {
	
	public static void deleteVirtualTourTicketByVirtualTourId(Integer virtualTourId) {
		System.out.println("OBRISI: "+virtualTourId);
	Connection conn=DBConnection.getConnection();
		
		try {
			
			 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM virtual_tour_ticket WHERE virtual_tour_id=?");
			 pstmt.setInt(1, virtualTourId);
			
			 pstmt.executeUpdate();
			 pstmt.close();
    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
