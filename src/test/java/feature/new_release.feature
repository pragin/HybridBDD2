Feature: Comment on new release

  User should be able to post a comment successfully
  @test
  Scenario: user should be able to post a comment
    When user click on details button
    And user fills comments form
    And clicks on new comment button
    Then the user should see the comment has been posted successfully

