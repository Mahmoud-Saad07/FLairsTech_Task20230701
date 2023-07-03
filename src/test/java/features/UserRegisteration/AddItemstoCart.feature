Feature: Adding Items to The Cart
  As a Logged in user I want to check that I can Add Items to my CART in JUMIA website.

  Background: Opening the Browser then go to JUMIA Website
    Given user Open the Browser then go to JUMIA Home page

  Scenario Outline: Add to CART
    When User log in with Valid Credentials "<emailOrPhone>" , "<password>"
    Then I try to Select Category from the Home page
    And I add Two Items to the CART
    And the Items will be added to the CART and subtotal is calculated correctly
    And I Will Remove the Added Items from Cart


    Examples:

      | emailOrPhone          | password       |
      | FLairsTch@outlook.com | test@1234#2023 |