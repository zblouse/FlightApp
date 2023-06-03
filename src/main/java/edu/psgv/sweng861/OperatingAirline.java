package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatingAirline {
	private String carrierCode;
	
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	public String getCarrierCode() {
		return this.carrierCode;
	}
}
