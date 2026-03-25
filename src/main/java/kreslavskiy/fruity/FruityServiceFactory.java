package kreslavskiy.fruity;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class FruityServiceFactory
{
    public FruityService create()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.fruityvice.com/")
                // Configure Retrofit to use Gson to turn the Json into Objects
                .addConverterFactory(GsonConverterFactory.create())
                // Configure Retrofit to use Rx
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        return retrofit.create(FruityService.class);
    }
}
