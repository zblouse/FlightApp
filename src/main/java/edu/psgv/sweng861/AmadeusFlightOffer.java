package edu.psgv.sweng861;

import java.util.List;

public class AmadeusFlightOffer {
	private String type;
	private String id;
	private String source;
	private boolean instantTicketingRequired;
	private boolean nonhomogenous;
	private boolean oneWay;
	private String lastTicketingDate;
	private String lastTicketingDateTime;
	private int numberOfBookableSeats;
	private List<Itinerary> itineraries;
	private Dictionaries dictionaries;
	
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setInstantTicketingRequired(boolean instantTicketingRequired) {
		this.instantTicketingRequired = instantTicketingRequired;
	}
	
	public boolean isInstantTicketingRequired() {
		return this.instantTicketingRequired;
	}
	
	public void setNonhomogenous(boolean nonhomogenous) {
		this.nonhomogenous = nonhomogenous;
	}
	
	public boolean isNonhomogenous() {
		return this.nonhomogenous;
	}
	
	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}
	
	public boolean isOneWay() {
		return this.oneWay;
	}
	
	public void setLastTicketingDate(String lastTicketingDate) {
		this.lastTicketingDate = lastTicketingDate;
	}
	
	public String getLastTicketingDate() {
		return this.lastTicketingDate;
	}
	
	public void setLastTicketingDateTime(String lastTicketingDateTime) {
		this.lastTicketingDateTime = lastTicketingDateTime;
	}
	
	public String getLastTicketingDateTime() {
		return this.lastTicketingDateTime;
	}
	
	public void setNumberOfBookableSeats(int numberOfBookableSeats) {
		this.numberOfBookableSeats = numberOfBookableSeats;
	}
	
	public int getNumberOfBookableSeats() {
		return this.numberOfBookableSeats;
	}
	
	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}
	
	public List<Itinerary> getItineraries() {
		return this.itineraries;
	}
	
	public void setDictionaries(Dictionaries dictionaries) {
		this.dictionaries = dictionaries;
	}
	
	public Dictionaries getDictionaires() {
		return this.dictionaries;
	}
}
