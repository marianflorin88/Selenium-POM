package Inventory;

import Base.InventoryBase;
import Pages.Inventory.InventoryPage;
import TestData.Purchase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryHappyPathTests extends InventoryBase {

    @Test(description = "Standard user adds sauce labs backpack to shopping cart.", dataProvider = "valid-purchases", dataProviderClass = InventoryBase.class)
    public void testAddSauceLabsBackpackToCart(Purchase purchase) {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart(purchase.getProductName());

        String actualButtonLabel = inventoryPage.returnButtonLabel();
        String shoppingCartBadgeCount = inventoryPage.returnShoppingCartBadgeCount();
        boolean isShoppingCartBadgeCountDisplayed = inventoryPage.returnIsShoppingCartBadgeDisplayed();

        Assert.assertEquals(actualButtonLabel, purchase.getExpectedButtonLabel());
        Assert.assertTrue(isShoppingCartBadgeCountDisplayed);
        Assert.assertEquals(shoppingCartBadgeCount, purchase.getExpectedNumberOfItemsInCart());
    }
}