Feature: Login functions
  As user I want to login the web site

  Background:
    Given user is on home page
    When user clicks on Sign in button from header
    Then user is displayed login page

  Scenario Outline: Login fail - possible combinations
    When user enters "<E-Mail>" and "<Password>"
    And user clicks Sign in button
    Then user gets login failed error "<ErrorMessage>"

    Examples:
      | E-Mail                   | Password | ErrorMessage                               |
      | wrongemail0020@gmail.com | 123456   | E-posta adresiniz ve/veya şifreniz hatalı. |
      | wrongemailformat         | 123456   | Lütfen geçerli bir e-posta adresi giriniz. |
      | mail0020@gmail.com       |          | Lütfen şifrenizi giriniz.                  |
      |                          | 123456   | Lütfen geçerli bir e-posta adresi giriniz. |
      |                          |          | Lütfen geçerli bir e-posta adresi giriniz. |


  Scenario: Success Login
    When user enters "yahyak.kara@gmail.com" and "test#case123"
    And user clicks password eye button
    Then user can display password
    And user clicks Sign in button
    Then user is displayed home page
    Then user is seen his name on the login menu "Yahya Kemal Kara"