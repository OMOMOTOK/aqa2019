Feature: Out base test for youtube

    Scenario: Load Youtube
        Given google page is loaded
        When I switch to "Youtube" page
        Then Youtube page loaded successfully

    Scenario: Search
        Given Youtube page is loaded
        When I search for video "Mammamia"
        Then Youtube video found!