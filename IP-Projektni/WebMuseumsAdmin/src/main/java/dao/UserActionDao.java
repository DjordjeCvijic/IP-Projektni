package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dto.MuseumDto;
import dto.UserActionDto;

public class UserActionDao {

	public static List<UserActionDto>getAllUsersActions(){
		List<UserActionDto> resulList=new LinkedList<>();
		Connection conn=DBConnection.getConnection();
		try {
			
			Statement st=conn.createStatement();
			
			ResultSet rs=st.executeQuery("SELECT * FROM user_action");
			while(rs.next()) {
				UserActionDto userActionDto=new UserActionDto();
				userActionDto.setAction(rs.getString("action"));
				userActionDto.setTime(rs.getTimestamp("time"));
				userActionDto.setUserActionId(rs.getInt("user_action_id"));
				userActionDto.setUserPersonId(rs.getInt("user_person_id"));
				resulList.add(userActionDto);
				
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resulList;
	}
}
