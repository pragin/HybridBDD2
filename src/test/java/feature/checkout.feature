Feature: Checkout

  As a registered user, I should be able to buy a product successfully

  Scenario: User should be able to buy a product successfully
    Given user is already registered
    When  user hovers over  category "Computers" in main menu
    And user clicks on submenu "Desktops"
    Then user should see desktop page
    When user clicks on Build your own computer heading
    Then user should see Build your own computer page
    When user select the relevant configuration
    And user clicks on the add to card button
    Then The product should have been added to the cart successfully
    When user clicks on Shopping cart button
    And user agrees to terms and conditions
    When user clicks on Checkout button
    Then user should see the checkout page
    When user fills billing address form
    And user fills shipping method form
    And user selects credit card as the payment type
    And user fills payment information form
    And user confirms order




