package models;

import io.restassured.http.Cookies;
import lombok.Data;

@Data
public class AuthorisationResponseModel {
    Cookies cookies;
}
