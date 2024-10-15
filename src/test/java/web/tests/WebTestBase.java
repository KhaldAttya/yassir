package web.tests;

import core.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.pages.PageFactory;

import java.time.Duration;

public class WebTestBase {

    protected static PageFactory page;
    protected static WebDriver driver;
    private static String baseUrl = "https://www.saucedemo.com/";
    protected ConfigLoader configLoader;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        page = new PageFactory(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(baseUrl);
        configLoader = new ConfigLoader("src/test/java/config.properties");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();
    }

}
