Feature: Demo of Cucumber integration with TestNG - part 3

Background:
  Given User navigates to search screen

@search_valid @search
Scenario: User searches for valid E-commerce items
  When User attempts to search for "valid" item
  Then Successful search results "should be" shown

@search_invalid @search
Scenario: User searches for invalid E-commerce items
  When User attempts to search for "invalid" item
  Then Successful search results "should NOT be" shown
