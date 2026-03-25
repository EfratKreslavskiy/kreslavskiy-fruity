package kreslavskiy.fruity;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface FruityService
{
    @GET("https://fruityvice.com/api/fruit/Strawberry")
    Single<Fruit> getFruit();




}
