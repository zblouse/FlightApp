package edu.psgv.sweng861;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmadeusFlightMeta {
	private int count;
	private Map<String,String> links;
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setLinks(Map<String,String> links) {
		this.links = links;
	}
	
	public Map<String,String> getLinks() {
		return this.links;
	}
}
