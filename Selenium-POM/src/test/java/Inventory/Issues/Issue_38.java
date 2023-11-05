package Inventory.Issues;

import Base.InventoryBase;
import Base.LoginBase;
import Pages.Inventory.InventoryPage;
import Pages.Login.LoginPage;
import TestData.Purchase;
import TestData.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Issue_38 extends LoginBase {

    @Test(priority = -1, description = "Test problem_user can remove items from cart.", dataProvider = "issue-38-purchase", dataProviderClass = InventoryBase.class)
    public void testLoginSuccessWithValidUsernames(Purchase purchase) {
        User user = new User("problem_user", "secret_sauce");
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());

        inventoryPage.addItemToCart(purchase.getProductName());
        inventoryPage.addItemToCart(purchase.getProductName());
        String actualButtonLabel = inventoryPage.returnButtonLabel();
        String shoppingCartBadgeCount = inventoryPage.returnShoppingCartBadgeCount();
        boolean isShoppingCartBadgeCountDisplayed = inventoryPage.returnIsShoppingCartBadgeDisplayed();

        Assert.assertEquals(actualButtonLabel, purchase.getExpectedButtonLabel());
        Assert.assertFalse(isShoppingCartBadgeCountDisplayed);
        Assert.assertEquals(shoppingCartBadgeCount, purchase.getExpectedNumberOfItemsInCart());
    }
}
