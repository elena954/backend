package HW5;

import HW5.model.ProductsResponse;
import HW5.model.ProductsResponseRequest;
import retrofit2.Call;
import retrofit2.http.*;

public interface MiniMarket {

    @POST("api/v1/products")
    Call<ProductsResponse> addendum(
            @Query("id") Integer id,
            @Query("title") String title,
            @Query("price") Integer price,
            @Query("categoryTitle") String categoryTitle

    );

    @PUT("/api/v1/products")
    Call<ProductsResponseRequest> modifyProduct(
            @Query("id") Integer id,
            @Query("title") String title,
            @Query("price") Integer price,
            @Query("categoryTitle") String categoryTitle
    );

    @GET("/api/v1/products/{id}")
    Call<ProductsResponseRequest> returnsASpecificProduct(
            @Query("id") Integer id
    );

}
