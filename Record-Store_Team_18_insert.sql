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
    ("Miley Cyrus", true, "Miley Ray Cyrus", "1992-11-23", false, null),
    ("Fleet Foxes", false, null, null, true, "2006-00-00"),
    ("Robin Pecknold", true, "Robin Pecknold", "1986-03-30", false, null),
    ("Skyler Skjelset", true, "Skyler Skjelset", "1986-03-05", false, null),
    ("Casey Wescott", true, "Casey Wescott", "1981-01-05", false, null),
    ("Christian Wargo", true, "Christian Wargo", "1976-09-22", false, null),
    ("Morgan Henderson", true, "Morgan Henderson", "1978-08-22", false, null),
    ("Tom Petty and the Heartbreakers", false, null, null, true, "1976-00-00"),
    ("George Harrison", true, "George Harrison", "1943-02-25", false, null),
    ("David Bowie", true, "David Robert Jones", "1947-01-08", false, 1962),
    ("Luther Vandross", true, "Luther Ronzoni Vandross Jr.", "1951-04-20", false, 1969),
    ("John Lennon", true, "John Winston Ono Lennon", "1940-08-09", false, 1956);

-- Albums
INSERT INTO ALBUM (AlbumTitle, ReleaseDate, Cost) VALUES
    ("In My Room", "2016-07-01", 17.58),
    ("Fleet Foxes", "2008-06-03", 13.98),
    ("Montero", "2021-09-17", 12.99),
    ("Born This Way", "2011-05-23", 7.99),
    ("Damn the Torpedoes", "1979-10-19", 12.99),
    ("Dark Horse", "1974-12-09", 13.98),
    ("Young Americans", "1975-03-05", 12.95);

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
    ("Highway Unicorn (Road to Love)", 4, "00:04:15"),
    ("Heavy Metal Lover", 4, "00:04:12"),
    ("Electric Chapel", 4, "00:04:13"),
    ("You and I", 4, "00:05:07"),
    ("Edge of Glory", 4, "00:05:20"),
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
    ("Am I Dreaming", 3, "00:03:03"),
-- Fleet Foxes (41-51)
    ("Sun It Rises", 2, "00:03:11"),
    ("White Winter Hymnal", 2, "00:02:27"),
    ("Ragged Wood", 2, "00:05:07"),
    ("Tiger Mountain Peasant Song", 2, "00:03:28"),
    ("Quiet Houses", 2, "00:03:32"),
    ("He Doesn't Know Why", 2, "00:03:20"),
    ("Heard Them Stirring", 2, "00:03:02"),
    ("Your Protector", 2, "00:04:09"),
    ("Meadowlarks", 2, "00:03:11"),
    ("Blue Ridge Mountains", 2, "00:04:25"),
    ("Oliver James", 2, "00:03:23"),
-- Damn the Torpedoes Album (52-60)
    ("Refugee", 5, "00:03:22"),
    ("Here Comes My Girl", 5, "00:04:27"),
    ("Even the Losers", 5, "00:03:59"),
    ("Shadow of a Doubt (A Complex Kid)", 5, "00:04:25"),
    ("Century City", 5, "00:03:45"),
    ("Don't Do Me Like That", 5, "00:02:44"),
    ("You Tell Me", 5, "00:04:35"),
    ("What Are You Doin' in My Life", 5, "00:03:27"),
    ("Louisiana Rain", 5, "00:05:54"),
-- Dark Horse (61-69)
    ("Hari's on Tour (Express)", 6, "00:04:43"),
    ("Simply Shady", 6, "00:04:38"),
    ("So Sad", 6, "00:05:00"),
    ("Bye Bye, Love", 6, "00:04:08"),
    ("Māya Love", 6, "00:04:24"),
    ("Ding Dong, Ding Dong", 6, "00:03:40"),
    ("Dark Horse", 6, "00:03:54"),
    ("Far East Man", 6, "00:05:52"),
    ("It Is 'He' (Jai Sri Krishna)", 6, "00:04:50"),
    -- Young Americans (70-77)
    ("Young Americans", 7, "00:05:11"),
    ("Win", 7, "00:04:44"),
    ("Fascination", 7, "00:05:45"),
    ("Right", 7, "00:04:15"),
    ("Somebody Up There Likes Me", 7, "00:06:36"),
    ("Across the Universe", 7, "00:04:29"),
    ("Can You Hear Me?", 7, "00:05:03"),
    ("Fame", 7, "00:04:21");

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
    (1, 11),
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
    (25,2),
-- Damn the Torpedoes album (SongID 52-60)
    (52,15),
    (53,15),
    (54,15),
    (55,15),
    (56,15),
    (57,15),
    (58,15),
    (59,15),
    (60,15),
-- Dark Horse album (SongID 61-69)
    (61,16),
    (62,16),
    (63,16),
    (64,16),
    (65,16),
    (66,16),
    (67,16),
    (68,16),
    (69,16),
    -- Young Americans album (SongID 70-77)
    (70, 17),
    (71, 17),
    (72, 17),
    (72, 18),
    (73, 17),
    (74, 17),
    (75, 17),
    (76, 17),
    (77, 17),
    (77, 19);

-- Genres
INSERT INTO GENRE (GenreName, Description) VALUES
    ("Jazz", "Jazz music is a broad style of music characterized by complex harmony, syncopated rhythms, and a heavy emphasis on improvisation."),
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
    ("Country Rock", "Country rock is a subgenre of popular music, formed from the fusion of rock and country."),
    ("Rock-n-Roll", "Rock/Rock-n-Roll is a broad genre of popular music that originated as 'rock and roll' in the United States in the late 1940s and early 1950s, developing into a range of different styles in the mid-1960s and later, particularly in the United States and the United Kingdom.");

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
    (11, "Jazz"),
-- Damn the Torpedoes album (52-60)
    (52, "Rock-n-Roll"),
    (53, "Rock-n-Roll"),
    (54, "Rock-n-Roll"),
    (55, "Rock-n-Roll"),
    (56, "Rock-n-Roll"),
    (57, "Rock-n-Roll"),
    (58, "Rock-n-Roll"),
    (59, "Rock-n-Roll"),
    (60, "Rock-n-Roll"),
-- Dark Horse album (61-69)
    (61, "Rock-n-Roll"),
    (62, "Rock-n-Roll"),
    (63, "Rock-n-Roll"),
    (64, "Rock-n-Roll"),
    (65, "Rock-n-Roll"),
    (66, "Rock-n-Roll"),
    (67, "Rock-n-Roll"),
    (68, "Rock-n-Roll"),
    (69, "Rock-n-Roll"),
-- Young Americans album (70-77)
	(70, "Pop"),
    (71, "Pop"),
    (72, "Pop"),
    (73, "Pop"),
    (74, "Pop"),
    (75, "Pop"),
    (76, "Pop"),
    (77, "Pop");

-- MemberOf

-- Locations
INSERT INTO LOCATION (LocationName, PhoneNumber, Address) VALUES
  ("Tutone Music Shop", "8608675309", "120 Jenny Lane, San Francisco, California 94102"),
  ("Rick's Record Shop", "8605553214", "322 Jesse Street, Springfield, Massachusetts 01020"),
  ("Stonewall Locker", "2535397684", "1010 122nd St S, Tacoma, WA 98447"),
  ("Big Round Record Store", "9085554242", "20 W 34th St., New York, NY 10001");

-- Employees
INSERT INTO EMPLOYEE (Name, LocationID) VALUES
  ("Ian Skelskey", 1),
  ("Andrew Tonn", 2),
  ("Graef Von Grundeltaag", 3),
  ("Steven Stabile", 4);

