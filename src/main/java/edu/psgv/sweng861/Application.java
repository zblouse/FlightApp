package edu.psgv.sweng861;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmadeusClient client = new AmadeusClient();
		client.getFlights("MAD", "NYC", "2023-11-01", TravelClass.ECONOMY, 1, false);
	}

}
