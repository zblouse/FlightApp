package edu.psgv.sweng861;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for deserializing the metadata from an Amadeus Flight Offers API response
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmadeusFlightMeta {
	private int count;
	private Map<String,String> links;
	
	/**
	 * Setter for count
	 * @param int count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Getter for count
	 * @return int count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Setter for links
	 * @param Map<String,String> links
	 */
	public void setLinks(Map<String,String> links) {
		this.links = links;
	}
	
	/**
	 * Getter for links
	 * @return Map<String,String> links
	 */
	public Map<String,String> getLinks() {
		return this.links;
	}
}
