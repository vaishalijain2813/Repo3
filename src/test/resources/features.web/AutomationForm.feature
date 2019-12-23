Feature: Fill Automation Practice Form

  Scenario: Fill Practice-Form
    Given user go to practice form
    And fill up the new account form with the following data
      | FirstName | LastName | Date        | Gender | YearOfExperience | Profession    | AutomationTool     | Continents | ContinentsMultiple | SeleniumCommands    |
      | Vaishali  | Jain     | 16-Dec-2019 | Female | 2                | Manual Tester | Selenium Webdriver | Europe     | Europe             | Navigation Commands |
    Then User choose File To Upload
    Then User Submit Form

