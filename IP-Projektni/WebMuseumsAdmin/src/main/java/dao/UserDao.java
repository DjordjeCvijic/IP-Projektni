package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dto.RoleDto;
import dto.UserDto;
public class UserDao {
	

    
	public static UserDto getUserByToken(String token) {
		
		UserDto user=new UserDto();
		Connection conn=DBConnection.getConnection();
		
		try {
			//dohvatanje korisnika
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user_person WHERE token=?");
			 pstmt.setString(1, token);
			 ResultSet rs=pstmt.executeQuery();
			//ResultSet rs = stmt.executeQuery( "SELECT * FROM user_person " );
			  while ( rs.next() ) {
	           
				  System.out.println(rs.getString("username"));
				  user.setUserId(rs.getInt("user_person_id"));
				  user.setUserStatusId(rs.getInt("user_status_id"));
				  user.setEmail(rs.getString("email"));
				  user.setFirstName(rs.getString("first_name"));
				  user.setLastName(rs.getString("last_name"));
				  user.setPassword(rs.getString("password"));
				  user.setUsername(rs.getString("username"));
				  user.setFirstName(rs.getString("first_name"));
				  user.setToken(rs.getString("token"));
		         }
		         rs.close();
		         pstmt.close();
		         //dohvatanje iz vezne tabele
		         pstmt=conn.prepareStatement("SELECT * FROM user_person_role WHERE user_id=?");
		         pstmt.setInt(1, user.getUserId());
		         rs=pstmt.executeQuery();
		         int roleId=0;
		         while ( rs.next() ) {
		        	 roleId=rs.getInt("role_id");
		         }
		         
		         RoleDto role=RoleDao.getRoleById(roleId);
		         if(role.name.equals("ROLE_ADMIN")) {
		        	 user.setAdmin(true);
		         }else {
		        	 user.setAdmin(false);
		         }

		         rs.close();
		         pstmt.close();
		         
		        
		         
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public static List<UserDto> getAllUsers(){
		List<UserDto> resultList=new LinkedList<>();
		Connection conn=DBConnection.getConnection();
		try {
			
			 Statement statement = conn.createStatement();
			 
			 ResultSet rs=statement.executeQuery("SELECT * FROM user_person");
			  while ( rs.next() ) {
	           UserDto user=new UserDto();
	           
				  user.setUserId(rs.getInt("user_person_id"));
				  user.setUserStatusId(rs.getInt("user_status_id"));
				  user.setEmail(rs.getString("email"));
				  user.setFirstName(rs.getString("first_name"));
				  user.setLastName(rs.getString("last_name"));
				  user.setPassword(rs.getString("password"));
				  user.setUsername(rs.getString("username"));
				  user.setToken(rs.getString("token"));
				  resultList.add(user);
		         }
		         rs.close();
		         statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return resultList;
	}

}
