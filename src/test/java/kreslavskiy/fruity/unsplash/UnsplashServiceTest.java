package kreslavskiy.fruity.unsplash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnsplashServiceTest
{
    @Test
    public void getUnsplash()
    {
        //given
        UnsplashService service =  new UnsplashServiceFactory().create();

        //when
        Photos photos = service.search("strawberry").blockingGet();


        //then
        assertNotNull(photos.results[0].urls.small);
    }
}