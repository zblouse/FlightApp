package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing Fee data from the AmadeusAPI response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fee {
	private String amount;
	private String type;
	
	/**
	 * Setter for amount
	 * @param String amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Getter for amount
	 * @return String amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Setter for type
	 * @param String type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Getter for type
	 * @return String type
	 */
	public String getType() {
		return this.type;
	}
}
