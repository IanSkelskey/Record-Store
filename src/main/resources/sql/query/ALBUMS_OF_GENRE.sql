SELECT DISTINCT
    G.GenreName AS 'Genre',
    M.AlbumTitle AS 'Album',
    M.Cost AS 'Cost'
FROM
    Genre AS G
        INNER JOIN
    SongGenreList AS SGL ON G.GenreName = SGL.GenreName
        INNER JOIN
    Song AS S ON SGL.SongID = S.SongID
        INNER JOIN
    Album AS M ON S.AlbumID = M.AlbumID
WHERE
    G.GenreName = ?;