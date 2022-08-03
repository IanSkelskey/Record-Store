-- Find all albums by a particular artist.
SELECT
    albumtitle, stagename
FROM
    album
        INNER JOIN
    song ON song.albumid = album.albumid
        INNER JOIN
    songfeaturelist ON songfeaturelist.SongID = song.songid
        INNER JOIN
    artist ON artist.artistid = songfeaturelist.artistid
WHERE
    StageName = ?
GROUP BY albumtitle;