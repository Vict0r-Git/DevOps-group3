# Use Case: 25 Generate population of people living in the cities and people not living in cities in each country.

## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want to generate a comprehensive report on the population of people living in the cities and people not living in cities in each country to get easy access to the population information.
### Scope
Organization (black box)
### Level
Primary
### Preconditions
Obtain dataset of all information of world
### Success End Condition
Analyst receives the requested report of population of people living in the cities and people not living in cities in each country.
### Failed End Condition
Analyst does not receive desired result or receive incorrect report.
### Primary Actor
Analyst
### Trigger
Respective users request analyst to report desired information.

## MAIN SUCCESS SCENARIO
1. The request from analyst is received
2.  The lists of people living in the cities and people not living in cities in each country from the database are fetched
3.  All fetched data are sorted.
4.  The data is displayed to the analyst

### EXTENSIONS
- 2.Incorrect data from database are fetched.
    - The request is sent again.
- 4.The data is not shown to analyst.
    - The request is sent again.

## SCHEDULE
Due Date: 2/2/2024



