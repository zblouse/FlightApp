package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing Itinerary objects from the Amadeus API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Itinerary {
	private String duration;
	private List<FlightSegment> segments;
	
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
		return this.duration;
	}
	
	/**
	 * Setter for segments
	 * @param List<FlightSegment> segments
	 */
	public void setSegments(List<FlightSegment> segments) {
		this.segments = segments;
	}
	
	/**
	 * Getter for segments
	 * @return List<FlightSegment>
	 */
	public List<FlightSegment> getFlightSegments() {
		return this.segments;
	}
	
	/**
	 * Formats the Itinerary object for display in the UI
	 * @param dictionaries
	 * @return
	 */
	public String toString(Dictionaries dictionaries) {
		String itineraryString = "\t\tTotal Duration: " + duration;
		
		for(FlightSegment flightSegment: segments) {
			itineraryString += "\n" + flightSegment.toString(dictionaries);
		}
		return itineraryString;
	}
}
