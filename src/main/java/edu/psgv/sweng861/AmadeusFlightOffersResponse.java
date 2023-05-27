package edu.psgv.sweng861;

import java.util.List;

public class AmadeusFlightOffersResponse {
	private AmadeusFlightMeta meta;
	private List<AmadeusFlightOffer> data;
	private Dictionaries dictionaries;
	
	public void setMeta(AmadeusFlightMeta meta) {
		this.meta = meta;
	}
	
	public AmadeusFlightMeta getMeta() {
		return this.meta;
	}
	
	public void setData(List<AmadeusFlightOffer> data) {
		this.data = data;
	}
	
	public List<AmadeusFlightOffer> getData() {
		return this.data;
	}
	
	public void setDictionaries(Dictionaries dictionaries) {
		this.dictionaries = dictionaries;
	}
	
	public Dictionaries getDictionaries() {
		return this.dictionaries;
	}
	
	@Override
	public String toString() {
		String flightOffersString = "";
		for(AmadeusFlightOffer amadeusFlightOffer: data) {
			flightOffersString += "\n" + amadeusFlightOffer.toString();
		}
		return flightOffersString;
	}
	
}
