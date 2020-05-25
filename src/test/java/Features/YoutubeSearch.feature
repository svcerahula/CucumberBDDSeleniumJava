@UITesting
Feature: To Test the Youtube application's Search functionality
  Scenario Outline: Youtube search positive scenario
    Given open chrome browser and enter url
    When enter search criteria as "<searchString>"
    Then click on search button
    And Search results page should have title as "<title>"

    Examples:
    |searchString           |title                 |
    |selenium by bakkappa n |selenium by bakkappa n|
    |selenium by C#         |selenium by C#        |