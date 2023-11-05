package Pages.CheckoutInformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static Pages.CheckoutInformation.Locators.*;

public class CheckoutInformationPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = FIRSTNAMEINPUTFIELDLOCATOR)
    private WebElement firstNameField;
    @FindBy(how = How.CSS, using = LASTNAMEINPUTFIELDLOCATOR )
    private WebElement lastNameField;
    @FindBy(how = How.CSS, using = POSTALCODEFIELDLOCATOR )
    private WebElement postalCodeField;
    @FindBy(how = How.CSS, using = CONTINUEBTNLOCATOR )
    private WebElement continueButton;
    @FindBy(how = How.CSS, using =CANCELBTNLOCATOR  )
    private WebElement cancelButton;
    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void writeFirstName(String firstName)
    {firstNameField.sendKeys(firstName);}
    private void writeLastName(String lastName)
    {lastNameField.sendKeys(lastName);}
    private void writePostalCode(String postalCode)
    {postalCodeField.sendKeys(postalCode);}
    public void clickOnContinueButton()
    {continueButton.click();}
    public void clickOnCancelButton()
    {cancelButton.click();}
    public void submitCheckoutInformation(String firstName, String lastName, String postalCode){
        writeFirstName(firstName);
        writeLastName(lastName);
        writePostalCode(postalCode);
        clickOnContinueButton();
    }
}
