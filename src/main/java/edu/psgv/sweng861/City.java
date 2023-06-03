package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
	private String cityCode;
	private String countryCode;
	
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getCityCode() {
		return this.cityCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getCountryCode() {
		return this.countryCode;
	}
}
