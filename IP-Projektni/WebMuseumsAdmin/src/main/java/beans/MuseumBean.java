package beans;

import java.io.Serializable;

public class MuseumBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer museumId;
	private String name;
	private String address;
	private String phoneNumber;
	private String countryName;
	private String cityName;
	private String latitude;
	private String longitude;
	private String museumTypeName;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getMuseumTypeName() {
		return museumTypeName;
	}
	public void setMuseumTypeName(String museumTypeName) {
		this.museumTypeName = museumTypeName;
	}
	
	

}
