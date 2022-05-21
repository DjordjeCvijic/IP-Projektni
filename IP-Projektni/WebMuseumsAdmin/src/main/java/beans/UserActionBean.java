package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserActionBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userActionId;
	private String action;
	private String time;
	private String  firstName;
	private String lastName;
	private String username;
	public Integer getUserActionId() {
		return userActionId;
	}
	public void setUserActionId(Integer userActionId) {
		this.userActionId = userActionId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		return time+" "+firstName+" "+lastName+" "+username+" "+action+"\n";
	}
	
}
