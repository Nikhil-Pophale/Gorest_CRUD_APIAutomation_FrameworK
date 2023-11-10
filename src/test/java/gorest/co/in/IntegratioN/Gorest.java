package gorest.co.in.IntegratioN;

import com.fasterxml.jackson.core.JsonProcessingException;
import gorest.co.in.PayloadManager.PayloadManager;
import gorest.co.in.SetUp.Base;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class Gorest extends Base {
    PayloadManager payloadManager;
    public static Integer id;

    @Test
    public void createuser() throws JsonProcessingException {
        payloadManager = new PayloadManager();
        response = requestSpecification.when().body(payloadManager.Createuser()).post();
//        validatableResponse= response.then().extract().path("id");
        id = response.then().extract().path("id");
        System.out.println(response.getBody().asString());
//        System.out.println(id);

    }

    @Test(dependsOnMethods = "updateuser")
    public void getuser() throws JsonProcessingException {
        payloadManager = new PayloadManager();
        requestSpecification.basePath("/" + id);
        response = requestSpecification.when().get();
        System.out.println(response.asString());
    }

    @Test
    public void updateuser() throws JsonProcessingException {
        payloadManager = new PayloadManager();
        requestSpecification.basePath("/" + id);
        response = requestSpecification.when().body(payloadManager.Updateuser()).patch();
//        validatableResponse= response.then().extract().path("id");
        String up = response.then().extract().response().asString();
//        System.out.println(response.getBody().asString());
        System.out.println(up);

    }

    @Test(dependsOnMethods = "getuser")
    public void deleteuser() {
        requestSpecification.basePath("/" + id);
        response = requestSpecification.when().delete();
        validatableResponse = response.then().log().all().statusCode(204);

        System.out.println(response.toString());
    }

    @Test(dependsOnMethods = "deleteuser")
    public void deleteuserConfirmation() throws JsonProcessingException {
        payloadManager = new PayloadManager();
        requestSpecification.basePath("/" + id);
        response = requestSpecification.when().get();
        ValidatableResponse validatableResponse1=response.then().statusCode(404);
//        System.out.println(response.asString());
    }
}
