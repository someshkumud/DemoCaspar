Feature: QA Task Feature
#  This feature deals with the assigned QA Task on the Caspar application

  Scenario: Perform QA Task as instructed
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

