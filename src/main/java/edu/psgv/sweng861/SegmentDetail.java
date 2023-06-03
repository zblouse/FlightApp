package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SegmentDetail {
	private String segmentId;
	private TravelClass cabin;
	private String fareBasis;
	private String brandedFare;
	private String segmentClass;
	private String sliceDiceIndicator;
	private IncludedCheckedBags includedCheckedBags;
	
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}
	
	public String getSegmentId() {
		return this.segmentId;
	}
	
	public void setCabin(TravelClass cabin) {
		this.cabin = cabin;
	}
	
	public TravelClass getCabin() {
		return this.cabin;
	}
	
	public void setFareBasis(String fareBasis) {
		this.fareBasis = fareBasis;
	}
	
	public String getFareBasis() {
		return this.fareBasis;
	}
	
	public void setBrandedFare(String brandedFare) {
		this.brandedFare = brandedFare;
	}
	
	public String getBrandedFare() {
		return this.brandedFare;
	}
	
	@JsonProperty("class")
	public void setSegmentClass(String segmentClass) {
		this.segmentClass = segmentClass;
	}
	
	public String getSegmentClass() {
		return this.segmentClass;
	}
	
	public void setSliceDiceIndicator(String sliceDiceIndicator) {
		this.sliceDiceIndicator = sliceDiceIndicator;
	}
	
	public String getSliceDiceIndicator() {
		return this.sliceDiceIndicator;
	}
	
	public void setIncludedCheckedBags(IncludedCheckedBags includedCheckedBags) {
		this.includedCheckedBags = includedCheckedBags;
	}
	
	public IncludedCheckedBags getIncludedCheckedBags() {
		return this.includedCheckedBags;
	}
	
}
