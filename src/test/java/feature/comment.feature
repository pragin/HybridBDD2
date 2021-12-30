Feature: Comment

  As a registered user, I should be able to post a comment

  @test
  Scenario: As a registered user, I should be able to post a comment successfully
    Given user is already registered
    And User is on homepage
    When user click on details button
    And user fills comments form
    And clicks on new comment button
    Then the user should see the comment has been posted successfully

