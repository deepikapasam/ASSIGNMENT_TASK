Feature: Title of your feature
  I want to use this template for my feature file

  Background: 
    Given user launches browser

  @smoke
  Scenario: Check the links populating in the homepage
    When user acces the homepage
    Then menu links should display
      | Bausparen | Finanzieren | Rechner | Services | Meine Wohnwelt | Kontakt |

  @smoke
  Scenario Outline: verify user is able to  navigate to respective page
    When user acces the homepage
    And user click on <page> and  verify the respective <urlvalue>

    Examples: 
      | page             | urlvalue         |
      | 'Bausparen'      | 'Bausparen'      |
      | 'Finanzieren'    | 'Finanzieren'    |
      | 'Rechner'        | 'Rechner'        |
      | 'Services'       | 'Services'       |
      | 'Meine Wohnwelt' | 'Meine Wohnwelt' |
      | 'Kontakt'        | 'Kontakt'        |

  @regression
  Scenario: Check the download functionality
    When user acces the homepage
    When user click on "Finanzieren"
    Then user click on download file

  @regression
  Scenario: Verify search functionality
    When user acces the homepage
    And search "Immobilie bewerten"
    Then Observe the data

  @regression
  Scenario: Check the calculator functionality
    When user acces the homepage
    And user click on "Rechner"
    Then user click on emi calculator

