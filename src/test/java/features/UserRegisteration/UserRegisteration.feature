Feature: User Registration
  As a user I want to check that I can register in JUMIA website.

  Scenario Outline: User Registration
    Given user Open the Browser then go to JUMIA Home page
    When I try to open registration page
    And I enter "<emailOrPhone>" , "<password1>" , "<confirmPassword1>" , "<firstName>" , "<lastName>" , "<Phone>" , "<BirthDate>"
    Then The registration will be done successfully

    Examples:

      | emailOrPhone           | password1       | confirmPassword1 |  | firstName  | lastName | Phone       | BirthDate |
      | FLairsTech@outlook.com | test@1234#2023  | test@1234#2023   |  | Mahamoud   | Saad     | 01115678910 | 1251990   |
      | FLairsTeech@gmail.com  | test2@1234#2023 | test2@1234#2023  |  | FLairsTech | Mahmoud  | 01115678911 | 1261991   |


