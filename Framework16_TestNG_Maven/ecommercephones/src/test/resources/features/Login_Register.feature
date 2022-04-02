Feature: Demo of Cucumber integration with TestNG - part 2

  @login @login_repeat_N_times
  Scenario Outline: Login happy path case repeat N times
    Given User navigates to login screen using "chrome" browser
    When User attempts to login with Username "<username>" and Password "<password>"
    Then Login should be successful

    Examples:
      |username                        | password           |
  #    |creativity2020@mailinator.com | creativity2020@@  |
  #    |creativity2021@mailinator.com | creativity2021@@  |
      |creativity2022@mailinator.com | creativity2022@@  |


  @registration
  Scenario: User registration with provided data
    Given User navigates to registration screen
    When User attempts to register with following data
      | Email            | fake  |
      | Title            | Mr    |
      | NameFirst        | James |
      | NameLast         | Bond  |
      | Password         | Fake@12345 |
      | DOB_DD           | 1      |
      | DOB_MM           | 1      |
      | DOB_YYYY         | 2020   |
      | AddressNameFirst | James |
      | AddressNameLast  | Bond  |
      | Address          | MG Road PO box 007 |
      | City             | Darjiling |
      | State            | Ohio   |
      | Zip              | 33160  |
      | AdditionalInfo  | Test account |
      | Mobile           | 9876543210   |
    Then Registration should be successful
