package HW5;

import HW5.model.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static final String API_URL = "https://minimarket1.herokuapp.com/market/";

    private MiniMarket api;

    public Client(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.api = retrofit.create(MiniMarket.class);
    }

    public ProductsResponse addendum(
            ProductsResponseRequest request
    ) {
        Call<ProductsResponse> responseCall = api.addendum(
                request.getId(),
                request.getTitle(),
                request.getPrice(),
                request.getCategoryTitle()
        );
        return ResponseUtils.executeCall(responseCall);
    }

    public ProductsResponseRequest modifyProduct(
           ProductsResponseRequest request
    ) {
        Call<ProductsResponseRequest> responseCall = api.modifyProduct(
                request.getId(),
                request.getTitle(),
                request.getPrice(),
                request.getCategoryTitle()
        );
        return ResponseUtils.executeCall(responseCall);
    }

    public ProductsResponseRequest returnsASpecificProduct(
            paramsId request
    ) {
        Call<ProductsResponseRequest> responseCall = api.returnsASpecificProduct(
                request.getId()
        );
        return ResponseUtils.executeCall(responseCall);
    }

}
