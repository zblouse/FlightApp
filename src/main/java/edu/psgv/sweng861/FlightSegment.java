package edu.psgv.sweng861;

public class FlightSegment {
	private AirportEvent departure;
	private AirportEvent arrival;
	private String carrierCode;
	private String number;
	private Aircraft aircraft;
	private String duration;
	private String id;
	private int numberOfStops;
	private boolean blacklistedInEU;
	private OperatingAirline operating;
	
	public void setDeparture(AirportEvent departure) {
		this.departure = departure;
	}
	
	public AirportEvent getDeparture() {
		return departure;
	}
	
	public void setArrival(AirportEvent arrival) {
		this.arrival = arrival;
	}
	
	public AirportEvent getArrival() {
		return arrival;
	}
	
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	public String getCarrierCode() {
		return carrierCode;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	
	public Aircraft getAircraft() {
		return aircraft;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	
	public int getNumberOfStops() {
		return this.numberOfStops;
	}
	
	public void setBlacklistedInEU(boolean blacklistedInEU) {
		this.blacklistedInEU = blacklistedInEU;
	}
	
	public boolean isBlacklistedInEU() {
		return this.blacklistedInEU;
	}
	
	public void setOperating(OperatingAirline operating) {
		this.operating = operating;
	}
	
	public OperatingAirline getOperatingAirline() {
		return this.operating;
	}
}
