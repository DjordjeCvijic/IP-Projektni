package dto;

import java.sql.Timestamp;

public class UserActionDto {

	private Integer userActionId;
	private String action;
	private Timestamp time;
	private Integer userPersonId;
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getUserPersonId() {
		return userPersonId;
	}
	public void setUserPersonId(Integer userPersonId) {
		this.userPersonId = userPersonId;
	}
	
}
