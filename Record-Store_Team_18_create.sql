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