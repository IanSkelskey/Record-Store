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
  ("Andrew Tonn", 2),
  ("Graef Von Grundeltaag", );

-- Locations
INSERT INTO LOCATION (LocationID, LocationName, PhoneNumber, Address) VALUES
  (1, "Tutone Music Shop", 8608675309, "120 Jenny Lane, San Francisco, California 94102"),
  (2, "Rick's Record Shop", 8605553214 "322 Jesse Street, Springfield, Massachusetts 01020"),
  (3, "Stonewall Locker", "2535397684", "1010 122nd St S, Tacoma, WA 98447");

-- Albums
INSERT INTO ALBUM (AlbumTitle, ReleaseDate, Cost) VALUES
	("In My Room", "2016-07-01", 17.58),
	("Fleet Foxes", "2008-06-03", 13.98),
	("Montero", "2021-09-17", 12.99),
	("Born This Way", "2011-05-23", 7.99);

-- Artists
INSERT INTO ARTIST (StageName, SoloFlag, ArtistName, DateOfBirth, BandFlag, Established)VALUES
    (1, "Jacob Collier", "1994-08-02", "Jacob Collier"),
	("Lady Gaga", true, "Stefani Joanne Angelina Germanotta", "1986-03-28", false, null),
	("Lil Nas X", true, "Montero Lamar Hill", "1999-04-09", false, null),
	("Jack Harlow", true, "Jack Thomas Harlow", "1998-03-13", false, null),
	("Doja Cat", true, "Amala Ratna Zandile Dlamini", "1995-10-21", false, null),
	("Elton John", true, "Sir Elton Hercules John", "1947-03-25", false, null),
	("Megan Thee Stallion", true, "Megan Jovon Ruth Pete", "1995-02-15", false, null),
	("Miley Cyrus", true, "Miley Ray Cyrus", "1992-11-23", false, null);

-- Songs
INSERT INTO SONG (SongTitle, AlbumID, Duration)VALUES
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
    (11, "Don't You Know", 550, "Lyrics", 1),
-- Born This Way Album
	("Marry The Night", 4, "00:04:24"),
	("Born This Way", 4, "00:04:20"),
	("Government Hooker", 4, "00:04:14"),
	("Judas", 4, "00:04:09"),
	("Americano", 4, "00:04:06"),
	("Hair", 4, "00:05:07"),
	("Sheibe", 4, "00:03:45"),
	("Bloody Mary", 4, "00:04:04"),
	("Bad Kids", 4, "00:03:50"),
	("Highway Unicorn (Road to Love)", 4, "00:04:15")
	("Heavy Metal Lover", 4, "00:04:12"),
	("Electric Chapel", 4, "00:04:13"),
	("You and I", 4, "00:05:07"),
	("Edge of Glory", 4, "00:05:20")
-- Montero ALBUM
	("Montero (Call Me By Your Name)", 3, "00:02:17"),
	("Dead Right Now", 3, "00:03:41"),
	("Industry Baby", 3, "00:03:32"),
	("Thats What I Want", 3, "00:02:23"),
	("The Art of Realization", 3, "00:00:24"),
	("Scoop", 3, "00:02:54"),
	("One of Me", 3, "00:02:41"),
	("Lost In The Citadel", 3, "00:02:50"),
	("Dolla Sign Slime", 3, "00:02:25"),
	("Tales of Dominica", 3, "00:02:26"),
	("Sun Goes Down", 3, "00:2:48"),
	("Void", 3, "00:04:08"),
	("Dont Want It", 3, "00:02:10"),
	("Life After Salem", 3, "00:03:30"),
	("Am I Dreaming", 3, "00:03:03");

-- Song Features
INSERT INTO SONG_FEATURE_LIST (SongID, ArtistID) VALUES
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
INSERT INTO GENRE (GenreName, Description) VALUES
	("Jazz music is a broad style of music characterized by complex harmony, syncopated rhythms, and a heavy emphasis on improvisation.", "Jazz"),
	("Pop", "A type of music, usually played on electronic instruments, that is popular with many people because it consists of short songs with a strong beat and simple tunes that are easy to remember."),
	("Electronic Rock", "Electronic rock is a music genre that involves a combination of rock music and electronic music, featuring instruments typically found within both genres."),
	("Disco", "Disco is a genre of dance music and a subculture that emerged in the 1970s from the United States' urban nightlife scene. Its sound is typified by four-on-the-floor beats, syncopated basslines, string sections, horns, electric piano, synthesizers, and electric rhythm guitars."),
	("Dance-pop","Generally characterised by strong beats with easy, uncomplicated song structures which are generally more similar to pop music than the more free-form dance genre, with an emphasis on melody as well as catchy tunes."),
	("Synth-pop", "A type of pop music featuring heavy use of synthesizers and other electronic instruments, originating in the early 1980s."),
	("Electro-pop", "A style of popular music characterized by the use of electronically created sounds, with a synthesizer as the primary instrument."),
	("Mariachi", "A type of traditional Mexican folk music, typically performed by a small group of strolling musicians dressed in native costume."),
	("House", "House is a music genre characterized by a repetitive four-on-the-floor beat and a typical tempo of 120 beats per minute."),
	("Techno", "A style of fast, heavy electronic dance music, typically with few or no vocals."),
	("R&B/Soul", "Short for rhythm and blues. A kind of pop music of African American origin with a soulful vocal style featuring improvisation."),
	("Glam Metal", "Glam metal is a subgenre of heavy metal that features pop-influenced hooks and guitar riffs, upbeat rock anthems, and slow power ballads."),
	("Country Rock", "Country rock is a subgenre of popular music, formed from the fusion of rock and country.");

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