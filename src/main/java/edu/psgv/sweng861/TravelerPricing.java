package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelerPricing {
	private String travelerId;
	private String fareOption;
	private String travelerType;
	private Price price;
	private List<SegmentDetail> fareDetailsBySegment; 
	
	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}
	
	public String getTravelerId() {
		return this.travelerId;
	}
	
	public void setFareOption(String fareOption) {
		this.fareOption = fareOption;
	}
	
	public String getFareOption() {
		return this.fareOption;
	}
	
	public void setTravelerType(String travelerType) {
		this.travelerType = travelerType;
	}
	
	public String getTravelerType() {
		return this.travelerType;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Price getPrice() {
		return this.price;
	}
	
	public void setFareDetailsBySegment(List<SegmentDetail> fareDetailsBySegment) {
		this.fareDetailsBySegment = fareDetailsBySegment;
	}
	
	public List<SegmentDetail> getFareDetailsBySegment(){
		return this.fareDetailsBySegment;
	}
	
}
