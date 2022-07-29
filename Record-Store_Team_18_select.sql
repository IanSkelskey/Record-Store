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

SELECT * FROM location; -- What are all the locations? You asked for it.

SELECT -- Find all albums by a particular artist.
    albumtitle, stagename
FROM
    album
        INNER JOIN
    song ON song.albumid = album.albumid
        INNER JOIN
    songfeaturelist ON songfeaturelist.SongID = song.songid
        INNER JOIN
    artist ON artist.artistid = songfeaturelist.artistid
WHERE
    StageName = 'Fleet foxes'
GROUP BY albumtitle;

SELECT -- Find a song that contains a set of lyrics.
    songtitle, albumtitle
FROM
    song
        INNER JOIN
    ALBUM ON album.AlbumID = song.albumid
WHERE
    lyrics LIKE '%, oh%'

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
	songtitle AS 'Song',
    stagename AS 'Artist'
FROM
	artist
		INNER JOIN
	songfeaturelist ON artist.ArtistID = songfeaturelist.ArtistID
		INNER JOIN
	song ON songfeaturelist.SongID = song.SongID
WHERE 
	SongTitle = 'Industry Baby';

SELECT
	g.stagename AS 'Group',
    i.stagename AS 'Member'
FROM
	artist AS i
		INNER JOIN
	memberof ON i.ArtistID = memberof.IndividualID
		INNER JOIN
	artist AS g ON g.ArtistID = memberof.GroupID
WHERE
	g.StageName = 'Fleet Foxes';
	
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
select *
from (select song.songTitle
	from song, artist, songfeaturelist
	where artist.StageName = 'Lil Nas X' and
		artist.ArtistID = songfeaturelist.ArtistID and
		songfeaturelist.SongID = song.SongID
) as A
join
(select song.songTitle
from song, artist, songfeaturelist
where artist.StageName = 'Miley Cyrus' and
	artist.ArtistID = songfeaturelist.ArtistID and
    songfeaturelist.SongID = song.SongID
) as B
on A.SongTitle = B.songTitle;
	
