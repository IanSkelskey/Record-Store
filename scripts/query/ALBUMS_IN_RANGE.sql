-- What albums were released in a range of dates
SELECT DISTINCT
    AlbumTitle AS 'Album',
    ReleaseDate AS 'Release Date'
FROM
    Album
        JOIN
    Song ON Album.AlbumID = Song.AlbumID
        JOIN
    SongFeatureList ON SongFeatureList.SongID = Song.SongID
WHERE
    Album.ReleaseDate BETWEEN ? AND ?
ORDER BY Album.ReleaseDate;