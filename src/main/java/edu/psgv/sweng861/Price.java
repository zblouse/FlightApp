package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	private String currency;
	private String total;
	private String base;
	private List<Fee> fees;
	private String grandTotal;
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getTotal() {
		return this.total;
	}
	
	public void setBase(String base) {
		this.base = base;
	}
	
	public String getBase() {
		return this.base;
	}
	
	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}
	
	public List<Fee> getFees() {
		return this.fees;
	}
	
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public String getGrandTotal() {
		return this.grandTotal;
	}
}
