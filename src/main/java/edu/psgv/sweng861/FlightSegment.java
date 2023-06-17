package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing FlightSegment data from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightSegment {
	private AirportEvent departure;
	private AirportEvent arrival;
	private String carrierCode;
	private String number;
	private Aircraft aircraft;
	private String duration;
	private String id;
	private int numberOfStops;
	private boolean blacklistedInEU;
	private OperatingAirline operating;
	
	/**
	 * Setter for the departure AirportEvent
	 * @param AirportEvent departure
	 */
	public void setDeparture(AirportEvent departure) {
		this.departure = departure;
	}
	
	/**
	 * Getter for the departure AirportEvent
	 * @return AirportEvent departure
	 */
	public AirportEvent getDeparture() {
		return departure;
	}
	
	/**
	 * Setter for the arrival AirportEvent
	 * @param AirportEvent arrival
	 */
	public void setArrival(AirportEvent arrival) {
		this.arrival = arrival;
	}
	
	/**
	 * Getter for the arrival AirportEvent
	 * @return
	 */
	public AirportEvent getArrival() {
		return arrival;
	}
	
	/**
	 * Setter for carrierCode
	 * @param String carrierCode
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	/**
	 * Getter for carrierCode
	 * @return String carrierCode
	 */
	public String getCarrierCode() {
		return carrierCode;
	}
	
	/**
	 * Setter for flight number
	 * @param String number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Getter for flightNumber
	 * @return String number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Setter for aircraft
	 * @param Aircraft aircraft
	 */
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	
	/**
	 * Getter for aircraft
	 * @return Aircraft aircraft
	 */
	public Aircraft getAircraft() {
		return aircraft;
	}
	
	/**
	 * Setter for duration
	 * @param String duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Getter for duration
	 * @return String duration
	 */
	public String getDuration() {
		return duration;
	}
	
	/**
	 * Setter for id
	 * @param String id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Getter for id
	 * @return String id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Setter for numberOfStops
	 * @param int numberOfStops
	 */
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	
	/**
	 * Getter for numberOfStops
	 * @return int numberOfStops
	 */
	public int getNumberOfStops() {
		return this.numberOfStops;
	}
	
	/**
	 * Setter for blacklistedInEU
	 * @param boolean blacklistedInEU
	 */
	public void setBlacklistedInEU(boolean blacklistedInEU) {
		this.blacklistedInEU = blacklistedInEU;
	}
	
	/**
	 * Getter for blacklistedInEu
	 * @return boolean blacklistedInEu
	 */
	public boolean isBlacklistedInEU() {
		return this.blacklistedInEU;
	}
	
	/**
	 * Setter for operating airline
	 * @param OperatingAirline operating
	 */
	public void setOperating(OperatingAirline operating) {
		this.operating = operating;
	}
	
	/**
	 * Getter for operating airline
	 * @return OperatingAirline operating
	 */
	public OperatingAirline getOperatingAirline() {
		return this.operating;
	}
	
	/**
	 * Formats the FlightSegment for the UI
	 * @param Dictionaries dictionaries
	 * @return String formated string representation of the object
	 */
	public String toString(Dictionaries dictionaries) {
		String flightSegmentString = "\n\t\tCarrier: " + dictionaries.getCarriers().get(carrierCode);
		flightSegmentString += "\n\t\tAircraft: " + dictionaries.getAircraft().get(aircraft.getCode());
		flightSegmentString += "\n\t\tDeparture Airport: " + departure.getIataCode() +  " Time: " + departure.getAt();
		flightSegmentString += "\n\t\tArrival Airport: " + arrival.getIataCode() + " Time: " + arrival.getAt();
			
		return flightSegmentString;
	}
}
