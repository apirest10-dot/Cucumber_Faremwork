@tag
Feature: Suppliers and Customer
As admin user i want to test supplier and customer modules

  Background: Successful Login
    Given User is on the Login Page
    When User enters username "admin" and password "master"
    And clicks on Login button
    Then Dashboard should be displayed

  @Suppliers
  Scenario Outline: add supplier
    As admin user i want to validate add supplier with multiple data

    When user should navigate to add supplier page
    And Capture Supplier number
    And user enter supplier details "<sname>","<address>","<city>","<country>","<cperson>","<pnumber>","<email>","<mnumber>","<notes>"
    And user click add button
    And user click confirm ok
    And user click alert ok button
    And user should search for supplier number
    Then user should validate supplier number in table
    When user close browser

    Examples:
      | sname      | address   | city     | country | cperson   | pnumber    | email         | mnumber    | notes |
      | Dell Corp1 | Street 12 | New York | USA     | Akhiles61 | 1234567890 | dell@test.com | 9876543210 | High  |
      | Dell Corp2 | Street 13 | New York | USA     | Akhiles71 | 1234567890 | dell@test.com | 9876543210 | High  |
      | Dell Corp3 | Street 14 | New York | USA     | Akhiles31 | 1234567890 | dell@test.com | 9876543210 | High  |
      | Dell Corp4 | Street 15 | New York | USA     | Akhiles81 | 1234567890 | dell@test.com | 9876543210 | High  |
      | Dell Corp5 | Street 16 | New York | USA     | Akhiles31 | 1234567890 | dell@test.com | 9876543210 | High  |

  @Customer
  Scenario Outline: add  customer
As admin user i want to validate add customer with multiple data

    When user should navigate to add customer page
    And Capture customer number
    And user enter customer details "<cname>","<address>","<city>","<country>","<cperson>","<pnumber>","<email>","<mnumber>","<notes>"
    And user click add button
    And user click confirm ok
    And user click alert ok button
    And user should search for customer number
    Then user should validate customer number in table
    When user close browser

    Examples:
      | cname    | address | city   | country | cperson | pnumber    | email          | mnumber    | notes  |
      | Alice W1 | Lane 55 | London | UK      | Alice   | 1122334455 | alice@test.com | 5544332211 | Retail |
      | Alice W3 | Lane 57 | London | UK      | Alice   | 1122334455 | alice@test.com | 5544332211 | Retail |
      | Alice W5 | Lane 56 | London | UK      | Alice   | 1122334455 | alice@test.com | 5544332211 | Retail |
      | Alice W5 | Lane 54 | London | UK      | Alice   | 1122334455 | alice@test.com | 5544332211 | Retail |
