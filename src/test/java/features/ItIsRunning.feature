Feature: Cucumber tests are running

  Scenario: It can print a message from cucumber test
    Given I have saved the message "hello from cucumber" in test context
    When I change the message to "again hello" in test context
    Then the message is displayed
    And the message should not be "hello from cucumber"
    And the message should be "again hello"
