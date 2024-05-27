package requests;

import baseURL.CatfctNinja_baseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import pojo.CatfctNinja_pojo;

import static io.restassured.RestAssured.given;

public class Get_a_list_of_breeds_limit extends CatfctNinja_baseURL {
    @Test
    public void getBreedsWithLimit(){
        CatfctNinja_pojo pojo = new CatfctNinja_pojo();
        pojo.setLimit(1);
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get_a_list_of_breeds_limit.class);

        specification.pathParam("firstParam","breeds")
                .queryParam("limit",pojo.getLimit());
        logger.info("User sets the url with parameter and limit");
        Response response=given().spec(specification).when().get("/{firstParam}");
        logger.info("User sends the GET request");
        response.getBody().prettyPrint();
        logger.info("User displays the breeds list in the response body");
        response.then().assertThat().statusCode(200);
        logger.info("User asserts that The status code is 200");
        response.then().assertThat().contentType(ContentType.JSON);
        logger.info("User asserts that The content type is application/json");

    }
}
