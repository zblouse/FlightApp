package edu.psgv.sweng861;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionaries {
	private Map<String, City> locations;
	private Map<String, String> aircraft;
	private Map<String, String> currencies;
	private Map<String, String> carriers;
	
	public void setLocations(Map<String, City> locations) {
		this.locations = locations;
	}
	
	public Map<String, City> getLocations() {
		return this.locations;
	}
	
	public void setAircraft(Map<String, String> aircraft) {
		this.aircraft = aircraft;
	}
	
	public Map<String, String> getAircraft() {
		return this.aircraft;
	}
	
	public void setCurrencies(Map<String, String> currencies) {
		this.currencies = currencies;
	}
	
	public Map<String, String> getCurrencies() {
		return this.currencies;
	}
	
	public void setCarriers(Map<String, String> carriers) {
		this.carriers = carriers;
	}
	
	public Map<String, String> getCarriers() {
		return this.carriers;
	}
}
