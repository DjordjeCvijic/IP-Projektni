package dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VirtualTourDto {

	private Integer virtualTourId;
	private Integer museumId;
	private String name;
	private Integer duration;
	private Timestamp startDateTime;
	private String youtubeUrl;
	public Integer getVirtualTourId() {
		return virtualTourId;
	}
	public void setVirtualTourId(Integer virtualTourId) {
		this.virtualTourId = virtualTourId;
	}
	public Integer getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Integer museumId) {
		this.museumId = museumId;
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
	public Timestamp getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getYoutubeUrl() {
		return youtubeUrl;
	}
	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}


	
	

}
