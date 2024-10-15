package api;

import api.models.LocationWeather;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherTest extends APITestBase {

    String city = "Cairo";
    String lat;
    String lon;

    @Test()
    public void getLocationCurrentWeatherByNameTest(){

        LocationWeather locationWeather = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .queryParam("access_key",accessKey)
                .queryParam("query", city)
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .as(LocationWeather.class);

        Assert.assertEquals(locationWeather.getLocation().getName(),city);
        lat = locationWeather.getLocation().getLat();
        lon = locationWeather.getLocation().getLon();
    }

    @Test(dependsOnMethods = "getLocationCurrentWeatherByNameTest")
    public void getLocationCurrentWeatherByLongAndLatTest(){
        LocationWeather locationWeather = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .queryParam("access_key",accessKey)
                .queryParam("query", lat +","+lon)
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .as(LocationWeather.class);

        Assert.assertEquals(locationWeather.getLocation().getName(),city);
    }
}
