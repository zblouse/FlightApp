package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO for deserializing SegmentDetail objects from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SegmentDetail {
	private String segmentId;
	private TravelClass cabin;
	private String fareBasis;
	private String brandedFare;
	private String segmentClass;
	private String sliceDiceIndicator;
	private IncludedCheckedBags includedCheckedBags;
	
	/**
	 * Setter for segmentId
	 * @param String segmentId
	 */
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}
	
	/**
	 * Getter for segmentId
	 * @return String segmentId
	 */
	public String getSegmentId() {
		return this.segmentId;
	}
	
	/**
	 * Setter for cabin
	 * @param TravelClass cabin
	 */
	public void setCabin(TravelClass cabin) {
		this.cabin = cabin;
	}
	
	/**
	 * Getter for cabin
	 * @return TravelClass cabin
	 */
	public TravelClass getCabin() {
		return this.cabin;
	}
	
	/**
	 * Setter for fareBasis
	 * @param String fareBasis
	 */
	public void setFareBasis(String fareBasis) {
		this.fareBasis = fareBasis;
	}
	
	/**
	 * Getter for fareBasis
	 * @return String fareBasis
	 */
	public String getFareBasis() {
		return this.fareBasis;
	}
	
	/**
	 * Setter for brandedFare
	 * @param String brandedFare
	 */
	public void setBrandedFare(String brandedFare) {
		this.brandedFare = brandedFare;
	}
	
	/**
	 * Getter for brandedFare
	 * @return String brandedFare
	 */
	public String getBrandedFare() {
		return this.brandedFare;
	}
	
	/**
	 * Setter for segmentClass
	 * @param String segmentClass
	 */
	@JsonProperty("class")
	public void setSegmentClass(String segmentClass) {
		this.segmentClass = segmentClass;
	}
	
	/**
	 * Getter for segmentClass
	 * @return String segmentClass
	 */
	public String getSegmentClass() {
		return this.segmentClass;
	}
	
	/**
	 * Setter for sliceDiceIndicator
	 * @param String sliceDiceIndicator
	 */
	public void setSliceDiceIndicator(String sliceDiceIndicator) {
		this.sliceDiceIndicator = sliceDiceIndicator;
	}
	
	/**
	 * Getter for sliceDiceIndicator
	 * @return String sliceDiceIndicator
	 */
	public String getSliceDiceIndicator() {
		return this.sliceDiceIndicator;
	}
	
	/**
	 * Setter for includedCheckedBags
	 * @param IncludedCheckedBags includedCheckedBags
	 */
	public void setIncludedCheckedBags(IncludedCheckedBags includedCheckedBags) {
		this.includedCheckedBags = includedCheckedBags;
	}
	
	/**
	 * Getter for includedCheckedBags
	 * @return IncludedCheckedBags includedCheckedBags
	 */
	public IncludedCheckedBags getIncludedCheckedBags() {
		return this.includedCheckedBags;
	}
	
}
