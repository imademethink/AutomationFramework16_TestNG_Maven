Feature: Demo of Cucumber integration with TestNG - part 5

# Below scenario will fail on purpose
@registration_fail
Scenario: User registration with incorrect provided data
  Given User navigates to registration screen only
  When User attempts to register with invalid data
