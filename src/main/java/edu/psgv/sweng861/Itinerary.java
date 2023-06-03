package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Itinerary {
	private String duration;
	private List<FlightSegment> segments;
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public void setSegments(List<FlightSegment> segments) {
		this.segments = segments;
	}
	
	public List<FlightSegment> getFlightSegments() {
		return this.segments;
	}
	
	@Override
	public String toString() {
		String itineraryString = "\t\tTotal Duration: " + duration;
		
		for(FlightSegment flightSegment: segments) {
			itineraryString += "\n" + flightSegment.toString();
		}
		return itineraryString;
	}
}
