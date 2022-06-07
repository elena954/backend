package HW3.HW2;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

public class GetComplexSearch {

    private static final String API_KEY = "3a81c8a33bc84ba4a18ba4fe12267b4e";
    private static final  String BASE_URL = "https://api.spoonacular.com";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    void testGetComplexSearch1() {
                given()
                .queryParam("apiKey", API_KEY)
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("results[0].id", Matchers.notNullValue())
                .body("offset", is(0))
                .body("number", is(10))
                .body("totalResults", is(5222))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();
        }

    @Test
    void testGetComplexSearch2()  {
            given()
                .queryParam("apiKey", API_KEY)
                .queryParam("includeIngredients", "onion, meat, potato")
                .queryParam("type", "main course")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("results[0].id", Matchers.notNullValue())
                .body("offset", is(0))
                .body("number", is(10))
                .body("totalResults", is(67))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }

    @Test
    void testGetComplexSearch3() {
        given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "burger")
                .queryParam("includeIngredients", "tomatoes, onion, cheese")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("results[0].id", Matchers.notNullValue())
                .body("offset", is(0))
                .body("number", is(10))
                .body("totalResults", is(1))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();
    }

    @Test
    void testGetComplexSearch4(){
            given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "rib eye steak")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("results[0].id", Matchers.notNullValue())
                .body("offset", is(0))
                .body("number", is(10))
                .body("totalResults", is(1))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }

    @Test
    void testGetComplexSearch5() {
        given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "risotto")
                .queryParam("minCalories", "50")
                .queryParam("maxCalories", "400")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("results[0].id", Matchers.notNullValue())
                .body("offset", is(0))
                .body("number", is(10))
                .body("totalResults", is(5))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }
}

