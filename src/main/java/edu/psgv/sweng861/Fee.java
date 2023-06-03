package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fee {
	private String amount;
	private String type;
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return this.amount;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
