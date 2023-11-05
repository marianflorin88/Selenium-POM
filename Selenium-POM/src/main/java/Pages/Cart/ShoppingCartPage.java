package Pages.Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static Pages.Cart.Locators.*;

public class ShoppingCartPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = SHOPPINGCARTBADGECOUNTLOCATOR)
    private WebElement shoppingCartBadgeCount;
    @FindBy(how = How.CSS, using = PRODUCTSLOCATOR)
    private WebElement productItem;
    @FindBy(how = How.CSS, using = PRODUCTSLOCATOR)
    private WebElement removeFromCart;
    @FindBy(how = How.CSS, using = CONTINUESHOPPINGBTNLOCATOR)
    private WebElement continueShoppingButton;
    @FindBy(how = How.CSS, using = CHECKOUTBTNLOCATOR)
    private WebElement checkOutButton;
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSpecificButton(WebElement element )
    {element.click();}

    public void clickOnRemoveButton ()
    {clickOnSpecificButton(removeFromCart);}

    public void clickOnContinueShoppingButton ()
    {clickOnSpecificButton(continueShoppingButton);}

    public void clickCheckOutButton ()
    {clickOnSpecificButton(checkOutButton);}

}