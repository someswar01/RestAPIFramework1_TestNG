#Feature: Product API Automation
#
#  Background:
#    Given User is authenticated
#
#  Scenario: Verify Add Product API
#    When User adds a product
#    Then Product should be created successfully
#
#  Scenario: Verify Create Order API
#    When User creates an order
#    Then Order should be created successfully
#
#  Scenario: Verify Get Order Details API
#    When User gets order details
#    Then Order details should be returned
#
#  Scenario: Verify Delete Product API
#    When User deletes the product
#    Then Product should be deleted successfully

#Feature: Product API
#
#  Scenario: Complete Product Flow
#
#    Given User is logged into the application
#
#    When User adds a product
#    Then Product should be created successfully
#
#    When User creates an order
#    Then Order should be created successfully
#
#    When User gets order details
#    Then Order details should be returned
#
#    When User deletes the product
#    Then Product should be deleted successfully

Feature: Product API

  Scenario: Complete Product Flow

    When User adds a product
    Then Product should be created successfully

    When User creates an order
    Then Order should be created successfully

    When User gets order details
    Then Order details should be returned

    When User deletes the product
    Then Product should be deleted successfully