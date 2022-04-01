package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dto.RoleDto;
import dto.UserDto;
import dto.VirtualTourDto;

public class VirtualTourDao {
	
	public static List<VirtualTourDto>  getVirtualToursOfMuseum(Integer museumId){
		
		List<VirtualTourDto> resultList=new LinkedList<>();
		Connection conn=DBConnection.getConnection();
		
		try {
			
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM virtual_tour WHERE museum_id=?");
			 pstmt.setInt(1, museumId);
			 ResultSet rs=pstmt.executeQuery();
			  while ( rs.next() ) {
				  VirtualTourDto tour=new VirtualTourDto();
				  tour.setDuration(rs.getInt("duration"));
				  tour.setMuseumId(museumId);
				  tour.setName(rs.getString("name"));
				  tour.setStartDateTime(rs.getTimestamp("start_date_time"));
				  tour.setVirtualTourId(rs.getInt("virtual_tour_id"));
				  tour.setYoutubeUrl(rs.getString("youtube_url"));
				  resultList.add(tour);
		         }
		         rs.close();
		         pstmt.close();
		         
		         
		        
		         
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resultList;
	}

}
