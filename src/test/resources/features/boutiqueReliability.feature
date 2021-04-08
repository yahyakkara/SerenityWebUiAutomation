Feature: Boutique reliability
  As a user I want list boutique with smoothly

  Scenario Outline: Boutique url's status code
    Given user is on home page
    When user is listed all Boutique on "<PageUrl>" with "<PCount>"
    And user update Boutique information in a file "<PageUrl>""<PCount>"
    Examples:
      | PageUrl                | PCount |
      | Home                   | 50     |
      | /butik/liste/erkek     | 50     |
      | /butik/liste/cocuk     | 50     |
      | /butik/liste/ev--yasam | 50     |