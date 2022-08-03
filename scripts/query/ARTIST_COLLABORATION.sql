-- "What song did artist A and artist B collaborate on?"
SELECT
    *
FROM
    (SELECT
        song.songTitle
    FROM
        song, artist, songfeaturelist
    WHERE
        artist.StageName = 'Lil Nas X'
            AND artist.ArtistID = songfeaturelist.ArtistID
            AND songfeaturelist.SongID = song.SongID) AS A
        JOIN
    (SELECT
        song.songTitle
    FROM
        song, artist, songfeaturelist
    WHERE
        artist.StageName = 'Miley Cyrus'
            AND artist.ArtistID = songfeaturelist.ArtistID
            AND songfeaturelist.SongID = song.SongID) AS B ON A.SongTitle = B.songTitle;