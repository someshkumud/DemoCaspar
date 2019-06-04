Feature: LoginFeature
#  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
#    Given default properties loded into hashmap
    Given Launch browser and navigate to Caspar
    And user log into Casper
    And user adds a Patient and set credentials in default properties
    And user log out from Caspar
    And close browser
    And Launch browser and navigate to Caspar
    And user log into Casper
    And navigate to release of medical information page
    And verify visibility of medical information page and close it
    And navigate to terms and conditions page
    And verify visibility of terms and conditions page and close it

