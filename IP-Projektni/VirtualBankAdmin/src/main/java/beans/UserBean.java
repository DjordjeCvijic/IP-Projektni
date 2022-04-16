package beans;

import java.io.Serializable;

public class UserBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private boolean isLoggedIn = false;
	
	public boolean login(String username,String password) {
		if(username.equals("admin") && password.equals("admin123")){
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
