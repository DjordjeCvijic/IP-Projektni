package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dto.MuseumDto;
import dto.MuseumTypeDto;
import dto.RoleDto;

public class MuseumTypeDao {
	
	public static MuseumTypeDto getMuseumTypeById(Integer museumTypeId) {
		MuseumTypeDto museumTypeDto=new MuseumTypeDto();
		Connection conn=DBConnection.getConnection();
		try {
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM museum_type WHERE museum_type_id=?");
			 pstmt.setInt(1, museumTypeId);
			 ResultSet rs=pstmt.executeQuery();
			  while ( rs.next() ) {
				  museumTypeDto.setMuseumTypeId(museumTypeId);
				  museumTypeDto.setName(rs.getString("name"));
		         }
		         rs.close();
		         pstmt.close();
		         
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return museumTypeDto;
		
	}
	
	public static List<MuseumTypeDto> getAllMuseumType() {
		List<MuseumTypeDto> museumTypeDtoList=new LinkedList<>();
		Connection conn=DBConnection.getConnection();
		try {
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM museum_type");
			
			 ResultSet rs=pstmt.executeQuery();
			  while ( rs.next() ) {
				  MuseumTypeDto museumTypeDto=new MuseumTypeDto();
				  museumTypeDto.setMuseumTypeId(rs.getInt("museum_type_id"));
				  museumTypeDto.setName(rs.getString("name"));
				  museumTypeDtoList.add(museumTypeDto);
		         }
		         rs.close();
		         pstmt.close();
		         
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return museumTypeDtoList;
		
	}


}
