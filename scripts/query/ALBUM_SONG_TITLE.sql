-- What album contains a song with a specific title
SELECT
	albumtitle AS 'Album'
FROM
	album
		INNER JOIN
	song ON song.AlbumID = album.AlbumID
WHERE
	SongTitle = ?
GROUP BY AlbumTitle;