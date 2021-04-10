@Boutique @Performance
Feature: Boutique reliability
  As a user I want list boutique with smoothly

  Scenario Outline: Boutique url's status code
    Given user is on home page
    When user is listed all Boutique on "<PageUrl>" with "<PCount>"
    And user update Boutique information in a file "<PageUrl>""<PCount>"
    Examples:
      | PageUrl                | PCount |
      | Home                   |        |

  @Manual
  @Manual:Passed
  @manual-last-tested:sprint-1
  Scenario: Boutique details should be valid
    Given Boutique url's status code Test result is created
    Then tester reads Boutique status and permormance information
    And Boutique status should be 200
    And Boutique performance should be valid