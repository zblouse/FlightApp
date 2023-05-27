package edu.psgv.sweng861;

import java.util.List;

public class AmadeusFlightOffer {
	private String type;
	private String id;
	private String source;
	private boolean instantTicketingRequired;
	private boolean nonHomogeneous;
	private boolean oneWay;
	private String lastTicketingDate;
	private String lastTicketingDateTime;
	private int numberOfBookableSeats;
	private List<Itinerary> itineraries;
	private Dictionaries dictionaries;
	private Price price;
	private PricingOptions pricingOptions;
	private List<String> validatingAirlineCodes;
	private List<TravelerPricing> travelerPricings;
	
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
	
	public void setNonHomogeneous(boolean nonHomogeneous) {
		this.nonHomogeneous = nonHomogeneous;
	}
	
	public boolean isNonHomogeneous() {
		return this.nonHomogeneous;
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
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Price getPrice() {
		return this.price;
	}
	
	public void setPricingOptions(PricingOptions pricingOptions) {
		this.pricingOptions = pricingOptions;
	}
	
	public PricingOptions getPricingOptions() {
		return this.pricingOptions;
	}
	
	public void setValidatingAirlineCodes(List<String> validatingAirlineCodes) {
		this.validatingAirlineCodes = validatingAirlineCodes;
	}
	
	public List<String> getValidatingAirlineCodes() {
		return this.validatingAirlineCodes;
	}
	
	public void setTravelerPricings(List<TravelerPricing> travelerPricings) {
		this.travelerPricings = travelerPricings;
	}
	
	public List<TravelerPricing> getTravelerPricings(){
		return this.travelerPricings;
	}
	
	@Override
	public String toString() {
		String amadeusFlightOfferString = "\tFlight Offer: Price: " + price.getGrandTotal();
		amadeusFlightOfferString += "\n\tItineraries:";
		for(Itinerary itinerary: itineraries) {
			amadeusFlightOfferString += "\n" + itinerary.toString();
		}
		return amadeusFlightOfferString;
	}
}
