package models;

import lombok.Data;

@Data
public class AuthorisationRequestModel {
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String refresh_token_expires_in;
    private String user_id;
}
