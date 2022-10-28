package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonplaceholderBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
   I send a GET request to the Url
 And
     Accept type is "application/json"
 Then
     HTTP Status Code should be 200
 And
     Response format should be "application/json"
 And
     There should be 200 todos
 And
     "quis eius est sint explicabo" should be one of the todos title
 And
     2, 7, and 9 should be among the userIds
 */

    @Test
    public void get04(){
        spec.pathParam("first","todos");

        Response response = given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
        response.prettyPrint();

        response.then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200).
                body("id",hasSize(200)).
                body("title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));



    }

}
