package edu.psgv.sweng861;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to deserialize the AmadeusAccessToken response.
 * The access token is needed to authenticate for other Amadeus API requests
 * @author zachb
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
   
    /**
     * Setter for type
     * @param String type
     */
    public void setType(String type) {
    	this.type = type;
    }

    /**
     * Setter for username
     * @param String username
     */
    public void setUsername(String username) {
    	this.username = username;
    }

    /**
     * Setter for application_name
     * @param String applicationName
     */
    @JsonProperty("application_name")
    public void setApplicationName(String applicationName){
    	this.applicationName = applicationName;
    }
    
    /**
     * Setter for client_id
     * @param String clientId
     */
    @JsonProperty("client_id")
    public void setClientId(String clientId) {
    	this.clientId = clientId;
    }

    /**
     * setter for token_type
     * @param String tokenType
     */
    @JsonProperty("token_type")
    public void setTokenType(String tokenType) {
    	this.tokenType = tokenType;
    }

    /**
     * setter for access_token, the token that will need to be passed with future requests
     * @param String accessToken
     */
    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
    	this.accessToken = accessToken;
    }

    /**
     * Getter for access token
     * @return String accessToen
     */
    public String getAccessToken() {
    	return accessToken;
    }

    /**
     * Setter for expires_in
     * @param int expiresIn
     */
    @JsonProperty("expires_in")
    public void setExpiresIn(int expiresIn) {
    	this.expiresIn = expiresIn;
    }

    /**
     * Setter for state
     * @param String state
     */
    public void setState(String state) {
    	this.state = state;
    }

    /**
     * Setter for scope
     * @param String scope
     */
    public void setScope(String scope) {
    	this.scope = scope;
    }
}
