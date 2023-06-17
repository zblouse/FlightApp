package edu.psgv.sweng861;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing the Dictionaries from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionaries {
	private Map<String, City> locations;
	private Map<String, String> aircraft;
	private Map<String, String> currencies;
	private Map<String, String> carriers;
	
	/**
	 * Setter for locations
	 * @param Map<String, City> locations
	 */
	public void setLocations(Map<String, City> locations) {
		this.locations = locations;
	}
	
	/**
	 * Getter for locations
	 * @return Map<String, City>
	 */
	public Map<String, City> getLocations() {
		return this.locations;
	}
	
	/**
	 * Setter for aircraft
	 * @param Map<String, String> aircraft
	 */
	public void setAircraft(Map<String, String> aircraft) {
		this.aircraft = aircraft;
	}
	
	/**
	 * Getter for aircraft
	 * @return Map<String, String>
	 */
	public Map<String, String> getAircraft() {
		return this.aircraft;
	}
	
	/**
	 * Setter for currencies
	 * @param Map<String, String> currencies
	 */
	public void setCurrencies(Map<String, String> currencies) {
		this.currencies = currencies;
	}
	
	/**
	 * Getter for currencies
	 * @return Map<String, String>
	 */
	public Map<String, String> getCurrencies() {
		return this.currencies;
	}
	
	/**
	 * Setter for carriers
	 * @param Map<String, String> carriers
	 */
	public void setCarriers(Map<String, String> carriers) {
		this.carriers = carriers;
	}
	
	/**
	 * Getter for carriers
	 * @return Map<String, String>
	 */
	public Map<String, String> getCarriers() {
		return this.carriers;
	}
}
