package edu.psgv.sweng861;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AmadeusClient {
	//In actual production I would have these in either Vault or encrypt it with a key
	private final String API_KEY = "YtbP1LgAPsLirTIPb1PFxVe0yNI9oCgv";
	private final String API_SECRET = "JAV6z6wIBzJgyrSo";
	private final String AMADEUS_BASE_URI = "https://test.api.amadeus.com";
	
	private HttpClient httpClient;
	private ObjectMapper objectMapper;
	
	public AmadeusClient() {
		httpClient = HttpClient.newHttpClient();
	}
	
	public void getFlights(String departCode, String arrivalCode, TravelClass travelClass, int tickets, boolean nonstop) {
		String accessToken = getAccessToken();
		System.out.println("ACCESS TOKEN: " + accessToken);
	}
	
	private String getAccessToken() {
		HttpRequest accessTokenRequest = HttpRequest.newBuilder()
				.uri(URI.create(AMADEUS_BASE_URI+"/v1/security/oauth2/token"))
				.POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + API_SECRET))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.build();
		try {
			HttpResponse<String> response = httpClient.send(accessTokenRequest, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR: " + e.getMessage();
		}
	}
}
