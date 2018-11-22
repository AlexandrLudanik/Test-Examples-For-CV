Feature: Test send letter page

  Scenario: Test positive sendLetter page
    Given I am on main application page5
    When I login as correct user5
    Then I click button write letter5
    Then I click on receiver field5
    Then I click on receiver field5
    Then I write receivers5
    Then I write message5
    Then I click button send5
    Then I see what message send5
    Then close browser5