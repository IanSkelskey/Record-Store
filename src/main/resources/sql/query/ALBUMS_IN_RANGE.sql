SELECT DISTINCT
    AlbumTitle AS 'Album',
    ReleaseDate AS 'Release Date',
    Cost AS 'Cost'
FROM
    Album
        INNER JOIN
    Song ON Album.AlbumID = Song.AlbumID
        INNER JOIN
    SongFeatureList ON SongFeatureList.SongID = Song.SongID
WHERE
    Album.ReleaseDate BETWEEN ? AND ?
ORDER BY Album.ReleaseDate;