Feature: Test send letter in spam page

  Scenario: Test positive send Letter In Spam page
    Given I am on main application page6
    When I login as correct user6
    Then I click checkBox6
    Then I click button spam6
    Then I see message what letter send in spam6
    Then close browser6