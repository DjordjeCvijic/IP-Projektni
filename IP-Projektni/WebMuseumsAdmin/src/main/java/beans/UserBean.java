package beans;

import java.io.Serializable;

public class UserBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private boolean admin;
	private boolean loggedIn;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	

}
