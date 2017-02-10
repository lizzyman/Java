package com.ktds.lizzy.hr.vo;

import com.ktds.lizzy.hr.dao.support.annotation.Types;

public class LocationsVO {
	
	@Types
	private int LocationId;
	@Types
	private String streetAddress;
	@Types
	private String postalCode;
	@Types
	private String city;
	@Types
	private String stateProvince;
	@Types
	private String countryId;
	
	public int getLocationId() {
		return LocationId;
	}
	
	public void setLocationId(int locationId) {
		LocationId = locationId;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStateProvince() {
		return stateProvince;
	}
	
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	
	public String getCountryId() {
		return countryId;
	}
	
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
}
