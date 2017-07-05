#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Amazon Search

  @tag1
  Scenario Outline: Amazon Search for Nikon D3X
    Given Open "<url>" in Firefox browser
    And Enter Nikon in Search bar
    And I click on search button
    And select sort results from highest to lowest
    When I select the second result for Nikon
    Then Product Title should text as Nikon D3X

    Examples: 
      | url                      |
      | https://www.amazon.com   |
