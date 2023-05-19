package edu.psgv.sweng861;

public class AmadeusAccessToken {
    private String type;
    private String username;
    private String applicationName;
    private String clientId;
    private String tokenType;
    private String accessToken;
    private int expiresIn;
    private String state;
    private String scope;
   
    public String getAccessToken() {
    	return accessToken;
    }
}
