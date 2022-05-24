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

	public static void saveVirtualTour(VirtualTourDto virtualTourDto) {
		Connection connection=DBConnection.getConnection();
		String query = " insert into virtual_tour ( name, museum_id, youtube_url, start_date_time, duration)"
		        + " values ( ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, virtualTourDto.getName());
			preparedStatement.setInt(2, virtualTourDto.getMuseumId());
			preparedStatement.setString(3, virtualTourDto.getYoutubeUrl());
			preparedStatement.setTimestamp(4, virtualTourDto.getStartDateTime());
			preparedStatement.setInt(5, virtualTourDto.getDuration());

			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void deleteVirtualTourById(Integer virtualTourId) {
		Connection conn=DBConnection.getConnection();
			
			try {
				
				 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM virtual_tour WHERE virtual_tour_id=?");
				 pstmt.setInt(1, virtualTourId);
				 pstmt.executeQuery();
				 pstmt.close();
	    
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
}