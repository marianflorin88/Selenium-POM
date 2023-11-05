package Base;
import TestData.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class LoginBase {
    public static WebDriver driver;
    public String url = "https://www.saucedemo.com/";

    @DataProvider(name = "valid-usernames")
    public Object[][] returnValidUsernames() {
        return new Object[][] {
                { "standard_user" },
                { "problem_user" },
                { "performance_glitch_user" }
        };
    }

    @DataProvider(name = "valid-accounts")
    public Object[][] returnValidAccounts() {
        return new Object[][] {
                { new User("standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html") },
                { new User("problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html") },
                { new User("performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html") },
        };
    }
    @DataProvider(name = "locked-out-user")
    public Object [][] returnLockedUsername(){
        return new Object[][]{
                { new User("locked_out_user", "secret_sauce", "https://www.saucedemo.com/", "Epic sadface: Sorry, this user has been locked out.") }
        };
    }
    @DataProvider(name = "inexistent-username")
    public Object [][] returnInvalidUsername(){
        return new Object[][]{
                { new User("valid_inexistent", "secret_sauce", "https://www.saucedemo.com/", "Epic sadface: Username and password do not match any user in this service") },
                { new User("asdawdawda", "secret_sauce", "https://www.saucedemo.com/", "Epic sadface: Username and password do not match any user in this service") },
                { new User("123123", "secret_sauce", "https://www.saucedemo.com/", "Epic sadface: Username and password do not match any user in this service") },
                { new User("!@#$%#@!", "secret_sauce", "https://www.saucedemo.com/", "Epic sadface: Username and password do not match any user in this service") },
        };
    }
    @DataProvider(name = "empty-username")
    public Object [][] returnEmptyUsernames(){
        return new Object[][]{
                { new User("", "secret_sauce", "https://www.saucedemo.com/", "Epic sadface: Username is required") }
        };
    }
    @DataProvider(name = "checkout-information")
    public Object [][] returnCheckoutInformation(){
        return new Object[][]{
                { new User("standard_user", "secret_sauce", "firstname", "lastname", "postalcode") }
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
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests are completed, webdriver is closing.");
        driver.quit();
    }
}