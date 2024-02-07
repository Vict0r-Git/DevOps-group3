# Use Case: 1 	Organize countries in the world from largest to smallest populations

----------------------
## CHARACTERISTIC INFORMATION
### Goal in Context: 
As an analyst, I want to generate a report that will list all the countries in the world, sorted from largest to smallest population to get easy access to the population information.
### Scope: 
Organization (Black Box)
### Level: 
Primary
### Preconditions: 
Obtain dataset of all information of the world
### Success End Condition: 
Analyst receives the requested report of countries sorted from largest to smallest by population
### Failed End Condition: 
Analyst does not receive desired result or receive incorrect report
### Primary Actor: 
Analyst
### Trigger: 
Respective users request analyst to report desired information.

----------------------
### MAIN SUCCESS SCENARIO
1.	The request from analyst is received.
2.	The lists of countries in the world from the database are fetched.
3.	All data are sorted.
4.	The data is displayed to the analyst.
----------------------
### EXTENSIONS
-  2.Incorrect data from database are fetched.
    - The request is sent again.
-  4.The data is not shown to analyst.
    - The request is sent again.

### SCHEDULE
Due Date: 2/2/2024

