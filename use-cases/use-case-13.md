# Use Case: 13 	Generate a report of all top 15 populated cities in the continents

----------------------
## CHARACTERISTIC INFORMATION
### Goal in Context: 
As an analyst, I want to generate a report on top 15 populated cities in a continent to get easy access to the population information.
### Scope: 
Organization (Black Box)
### Level: 
Primary
### Preconditions: 
Obtain dataset of all information of world
### Success End Condition: 
Analyst obtains the report of top 15 populated cities in all continents.
### Failed End Condition: 
Analyst does not receive desired result or receive incorrect report
### Primary Actor: 
Analyst
### Trigger: 
Respective users request analyst to report desired information

----------------------
### MAIN SUCCESS SCENARIO
1.	The request from analyst is received
2.	The lists of cities in the continents from the database are fetched
3.	15 data of cities are sorted
4.	The data is displayed to the analyst

### EXTENSIONS
-  2.Incorrect data from database are fetched.
   - The request is sent again.
-  4.The data is not shown to analyst.
   - The request is sent again.
----------------------
### SCHEDULE
Due Date: 2/2/2024