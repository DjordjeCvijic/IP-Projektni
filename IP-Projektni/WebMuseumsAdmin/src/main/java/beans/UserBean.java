package beans;

import java.io.Serializable;

public class UserBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private boolean admin;
	private boolean logedIn;
	public boolean isLogedIn() {
		return logedIn;
	}

	public void setLogedIn(boolean logedIn) {
		this.logedIn = logedIn;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	

}
