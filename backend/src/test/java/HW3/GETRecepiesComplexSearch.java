package HW3;

import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.JsonAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

public class GETRecepiesComplexSearch extends BaseTest{

    private static final String API_KEY = "3a81c8a33bc84ba4a18ba4fe12267b4e";
    private static final  String BASE_URL = "https://api.spoonacular.com";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    void testGetComplexSearch1() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "sushi")
                .queryParam("cuisine", "Japanese")
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

        String expected = getResourceAsString("ComplexSearch1.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testGetComplexSearch2() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "Caesar")
                .queryParam("cuisine", "European")
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
                .body("totalResults", is(6))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("ComplexSearch2.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testGetComplexSearch3() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "Greek")
                .queryParam("cuisine", "European")
                .queryParam("title", "Greek Shrimp Orzo")
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
                .body("totalResults", is(18))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("ComplexSearch3.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testGetComplexSearch4() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "meat and potatoes")
                .queryParam("cuisine", "European")
                .queryParam("title", "Corned Beef and Cabbage")
                .queryParam("includeIngredients", "meat")
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
                .body("totalResults", is(21))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("ComplexSearch4.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testGetComplexSearch5() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("query", "meat and potatoes")
                .queryParam("cuisine", "European")
                .queryParam("title", "Corned Beef and Cabbage")
                .queryParam("includeIngredients", "meat")
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
                .body("totalResults", is(21))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("ComplexSearch5.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }
}

