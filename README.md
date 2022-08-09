# Record Store

Project designed for SER322: Database Management at Arizona State University by group 18 for Summer Session B 2022.

## Description

Record Store is a database and application to aid record store employees. The system should allow 
employees to find what a customer is looking for. The database contains a list of records and their stock quantity
along with additional information about artists, songs, genres, etc.

## Schema

![Relational Schema for the Record Store Database Project](diagrams/RS.png)

## Initializing the Database

We have automated the initialization of the database with a gradle task.

Navigate to the record-store root directory in a terminal window and run the following command:

`gradle createDB -Purl="jdbc:mysql://localhost:3306/record-store?userSSL=false&useOldAliasMetadataBehavior=true" -Puser="root" -Ppwd="pass"`

### Parameters

1. **URL** - The URL for the database that you would like to interact with including host and port.
You must set userSSL to false as shown in the example in order to log in properly.
2. **Username** - The name of the user to connect with.
3. **Password** - The specified user's password.

### Task Description
Running the above task will execute four initialization scripts in order:

1. **Drop** - Drops preexisting tables that have names that exist in our schema.
   This ensures that when you run this task duplication does not occur.
2. **Create** - Creates all tables in our schema:
3. **Insert** - Populates the tables with the initial data provided.
4. **Lyrics** - Updates certain songs with their lyrics. This was done with a separate script to enhance readability.

## Environment

- MySQL 5.6
- Java 11.0.13
- Gradle 6.6.1
- JDBC 8.0.29

## Steps for Execution

1. 

## Video Presentations

- [Deliverable 3](https://www.youtube.com/watch?v=8NFbX4rywlE)
- Deliverable 4

## Contributors 

The members of group 18 are listed below along with their individual contributions.

### [Andrew Tonn](https://github.com/attonn7)

- Contributed to proposal
- Contributed to creation of ERD
- Contributed to database design before generating SQL from the relational schema
- Wrote 1/4 of the insert statements
- Wrote 1/4 of the initial queries
- Implemented insert method

### [Steven Stabile](https://github.com/sstabile)

- Contributed to proposal
- Contributed to creation of ERD
- Contributed to database design before generating SQL from the relational schema

### [Nathanael Swecker](https://github.com/ndswecker)

- Contributed to proposal
- Contributed to creation of ERD
- Converted ERD to relational schema
- Contributed to database design before generating SQL from the relational schema
- Contributed 3 SQL queries
- Contributed 2 albums
- Converted all 12 static sql script to dynamic scripts
- Created enum to hold script query paths
- Tested all selects
- Generated QueryLogic.java functionality and collaborated on its refactoring
- Generated build.gradle and collaborated on its additional functionality
- Hosted weekly team meetings
- Reviewed multiple github pull-requests

### [Ian Skelskey](https://github.com/IanSkelskey)

- Created a Slack channel for the group and hosted initial meetings
- Contributed to proposal
- Contributed to creation of ERD
- Contributed to database design before generating SQL from the relational schema
- Created git repository
- Created GitHub project
- Set git standards for the team
  - Two reviews for main
  - One review for Development
  - Working branches for each contributor
  - Continuous Integration
- Created and maintained README.md
- Wrote 1/4 of the insert statements necessary to populate database
- Wrote 1/4 of the initial queries for deliverable 3
- Added lyrics for 1 album
- Hosted team meetings
- Met with team members individually to maintain consistent vision
- Reviewed pull requests
  - Refactored submissions where necessary
- Updated query enum
- Wrote the DBInitializer class
- Wrote the SQLHelper class and documentation
- Wrote a dynamic query menu for the terminal UI

## Assets

- [Add Employee Icon](https://www.flaticon.com/free-icons/add-user)
- [App Icon](https://www.flaticon.com/free-icons/vinyl)
- [Location Icon](https://www.flaticon.com/free-icons/shop)