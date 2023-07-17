Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check search functionality
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that current url contains 'q=armani' text

    Examples:
      | homePage              | keyword  |
      | https://www.asos.com/ | Armani   |

  Scenario Outline: Check open cart
    Given User opens '<homePage>' page
    And User checks cart icon visibility
    When User clicks on cart icon
    Then User checks that current url contains 'bag' text

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check add cart error message
    Given User open '<shopWomanPage>' page
    When User makes search by '<keyword>'
    And User clicks on search button
    Then User checks that current url contains 'q=dress' text
    And User clicks on product
    And User click on Add to Bag button
    Then User checks that error Message is '<errorMessage>'

    Examples:
      | shopWomanPage              | keyword | errorMessage                                             |
      | https://www.asos.com/women/ | Dress  | Please select from the available colour and size options |

  Scenario Outline: Check sorting functionality
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that current url contains 'q=dress' text
    Then User clicks on Sort Button
    And User select sort option
    Then User checks that current url contains '<sort>' text

    Examples:
      | homePage              | keyword | sort           |
      | https://www.asos.com/ | Dress   | sort=freshness |

  Scenario Outline: Check wishlist
    Given User opens '<homePage>' page
    When User clicks on Man Tab
    Then User hover on category
    And User clicks on selected category
    And User clicks on wishlist icon
    Then User goes to Wishlist page
    Then User checks that page contains '<wishList>'

    Examples:
      | homePage               | wishList    |
      | https://www.asos.com/  | Saved Items |

  Scenario Outline: Check search for incorrect input
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that error message is '<errorMessage>'

    Examples:
      | homePage               | keyword                                | errorMessage                                             |
      | https://www.asos.com/  | gfhdgfjhefjgtegrfgmvygmhgfvhmjfn323445 | NOTHING MATCHES YOUR SEARCH |

  Scenario Outline: Check amount of products in cart
    Given User opens '<homePage>' page
    When User clicks on Man Tab
    Then User hover on category
    And User clicks on selected category
    And User select some product
    And User configure product
    And User add product to cart
    Then User check that amounts of products in cart is '<amountOfProducts>'

    Examples:
      | homePage               | amountOfProducts   |
      | https://www.asos.com/  | 1                  |

  Scenario Outline: Check cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User select and click on product
    And User select size
    And User add product to cart
    When User hover on mini cart icon
    And User clicks on View Bag button
    Then User checks that cart contains '<header>'

    Examples:
      | homePage               | keyword        | header   |
      | https://www.asos.com/  | Sweater        | MY BAG   |

  Scenario Outline: Go to My Account Page
    Given User opens '<homePage>' page
    When User hover on Account button
    And User clicks on My Account link
    Then User checks that current url contains '<query>' text

    Examples:
      | homePage               | query        |
      | https://www.asos.com/  | login?signin |

  Scenario Outline: Check Sign In Process
    Given User opens '<homePage>' page
    When User hover on Account button
    And User clicks on My Account link
    When User enter '<email>' into email field
    And User enter '<password>' into password field
    And User clicks Sign In button
    Then User checks that current page contains '<myAccount>' header

    Examples:
      | homePage               | email             | password   | myAccount   |
      | https://www.asos.com/  | ivkaloz@gmail.com | Aa12345678 | MY ACCOUNT  |

