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
	

