package HW3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

//Этот пример из методички. Я так и не поняла откуда взять "hash" и "username"

public class MealPlan {

    String id;

    @Test
    void addMealTest() {
        id = given()
                .queryParam("apiKey", "3e6cc9c807c84d0ba3518045b86e6687")
                .queryParam("hash", "75e258c933fd5552b3781398b2b66c03295d03f1")
                .queryParam("username", "len4ik")
                .body("{\n"
                        +"    \"item\": \"1 package baking powder\",\n"
                        +"    \"aisle\": \"Baking\",\n"
                        +"    \"parse\": true\n"
                        +"}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/len4ik/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

    }
    @AfterEach
    void tearDown() {
        given()
                .queryParam("apiKey", "3e6cc9c807c84d0ba3518045b86e6687")
                .queryParam("hash", "75e258c933fd5552b3781398b2b66c03295d03f1")
                .delete("https://api.spoonacular.com/mealplanner/len4ik/shopping-list/items/" + id)
                .then()
                .statusCode(200);
    }
}
