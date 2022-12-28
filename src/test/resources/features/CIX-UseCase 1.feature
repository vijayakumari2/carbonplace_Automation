Background:
    Given I open a 'Chrome' Browser
    And  I go to URL
    Then I validate landing page title
    And I verify CP Landing page - 'Welcome'
    When I Click on Log in button in Landing Page
    Then I verify Cp Login page - 'Sign up'
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And I click on Conitune button
    Then I verify Home Page - '<Email Address>' 
    
    Examples:
      | Email Address          | Password |
      | anw-seller@yopmail.com | Uat2022! |
    
 @tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
