Feature: Search and place the order foe products

@PlaceOrder
Scenario Outline: Search experience for product search in both home and offers page

Given User is on Greencart Landing page
When user searched with shortname <Name> and etracted actual name of product
And Added "3" items of the selected product to cart
Then user proceeds to checkout and validate the <Name> items in checkout page
And verify user has the ability to enter promo code and place the order


Examples:
| Name |
| Tom  |