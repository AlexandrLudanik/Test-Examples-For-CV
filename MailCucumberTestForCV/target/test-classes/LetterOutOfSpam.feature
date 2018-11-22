Feature: Test letter out of spam page


  Scenario: Test positive letterOutOfSpam page
    Given I am on main application page3
    When I login as correct user3
    Then I click spam link3
    Then I click checkbox3
    Then I click button no spam3
    Then I see info message3
    Then close browser3