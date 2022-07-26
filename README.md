# Record Store

Project designed for SER322: Database Management at Arizona State University by group 18 for Summer Session B 2022.

## Description

Record Store is a database and application to aid record store employees. The system should allow 
employees to find what a customer is looking for. The database contains a list of records and their stock quantity
along with additional information about artists, songs, genres, etc.

## Creating the Database
```sql
CREATE TABLE Location
(
  LocationID INT NOT NULL AUTO_INCREMENT,
  LocationName VARCHAR(45) NOT NULL,
  PhoneNumber CHAR(10) NOT NULL,
  Address VARCHAR(50) NOT NULL,
  PRIMARY KEY (LocationID)
);

CREATE TABLE Employee
(
  EmployeeID INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(30) NOT NULL,
  LocationID INT NOT NULL,
  PRIMARY KEY (EmployeeID),
  FOREIGN KEY (LocationID) REFERENCES Location(LocationID)
);

CREATE TABLE Album (
    AlbumID INT NOT NULL AUTO_INCREMENT,
    AlbumTitle VARCHAR(30) NOT NULL,
    ReleaseDate DATE NOT NULL,
    Cost FLOAT NOT NULL,
    PRIMARY KEY (AlbumID)
);

CREATE TABLE Song
(
  SongID INT NOT NULL AUTO_INCREMENT,
  SongTitle VARCHAR(50) NOT NULL,
  Duration Time NOT NULL,
  Lyrics Text,
  AlbumID INT NOT NULL,
  PRIMARY KEY (SongID),
  FOREIGN KEY (AlbumID) REFERENCES Album(AlbumID)
);

CREATE TABLE Genre
(
  GenreName VARCHAR(25) NOT NULL,
  Description MEDIUMTEXT NOT NULL,
  PRIMARY KEY (GenreName)
);

CREATE TABLE SongGenreList
(
  GenreName VARCHAR(25) NOT NULL,
  SongID INT NOT NULL,
  PRIMARY KEY (GenreName, SongID),
  FOREIGN KEY (GenreName) REFERENCES Genre(GenreName),
  FOREIGN KEY (SongID) REFERENCES Song(SongID)
);

CREATE TABLE Artist
(
  ArtistID INT NOT NULL AUTO_INCREMENT,
  StageName VARCHAR(50) NOT NULL,
  SoloFlag Boolean NOT NULL,
  ArtistName VARCHAR(50),
  DateOfBirth DATE,
  BandFlag Boolean NOT NULL,
  Established DATE,
  PRIMARY KEY (ArtistID)
);

CREATE TABLE MemberOf
(
  GroupID INT NOT NULL,
  IndividualID INT NOT NULL,
  PRIMARY KEY (GroupID, IndividualID),
  FOREIGN KEY (GroupID) REFERENCES Artist(ArtistID),
  FOREIGN KEY (IndividualID) REFERENCES Artist(ArtistID)
);

CREATE TABLE Inventory (
    AlbumID INT NOT NULL,
    LocationID INT NOT NULL,
    Amount INT NOT NULL,
    PRIMARY KEY (AlbumID , LocationID),
    FOREIGN KEY (AlbumID)
        REFERENCES Album (AlbumID),
    FOREIGN KEY (LocationID)
        REFERENCES Location (LocationID)
);

CREATE TABLE SongFeatureList
(
  SongID INT NOT NULL,
  ArtistID INT NOT NULL,
  PRIMARY KEY (SongID, ArtistID),
  FOREIGN KEY (SongID) REFERENCES Song(SongID),
  FOREIGN KEY (ArtistID) REFERENCES Artist(ArtistID)
);
```
## Environment

- MySQL version 5.6

Java, Gradle, JDBC, etc?

## Steps for Execution

1. 

## Video Presentations

- Deliverable 3
- Deliverable 4

## Contributors 

The members of group 18 are listed below along with their individual contributions.

### [Andrew Tonn](https://github.com/attonn7)

- Contributed to proposal
- Contributed to creation of ERD
- Contributed to database design before generating SQL from the relational schema

### [Steven Stabile](https://github.com/sstabile)

- Contributed to proposal
- Contributed to creation of ERD
- Contributed to database design before generating SQL from the relational schema

### [Nathanael Swecker](https://github.com/ndswecker)

- Contributed to proposal
- Contributed to creation of ERD
- Converted ERD to relational schema
- Contributed to database design before generating SQL from the relational schema

### [Ian Skelskey](https://github.com/IanSkelskey)

- Contributed to proposal
- Contributed to creation of ERD
- Contributed to database design before generating SQL from the relational schema
- Created git repository
- Created GitHub project
- Created and maintained README.md