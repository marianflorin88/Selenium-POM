Feature: Removing Sauce Labs Backpack from inventory page
  As a problem user
  I want to remove Sauce Labs Backpack from my inventory page
  So that the item is not longer displayed into the inventory page

  Scenario: Remove the "Sauce Labs Backpack" from the inventory page
  Given user is on home page
  And is logged in with "problem_user"
  When adding the "Sauce Labs Backpack" to the inventory page
  And the user clicks the Remove button to remove the item from the inventory page
  Then the button label changes from Remove to "Add to Cart"
  And the item is successfully removed from the inventory page