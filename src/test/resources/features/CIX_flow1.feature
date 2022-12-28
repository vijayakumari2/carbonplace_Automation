Feature: CIX flow

  Background:
    Given I open a 'Chrome' Browser
    And   I go to URL
    Then  I validate landing page title
    And   I verify CP Landing page - 'Welcome'
    When  I Click on Log in button in Landing Page
    Then  I verify Cp Login page - 'Sign up'


  Scenario Outline: Verify seller is able to update the listing on CP UI and same is getting reflected in CIX UI
  Given I enter '<seller_Email_Address>' and '<seller_Password>' in Cp Login Page

    Examples:
      | seller_Email_Address | seller_Password |
      | axis_seller@mailinator.com   | Test@123 |


#


#    Then I verify Active listings projects have update button
#    Given I click on update button
#    Then I verify whether application is navigating to update page or not
#    Given I enter '<price>'  other than integers
#    Then I verify validation message for price
#    And I enter '<quantity>'
#    And I select the confirm check box
#    And I click on update listing button
#    Then I verify Confirm update listing pop up window
#    And  I click on update listing button on pop up window
#    Then I verify whether application is navigating to Listing confirmation page or not
#    Then I verify whether credits are displaying on CIX website or not