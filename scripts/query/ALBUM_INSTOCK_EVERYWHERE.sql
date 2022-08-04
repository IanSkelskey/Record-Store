SELECT
    inventory.Amount AS 'Album Amount', location.LocationName AS 'Located At'
FROM
    album,
    inventory,
    location
WHERE
    album.AlbumTitle = ?
        AND album.AlbumID = inventory.AlbumID
        AND inventory.LocationID = location.LocationID
ORDER BY inventory.amount DESC;