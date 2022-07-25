/*
    Order of inserts will be important based on dependencies. Please follow this ORDER
    1. Artist table inserts
    2. Album table inserts
    3. Song table inserts
    4. SongFeatureList
    5. Genre
    6. SongGenreList
    7. MemberOf
    8. LOCATION
    9. EMPLOYEE
    10. Inventory
*/

-- Artists
INSERT INTO ARTIST (StageName, SoloFlag, ArtistName, DateOfBirth, BandFlag, Established) VALUES
    ("Jacob Collier", true, "Jacob Collier", "1994-08-02", false, null),
    ("Lady Gaga", true, "Stefani Joanne Angelina Germanotta", "1986-03-28", false, null),
    ("Lil Nas X", true, "Montero Lamar Hill", "1999-04-09", false, null),
    ("Jack Harlow", true, "Jack Thomas Harlow", "1998-03-13", false, null),
    ("Doja Cat", true, "Amala Ratna Zandile Dlamini", "1995-10-21", false, null),
    ("Elton John", true, "Sir Elton Hercules John", "1947-03-25", false, null),
    ("Megan Thee Stallion", true, "Megan Jovon Ruth Pete", "1995-02-15", false, null),
    ("Miley Cyrus", true, "Miley Ray Cyrus", "1992-11-23", false, null);

-- Albums
INSERT INTO ALBUM (AlbumTitle, ReleaseDate, Cost) VALUES
    ("In My Room", "2016-07-01", 17.58),
    ("Fleet Foxes", "2008-06-03", 13.98),
    ("Montero", "2021-09-17", 12.99),
    ("Born This Way", "2011-05-23", 7.99);

-- Songs
INSERT INTO SONG (SongTitle, AlbumID, Duration)VALUES
-- In My Room (1-11)
    ("Woke Up Today", 1, "00:04:40"),
    ("In My Room", 1, "00:04:49"),
    ("Hideaway", 1, "00:06:52"),
    ("You And I", 1, "00:04:20"),
    ("Down The Line", 1, "00:06:38"),
    ("Now And Then I Think About You", 1, "00:00:53"),
    ("Saviour", 1, "00:06:08"),
    ("Hajanga", 1, "00:06:02"),
    ("Flintstones", 1, "00:03:10"),
    ("In The Real Early Morning", 1, "00:06:09"),
    ("Don't You Know", 1, "00:09:10"),
-- Born This Way Album (12-25)
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
-- Montero ALBUM (26-40)
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
-- In My Room (SONGID 1-11)
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
    (1, 11)
-- Born this way album (SongID 12-25)
    (12,2),
    (13,2),
    (14,2),
    (15,2),
    (16,2),
    (17,2),
    (18,2),
    (19,2),
    (20,2),
    (21,2),
    (22,2),
    (23,2),
    (24,2),
    (25,2),
-- Montero album (26-40)
    (26,2),
    (27,2),
    (28,2),
    (15,2),
    (16,2),
    (17,2),
    (18,2),
    (19,2),
    (20,2),
    (21,2),
    (22,2),
    (23,2),
    (24,2),
    (25,2);

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
INSERT INTO SONG_GENRE_LIST (SongID, GenreName) VALUES
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

-- MemberOf

-- Locations
INSERT INTO LOCATION (LocationName, PhoneNumber, Address) VALUES
  ("Tutone Music Shop", "8608675309", "120 Jenny Lane, San Francisco, California 94102"),
  ("Rick's Record Shop", "8605553214", "322 Jesse Street, Springfield, Massachusetts 01020"),
  ("Stonewall Locker", "2535397684", "1010 122nd St S, Tacoma, WA 98447");

-- Employees
INSERT INTO EMPLOYEE (Name, LocationID) VALUES
  ("Ian Skelskey", 1),
  ("Andrew Tonn", 2),
  ("Graef Von Grundeltaag", 3);

