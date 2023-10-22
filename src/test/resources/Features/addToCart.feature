Feature: Add To Cart
  Scenario: Add Product Cart
    Given login success in saucedemo website
    When User click button Add to Cart in list product
    And User click icon cart
    Then Show Page the selected product
