package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing price objects from the Amadeus API JSON response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	private String currency;
	private String total;
	private String base;
	private List<Fee> fees;
	private String grandTotal;
	
	/**
	 * Setter for currency
	 * @param String currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Getter for currency
	 * @return String currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Setter for total
	 * @param String total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Getter for total
	 * @return String total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Setter for base
	 * @param String base
	 */
	public void setBase(String base) {
		this.base = base;
	}
	
	/**
	 * Getter for base
	 * @return String base
	 */
	public String getBase() {
		return this.base;
	}
	
	/**
	 * Setter for fees
	 * @param List<Fee> fees
	 */
	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}
	
	/**
	 * Getter for fees
	 * @return List<Fee> fees
	 */
	public List<Fee> getFees() {
		return this.fees;
	}
	
	/**
	 * Setter for grandTotal
	 * @param String grandTotal
	 */
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	/**
	 * Getter for grandTotal
	 * @return String grandTotal
	 */
	public String getGrandTotal() {
		return this.grandTotal;
	}
}
