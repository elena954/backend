package HW3;

import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.*;


public class POSTClassifyGroceryProduct extends BaseTest {

    private static final String API_KEY = "3a81c8a33bc84ba4a18ba4fe12267b4e";
    private static final String BASE_URL = "https://api.spoonacular.com";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = BASE_URL;
    }



    @Test
    void testPOSTClassifyGroceryProduct1() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "Pork roast with green beans")
                .queryParam("ingredientList", "3 oz pork shoulder")
                .queryParam("language", "en")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("confidence", is( 0.0F))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("GroceryProduct1.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testPOSTClassifyGroceryProduct2() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "potatoes")
                .queryParam("ingredientList", "potatoes, onions, pork")
                .queryParam("language", "en")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("confidence", is( 0.0F))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("GroceryProduct1.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testPOSTClassifyGroceryProduct3() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "hatchet")
                .queryParam("ingredientList", "beef loin on the bone")
                .queryParam("language", "en")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("confidence", is( 0.0F))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("GroceryProduct1.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testPOSTClassifyGroceryProduct4() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "pike perch with curry")
                .queryParam("ingredientList", "pike perch fillet, onion, tomato, broth, spicy curry, cilantro")
                .queryParam("language", "en")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("confidence", is( 0.95F))
                .body("cuisine", equalTo("Indian"))
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("GroceryProduct2.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testPOSTClassifyGroceryProduct5() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "Pork knuckle")
                .queryParam("ingredientList", "Stewed knuckle, mustard, honey, potatoes, mayonnaise, horseradish sauce")
                .queryParam("language", "en")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("confidence", is( 0.0F))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("GroceryProduct1.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }
}