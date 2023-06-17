package edu.psgv.sweng861;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class for making reqeusts to the Amadeus API
 * @author zachb
 *
 */
public class AmadeusClient {
	//In actual production I would have these in either Vault or encrypt it with a key
	private final String API_KEY = "YtbP1LgAPsLirTIPb1PFxVe0yNI9oCgv";
	private final String API_SECRET = "JAV6z6wIBzJgyrSo";
	private final String AMADEUS_BASE_URI = "https://test.api.amadeus.com";
	
	private HttpClient httpClient;
	private ObjectMapper objectMapper;
	
	/**
	 * Constructor
	 */
	public AmadeusClient() {
		httpClient = HttpClient.newHttpClient();
		objectMapper = new ObjectMapper();
	}
	
	/**
	 * Sends the API request to get flight offers
	 * @param String departCode IATA code of origin airport
	 * @param String arrivalCode IATA code of destination airport
	 * @param String departureDate YYYY-MM-DD format
	 * @param TravelClass travelClass Minimum travel class to find tickets for
	 * @param int tickets Number of tickets needed
	 * @param boolean nonStop Whether the customer requires a nonstop flight
	 * @return AmadeusFlightOffersReponse, deserialized JSON response from the API
	 * @throws Exception
	 */
	public AmadeusFlightOffersResponse getFlights(String departCode, String arrivalCode, String departureDate, TravelClass travelClass, int tickets, boolean nonStop) throws Exception {
		AmadeusAccessToken accessToken = getAccessToken();
		
		HttpGet getRequest = new HttpGet();
		
		getRequest.addHeader("Authorization","Bearer " + accessToken.getAccessToken());
		getRequest.addHeader("Accept","*/*");
		getRequest.addHeader("Accept-Encoding","gzip");
		URI uri = new URIBuilder(AMADEUS_BASE_URI+"/v2/shopping/flight-offers")
				.addParameter("originLocationCode", departCode)
				.addParameter("destinationLocationCode", arrivalCode)
				.addParameter("departureDate", departureDate)
				.addParameter("adults", "" + tickets)
				.addParameter("nonStop", "" + nonStop)
				.addParameter("travelClass", travelClass.toString())
				.build();
		getRequest.setURI(uri);
		CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpResponse response = client.execute(getRequest);
        byte[] buff = new byte[1024];
        byte[] emptyBuff = new byte[1024];
        InputStream inputStream = response.getEntity().getContent();

        StringBuilder stringBuilder = new StringBuilder();

        int byteCount = 0;
        while ((byteCount = inputStream.read(buff, 0, 1024)) > 0) {
            byte[] smallerBuff = new byte[byteCount];
            smallerBuff = Arrays.copyOf(buff, byteCount);

            String newString = new String(smallerBuff, "UTF-8");
            if(newString != "") {
                stringBuilder.append(newString);
            }
            System.arraycopy(emptyBuff, 0, buff, 0, 1024);
        }
        AmadeusFlightOffersResponse amadeusFlightOffersResponse = objectMapper.readValue(stringBuilder.toString(),AmadeusFlightOffersResponse.class);
        return amadeusFlightOffersResponse;

	}
	
	/**
	 * Sends an API request for an access token. The token is required to authenticate all other reuqests.
	 * @return AmadeusAccessToken
	 */
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
