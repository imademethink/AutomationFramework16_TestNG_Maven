Feature: Demo of Cucumber integration with TestNG - part 4

@search_special_1
Scenario: User searches for valid E-commerce items
  When User attempts to search for "valid" ecommerce item
  Then Successful ecommerce search results "should be" shown

@search_special_2
Scenario: User searches for invalid E-commerce items
  When User attempts to search for "invalid" ecommerce item
  Then Successful ecommerce search results "should NOT be" shown

