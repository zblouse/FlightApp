package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonProperty;

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
   
    public void setType(String type) {
    	this.type = type;
    }

    public void setUsername(String username) {
    	this.username = username;
    }

    @JsonProperty("application_name")
    public void setApplicationName(String applicationName){
    	this.applicationName = applicationName;
    }
    
    @JsonProperty("client_id")
    public void setClientId(String clientId) {
    	this.clientId = clientId;
    }

    @JsonProperty("token_type")
    public void setTokenType(String tokenType) {
    	this.tokenType = tokenType;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
    	this.accessToken = accessToken;
    }

    public String getAccessToken() {
    	return accessToken;
    }

    @JsonProperty("expires_in")
    public void setExpiresIn(int expiresIn) {
    	this.expiresIn = expiresIn;
    }

    public void setState(String state) {
    	this.state = state;
    }

    public void setScope(String scope) {
    	this.scope = scope;
    }
}
