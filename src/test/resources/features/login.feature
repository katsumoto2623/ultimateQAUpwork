
@wip
Feature: Ultimate QA Login Feature
  User Story:
  As a user, I should be able to successfully login the ultimate QA Website
  and navigate to the profile page,
  update user details, and verify the updates.


  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the login page


  Scenario: Login as user
    When user enters username
    And user enters password
    Then user should see the dashboard

    Scenario: User should navigate to profile page and update the information.
      When user goes to profile page
      And user can update company name as "Ultimate QA"
      Then company name should be same




