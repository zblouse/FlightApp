package edu.psgv.sweng861;

import java.util.List;

public class PricingOptions {
	private List<String> fareType;
	private boolean includedCheckedBagsOnly;
	
	public void setFareType(List<String> fareType) {
		this.fareType = fareType;
	}
	
	public List<String> getFareType() {
		return this.fareType;
	}
	
	public void setIncludedCheckedBagsOnly(boolean includedCheckedBagsOnly) {
		this.includedCheckedBagsOnly = includedCheckedBagsOnly;
	}
	
	public boolean isIncludedCheckedBagsOnly() {
		return this.includedCheckedBagsOnly;
	}
}
