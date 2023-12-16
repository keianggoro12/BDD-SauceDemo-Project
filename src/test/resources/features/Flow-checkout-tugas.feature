@BDDSauceDemoFlow
Feature: Product Ordering: User Authentication, Item Selection, Price Validation, and Order Confirmation

@ProductOrderingJourney
  Scenario: User successfully completes the product ordering process
  Given User already on login page
  When User login with valid "standard_user" username and "secret_sauce" password
  Then User now already on inventory page
  When User sort product from "Price (low to high)"
  And User clicks on the "Sauce Labs Onesie" and "Sauce Labs Bike Light" products to add them to the cart, ensuring a seamless transition to the cart page
  Then User ensures that the selected product is in accordance with what has been selected, namely "Sauce Labs Onesie" and "Sauce Labs Bike Light"
  When User removes one of the products that has been put into the cart in this case is "Sauce Labs Bike Light"
  And User click checkout button
  And User inputs valid personal information "wadaw" "wadidaw" with postal code "14420"
  Then Verify the price of product "Sauce Labs Onesie" should be equal to the total price
  And Verify the tax value should be equal to 8% of the total price
  And Verify the total payment should be equal to the total product price plus tax
  When User clicks the finish button
  Then User has completed their order
  When User back to inventory page
  



