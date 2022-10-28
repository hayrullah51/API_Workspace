package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Get02 {

    /* Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "Hayrullah"
    And
    Server is "Cowboy"
     */

    @Test
    public void get02(){
        String url = "https://restful-booker.herokuapp.com/booking/1";
        Response response = given().when().get(url);

        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("Hayrullah"));

    }
}
