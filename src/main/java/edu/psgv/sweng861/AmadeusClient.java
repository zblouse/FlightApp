package edu.psgv.sweng861;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.zip.GZIPInputStream;

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
		objectMapper = new ObjectMapper();
	}
	
	public void getFlights(String departCode, String arrivalCode, String departureDate, TravelClass travelClass, int tickets, boolean nonStop) {
		//TODO add error handling for failure to get token
		AmadeusAccessToken accessToken = getAccessToken();
		String queryString = "?originLocationCode=" + departCode + "&destinationLocationCode=" + arrivalCode 
				+ "&departureDate=" + departureDate + "&adults=" + tickets;
		HttpRequest flightRequest = HttpRequest.newBuilder()
				.uri(URI.create(AMADEUS_BASE_URI+"/v2/shopping/flight-offers"+queryString))
				.header("Authorization","Bearer " + accessToken.getAccessToken())
				.header("Accept", "*/*")
				.header("Accept-Encoding", "gzip")
				.build();
		try {
			System.out.println("Token: " + accessToken.getAccessToken());
			HttpResponse<InputStream> response = httpClient.send(flightRequest, HttpResponse.BodyHandlers.ofInputStream());
			GZIPInputStream gzipStream = new GZIPInputStream(response.body());
			
			byte[] readBuffer = new byte[5000];
			String result = "";
			int read = 0;
			while(read != -1) {
				read = gzipStream.read(readBuffer, 0, readBuffer.length);
				String responseString = new String(readBuffer, "UTF-8");
				result += responseString;
			}
			gzipStream.close();

		    System.out.println("Response: " + result);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private AmadeusAccessToken getAccessToken() {
		HttpRequest accessTokenRequest = HttpRequest.newBuilder()
				.uri(URI.create(AMADEUS_BASE_URI+"/v1/security/oauth2/token"))
				.POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + API_SECRET))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.build();
		try {
			HttpResponse<String> response = httpClient.send(accessTokenRequest, HttpResponse.BodyHandlers.ofString());
			AmadeusAccessToken accessToken = objectMapper.readValue(response.body(),AmadeusAccessToken.class);
			return accessToken;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
