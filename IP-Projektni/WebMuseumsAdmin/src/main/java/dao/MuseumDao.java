package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dto.MuseumDto;

public class MuseumDao {
	
	
	public static List<MuseumDto> getMuseums(){
		List<MuseumDto> resulList=new LinkedList<>();
		Connection conn=DBConnection.getConnection();
		try {
			
			Statement st=conn.createStatement();
			
			ResultSet rs=st.executeQuery("SELECT * FROM museum");
			while(rs.next()) {
				
				MuseumDto museum=new MuseumDto();
				museum.setMuseumId(rs.getInt("museum_id"));
				museum.setCityName(rs.getString("city_name"));
				museum.setCountryName(rs.getString("country_name"));
				museum.setLatitude(rs.getString("latitude"));
				museum.setLongitude(rs.getString("longitude"));
				museum.setName(rs.getString("name"));
				museum.setPhoneNumber(rs.getString("phone_number"));
				museum.setAddress(rs.getString("address"));
				museum.setMuseumTypeId(rs.getInt("museum_type_id"));
				resulList.add(museum);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resulList;
	}
	
	public static  void addMuseum(MuseumDto museumToAdd) {
		
		Connection connection=DBConnection.getConnection();
		String query = " insert into museum ( name, museum_type_id, city_name, country_name, address, phone_number, latitude, longitude)"
		        + " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, museumToAdd.getName());
			preparedStatement.setInt(2, museumToAdd.getMuseumTypeId());
			preparedStatement.setString(3, museumToAdd.getCityName());
			preparedStatement.setString(4, museumToAdd.getCountryName());
			preparedStatement.setString(5, museumToAdd.getAddress());
			
			preparedStatement.setString(6, museumToAdd.getPhoneNumber());
			preparedStatement.setString(7, museumToAdd.getLatitude());
			preparedStatement.setString(8, museumToAdd.getLongitude());
			
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public static void deleteMuseumById(Integer museumId) {
		Connection conn=DBConnection.getConnection();
			
			try {
				
				 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM museum WHERE museum_id=?");
				 pstmt.setInt(1, museumId);
				 pstmt.executeUpdate();
				 pstmt.close();
	    
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

}
