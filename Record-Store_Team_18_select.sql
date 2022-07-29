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
	

