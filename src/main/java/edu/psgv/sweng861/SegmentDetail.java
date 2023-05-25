package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SegmentDetail {
	private String segmentId;
	private TravelClass cabin;
	private String fareBasis;
	private TravelClass brandedFare;
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
	
	public void setBrandedFare(TravelClass brandedFare) {
		this.brandedFare = brandedFare;
	}
	
	public TravelClass getBrandedFare() {
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
