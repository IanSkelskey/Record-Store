/*
Order of inserts will be important based on dependancies. Please follow this ORDER
1. Artist table inserts
2. Album table inserts
3. Song table inserts
4. SongFeatureList
5. SongGenreList
6. MemberOf
7. LOCATION
8. EMPLOYEE
9. Inventory
*/

-- Employees
INSERT INTO EMPLOYEE (Name, LocationID) VALUES
  ("Ian Skelskey", 1),
  ("Andrew Tonn", 2);

-- Locations
INSERT INTO LOCATION (LocationName, PhoneNumber, Address) VALUES
  ("Tutone Music Shop", 8608675309, "120 Jenny Lane, San Francisco, California 94102"),
  ("Rick's Record Shop", 8605553214 "322 Jesse Street, Springfield, Massachusetts 01020");

-- Albums
INSERT INTO ALBUM (AlbumTitle, ReleaseDate, Cost) VALUES
	("In My Room", "2016-07-01", 17.58),
	("Fleet Foxes", "2008-06-03", 13.98);

-- Artists
INSERT INTO ARTIST VALUES
    (1, "Jacob Collier", "1994-08-02", "Jacob Collier");

-- Songs
INSERT INTO SONG VALUES
	(1, "Woke Up Today", 280, "Lyrics", 1),
    (2, "In My Room", 289, "Lyrics", 1),
    (3, "Hideaway", 412, "Lyrics", 1),
    (4, "You And I", 260, "Lyrics", 1),
    (5, "Down The Line", 398, "Lyrics", 1),
    (6, "Now And Then I Think About You", 53, "Lyrics", 1),
    (7, "Saviour", 368, "Lyrics", 1),
    (8, "Hajanga", 362, "Lyrics", 1),
    (9, "Flintstones", 190, "Lyrics", 1),
    (10, "In The Real Early Morning", 369, "Lyrics", 1),
    (11, "Don't You Know", 550, "Lyrics", 1);

-- Song Features
INSERT INTO SONG_FEATURE_LIST VALUES
	(1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6),
    (1, 7),
    (1, 8),
    (1, 9),
    (1, 10),
    (1, 11);

-- Genres
INSERT INTO GENRE VALUES
	("Jazz music is a broad style of music characterized by complex harmony, syncopated rhythms, and a heavy emphasis on improvisation.", "Jazz");

-- Song Genre
INSERT INTO SONG_GENRE_LIST VALUES
	(1, "Jazz"),
    (2, "Jazz"),
    (3, "Jazz"),
    (4, "Jazz"),
    (5, "Jazz"),
    (6, "Jazz"),
    (7, "Jazz"),
    (8, "Jazz"),
    (9, "Jazz"),
    (10, "Jazz"),
    (11, "Jazz");