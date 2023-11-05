package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StepDefinitions {

    public static WebDriver driver;
    public static String url = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        final String driverChrome = "webdriver.chrome.driver";
        final String chromeDriverAddress = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        System.setProperty(driverChrome, chromeDriverAddress);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @After
    public void tearDown() {
        System.out.println("Tests are completed, webdriver is closing.");
        driver.quit();
    }

}