Feature: Administrator logs out

  Scenario Outline: Administrator logs out
    Given there is Administrator "<username>" logged in with "<password>"
    When Administrator call logout function
    Then Administrator should get logged out to login page and Message printed on the console Logout successfully
Examples:
    | username      | password |
    | Aya_Abu3li    | 123456   |
    | Waseem_ghazal | 12356    |


