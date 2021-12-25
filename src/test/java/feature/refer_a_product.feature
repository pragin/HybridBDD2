Feature: Refer a product

  As a registered use, I should be able to refer a product to a friend
  @test
  Scenario: A registered user should be able to refer a product to a friend

    Given user is on registration page
    When user enters required registration details
    And click on register submit button
    Then user should able to register successfully
    Then user clicks on computers main menu
    And user clicks on desktop heading
    And user clicks on Build your own computer heading
    Then user should see Build your own computer page
    And user clicks on Email a friend button
    Then user should see email a friend page
    When user fills the form
    And clicks on send email button
    Then user should see the email has been successfully sent message
