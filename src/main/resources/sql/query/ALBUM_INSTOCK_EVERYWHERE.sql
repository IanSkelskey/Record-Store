SELECT
    inventory.Amount AS 'Stock Quantity', AlbumTitle AS 'Album', location.LocationName AS 'Located At', location.Address, Cost
FROM
    album,
    inventory,
    location
WHERE
    album.AlbumTitle = ?
        AND album.AlbumID = inventory.AlbumID
        AND inventory.LocationID = location.LocationID
ORDER BY inventory.amount DESC;