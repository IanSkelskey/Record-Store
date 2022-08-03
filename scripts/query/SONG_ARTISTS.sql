-- What artists are featured on a particular song
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
	SongTitle = ?;