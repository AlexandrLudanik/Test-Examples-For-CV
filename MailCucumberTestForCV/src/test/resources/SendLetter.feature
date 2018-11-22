Feature: Test send letter page

  Scenario: Test positive sendLetter page
    Given I am on main application page4
    When I login as correct user4
    Then I click button write letter4
    Then I write address and message4
    Then I click button send letter4
    Then I see message what message send4
    Then close browser4