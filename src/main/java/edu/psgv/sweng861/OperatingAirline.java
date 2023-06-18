package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing OperatingAirline objects from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatingAirline {
	private String carrierCode;
	
	/**
	 * Setter for carrierCode
	 * @param String carrierCode
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	/**
	 * Getter for carrierCode
	 * @return String carrierCode
	 */
	public String getCarrierCode() {
		return this.carrierCode;
	}
}
