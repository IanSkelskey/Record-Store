SELECT
    songtitle AS 'Title',
    duration AS 'Duration',
    albumtitle AS 'Album',
    GROUP_CONCAT(stagename
        SEPARATOR ', ') AS 'Artists'
FROM
    SONG
        INNER JOIN
    album ON album.albumID = song.albumID
        INNER JOIN
    songfeaturelist ON song.songid = songfeaturelist.songid
        INNER JOIN
    artist ON songfeaturelist.ArtistID = artist.ArtistID
GROUP BY songtitle