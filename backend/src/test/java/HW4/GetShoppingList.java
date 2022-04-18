package HW4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoonaccular.ShoppingListResponse;
import java.lang.reflect.Type;


import static org.hamcrest.Matchers.lessThan;

public class GetShoppingList {

    private static final String API_KEY = "3a81c8a33bc84ba4a18ba4fe12267b4e";
    private static final String BASE_URL = "https://api.spoonacular.com";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", API_KEY)
                .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(4000L))
                .build();
    }

    @Test
    void GetShoppingList() {
        ShoppingListResponse actually = RestAssured.given()
                .queryParam("hash", "75e258c933fd5552b3781398b2b66c03295d03f1")
                .queryParam("username", "len4ik")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("https://api.spoonacular.com/mealplanner/len4ik/shopping-list")
                .body()
                .as((Type) ShoppingListResponse.class);

//        System.out.println(actually);
//        for (ShoppingListResponseItem item : actually.getAisles()) {
//            Assertions.assertNotNull(item.getId());
//            Assertions.assertTrue(item.getName().toLowerCase(Locale.ROOT).contains("baking powder"));
//        }
    }
}