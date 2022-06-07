package HW3.HW2;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class PostCuisine1 {

    private static final String API_KEY = "3a81c8a33bc84ba4a18ba4fe12267b4e";
    private static final String BASE_URL = "https://api.spoonacular.com";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = BASE_URL;
    }



    @Test
    void testPOSTClassifyGroceryProduct1() {
            given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "caesar")
                .queryParam("ingredientList", "lettuce leaves, croutons, sauce, tomatoes")
                .queryParam("language", "en")
                .queryParam("images", "https://donatewales.org/wp-content/uploads/0/5/8/0580fb82721b3faac4c60abab6b4fa99.jpeg")
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

    }

    @Test
    void testPOSTClassifyGroceryProduct2() {
            given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "Julienne of chicken")
                .queryParam("ingredientList", "Chicken, onion, cream, mushrooms, cheese")
                .queryParam("language", "en")
                    .queryParam("images","https://flywoman.ru/wp-content/uploads/2020/05/4-63-1.jpg")
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

    }

    @Test
    void testPOSTClassifyGroceryProduct3() throws IOException {
        String actually = RestAssured.given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "Meat casserole")
                .queryParam("ingredientList", "Mashed potatoes, minced meat, onions")
                .queryParam("language", "en")
                .queryParam("images", "https://attuale.ru/wp-content/uploads/2018/11/Hachis-Parmentier-.jpg")
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
    }

    @Test
    void testPOSTClassifyGroceryProduct4() {
            given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "Dumplings")
                .queryParam("ingredientList", "Dough, minced meat")
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

          }

    @Test
    void testPOSTClassifyGroceryProduct5() {
            given()
                .queryParam("apiKey", API_KEY)
                .queryParam("title", "Borsch")
                .queryParam("ingredientList",
                        "Meat broth, potatoes, cabbage, carrots, beets, onions, peppers, tomato paste")
                .queryParam("language", "en")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("confidence", is(0.0F))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();

    }
}
