package edu.psgv.sweng861;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

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
		System.out.println("Token: " + accessToken.getAccessToken());
		String queryString = "?originLocationCode=" + departCode + "&destinationLocationCode=" + arrivalCode 
				+ "&departureDate=" + departureDate + "&adults=" + tickets;
		HttpRequest flightRequest = HttpRequest.newBuilder()
				.uri(URI.create(AMADEUS_BASE_URI+"/v2/shopping/flight-offers"+queryString))
				.header("Authorization","Bearer " + accessToken.getAccessToken())
				.header("Accept", "*/*")
				.header("Accept-Encoding", "gzip")
				.build();
		HttpGet getRequest = new HttpGet();
		
		getRequest.addHeader("Authorization","Bearer " + accessToken.getAccessToken());
		getRequest.addHeader("Accept","*/*");
		getRequest.addHeader("Accept-Encoding","gzip");
		try {
			URI uri = new URIBuilder(AMADEUS_BASE_URI+"/v2/shopping/flight-offers")
					.addParameter("originLocationCode", departCode)
					.addParameter("destinationLocationCode", arrivalCode)
					.addParameter("departureDate", departureDate)
					.addParameter("adults", ""+tickets)
					.build();
			getRequest.setURI(uri);
			CloseableHttpClient client = HttpClientBuilder.create().build();
			CloseableHttpResponse response = client.execute(getRequest);
	        byte[] buff = new byte[1024];
	        byte[] emptyBuff = new byte[1024];
            StringBuffer unGzipRes = new StringBuffer();
            InputStream inputStream = response.getEntity().getContent();
            inputStream.read(buff, 0, 1024);
            System.out.println("Printing DAta: " );
            //String firstLine = new String(buff, "UTF-8");
            //System.out.println("First Line length: " + firstLine.length());
            //System.out.println(firstLine);
            
            int byteCount = 0;
            while ((byteCount = inputStream.read(buff, 0, 1024)) > 0) {
                // only append the buff elements that
                // contains data
                unGzipRes.append(new String(buff, "UTF-8"));

                // empty the buff for re-usability and
                // prevent dirty data attached at the
                // end of the buff
                System.arraycopy(emptyBuff, 0, buff, 0,
                        1024);
            }
            System.out.println("Response: " + unGzipRes.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
