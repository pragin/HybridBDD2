Feature: Category

  Scenario Outline: As a user, I should be able to navigate through different category pages

    Given User is on homepage
    When user hovers over  category "<category>" in main menu
    And user clicks on submenu
    Then verify user is on  url "<url>" accordingly
    And verify the title "<title>" of the page
    Examples:
      | category    | url                                      | title       |
      | Computers   | https://demo.nopcommerce.com/computers   | Computers   |
      | Electronics | https://demo.nopcommerce.com/electronics | Electronics |
      | Apparel     | https://demo.nopcommerce.com/apparel     | Apparel     |
      | Books       | https://demo.nopcommerce.com/books       | Books       |
