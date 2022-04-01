package beans;

import java.io.Serializable;

public class VirtualTourBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer virtualTourId;
	private String name;
	private Integer duration;
	private String startDateTime;
	private String youtubeUrl;
	public Integer getVirtualTourId() {
		return virtualTourId;
	}
	public void setVirtualTourId(Integer virtualTourId) {
		this.virtualTourId = virtualTourId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getYoutubeUrl() {
		return youtubeUrl;
	}
	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}
	
	

}
