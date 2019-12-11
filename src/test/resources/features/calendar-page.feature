# new feature
# Tags: optional

Feature: Out base test for calendar

  Scenario: Load Calendar
    Given google page is loaded
    When I switch to "Calendar" page
    Then Calendar page is loaded successfully
