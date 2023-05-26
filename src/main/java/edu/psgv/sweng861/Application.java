package edu.psgv.sweng861;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmadeusClient client = new AmadeusClient();
		Scanner in = new Scanner(System.in);
		System.out.println("Starting Airport IATA Code: ");
		String startingAirport = in.nextLine();
		System.out.println("Ending Airport IATA Code: ");
		String endingAirport = in.nextLine();
		in.close();
		client.getFlights(startingAirport, endingAirport, "2023-11-01", TravelClass.ECONOMY, 1, false);
		
	}

}
