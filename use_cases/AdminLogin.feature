Feature: Admin login

  Scenario Outline: Administrator can log in with valid credentials
    Given there is an admin in login page
    When user logs in with valid username "<username>" And valid password "<password>"
    Then User should get logged in and Message "<Status>" printed on the console Login Successfully

    Examples:
      | username      | password | Status               |
      | Aya_Abu3li    | 123456   | Login Successfully   |
      | Waseem_ghazal | 12356    | Login Successfully   |

  Scenario Outline: Administrator has the wrong password
    Given there is an user in login page
    When user logs in with valid username "<username>" And invalid password "<password>"
    Then User should not log in And stay in the login page and Message "<Status>" printed on the console Login failed
    Examples:
      | username      | password | Status       |
      | Aya_Abu3li    | 123455   | Login failed |
      | Waseem_ghazal | 123451   | Login failed |