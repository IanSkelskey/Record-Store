-- Ian's Queries
SET @track_num = 0; -- Get all the lyrics for a specific album

SELECT
    (@track_num:=@track_num + 1) AS 'Track',
    songtitle AS 'Song',
    albumtitle AS 'Album',
    artistname AS 'Artist',
    lyrics AS 'Lyrics'
FROM
    song
        JOIN
    ALBUM ON song.albumid = album.albumid
        JOIN
    songfeaturelist ON songfeaturelist.songid = song.songid
        JOIN
    ARTIST ON songfeaturelist.ArtistID = artist.ArtistID
WHERE
    AlbumTitle = 'In My Room'
ORDER BY song.SONGID;

-- Andrew's Queries
SELECT
	albumtitle AS 'Album'
FROM
	album
WHERE
	AlbumID IN (SELECT
						AlbumID
					FROM
						song
					WHERE
						SongTitle = 'Void');						
                        
SELECT
	stagename AS 'Artist'
FROM
	artist
WHERE ArtistID IN (SELECT
						ArtistID AS 'Artist'
					FROM
						song
							JOIN
						songfeaturelist ON songfeaturelist.SongID = song.SongID
					WHERE
						SongTitle = 'Industry Baby');

SELECT
	stagename AS 'Artist'
FROM
	artist
WHERE
	artist.ArtistID IN (SELECT
							IndividualID
						FROM
							memberof
								JOIN
							artist ON artist.ArtistID = memberof.GroupID
                            AND
                            artist.StageName = 'Fleet Foxes');
	
-- Nate Queries
-- "Who are all the employees at each of the locations ordered by location"
SELECT 
    employee.EmployeeID, employee.Name, location.LocationName AS 'Works At'
FROM
    employee,
    location
WHERE
    employee.EmployeeID = location.LocationID
ORDER BY location.LocationID;

-- "How many copies of a particular album (Montero) are there at each location?"
SELECT 
    inventory.Amount AS 'Montero Album Amount', location.LocationName AS 'Located At'
FROM
    album,
    inventory,
    location
WHERE
    album.AlbumTitle = 'Montero'
        AND album.AlbumID = inventory.AlbumID
        AND inventory.LocationID = location.LocationID
ORDER BY inventory.amount DESC;

-- "What song did artist A and artist B collaborate on?"
SELECT 
    * 
FROM
    (SELECT 
        song.songTitle
    FROM
        song, artist, songfeaturelist
    WHERE
        artist.StageName = 'Lil Nas X'
            AND artist.ArtistID = songfeaturelist.ArtistID
            AND songfeaturelist.SongID = song.SongID) AS A
        JOIN
    (SELECT 
        song.songTitle
    FROM
        song, artist, songfeaturelist
    WHERE
        artist.StageName = 'Miley Cyrus'
            AND artist.ArtistID = songfeaturelist.ArtistID
            AND songfeaturelist.SongID = song.SongID) AS B ON A.SongTitle = B.songTitle;
	
