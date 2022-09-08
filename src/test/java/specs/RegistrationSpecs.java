package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;


public class RegistrationSpecs {
    public static RequestSpecification requestSpecificationRequest = with()
            .filter(withCustomTemplates())
            .baseUri("https://open-broker.ru/");

    public static ResponseSpecification requestSpecificationResponse = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
