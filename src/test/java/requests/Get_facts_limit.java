package requests;

import baseURL.CatfctNinja_baseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import pojo.CatfctNinja_pojo;

import static io.restassured.RestAssured.given;

public class Get_facts_limit extends CatfctNinja_baseURL {
    @Test
    public void getFactsLimit(){
        CatfctNinja_pojo pojo = new CatfctNinja_pojo();
        pojo.setLimit(2);

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get_facts_limit.class);

        specification.pathParam("firstParam","facts")
                .queryParam("limit",pojo.getLimit());
        logger.info("User sets the url with parameter and limit");
        Response response=given().spec(specification).when().get("/{firstParam}");
        logger.info("User sends the GET request");
        response.getBody().prettyPrint();
        logger.info("User displays the facts list in the response body");
        response.then().assertThat().statusCode(200);
        logger.info("User asserts that the status code is 200");
        response.then().assertThat().contentType(ContentType.JSON);
        logger.info("User asserts that the content type is application/json");

    }
}
