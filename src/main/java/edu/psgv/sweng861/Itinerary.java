package edu.psgv.sweng861;

import java.util.List;

public class Itinerary {
	private String duration;
	private List<FlightSegment> segments;
	private Price price;
	private PricingOptions pricingOptions;
	private List<String> validatingAirlineCodes;
	private List<TravelerPricing> travelerPricings;
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public void setSegments(List<FlightSegment> segments) {
		this.segments = segments;
	}
	
	public List<FlightSegment> getFlightSegments() {
		return this.segments;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Price getPrice() {
		return this.price;
	}
	
	public void setPricingOptions(PricingOptions pricingOptions) {
		this.pricingOptions = pricingOptions;
	}
	
	public PricingOptions getPricingOptions() {
		return this.pricingOptions;
	}
	
	public void setValidatingAirlineCodes(List<String> validatingAirlineCodes) {
		this.validatingAirlineCodes = validatingAirlineCodes;
	}
	
	public List<String> getValidatingAirlineCodes() {
		return this.validatingAirlineCodes;
	}
	
	public void setTravelerPricings(List<TravelerPricing> travelerPricings) {
		this.travelerPricings = travelerPricings;
	}
	
	public List<TravelerPricing> getTravelerPricings(){
		return this.travelerPricings;
	}
}
