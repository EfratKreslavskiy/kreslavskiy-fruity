package kreslavskiy.fruity.unsplash;

import static org.junit.jupiter.api.Assertions.*;

import com.andrewoid.apikeys.ApiKey;
import org.junit.jupiter.api.Test;

class UnsplashServiceTest
{
    @Test
    public void getUnsplash()
    {
        //given
        ApiKey apiKey = new ApiKey();
        String keyString = apiKey.get();
        UnsplashService service =  new UnsplashServiceFactory().create();

        //when
        Photos photos = service.getUnsplash(
                keyString,
                "strawberry"
        ).blockingGet();

        //then
        assertNotNull(photos.results()[0].urls().small());
    }
}