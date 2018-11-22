Feature: Test clean basket page

  Scenario: Test positive cleanBasket page
    Given I am on main application page1
    When I login as correct user1
    Then I click basket link1
    Then I click button clear folder1
    Then I click button confirm1
    Then I see what basket is empty1
    Then close browser1
