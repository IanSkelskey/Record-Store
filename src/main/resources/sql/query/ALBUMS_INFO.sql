SELECT
    AlbumTitle AS 'Album Title',
    ReleaseDate AS 'Release Date',
    Cost AS 'Cost',
    GROUP_CONCAT(DISTINCT stagename
        SEPARATOR ', ') AS 'Featured Artists',
    GROUP_CONCAT(DISTINCT SongTitle
        SEPARATOR '
        ') AS 'Tracks'
FROM
    album
        INNER JOIN
    song ON song.AlbumID = album.AlbumID
        INNER JOIN
    songfeaturelist ON song.SongID = songfeaturelist.SongID
        INNER JOIN
    artist ON artist.ArtistID = songfeaturelist.ArtistID
GROUP BY AlbumTitle;