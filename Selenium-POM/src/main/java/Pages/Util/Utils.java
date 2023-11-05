package Pages.Util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Utils {
    public static FluentWait waitASpecificAmountOfTime(WebDriver driver, int totalWaitTime, int pollingTime) {
        return new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(totalWaitTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
    }

    public static void clickOnSpecificItemButton(List<WebElement> products, List<WebElement> addToCartButtons, String itemName) {
        for (int i = 0; i < products.size(); i++) {
            String currentItemName = products.get(i).getText();
            if (itemName.equals(currentItemName)) {
                addToCartButtons.get(i).click();
                return;
            }
        }
        throw new IllegalArgumentException("Item with name " + itemName + " was not found");
    }
}
