package edu.psgv.sweng861;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing the AmadeusFlightOffer API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmadeusFlightOffersResponse {
	private AmadeusFlightMeta meta;
	private List<AmadeusFlightOffer> data;
	private Dictionaries dictionaries;
	
	/**
	 * Setter for meta
	 * @param AmadeusFlightMeta meta
	 */
	public void setMeta(AmadeusFlightMeta meta) {
		this.meta = meta;
	}
	
	/**
	 * Getter for meta
	 * @return AmadeusFlightMeta
	 */
	public AmadeusFlightMeta getMeta() {
		return this.meta;
	}
	
	/**
	 * Setter for data
	 * @param List<AmadeusFlightOffer> data
	 */
	public void setData(List<AmadeusFlightOffer> data) {
		this.data = data;
	}
	
	/**
	 * Getter for data
	 * @return List<AmadeusFlightOffer>
	 */
	public List<AmadeusFlightOffer> getData() {
		return this.data;
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
	public Dictionaries getDictionaries() {
		return this.dictionaries;
	}
	
	/**
	 * Overriding the toString method to format the response for the UI
	 */
	@Override
	public String toString() {
		String flightOffersString = "";
		for(AmadeusFlightOffer amadeusFlightOffer: data) {
			flightOffersString += "\n" + amadeusFlightOffer.toString();
		}
		return flightOffersString;
	}
	
}
