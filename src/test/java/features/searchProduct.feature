Feature: Search and place the order foe products

@OfferPage
Scenario Outline: Search experience for product search in both home and offers page

Given User is on Greencart Landing page
When user searched with shortname <Name> and etracted actual name of product
Then user searched for <Name> shortname in offers page 
And validate product name in offers page  matches with Landing Page

Examples:
| Name |
| Tom  |
| Beet |