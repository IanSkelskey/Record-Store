SELECT 
    S.SongTitle, A1.StageName, A2.StageName
FROM
    Song AS S
        INNER JOIN
    SongFeatureList AS SFL1 ON S.SongID = SFL1.SongID
        INNER JOIN
    Artist AS A1 ON SFL1.ArtistID = A1.ArtistID
        INNER JOIN
    SongFeatureList AS SFL2 ON S.SongID = SFL2.SongID
        INNER JOIN
    Artist AS A2 ON SFL2.ArtistID = A2.ArtistID
WHERE
    A1.StageName = 'Miley Cyrus'
        AND A2.StageName = 'Lil Nas X';