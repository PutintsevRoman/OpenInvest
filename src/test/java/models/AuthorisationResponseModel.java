package models;

import io.restassured.http.Cookies;
import lombok.Data;

@Data
public class AuthorisationResponseModel {
    Cookies cookies;

    public String getCookiesByName(String name){
       return cookies.getValue(name);
    }
}
