package gorest.co.in.SetUp;

import gorest.co.in.EndPoints.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Base {

    public static RequestSpecification requestSpecification=RestAssured.given();
    public static Response response;
    public static JsonPath json;

    public static ValidatableResponse validatableResponse;
    @BeforeMethod(alwaysRun = true)
    public void setup(){

        requestSpecification= RestAssured.given().baseUri(Constants.baseurl)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer f880144ccdbee83e957fda0518150d5aa18b761f6732f199dd14b35ee4dd5afd");

    }

}
