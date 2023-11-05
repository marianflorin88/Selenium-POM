package StepDefinitions;

import Pages.Inventory.InventoryPage;
import Pages.Login.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static StepDefinitions.StepDefinitions.driver;

public class Issue38StepDefinition {
    InventoryPage inventoryPage = new InventoryPage(driver);
    private StepDefinitions stepDefinitions = new StepDefinitions();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("problem user is on inventory page {string}")
    public void inventory_page(String inventoryUrl) {
        driver.get(inventoryUrl);
    }

    @When("adding the {string} to the inventory page")
    public void addingItemtoShoppingCart(String itemName) {
        inventoryPage.addItemToCart(itemName);
    }

    @And("the user clicks the Remove button to remove the item from the inventory page")
    public void assertShoppingCartBadgeCountIncreased() {
        inventoryPage.addItemToCart("Sauce Labs Backpack");

    }


    @Then("the button label changes from Remove to {string}")
    public void theButtonLabelChangesFromRemoveToAddToCart(String expectedBtnLabel) {
        String actualButtonLabel = inventoryPage.returnButtonLabel();
        Assert.assertEquals(actualButtonLabel, expectedBtnLabel);

    }

    @And("the item is successfully removed from the inventory page")
    public void theItemIsSuccessfullyRemovedFromTheInventoryPage() {
        boolean isShoppingCartBadgeCountDisplayed = inventoryPage.returnIsShoppingCartBadgeDisplayed();
        Assert.assertFalse(isShoppingCartBadgeCountDisplayed);
    }
}
