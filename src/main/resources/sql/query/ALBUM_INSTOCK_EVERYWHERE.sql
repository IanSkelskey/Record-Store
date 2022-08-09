SELECT
    inventory.Amount AS 'Stock Quantity', AlbumTitle AS 'Album', location.LocationName AS 'Located At', location.Address, Cost
FROM
	Album AS M
		INNER JOIN
	Inventory AS I ON M.AlbumID = I.AlbumID
		INNER JOIN
	Location AS L ON I.LocationID = L.LocationID
WHERE
	M.AlbumTitle = ?
ORDER BY I.Amount DESC;