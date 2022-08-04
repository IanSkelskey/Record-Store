SELECT
    songtitle, albumtitle
FROM
    song
        INNER JOIN
    ALBUM ON album.AlbumID = song.albumid
WHERE
    lyrics LIKE CONCAT( '%',?,'%');