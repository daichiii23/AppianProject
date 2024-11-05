Feature: Login to Appian environment and navigate Tempo tabs

  Scenario: Login to Appian environment and navigate Tempo tabs
    Given I setup with "CHROME" browser
    When I set Appian URL to "https://via-appiaph-dev.appiancloud.com/suite"
    And I set Appian version to "24.3"
    And I set Appian locale to "en_US"
    And I login with username "shawn.relova@via-appia.ph"
    Then I navigate to site "kaizen-registry"
    And I click on button "Create Request"
    And I populate field "Process Gaps" with "Test Shawn 5 Multiple Uploads"
    And I populate field "Description" with "Cucumber Testing"
    And I populate field "Suggested Target Date" with "10/25/2026"
    And I populate field "Affected Department/s" with "Legal"
    And I populate field "Affected Department/s" with "Sales"
    And I populate field "Strategic Objective/s" with "F1 - Achieve Revenue Target"
    And I populate field "Strategic Objective/s" with "F5 - People Activities"
    And I populate field type "FILE_UPLOAD" named "[1]" with "C:\\Users\\Shawn Relova\\Downloads\\fortesting.xlsx"
    And I click on button "SUBMIT"
    And I wait for "10" seconds
    And I tear down
