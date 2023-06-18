package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing PricingOptions from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PricingOptions {
	private List<String> fareType;
	private boolean includedCheckedBagsOnly;
	
	/**
	 * Setter for fare type
	 * @param List<String> fareType
	 */
	public void setFareType(List<String> fareType) {
		this.fareType = fareType;
	}
	
	/**
	 * Getter for fareType
	 * @return List<String>
	 */
	public List<String> getFareType() {
		return this.fareType;
	}
	
	/**
	 * Setter for includedCheckedBagsOnly
	 * @param boolean includedCheckedBagsOnly
	 */
	public void setIncludedCheckedBagsOnly(boolean includedCheckedBagsOnly) {
		this.includedCheckedBagsOnly = includedCheckedBagsOnly;
	}
	
	/**
	 * Getter for includedCheckedBagsOnly
	 * @return boolean includedCheckedBagsOnly
	 */
	public boolean isIncludedCheckedBagsOnly() {
		return this.includedCheckedBagsOnly;
	}
}
