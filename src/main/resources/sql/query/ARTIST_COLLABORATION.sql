SELECT 
    S.SongTitle as 'Song', A1.StageName as 'Artist 1', A2.StageName as 'Artist 2', M.AlbumTitle as 'Album', M.Cost
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
		inner join
	Album As M on S.AlbumID = M.AlbumID
WHERE
    A1.StageName = ?
        AND A2.StageName = ?;