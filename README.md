# Codetest Application

##Overview

The Codetest application uses the Github Jobs API to retrieve a listing of jobs.
The application is designed to return job statistics as shown below. At present, 
the application searches for 10 languages (c#, python, java, ruby, node, groovy, 
javascript, swift, scala, rust) in 7 cities 
(Boston, San Francisco, Los Angeles, Denver, Boulder, Chicago, New York).

- New York
    - c#
		- Full Time    20 %
	- python
		- Full Time    31 %
	- java
		- Full Time    25 %
	- javascript
		- Full Time    20 %
	- ruby
		- Full Time    2 %
- Chicago
	- c#
		- Full Time    14 %
	- javascript
		- Full Time    71 %
	- ruby
		- Full Time    14 %


##Requirements
- This project requires Java 8 and Maven

##Run the application
- Clone the repository
- In the root of the project, run the Maven goal spring-boot:run
    - Run the Maven goal test to run unit tests

##Roadmap
Future versions of this application could include the following:
- User input for city and language (or a subset)
- Refactoring for better testing
- Additional output methods such as file or HTML