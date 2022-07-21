# Record Store

Project designed for SER322: Database Management at Arizona State University by group 18 for Summer Session B 2022.

## Description

Record Store is a database and application to aid record store employees. The system should allow 
employees to find what a customer is looking for. The database contains a list of records and their stock quantity
along with additional information about artists, songs, genres, etc.

## Creating the Database
```sql
CREATE TABLE LOCATION
(
  PhoneNumber INT NOT NULL,
  Address VARCHAR(50) NOT NULL,
  LocationName VARCHAR(25) NOT NULL,
  LocationID INT NOT NULL,
  PRIMARY KEY (LocationID)
);

CREATE TABLE EMPLOYEE
(
  EmployeeID INT NOT NULL,
  EmployeeName VARCHAR(30) NOT NULL,
  LocationID INT NOT NULL,
  PRIMARY KEY (EmployeeID),
  FOREIGN KEY (LocationID) REFERENCES LOCATION(LocationID)
);

CREATE TABLE ALBUM
(
  AlbumID INT NOT NULL,
  AlbumTitle VARCHAR(30) NOT NULL,
  ReleaseDate DATE NOT NULL,
  Cost FLOAT NOT NULL,
  PRIMARY KEY (AlbumID)
);

CREATE TABLE SONG
(
  SongID INT NOT NULL,
  SongTitle VARCHAR(30) NOT NULL,
  Duration INT NOT NULL,
  Lyrics VARCHAR(3000) NOT NULL,
  AlbumID INT NOT NULL,
  PRIMARY KEY (SongID),
  FOREIGN KEY (AlbumID) REFERENCES ALBUM(AlbumID)
);

CREATE TABLE GENRE
(
  Description VARCHAR(200) NOT NULL,
  GenreName VARCHAR(15) NOT NULL,
  PRIMARY KEY (GenreName)
);

CREATE TABLE ARTIST
(
  ArtistID INT NOT NULL,
  StageName VARCHAR(30) NOT NULL,
  DateOfBirth DATE NOT NULL,
  ArtistName VARCHAR(30) NOT NULL,
  PRIMARY KEY (ArtistID)
);

CREATE TABLE SONG_GENRE_LIST
(
  SongID INT NOT NULL,
  GenreName VARCHAR(15) NOT NULL,
  PRIMARY KEY (SongID, GenreName),
  FOREIGN KEY (SongID) REFERENCES SONG(SongID),
  FOREIGN KEY (GenreName) REFERENCES GENRE(GenreName)
);

CREATE TABLE INVENTORY
(
  Amount INT NOT NULL,
  AlbumID INT NOT NULL,
  LocationID INT NOT NULL,
  PRIMARY KEY (AlbumID, LocationID),
  FOREIGN KEY (AlbumID) REFERENCES ALBUM(AlbumID),
  FOREIGN KEY (LocationID) REFERENCES LOCATION(LocationID)
);

CREATE TABLE SONG_FEATURE_LIST
(
  SongID INT NOT NULL,
  ArtistID INT NOT NULL,
  PRIMARY KEY (SongID, ArtistID),
  FOREIGN KEY (SongID) REFERENCES SONG(SongID),
  FOREIGN KEY (ArtistID) REFERENCES ARTIST(ArtistID)
);
```
## Environment

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