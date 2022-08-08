SELECT DISTINCT
	Genre.GenreName as 'Genre',
	AlbumTitle as 'Album'
FROM 
	Album, Genre, Song, SongGenreList
WHERE
	Album.AlbumID = Song.AlbumID
AND
	Song.SongID = SongGenreList.SongID
AND
	SongGenreList.GenreName = Genre.GenreName
AND
	Genre.GenreName = ?;