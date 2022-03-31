package dao;

import java.sql.Connection;
import java.sql.ResultSet;
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

}
