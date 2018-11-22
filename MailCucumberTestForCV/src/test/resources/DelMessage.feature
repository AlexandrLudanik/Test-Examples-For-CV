Feature: Test delete message page

  Scenario: Test positive delMessage page
    Given I am on main application page2
    When I login as correct user2
    Then I click checkBox
    Then I click button delete
    Then I see message what letter delete
    Then close browser2