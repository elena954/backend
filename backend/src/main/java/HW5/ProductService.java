package HW5;
import HW5.model.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import file.db.model.Products;

import java.util.List;

public interface ProductService {
    @GET("products")
    Call<List<Products>> getProducts();

    @GET("products/{id}")
    Call<Products> getProduct(@Path("id") Integer id);

    @POST("products")
    Call<Products> createProduct(@Body Product createProductRequest);

    @PUT("products")
    Call<Products> updateProduct(@Body Products updateProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);


}