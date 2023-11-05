package Pages.Inventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

import static Pages.Inventory.Locators.*;
import static Pages.Util.Utils.clickOnSpecificItemButton;
import static Pages.Util.Utils.waitASpecificAmountOfTime;

public class InventoryPage {

    private WebDriver driver;
    @FindBy(className = ADDTOCARTBTNLOCATOR)
    private List<WebElement> addToCartButtons;

    @FindBy(how = How.CSS, using = REMOVEFROMCARTBTNLOCATOR)
    private WebElement removeFromCartButton;

    @FindBy(how = How.CSS, using = SHOPPINGCARTCOUNTERLOCATOR)
    private WebElement shoppingCartCounter;

    @FindBy(className = PRODUCTSLOCATOR)
    private List<WebElement> products;
    @FindBy(how = How.CSS, using = GOTOCARTLOCATOR)
    private WebElement goToCartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart(String itemName) {
        clickOnSpecificItemButton(products, addToCartButtons, itemName);
    }
    public void goToCart() {
        goToCartIcon.click();
    }

    public String returnButtonLabel() {
        FluentWait wait = waitASpecificAmountOfTime(driver, 45, 5);

        if(wait.until(ExpectedConditions.visibilityOf(removeFromCartButton)) == null) {
            return "No label with expected text found!";
        } else {
            return removeFromCartButton.getText();
        }
    }

    public String returnShoppingCartBadgeCount() {
        return shoppingCartCounter.getText();
    }

    public boolean returnIsShoppingCartBadgeDisplayed() {
        return shoppingCartCounter.isDisplayed();
    }
}