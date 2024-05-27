package requests;

import baseURL.CatfctNinja_baseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import pojo.CatfctNinja_pojo;

import static io.restassured.RestAssured.given;

public class Get_random_fact_max_length extends CatfctNinja_baseURL{
    @Test
    public void getRandomFactMaxLenght(){
        CatfctNinja_pojo pojo = new CatfctNinja_pojo();
        pojo.setMax_lenght(20);

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get_random_fact_max_length.class);

        specification.pathParam("firstParam","fact")
                .queryParam("max_length",pojo.getMax_lenght());
        logger.info("User sets the url with parameter");
        Response response=given().spec(specification).when().get("/{firstParam}");
        logger.info("User sends the GET request");
        response.getBody().prettyPrint();
        logger.info("User displays a random fact in the response body");
        response.then().assertThat().statusCode(200);
        logger.info("User asserts that the status code is 200");
        response.then().assertThat().contentType(ContentType.JSON);
        logger.info("User asserts that the content type is application/json");

    }
}
