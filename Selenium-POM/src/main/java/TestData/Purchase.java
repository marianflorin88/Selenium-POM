package TestData;

public class Purchase {
    private String productName;
    private String expectedButtonLabel;
    private String expectedNumberOfItemsInCart;

    public Purchase(String productName, String expectedButtonLabel, String expectedNumberOfItemsInCart) {
        this.productName = productName;
        this.expectedButtonLabel = expectedButtonLabel;
        this.expectedNumberOfItemsInCart = expectedNumberOfItemsInCart;
    }

    public String getProductName() {
        return productName;
    }

    public String getExpectedButtonLabel() {
        return expectedButtonLabel;
    }

    public String getExpectedNumberOfItemsInCart() {
        return expectedNumberOfItemsInCart;
    }
}