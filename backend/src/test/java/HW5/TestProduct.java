package HW5;

import HW5.model.ProductsResponse;
import HW5.model.ProductsResponseRequest;
import HW5.model.paramsId;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import HW3.BaseTest;

import java.io.IOException;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.lessThan;

public class TestProduct extends BaseTest{

    private static final String BASE_URL = "minimarket1.herokuapp.com/market/api/v1/products";

    private static Client client;

    @BeforeAll
    static void beforeAll(){
        RestAssured.baseURI = BASE_URL;

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(3000L))
                .build();

        client = new Client();
    }


    @Test
    void testAddendum() throws IOException {
        ProductsResponse products = client.addendum(
                ProductsResponseRequest.builder()
                        .id(1)
                        .title("Bread")
                        .price(100)
                        .categoryTitle("Food")
                        .build()
        );

        String expected = getResourceAsString("Error.json");

        JsonAssert.assertJsonEquals(
                expected,
                products,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }
    @Test
    void testModifyProduct() throws IOException {
        ProductsResponseRequest product = client.modifyProduct(
                ProductsResponseRequest.builder()
                        .id(186)
                        .title("meat")
                        .price(100)
                        .categoryTitle("Food")
                        .build()
        );
        String expected = getResourceAsString("product.json");

        JsonAssert.assertJsonEquals(
                expected,
                product,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }

    @Test
    void testReturnsASpecificProduct() throws IOException {
        ProductsResponseRequest product = client.returnsASpecificProduct(
             paramsId.builder()
                     .id(186)
                     .build()
        );
        String expected = getResourceAsString("product1.json");

        JsonAssert.assertJsonEquals(
                expected,
                product,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }
}
