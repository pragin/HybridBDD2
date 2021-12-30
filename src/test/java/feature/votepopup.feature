Feature: community poll

  As an unregistered user, I should not be able vote
  @test
  Scenario: Unregistered users should not be able to vote
    Given User is on homepage
    When user clicks on vote button
    Then an alert should pop asking to choose an option


