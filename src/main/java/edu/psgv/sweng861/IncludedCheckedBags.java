package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing IncludedCheckedBags objects from the AmadeusAPI JSON response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncludedCheckedBags {
	private int quantity;
	
	/**
	 * Setter for quantity
	 * @param int quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Getter for quantity
	 * @return int quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
}
