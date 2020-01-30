Feature: My home project

  Scenario Outline: login facebook page
    When I navigate to facebook login page and enter "<User Name>", "<Password>"
    Examples:
      | User Name              | Password   |
      | sairamchary83@yahoo.in | dornala123 |
    Then I validate the login is sucessful