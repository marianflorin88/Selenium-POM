package StepDefinitions;

import Pages.Inventory.InventoryPage;
import Pages.Login.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static StepDefinitions.StepDefinitions.driver;

public class ShoppingCartStepDefinitions {

    private StepDefinitions stepDefinitions = new StepDefinitions();
    private LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    @Given("standard user is on inventory page {string}")
    public void inventory_page(String inventoryUrl) { //numele metodei este mult prea generic. Va rog sa respectati clean code intotdeauna
        driver.get(inventoryUrl);
    }

    @When("adding the {string} to the shopping cart")
    public void addingItemtoShoppingCart(String itemName){
        inventoryPage.addItemToCart(itemName);
    }
    @Then("the buton label changes from Add to cart to Remove")
    public void assertShoppingCartBadgeCountIncreased(){
        String shoppingCartBadgeCount = inventoryPage.returnShoppingCartBadgeCount();
        boolean isShoppingCartBadgeCountDisplayed = inventoryPage.returnIsShoppingCartBadgeDisplayed();
        Assert.assertTrue(isShoppingCartBadgeCountDisplayed);
        Assert.assertEquals(shoppingCartBadgeCount, "1");
    }
    @And("the shopping cart number is increased to one")
    public void assertButtonChangeLabel(){
        String actualButtonLabel = inventoryPage.returnButtonLabel();
        Assert.assertEquals(actualButtonLabel, "Remove");
    }


}