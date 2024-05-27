package requests;

import baseURL.CatfctNinja_baseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_a_list_of_breeds extends CatfctNinja_baseURL {
    @Test
    public void getBreeds(){
        specification.pathParam("firstParam","breeds");
        Response response=given().spec(specification).when().get("/{firstParam}");
        response.getBody().prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType(ContentType.JSON);


    }
}
