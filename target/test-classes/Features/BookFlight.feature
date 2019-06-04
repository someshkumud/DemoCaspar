Feature: Book Flight Feature

  Scenario: Book one way flight for single passenger
    Given I navigate to the login page
    And I enter the following for Login
      | username | password |
      | om       | om       |
    And I click login button
    And I select trip type "One Way"
    And I select number of passengers as "1"
    And I select departing from "Frankfurt"
    And I select departing on "22/09"
    And I select arriving in "London"
    And I select service class as "Economy class"
    And I click Continue button
    Then I should see the userform page
