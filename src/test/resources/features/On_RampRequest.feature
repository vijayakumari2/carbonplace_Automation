Feature: verify cp is able to accept the request

  Background:
    Given I open a 'Chrome' Browser
    And   I go to URL
    Then  I validate landing page title
    And   I verify CP Landing page - 'Welcome'
    When  I Click on Log in button in Landing Page
    Then  I verify Cp Login page - 'Sign up'


  Scenario Outline:  verify cp is able to accept the request
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Projects'
    When  I click on menu button
    And   I click on onRampRequest button
    Then  I verify page with- 'On-Ramp Requests'
    When  I search with Project Id-'1218'
    Then  I verify Project Details in OnRampRequest Page -'1218','project'
    And   I click on view button
     Examples:
      | Email Address | Password |
      |carbon-place-dev-issuer@yopmail.com|Password123|