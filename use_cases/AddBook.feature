Feature: Add book

  Scenario Outline: Add a book when the administrator is logged in
    Given there is Administrator "<username>" loggedin with "<password>"
    When Administrator call add book function with valid parameters "<title>" , "<author>" , "<ISBN>" and "<Signature>"
    Then The book added and Message printed on the console the book added successfully

    Examples:
      | title                             | author                  | ISBN          | Signature    | username      | password |
      | Test-Drivenest Driven Development | Kent Beck               | 1476765995 | Beck2002     | Aya_Abu3li    | 123456   |
      | The Paris Library                 | Janet Skeslien Charles  | 1250077036 | Charles2002  | Waseem_ghazal | 12356    |

  Scenario Outline: Add a book when the administrator is not logged in
    Given there is no Administrator logged in with this "<username>" and "<password>"
    When Administrator can not call add book function
    Then The book can not be added and Message printed on the console book can not be add because you are not logged in

    Examples:
      | username      | password |
      | Aya_Abu3li    | 123456   |
      | Waseem_ghazal | 12356    |