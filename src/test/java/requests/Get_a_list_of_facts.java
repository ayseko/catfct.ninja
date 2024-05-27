package requests;

import baseURL.CatfctNinja_baseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_alist_of_facts extends CatfctNinja_baseURL {
    @Test
    public void getFactsList(){
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get_a_list_of_breeds.class);

        specification.pathParam("firstParam","breeds");
        logger.info("User sets the url with parameter");
        Response response=given().spec(specification).when().get("/{firstParam}");
        logger.info("User sends the GET request");
        response.getBody().prettyPrint();
        logger.info("User displays the response body");
        response.then().assertThat().statusCode(200);
        logger.info("User asserts that The status code is 200");
        response.then().assertThat().contentType(ContentType.JSON);
        logger.info("User asserts that The conten type is applicatian/json");

    }
}
