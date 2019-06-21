@Tag1
Feature: Search SecurePay and fill the contact us form
#Scenario
  Scenario Outline: Search SecurePay and fill the contact us form scenario

    Given I Search for <searchWord> on website <url>
    When I Click through to the SecurePay website
    Then I Navigate to the contact us page
    And I Verify that the contact us page is loaded
    And I use randomly generated data to fill in the contact us form



    Examples:
      |url|searchWord|
      |https://www.google.com/|SecurePay|


