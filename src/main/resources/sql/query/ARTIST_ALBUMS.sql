SELECT 
    A.stagename AS 'Artist',
    M.albumtitle AS 'Album',
    M.cost AS 'Cost'
FROM
    Album AS M
        INNER JOIN
    song AS S ON M.albumID = S.AlbumID
        INNER JOIN
    songfeaturelist AS SFL ON SFL.SongID = S.songid
        INNER JOIN
    artist AS A ON A.artistid = SFL.artistid
WHERE
    StageName = ?
GROUP BY albumtitle;