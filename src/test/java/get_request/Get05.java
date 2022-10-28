package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get05 extends RestfulBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
     */

    @Test
    public void get05() {
        //https://restful-booker.herokuapp.com/booking?firstname=Ali&lastname=Cengiz
        spec.pathParam("first","booking").queryParams("firstname","Hayrullah","lastname","DEDELER");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
