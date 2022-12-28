@Login
Feature: Login in to the application
      Verifying Landing Page,Login Page and Home Page

  Background:
    Given I open a 'Chrome' Browser
    And  I go to URL
    Then I validate landing page title
    And I verify CP Landing page - 'Welcome'
    When I Click on Log in button in Landing Page
    Then I verify Cp Login page - 'Sign up'
    

  @ValidLogin-1
  Scenario Outline: Login in with valid login details
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And I click on Continue button
    Then I verify Home Page - '<Email Address>' 
    
    Examples:
      | Email Address          | Password |
      | anw-seller@yopmail.com | Uat2022! |
      | cpbroker@mailinator.com  | Test@123 |
      
  @PasswordMasking-2
  Scenario Outline: Verify whether user is able to see and hide password
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And I click on 'show' password button
    Then I verify '<Password>' 'visibility'
    And I click on 'hide' password button
    Then I verify '<Password>' 'invisibility'
    
    Examples:
      | Email Address          | Password |
      | anw-seller@yopmail.com | Uat2022! |
    
   @Invalid-3
  Scenario Outline: Login in with invalid login details
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And I click on Conitune button
    Then I verify for 'Wrong email or password' error message
      
    Examples:
      | Email Address          | Password |
      | anw-seller@yopmail | Uat2022 |


  @Login-4-NegativeScenrio @skip
  Scenario Outline: In login Page,clicking on submit button without entering Email Address and Password
    Given I dont enter Email Address and Password in Cp Login Page and I click on Conitune button
    Then I verify for proper error message

      
     @Login-5-NegativeScenrio @skip
  Scenario Outline: Login in with invalid Email Address amd valid Password
    Given I enter invalid '<Email Address>' and valid '<Password>' in Cp Login Page
    And I click on Conitune button
       Then I verify for 'Wrong email ' error message
       Examples:
         | Email Address          | Password |
         | anw-selle@yopmail.com | Uat2022! |


  @Login-6-NegativeScenrio @skip
  Scenario Outline: Login in with valid Email Address amd invalid Password
    Given I enter valid '<Email Address>' and invalid '<Password>' in Cp Login Page
    And I click on Conitune button
    Then I verify for 'Wrong  password' error message
      
    Examples:
      | Email Address          | Password |
      | anw-seller@yopmail.com | Uat2022 |
