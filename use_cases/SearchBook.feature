Feature: Search about suitable book

  Background: The System has a repository of books with their specifications (title-author-ISBN-Signature)
    Given  the following book is a data in the system

      | Property    | value                            |
      | title       | Test-Drivenest Driven Development|
      | author      | Kent Beck                        |
      | ISBN        | 9780321146533                    |
      | Signature   | Beck2002                         |

    And the following book is a data in the system

      | Property    | value                            |
      | title       | The Paris Library                |
      | author      | Janet Skeslien Charles           |
      | ISBN        | 9781982134198                    |
      | Signature   | Charles2002                      |


  Scenario Outline: Search book by title
    When user OR administrator search about book by title "<title>"
    Then A list of books that matches specifications "<result>" should be returned and printed on the console

    Examples:
      | title             | result |
      | The Paris Library | found  |


  Scenario Outline: Search about book by ISBN
    When user OR administrator search about book by ISBN "<ISBN>"
    Then A list of books that matches specifications "<result>" should be returned and printed on the console

    Examples:
      | ISBN              | result |
      | 9781982134198     | found  |

  Scenario Outline: Search book by author
    When user OR administrator search about book by author "<author>"
    Then A list of books that matches specifications "<result>" should be returned and printed on the console

    Examples:
      | author | result |
      | Janet  | found  |


  Scenario Outline: Searching also works when the user/administrator is logged in
    Given there is an user logged in with "Aya_Abu3li" and "123456"
    When user OR administrator search about book by title "<title>"
    Then A list of books that matches specifications "<result>" should be returned and printed on the console
    Examples:
      | title        | result     |
      | Midnight      | found      |
      | Development  | not found  |


  Scenario Outline: No books match the criteria (substring)
    When user OR administrator search about book by author "<author>"
    Then A list of books that matches specifications "<result>" should be returned and printed on the console

    Examples:
      | author  | result     |
      | Waseem  | not found  |
      | Aya     | not found  |

  Scenario Outline: Find more than one book
    When user OR administrator search about book by title "<title>"
    Then A list of books that matches specifications "<result>" should be returned and printed on the console
    Examples:
      | title        | result     |
      | Library      | found      |

