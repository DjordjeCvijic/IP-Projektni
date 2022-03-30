package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.RoleDto;

public class RoleDao {
	
	public static RoleDto getRoleById(Integer roleId) {
		RoleDto resultRole=new RoleDto();
		Connection conn=DBConnection.getConnection();
		try {
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM role WHERE role_id=?");
			 pstmt.setInt(1, roleId);
			 ResultSet rs=pstmt.executeQuery();
			  while ( rs.next() ) {
				  resultRole.setRoleId(roleId);
					resultRole.setName(rs.getString("name"));
		         }
		         rs.close();
		         pstmt.close();
		         
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultRole;
		
	}

}
