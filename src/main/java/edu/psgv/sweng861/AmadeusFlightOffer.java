package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO to deserialize JSON from an AmadeusFlightOffer API response.
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
	 * Setter for source
	 * @param String source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Getter for source
	 * @return String source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Setter for instantTicketingRequired
	 * @param boolean instantTicketingRequired
	 */
	public void setInstantTicketingRequired(boolean instantTicketingRequired) {
		this.instantTicketingRequired = instantTicketingRequired;
	}
	
	/**
	 * Getter for instantTicketingRequired
	 * @return boolean
	 */
	public boolean isInstantTicketingRequired() {
		return this.instantTicketingRequired;
	}
	
	/**
	 * Setter for nonHomogenous
	 * @param boolean nonHomogeneous
	 */
	public void setNonHomogeneous(boolean nonHomogeneous) {
		this.nonHomogeneous = nonHomogeneous;
	}
	
	/**
	 * Getter for nonHomogenous
	 * @return boolean nonHomogenous
	 */
	public boolean isNonHomogeneous() {
		return this.nonHomogeneous;
	}
	
	/**
	 * Setter for oneWay
	 * @param boolean oneWay
	 */
	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}
	
	/**
	 * Getter for oneWay
	 * @return boolean
	 */
	public boolean isOneWay() {
		return this.oneWay;
	}
	
	/**
	 * Setter for LastTicketingDate
	 * @param String lastTicketingDate
	 */
	public void setLastTicketingDate(String lastTicketingDate) {
		this.lastTicketingDate = lastTicketingDate;
	}
	
	/**
	 * Getter for lastTicketingDate
	 * @return String lastTicketingDate
	 */
	public String getLastTicketingDate() {
		return this.lastTicketingDate;
	}
	
	/**
	 * Setter for lastTicketingDateTime
	 * @param String lastTicketingDateTime
	 */
	public void setLastTicketingDateTime(String lastTicketingDateTime) {
		this.lastTicketingDateTime = lastTicketingDateTime;
	}
	
	/**
	 * Getter for lastTicketingDateTime
	 * @return String lastTicketingDateTime
	 */
	public String getLastTicketingDateTime() {
		return this.lastTicketingDateTime;
	}
	
	/**
	 * Setter for numberOfBookableSeats
	 * @param in numberOfBookableSeats
	 */
	public void setNumberOfBookableSeats(int numberOfBookableSeats) {
		this.numberOfBookableSeats = numberOfBookableSeats;
	}
	
	/**
	 * Getter for numberOfBookableSeats
	 * @return int numberOfBookableSeats
	 */
	public int getNumberOfBookableSeats() {
		return this.numberOfBookableSeats;
	}
	
	/**
	 * Setter for itineraries
	 * @param List<Itinerary> itineraries
	 */
	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}
	
	/**
	 * Getter for itineraries
	 * @return List<Itinerary>
	 */
	public List<Itinerary> getItineraries() {
		return this.itineraries;
	}
	
	/**
	 * Setter for dictionaries
	 * @param Dictionaries dictionaries
	 */
	public void setDictionaries(Dictionaries dictionaries) {
		this.dictionaries = dictionaries;
	}
	
	/**
	 * Getter for dictionaries
	 * @return Dictionaries dictionaries
	 */
	public Dictionaries getDictionaires() {
		return this.dictionaries;
	}
	
	/**
	 * Setter for price
	 * @param Price price
	 */
	public void setPrice(Price price) {
		this.price = price;
	}
	
	/**
	 * Getter for price
	 * @return Price price
	 */
	public Price getPrice() {
		return this.price;
	}
	
	/**
	 * Setter for pricingOptions
	 * @param PricingOptions pricingOptions
	 */
	public void setPricingOptions(PricingOptions pricingOptions) {
		this.pricingOptions = pricingOptions;
	}
	
	/**
	 * Getter for PricingOptions
	 * @return PricingOptions pricingOptions
	 */
	public PricingOptions getPricingOptions() {
		return this.pricingOptions;
	}
	
	/**
	 * Setter for validatingAirlineCodes
	 * @param List<String> validatingAirlineCodes
	 */
	public void setValidatingAirlineCodes(List<String> validatingAirlineCodes) {
		this.validatingAirlineCodes = validatingAirlineCodes;
	}
	
	/**
	 * Getter for validatingAirlineCodes
	 * @return List<String>
	 */
	public List<String> getValidatingAirlineCodes() {
		return this.validatingAirlineCodes;
	}
	
	/**
	 * Setter for travelerPricings
	 * @param List<TravelerPricing> travelerPricings
	 */
	public void setTravelerPricings(List<TravelerPricing> travelerPricings) {
		this.travelerPricings = travelerPricings;
	}
	
	/**
	 * Getter for travelerPricings
	 * @return List<TravelerPricing>
	 */
	public List<TravelerPricing> getTravelerPricings(){
		return this.travelerPricings;
	}
	
	/**
	 * toString method used to format the AmadeusFlightOffer to print in the UI
	 * @param dictionaries
	 * @return String string representation of the AmadeusFlightOffer
	 */
	public String toString(Dictionaries dictionaries) {
		String amadeusFlightOfferString = "\tFlight Offer: Price: " + price.getGrandTotal();
		amadeusFlightOfferString += "\n\tItineraries:";
		for(Itinerary itinerary: itineraries) {
			amadeusFlightOfferString += "\n" + itinerary.toString(dictionaries);
		}
		return amadeusFlightOfferString;
	}
}
