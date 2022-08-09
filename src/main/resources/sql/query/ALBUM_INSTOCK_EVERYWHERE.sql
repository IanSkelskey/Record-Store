SELECT
    I.Amount AS 'Stock Quantity', AlbumTitle AS 'Album', L.LocationName AS 'Located At', L.Address, Cost
FROM
	Album AS M
		INNER JOIN
	Inventory AS I ON M.AlbumID = I.AlbumID
		INNER JOIN
	Location AS L ON I.LocationID = L.LocationID
WHERE
	M.AlbumTitle = ?
ORDER BY I.Amount DESC;