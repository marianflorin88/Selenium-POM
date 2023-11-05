package CheckoutInformation;

import Base.LoginBase;
import Pages.Cart.ShoppingCartPage;
import Pages.CheckoutInformation.CheckoutInformationPage;
import Pages.Inventory.InventoryPage;
import Pages.Login.LoginPage;
import TestData.Purchase;
import TestData.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutInformationPositiveTests extends LoginBase {

    @Test(priority = 1, description = "Test checkout information with valid credentials.", dataProvider = "checkout-information", dataProviderClass = LoginBase.class)
    public void testCheckoutInformationSucces(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
        InventoryPage inventoryPage = new InventoryPage(driver);
        String product = "Sauce Labs Backpack";

        inventoryPage.addItemToCart(product);
        inventoryPage.goToCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        shoppingCartPage.clickCheckOutButton();
        checkoutInformationPage.submitCheckoutInformation(user.getFirstName(), user.getLastName(), user.getPostalCode());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }
}
