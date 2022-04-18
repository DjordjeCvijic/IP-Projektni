package service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import beans.UserActionBean;
import dao.UserActionDao;
import dao.UserDao;
import dto.UserActionDto;
import dto.UserDto;

public class UserActionService {
	
	public static List<UserActionBean> getUsersActions(){
		List<UserActionBean> result=new LinkedList<>();
		List<UserActionDto> userActionDtoList=UserActionDao.getAllUsersActions();
		userActionDtoList.forEach(element->{
			UserActionBean userAction=new UserActionBean();
			UserDto user=UserDao.getUserByUserId(element.getUserPersonId());
			userAction.setAction(element.getAction());
			userAction.setFirstName(user.getFirstName());
			userAction.setLastName(user.getLastName());
			userAction.setTime(new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(element.getTime()));
			userAction.setUserActionId(element.getUserActionId());
			userAction.setUsername(user.getUsername());
			result.add(userAction);
		});
		
		
		
		return result;
	}

}
