# Use Case: 10	Generate all the cities in a country that sorted from largest to smallest population

## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want to generate a report that list all the cities in a country that are organized by largest to smallest population to get easy access to the population information.

### Scope
Organization (black box)
### Level
Primary
### Preconditions
Obtain dataset of all information of world
### Success End Condition
Analyst receives the requested report of all the cities in a country that are sorted from largest to smallest.
### Failed End Condition
Analyst does not receive desired result or receive incorrect report
### Primary Actor
Analyst
### Trigger
Respective users request analyst to report desired information

## MAIN SUCCESS SCENARIO
1.  The request from analyst is received
2.  The lists of all cities in a country that are sorted from largest to smallest population from the database are fetched
3.  All fetched data are sorted.
4.  The data is displayed to the analyst

### EXTENSIONS
-  2.Incorrect data from database are fetched.
    - The request is sent again.
-  4.The data is not shown to analyst.
    - The request is sent again.

## SCHEDULE
Due Date: 2/2/2024

