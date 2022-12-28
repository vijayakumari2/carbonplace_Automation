Feature: On_Ramp credits

  Background:
    Given I open a 'Chrome' Browser
    And   I go to URL
    Then  I validate landing page title
    And   I verify CP Landing page - 'Welcome'
    When  I Click on Log in button in Landing Page
    Then  I verify Cp Login page - 'Sign up'


  Scenario Outline: Verify User is able to create a project
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Portfolio'
    When  I click on menu button
    When  I click on OnRampCredits option
    Then  I verify on-ramp projects page-'On-Ramp Carbon Credits'
    When  I click on selected Registry
    And   I enter '<projectID>'
    And   I click on CreateNewProject
    Then  I verify carbonCredit page-'New Carbon Credit'
    When  I enter the  '<projectName>'


    Examples:
      | Email Address | Password |projectID|projectName|
      |mohiddin.shaik_seller@yopmail.com|Uat2022!|1109|test|


  Scenario Outline: Verify User is able to on ramp the credits for a project
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Portfolio'
    When  I click on menu button
    When  I click on OnRampCredits option
    Then  I verify on-ramp projects page-'On-Ramp Carbon Credits'
    When  I click on selected Registry
    And   I enter  existed '<projectID>'
    And   I select the required project
    And   I enter the '<vintage>'
    And   I enter the value of  '<quantity>'
    And   I click OnRampCredits button

    Examples:
      | Email Address | Password | projectID |vintage|quantity|
      |mohiddin.shaik_seller@yopmail.com|Uat2022!|autoupdate|2005|100|