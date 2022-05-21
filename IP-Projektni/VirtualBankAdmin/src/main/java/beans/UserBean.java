package beans;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import dao.UserDao;
import dto.UserDto;

public class UserBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private boolean isLoggedIn = false;
	
	public boolean login(String username,String password)  {
		String passwordString="";
		 try {
			 MessageDigest md;
				
				md = MessageDigest.getInstance("SHA-256");
		     byte[] passwordDigest = md.digest(password.getBytes());
		     
	
		      passwordString = Base64.getEncoder().encodeToString(passwordDigest);
		    
		     
		 } catch (NoSuchAlgorithmException e) {
		   e.printStackTrace();
		 }
		 UserDto user=UserDao.getUserByUsername(username);

		 if(user!=null && user.getPassword().equals(passwordString)){
				isLoggedIn=true;
				return true;
			}
		return false;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
}
