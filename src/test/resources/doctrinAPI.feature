Feature: API test to process covid19 data.

  Scenario: Test to get covid19 data from API response.
    Given Acccess and get the response of the covid API for country "GR"
    Then Get the date when the number of infections was the highest and the count
    And Get the date when the number of deaths was the highest and the count