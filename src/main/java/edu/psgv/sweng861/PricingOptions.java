package edu.psgv.sweng861;

import java.util.List;

public class PricingOptions {
	private List<String> fareType;
	private boolean includeCheckedBagsOnly;
	
	public void setFareType(List<String> fareType) {
		this.fareType = fareType;
	}
	
	public List<String> getFareType() {
		return this.fareType;
	}
	
	public void setIncludeCheckedBagsOnly(boolean includeCheckedBagsOnly) {
		this.includeCheckedBagsOnly = includeCheckedBagsOnly;
	}
	
	public boolean isIncludeCheckedBagsOnly() {
		return this.includeCheckedBagsOnly;
	}
}
