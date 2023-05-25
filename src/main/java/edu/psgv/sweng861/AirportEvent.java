package edu.psgv.sweng861;

public class AirportEvent {
	private String iataCode;
	private String at;
	private String terminal;
	
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	
	public String getIataCode() {
		return this.iataCode;
	}
	
	public void setAt(String at) {
		this.at = at;
	}
	
	public String getAt() {
		return this.at;
	}
	
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
	public String getTerminal() {
		return this.terminal;
	}
}
