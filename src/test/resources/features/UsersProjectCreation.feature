Feature: users and project creation

  Background:
    Given I open a 'Chrome' Browser
    And   I go to URL
    Then  I validate landing page title
    And   I verify CP Landing page - 'Welcome'
    When  I Click on Log in button in Landing Page
    Then  I verify Cp Login page - 'Sign up'


  Scenario Outline:admin is able to create a bank
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Projects'
    When  I click on Client management page
    And   I click on Create new client button
    And   I click on Create new Bank option
    When  I enter '<Bank_Name>' value
    And   I enter a '<Admin_first_name>' value
    When  I enter the '<Admin_last_name>' value
    And   I entering '<Admin_email_address>' value
    When  I click on Create  bank button















    Examples:
      |  |