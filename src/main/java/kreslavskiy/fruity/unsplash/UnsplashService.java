package kreslavskiy.fruity.unsplash;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Query;
import retrofit2.http.GET;

public interface UnsplashService
{
    @GET("/search/photos")
    Single<Photos> search(@Query("query") String query);
}