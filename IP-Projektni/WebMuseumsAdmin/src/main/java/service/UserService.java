package service;

import java.io.Serializable;

import beans.UserBean;
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

}
