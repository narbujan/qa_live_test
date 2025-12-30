Feature: Test some random things

  Scenario: It can save and read a message from test context
    Given I have saved the message "hello from cucumber" in test context
    When I change the message to "again hello" in test context
    Then the message is displayed
    And the message should not be "hello from cucumber"
    And the message should be "again hello"

  Scenario: It can execute api request
    Given I request post with ID 1
    Then the title should be at least 10 characters long

  @ui
  Scenario: It can visit mintos home page
    Given I have opened mintos homepage
    Then I should see login button

