package service;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import beans.UserBean;
import beans.UserInfoBean;
import dao.UserDao;
import dto.UserDto;

public class UserService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static UserBean getUserBeanByToken(String token) {
		
		UserDto userDto=UserDao.getUserByToken(token);
		UserBean userBean=new UserBean();
		userBean.setAdmin(userDto.isAdmin());
		return userBean;
		
		
	}
	
	public static List<UserInfoBean> getUsers(){
		List<UserInfoBean> resultUserList=new LinkedList<>();
		List<UserDto>usersDtoList=UserDao.getAllUsers();
		usersDtoList.forEach(e->{
			UserInfoBean user=new UserInfoBean();
			user.setEmail(e.getEmail());
			user.setFirstName(e.getFirstName());
			user.setLastName(e.getLastName());
			user.setUserId(e.getUserId());
			user.setUsername(e.getUsername());
			user.setUserStatusId(e.getUserStatusId());
			
			resultUserList.add(user);
		});		
		
		
		return resultUserList.stream().sorted((a,b)->a.getUserId()-b.getUserId()).collect(Collectors.toList());
		
	}
	
	
	public static void saveUserStatus(String userId,String newStatusId) {
		UserDao.updateUserStatus(Integer.valueOf(userId), Integer.valueOf(newStatusId));
	}

}
