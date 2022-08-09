SELECT
	song.SongTitle as 'Song', albumtitle AS 'Album', cost as 'Cost'
FROM
	album
		INNER JOIN
	song ON song.AlbumID = album.AlbumID
WHERE
	SongTitle = ?
GROUP BY AlbumTitle;