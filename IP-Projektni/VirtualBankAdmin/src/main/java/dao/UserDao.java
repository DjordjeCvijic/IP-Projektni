package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.UserDto;

public class UserDao {

	public static UserDto getUserByUsername(String username) {
		System.out.println(username);
		UserDto user=null;
		
		Connection conn=DBConnection.getConnection();
		try {
			System.out.println("1");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user_person WHERE username=?");
			System.out.println("2");
			 pstmt.setString(1, username);
			 ResultSet rs=pstmt.executeQuery();
			 
			while(rs.next()) {
				user=new UserDto();
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getInt("user_id"));
				
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return user;
	}
}
