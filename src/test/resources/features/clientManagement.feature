Feature: Create a bank,broker,observer

  Background:
    Given I open a 'Chrome' Browser
    And   I go to URL
    Then  I validate landing page title
    And   I verify CP Landing page - 'Welcome'
    When  I Click on Log in button in Landing Page
    Then  I verify Cp Login page - 'Sign up'

  Scenario Outline: Verify CP can create new bank
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Projects'
    When  I click on menu button
    And   I click on Client management page
    And   I click on Create new client button
    And   I click on Create new Bank option
    When  I enter '<Bank_Name>' value
    And   I enter a '<Admin_first_name>' value
    When  I enter the '<Admin_last_name>' value
    And   I entering '<Admin_email_address>' value
    When  I click on Create  bank button
#    Then I verify bankname  with '<Admin_first_name>'and '<Admin_first_name>'

    Examples:
      | Email Address | Password | Bank_Name|Admin_first_name|Admin_last_name|Admin_email_address|
      |cp-cix-uat-jv@yopmail.com|Uat2022!|bank|test |automation|bankautomated@yopmail.com        |
  Scenario Outline: Verify CP can create new broker
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Projects'
    When  I click on menu button
    And   I click on Client management page
    And   I click on Create new client button
    And   I click on Create new Broker option
    When  I enter '<Broker_Name>' value
    And   I enter a '<Admin_first_name>' value
    When  I enter the '<Admin_last_name>' value
    And   I entering '<Admin_email_address>' value
    When  I click on Create  broker button
    Examples:
      | Email Address | Password | Broker_Name | Admin_first_name | Admin_last_name | Admin_email_address |
      |cp-cix-uat-jv@yopmail.com|Uat2022!|broker|broker |automation|brokerautomate@yopmail.com        |

  Scenario Outline: Verify CP can create new observer
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Projects'
    When  I click on menu button
    And   I click on Client management page
    And   I click on Create new client button
    And   I click on Create new Observer option
    When  I enter '<Observer_Name>' value
    And   I enter a '<Admin_first_name>' value
    When  I enter the '<Admin_last_name>' value
    And   I entering '<Admin_email_address>' value
    When  I click on Create  observer button
    Examples:
      | Email Address | Password | Observer_Name | Admin_first_name | Admin_last_name | Admin_email_address |
      |cp-cix-uat-jv@yopmail.com|Uat2022!|observer|observer |automation|observerautomation@yopmail.com        |

  Scenario Outline: verify CP can filter the  Results by using type
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Projects'
    When  I click on menu button
    And   I click on Client management page
    And   I click on type button
    And   I select on '<type>'
#    Then  I verify '<type>' is available

    Examples:
      | Email Address           | Password  | type |
      |cp-cix-uat-jv@yopmail.com|Uat2022!   |observer|

  Scenario Outline: verify CP can filter the  Results by using searchbox
    Given I enter '<Email Address>' and '<Password>' in Cp Login Page
    And   I click on Continue button
    Then  I verify Home Page - 'Projects'
    When  I click on menu button
    And   I click on Client management page
    And   I click on searchBox

#    Then  I verify '<type>' is available

    Examples:
      | Email Address           | Password  | type |
      |cp-cix-uat-jv@yopmail.com|Uat2022!   |observer|