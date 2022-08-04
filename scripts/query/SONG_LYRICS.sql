-- Find a song that contains a set of lyrics.
SELECT 
    songtitle, albumtitle
FROM
    song
        INNER JOIN
    ALBUM ON album.AlbumID = song.albumid
WHERE
    lyrics LIKE CONCAT( '%',?,'%');