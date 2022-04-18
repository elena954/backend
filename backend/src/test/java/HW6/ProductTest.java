package HW6;

import HW5.CategoryService;
import HW5.DbUtils;
import HW5.ProductService;
import HW5.model.*;
import com.github.javafaker.Faker;
import file.db.dao.CategoriesMapper;
import file.db.dao.ProductsMapper;
import file.db.model.Products;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;
import retrofit2.Retrofit;


import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
public class ProductTest {
    final Integer wrongProductId = -1;
    Integer productId;

    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    static ProductsMapper productsMapper;
    static CategoriesMapper categoriesMapper;

    Product product;

    Faker faker = new Faker();

    @BeforeAll
    static void BeforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
        productsMapper = DbUtils.getProductsMapper();
        categoriesMapper = DbUtils.getCategoriesMapper();
    }

    @BeforeEach
    void setUp() throws IOException {
        product = new Product()
                .withTitle(faker.food().dish())
                .withPrice((int) (((Math.random() + 1)) * 100))
                .withCategoryTitle("Food");

        Response <Products> response = productService.createProduct(product).execute();
        productId = Math.toIntExact(Objects.requireNonNull(response.body()).getId());
    }

    @Test
    @DisplayName("Получение списка продуктов")
    void getProductTest() throws IOException {
        Response<List<Products>> response = productService.getProducts().execute();
        log.info(Objects.requireNonNull(response.body()).toString());
        assertThat(response.body().size(), CoreMatchers.not(0));
    }

    @Test
    @DisplayName("Получение продукта по ID")
    void getProductByIdPositiveTest() throws IOException {
        Response<Products> response = productService.getProduct(productId).execute();
        log.info(Objects.requireNonNull(response.body()).toString());
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
        assertThat(response.body().getTitle(), equalTo(product.getCategoryTitle()));
        Products productDB = productsMapper.selectByPrimaryKey(productId.longValue());
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
    }

    @Test
    @DisplayName("Получение продукта по ошибочному ID")
    void getProductByIdNegativeTest() throws IOException {
        Response<Products> response = productService.getProduct(wrongProductId).execute();
        assertThat(response.code(), equalTo(404));
        ErrorMessage errorMessage = RetrofitUtils.convertBody(response, ErrorMessage.class);
        if (errorMessage != null) {
            assertThat(errorMessage.getMessage(), equalTo("Unable to find product with id: " + wrongProductId));
        }
        assertNull(productsMapper.selectByPrimaryKey(wrongProductId.longValue()));
    }

    @Test
    @DisplayName("Создание продукта")
    void postProductTest() throws IOException {
        Response<Products> response = productService.createProduct(product).execute();
        log.info(Objects.requireNonNull(response.body()).toString());
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
    }

    @Test
    @DisplayName("Получение категорий по ID")
    void getCategoryByIdTest() throws IOException {
        Integer id = CategoryType.FOOD.getId();
        Response<Category> response = categoryService.getCategory(id).execute();
        log.info(Objects.requireNonNull(response.body()).toString());
        assertThat(response.body().getTitle(), equalTo(CategoryType.FOOD.getTitle()));
        assertThat(response.body().getId(), equalTo(id));
    }

    @Test
    @DisplayName("Создание пустого продукта")
    void createNewProductEmptyFieldsTest() throws IOException {
        Response<Products> response = productService.createProduct(new Product()).execute();
        log.info(Objects.requireNonNull(response.errorBody()).string());
        assertThat(response.code(), equalTo(500));
    }

    @Test
    @DisplayName("Создание продукта c длинным именем")
    void createNewProductLongTitleTest() throws IOException {
        Response<Products> response = productService
                .createProduct(new Product().withTitle(faker.lorem().fixedString(5000)))
                .execute();
        log.info(Objects.requireNonNull(response.errorBody()).string());
        assertThat(response.code(), equalTo(500));
    }

    @Test
    @DisplayName("Удаление продукта")
    void deleteProductTest() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(productId).execute();
        productId = null;
        assertNull(response.errorBody());
    }

    @Test
    @DisplayName("Удаление несуществующего продукта")
    void deleteNotExistsProductTest() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(wrongProductId).execute();
        log.info(Objects.requireNonNull(response.errorBody()).string());
        assertThat(response.code(), equalTo(500));
    }

    @Test
    @DisplayName("Обновление продукта")
    void updateProductTest() throws IOException {
        Product newProduct = new Product()
                .withId(productId)
                .withCategoryTitle(CategoryType.FOOD.getTitle())
                .withPrice((int) (Math.random() * 1000 + 1))
                .withTitle(faker.food().ingredient());
        Response<Products> response = productService.updateProduct(newProduct).execute();
        log.info(Objects.requireNonNull(response.body()).toString());
        assertThat(response.body().getId(), equalTo(productId));
        assertThat(response.body().getPrice(), equalTo(newProduct.getPrice()));
        assertThat(response.body().getTitle(), equalTo(newProduct.getTitle()));
        assertThat(response.body().getTitle(), equalTo(newProduct.getTitle()));
    }

    @Test
    @DisplayName("Обновление продукта с ошибочным ID")
    void updateProductTestNegative() throws IOException {
        Product newProduct = new Product()
                .withId(wrongProductId)
                .withCategoryTitle(CategoryType.FOOD.getTitle())
                .withPrice((int) (Math.random() * 1000 + 1))
                .withTitle(faker.food().ingredient());
        Response<Products> response = productService.updateProduct(newProduct).execute();
        assertThat(response.code(), equalTo(400));
        ErrorMessage errorMessage = RetrofitUtils.convertBody(response, ErrorMessage.class);
        if (errorMessage != null) {
            assertThat(errorMessage.getMessage(), equalTo("Product with id: " + wrongProductId + " doesn't exist"));
        }
        assertNull(productsMapper.selectByPrimaryKey(wrongProductId.longValue()));
    }

    @AfterEach
    void tearDown() {
        if (productId != null) {
            productsMapper.deleteByPrimaryKey(productId.longValue());
        }
    }

}
