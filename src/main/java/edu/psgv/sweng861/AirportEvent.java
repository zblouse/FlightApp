package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO to deserialize airport events from the Amadeus response.
 * Contains information about a takeoff or landing.
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportEvent {
	private String iataCode;
	private String at;
	private String terminal;
	
	/**
	 * Setter for the IATA code
	 * @param String iataCode
	 */
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	
	/**
	 * Getter for the IATA code
	 * @return String iataCode
	 */
	public String getIataCode() {
		return this.iataCode;
	}
	
	/**
	 * Setter for at, the time of the event
	 * @param String at
	 */
	public void setAt(String at) {
		this.at = at;
	}
	
	/**
	 * Getter for at, the time of the event
	 * @return String at
	 */
	public String getAt() {
		return this.at;
	}
	
	/**
	 * Setter for terminal
	 * @param String terminal
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
	/**
	 * Getter for terminal
	 * @return String terminal
	 */
	public String getTerminal() {
		return this.terminal;
	}
}
