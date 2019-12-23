Feature:Login the Taxonomy Page.

  Scenario Outline: Perform all possible negative scenarios for login functionality
    Given User on taxonomy login page
    When user enter "<username>" and "<password>" and verify "<errormessage>"
    Examples:
      | username        | password     | errormessage                                                       |
      | taxonomy.admin  | Superuser@12 | Sign in failed!                                                    |
      | taxonomy.admin1 | Superuser@1  | Sign in failed!                                                    |
      | taxonomy.admin1 | Superuser@12 | Sign in failed!                                                    |
      |                 |              | We found some errors. Please review the form and make corrections. |
      | taxonomy.admin  |              | We found some errors. Please review the form and make corrections. |
      |                 | Superuser@1  | We found some errors. Please review the form and make corrections. |