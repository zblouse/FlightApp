package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing TravelerPricing objects from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelerPricing {
	private String travelerId;
	private String fareOption;
	private String travelerType;
	private Price price;
	private List<SegmentDetail> fareDetailsBySegment; 
	
	/**
	 * Setter for travelerId
	 * @param String travelerId
	 */
	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}
	
	/**
	 * Getter for travelerId
	 * @return String travelerId
	 */
	public String getTravelerId() {
		return this.travelerId;
	}
	
	/**
	 * Setter for fareOption
	 * @param String fareOption
	 */
	public void setFareOption(String fareOption) {
		this.fareOption = fareOption;
	}
	
	/**
	 * Getter for fareOption
	 * @return String fareOption
	 */
	public String getFareOption() {
		return this.fareOption;
	}
	
	/**
	 * Setter for traverlerType
	 * @param String travelerType
	 */
	public void setTravelerType(String travelerType) {
		this.travelerType = travelerType;
	}
	
	/**
	 * Getter for travelerType
	 * @return String travelerType
	 */
	public String getTravelerType() {
		return this.travelerType;
	}
	
	/**
	 * Setter for price
	 * @param Price price
	 */
	public void setPrice(Price price) {
		this.price = price;
	}
	
	/**
	 * Getter for price
	 * @return Price price
	 */
	public Price getPrice() {
		return this.price;
	}
	
	/**
	 * Setter for fareDetailsBySegment
	 * @param List<SegmentDetail> fareDetailsBySegment
	 */
	public void setFareDetailsBySegment(List<SegmentDetail> fareDetailsBySegment) {
		this.fareDetailsBySegment = fareDetailsBySegment;
	}
	
	/**
	 * Getter for fareDetailsBySegment
	 * @return List<SegmentDetail> fareDetailsBySegment
	 */
	public List<SegmentDetail> getFareDetailsBySegment(){
		return this.fareDetailsBySegment;
	}
	
}
