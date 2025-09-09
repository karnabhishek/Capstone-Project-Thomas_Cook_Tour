Feature: Australia Tour Package Booking on Thomas Cook

  As a potential traveler
  I want to book an Australia tour package through the Thomas Cook website
  So that I can finalize my holiday plans seamlessly

  @All @LoginTest
  Scenario Outline: Verify User Login functionality
    Given the user has launched the Thomas Cook website
    When User clicks on "Login" dropdown and then the "Login" button
    And user enters email "<email>" and clicks on "Get OTP" button
    And User clicks the final "Login" button       
    And User hovers the cursor to "Holidays" and clicks on "Australia Tour Packages"
    And User selects a specific "Amazing Australia - Winter" package
    And User selects a travel date
    And User clicks on "Calculate Price Package"
    And the system should respond with the "Package Price" page
    And User reviews the package price and clicks on continue
    And  the system should respond with the "Booking Summary" page
    And User reviews the Booking Summary and clicks "Continue" twice
    And the system should take the user to the "Traveller Details" page
    And user enters Traveller1 details: "<T1_FirstName>" "<T1_LastName>" and "<T1_PassportNo>"
    And user enters Traveller2 details: "<T2_FirstName>" "<T2_LastName>" and "<T2_PassportNo>"
    And user enters Address for communication: "<Addr_FirstName>" "<Addr_LastName>" "<Address>" "<Pincode>"
    And user checks the box to add this passenger as a payer
    And user enters PAN details: "<PAN_Name>" "<PAN_DOB>" "<PAN_Number>"
    And user clicks on "Verify"
    Then the system should respond with the message "Invalid Pan Card"

    Examples:
    |           email             | expected_login_result | T1_FirstName | T1_LastName | T1_PassportNo | T2_FirstName | T2_LastName | T2_PassportNo | Addr_FirstName | Addr_LastName | Address | Pincode | PAN_Name | PAN_DOB    | PAN_Number  |
    |abhishekkumarkarn83@gmail.com|           Abhishek    | Rahul        | Kumar       | 123456        | Abhishek     | Kumar       | 654321        | Rahul          | Kumar         | Patna   | 847226  | Rahul    | 12-09-2002 | SEOAK7575B  |
    


    

  



