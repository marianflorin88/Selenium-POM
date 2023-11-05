package Pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static Pages.Login.Locators.*;
import static Pages.Util.Utils.waitASpecificAmountOfTime;

public class LoginPage {
    private final WebDriver driver;
    @FindBy(how = How.CSS, using = USERNAMEINPUTFIELDLOCATOR)
    private WebElement userNameInputField;
    @FindBy(how = How.CSS, using = PASSWORDINPUTFIELDLOCATOR)
    private WebElement passwordInputField;
    @FindBy(how = How.CSS, using = SUBMITBUTTONLOCATOR)
    private WebElement loginFormSubmitBtn;
    @FindBy(how = How.CSS, using = ERRORMESSAGELOCATOR)
    private WebElement loginErrorMessage;

    @FindBy(how = How.CSS, using = LOGINFORMLOCATOR)
    private WebElement loginForm;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeUsername(String username) {
        userNameInputField.sendKeys(username);
    }

    public void writePassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public void submitLoginForm() {
        loginFormSubmitBtn.click();
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        writeUsername(username);
        writePassword(password);
        submitLoginForm();
    }

    public String returnLoginErrorMessage() {
        FluentWait wait = waitASpecificAmountOfTime(driver, 45, 5);

        if (wait.until(ExpectedConditions.visibilityOf(loginErrorMessage)) == null) {
            return "No error text found!";
        } else {
            return loginErrorMessage.getText();
        }
    }
}
