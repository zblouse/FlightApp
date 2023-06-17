package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing City information from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
	private String cityCode;
	private String countryCode;
	
	/**
	 * Setter for cityCode
	 * @param String cityCode
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	/**
	 * Getter for cityCode
	 * @return String cityCode
	 */
	public String getCityCode() {
		return this.cityCode;
	}
	
	/**
	 * Setter for countryCode
	 * @param String countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * Getter for countryCode
	 * @return String countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
	}
}
