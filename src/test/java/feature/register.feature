Feature: Registration

  As a user, I was to register on DemoNopCommerce website
  So that, I can use all user features

  @test
  Scenario: User should be able to register successfully

    Given user is on registration page
    When user enters required registration details
    And click on register submit button
    Then user should able to register successfully
