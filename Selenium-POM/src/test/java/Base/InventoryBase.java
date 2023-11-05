package Base;

import Pages.Login.LoginPage;
import TestData.Purchase;
import TestData.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class InventoryBase {

    public static WebDriver driver;
    public String url = "https://www.saucedemo.com/";
    private LoginPage loginPage;
    private User user;

    @DataProvider(name = "valid-purchases")
    public Object[][] returnValidPurchases() {
        return new Object[][] {
                { new Purchase("Sauce Labs Backpack", "Remove", "1") },
                { new Purchase("Sauce Labs Bike Light", "Remove", "1") }
        };
    }

    @DataProvider(name = "issue-38-purchase")
    public Object[][] returnValidPurchase() {
        return new Object[][] {
                { new Purchase("Sauce Labs Backpack", "Add to cart", "0") }
        };
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        final String driverChrome = "webdriver.chrome.driver";
        final String chromeDriverAddress = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        System.setProperty(driverChrome, chromeDriverAddress);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(url);

        loginPage = new LoginPage(driver);
        user = new User("standard_user", "secret_sauce");
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests are completed, webdriver is closing.");
        driver.quit();
    }

}