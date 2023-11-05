Feature: SauceLabs Shopping Cart
  As a standard user
  I want to add the "sauce labs backpack" to my shopping cart
  So that I can purchase it later

  Scenario: Adding the "sauce labs backpack" to the shopping cart
    Given user is on home page
    And is logged in with "standard_user"
    When adding the "Sauce Labs Backpack" to the shopping cart
    Then the buton label changes from Add to cart to Remove
    And the shopping cart number is increased to one
