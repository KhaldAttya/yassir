package api;

import core.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import web.pages.PageFactory;

import java.time.Duration;

public class APITestBase {


    protected String baseUrl = "https://api.weatherstack.com/";
    protected String endpoint = "/current";
    protected String accessKey;
    protected ConfigLoader configLoader;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        configLoader = new ConfigLoader("src/test/java/config.properties");
        accessKey = configLoader.getProperty("accessKey");
    }
}
