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
       
    