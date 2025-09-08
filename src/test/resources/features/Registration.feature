Feature: User Registration for Thomas Cook

  @All @Positive
  Scenario: Successfull user registration using Excel data
    Given user is on registration page
    When user loads registration data from Excel "RegistrationData" of sheet "Sheet1" row 1
    And user click on Register button
    Then registration should be successful
    
  @All @Negative
   Scenario: User registration with invalid mobile number using Excel data
    Given user is on registration page
    When user loads registration data from Excel "RegistrationData" of sheet "Sheet1" row 2
    And user click on Register button
    Then user must see an error message "Please enter valid contact number"
    

    
    
    
   