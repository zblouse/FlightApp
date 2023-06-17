package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for Aircraft object deserialized from the Amadeus API response
 * The code can be used with the Aircraft dictionary to get a human understandable aircraft name.
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {
	
	private String code;
	
	/**
	 * Setter for code(code of the Aircraft for the Aircraft dictionary)
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Getter for the aircraft code.
	 * @return String code
	 */
	public String getCode() {
		return this.code;
	}
}
